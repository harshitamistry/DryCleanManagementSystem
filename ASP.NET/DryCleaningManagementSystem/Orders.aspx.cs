using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;
namespace DryCleaningManagementSystem
{
    public partial class Orders : System.Web.UI.Page
    {
        SqlConnection cnDryClean = new SqlConnection();
        DataTable ordersTable = new DataTable();
        DataTable invoiceTable = new DataTable();

        bool OrderIdGenerated = false;
        bool InvoiceIdGenerated = false;

        protected void Page_Load(object sender, EventArgs e)
        {
            var cstr = System.Configuration.ConfigurationManager.ConnectionStrings["DryCleanInventory"];
            string strConn = cstr.ConnectionString;
            cnDryClean = new SqlConnection(strConn);

            if (!IsPostBack)
            {
                //LoadTable();

                string custIdCheck = (string)Session["cusid"];
                custIde.Text = custIdCheck;
                loadName();

            }
        }

        protected void loadName()
        {
            cnDryClean.Open();
            SqlCommand cmd = cnDryClean.CreateCommand();
            string custIdCheck = (string)Session["cusid"];
            cmd.CommandText = "select customerFName FROM Customers WHERE CustomerId = @id";

            cmd.Parameters.Add("@id", SqlDbType.VarChar);
            cmd.Parameters["@id"].Value = custIdCheck;
            cNameLbl.Text = (cmd.ExecuteScalar()).ToString();
            custIde.Text = custIdCheck;
            cnDryClean.Close();
        }

        protected void LoadInvoiceTable()
        {

            cnDryClean.Open();
            invoiceTable.Clear();

            string sql = "SELECT * FROM Invoice";

            using (SqlCommand cmd = new SqlCommand(sql, cnDryClean))
            {
                SqlDataReader dr = cmd.ExecuteReader();
                invoiceTable.Load(dr);
                dr.Close();
            }
            cnDryClean.Close();
        }

        /**Get Number of rows from database
         * @param tableName - name of a table from where we have 
         * retrive rows.
         */
        protected string numOfRows(DataTable tableName, string joinString)
        {
            /* //if table is invoice table
             if (tableName == invoiceTable)
             {
                 LoadInvoiceTable();
             }

             int rowNums = tableName.Rows.Count + 1;

             string opString = joinString + rowNums.ToString();
             return opString;*/
            cnDryClean.Open();
            SqlCommand cmd = cnDryClean.CreateCommand();

            //if table is invoice table
            if (tableName == invoiceTable)
            {
                cmd.CommandText = "select InvoiceTable FROM idGenerator where id = 1 ";
                if (InvoiceIdGenerated)
                {
                    UpdateIdGenerator(Int32.Parse(cmd.ExecuteScalar().ToString()), "invoice");
                    InvoiceIdGenerated = false;
                }
            }

            //if table is orders table
            if (tableName == ordersTable)
            {
                cmd.CommandText = "select OrderTable FROM idGenerator where id = 1 ";
                if (OrderIdGenerated)
                {
                    UpdateIdGenerator(Int32.Parse(cmd.ExecuteScalar().ToString()), "orders");
                    OrderIdGenerated = false;
                }
            }

            string opString = joinString + (cmd.ExecuteScalar()).ToString();

            cnDryClean.Close();

            return opString;



        }


        protected void lastGenerateId(DataTable tableName)
        {
            cnDryClean.Open();
            SqlCommand cmd = cnDryClean.CreateCommand();

            //if table is invoice table
            if (tableName == invoiceTable)
            {
                cmd.CommandText = "select InvoiceTable FROM idGenerator where id = 1 ";
                //if (InvoiceIdGenerated)
                //{
                UpdateIdGenerator(Int32.Parse(cmd.ExecuteScalar().ToString()), "invoice");
                //  InvoiceIdGenerated = false;
                //}
            }

            //if table is orders table
            if (tableName == ordersTable)
            {
                cmd.CommandText = "select OrderTable FROM idGenerator where id = 1 ";
                //  if (OrderIdGenerated)
                // {
                UpdateIdGenerator(Int32.Parse(cmd.ExecuteScalar().ToString()), "orders");
                //   OrderIdGenerated = false;
                //}
            }


            cnDryClean.Close();


        }

        //update idGenerator table after creating id for orders and invoice
        public void UpdateIdGenerator(int num, string tableName)
        {

            try
            {
                if (tableName == "orders")
                {
                    string sql = "UPDATE idGenerator SET OrderTable=@oNum" +
                                " WHERE id=1";
                    using (SqlCommand cmd = new SqlCommand(sql, cnDryClean))
                    {
                        cmd.Parameters.AddWithValue("@oNum", num + 1);
                        //cmd.Parameters.AddWithValue("@iNum", num + 1);

                        cmd.ExecuteNonQuery();

                        //rows number of record got updated
                    }
                }

                else if (tableName == "invoice")
                {
                    string sql = "UPDATE idGenerator SET InvoiceTable=@iNum" +
                                " WHERE id=1";
                    using (SqlCommand cmd = new SqlCommand(sql, cnDryClean))
                    {
                        cmd.Parameters.AddWithValue("@iNum", num + 1);
                        cmd.ExecuteNonQuery();

                    }

                }


            }

            catch (SqlException ex)
            {
                //Log exception
                //Display Error message
            }
        }


        /**
         * Check the total amount after submit
         * */
        protected void checkTotalAmount(object sender, EventArgs e)
        {
            bool errorOccured = false;
            //check if user has entered orders
            if (OrdersGrid.Rows.Count <= 0)
            {
                Response.Write("<script>alert('Please add orderItem to generate invoice');</script>");
                errorOccured = true;
            }
            if (orderDate.Value == "")
            {
                Response.Write("<script>alert('Please enter order date');</script>");
                errorOccured = true;
            }
            else if (pickupDate.Value == "")
            {
                Response.Write("<script>alert('Please enter Pickup date');</script>");
                errorOccured = true;
            }
            if (!errorOccured)
            {
                //generate order number for this table
                string oNum = numOfRows(ordersTable, "ON");
                // UpdateOrders(oNum, buttonId);
                LoadInInvoiceTable(oNum);
                OrderIdGenerated = true;
                lastGenerateId(invoiceTable);
                lastGenerateId(ordersTable);

                Response.Write("<script>alert('Order stored successfully');</script>");
                Response.Redirect("OrderStatus.aspx");
            }


        }


        protected void UpdateOrders(string oNum, string buttonID)
        {
            cnDryClean.Open();
            string sql = "Insert into Orders (CustomerId, ClothId, OrderNum)" +
                        " Values (@customerId, @clothId, @orderNum )";
            using (SqlCommand cmd = new SqlCommand(sql, cnDryClean))
            {
                // set up all parameters

                cmd.Parameters.Add("@customerId", SqlDbType.VarChar);
                cmd.Parameters["@customerId"].Value = custIde.Text;

                cmd.Parameters.Add("@clothId", SqlDbType.VarChar);
                cmd.Parameters["@clothId"].Value = buttonID;
                cmd.Parameters.Add("@orderNum", SqlDbType.VarChar);
                cmd.Parameters["@orderNum"].Value = oNum;
                cmd.ExecuteNonQuery();
            }
            cnDryClean.Close();
        }


        protected void addToBill(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            string buttonId = button.ID;
            //generate order number for this table
            string oNum = numOfRows(ordersTable, "ON");
            UpdateOrders(oNum, buttonId);
            LoadOrderSummary(oNum);
        }



        protected void LoadInInvoiceTable(string orderNum)
        {
            cnDryClean.Open();
            SqlCommand cmd = cnDryClean.CreateCommand();
            cmd.CommandText = "select SUM(c.ClothCleaningPrice) FROM Cloth c " +
                "INNER JOIN Orders o ON c.ClothId = o.ClothId WHERE OrderNum = @orderNum";

            cmd.Parameters.Add("@orderNum", SqlDbType.VarChar);
            cmd.Parameters["@orderNum"].Value = orderNum;
            TotalAmt.Text = (cmd.ExecuteScalar()).ToString();
            object billAmt = cmd.ExecuteScalar();
            cnDryClean.Close();
            InsertToInvoice(billAmt, orderNum);


        }

        protected void InsertToInvoice(object billAmt, string orderNum)
        {
            string invId = numOfRows(invoiceTable, "I");
            cnDryClean.Open();
            string sql = "Insert into Invoice (InvoiceId, BillAmount, Paid, CustomerId, PickupDate, OrderDate, OrderNum)" +
                        " Values (@invoiceId, @billAmount, 'False', @customerId, @PickupDate, @OrderDate, @orderNum)";
            using (SqlCommand cmd = new SqlCommand(sql, cnDryClean))
            {
                // set up all parameters

                cmd.Parameters.Add("@customerId", SqlDbType.VarChar);
                cmd.Parameters["@customerId"].Value = custIde.Text;
                cmd.Parameters.Add("@invoiceId", SqlDbType.VarChar);
                cmd.Parameters["@invoiceId"].Value = invId;
                cmd.Parameters.Add("@billAmount", SqlDbType.Money);
                cmd.Parameters["@billAmount"].Value = billAmt;
                cmd.Parameters.Add("@OrderDate", SqlDbType.VarChar);
                cmd.Parameters["@OrderDate"].Value = orderDate.Value;
                cmd.Parameters.Add("@PickupDate", SqlDbType.VarChar);
                cmd.Parameters["@PickupDate"].Value = pickupDate.Value;
                cmd.Parameters.Add("@orderNum", SqlDbType.VarChar);
                cmd.Parameters["@orderNum"].Value = orderNum;

                cmd.ExecuteNonQuery();
            }
            cnDryClean.Close();
            InvoiceIdGenerated = true;
        }
        protected void LoadOrderSummary(string orderNum)
        {
            cnDryClean.Open();

            string sql = "select c.ClothName, c.ClothCleaningPrice FROM Cloth c " +
                "INNER JOIN Orders o ON c.ClothId = o.ClothId WHERE OrderNum = @orderNum";
            using (SqlCommand cmd = new SqlCommand(sql, cnDryClean))
            {
                cmd.Parameters.Add("@orderNum", SqlDbType.VarChar);
                cmd.Parameters["@orderNum"].Value = orderNum;
                SqlDataReader dr = cmd.ExecuteReader();
                ordersTable.Load(dr);
                dr.Close();
            }
            cnDryClean.Close();
            OrdersGrid.DataSource = ordersTable;
            OrdersGrid.DataBind();


        }
    }
}