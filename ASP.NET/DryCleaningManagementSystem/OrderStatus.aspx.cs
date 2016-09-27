using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

namespace DryCleaningManagementSystem
{
    public partial class OrderStatus : System.Web.UI.Page
    {
        SqlConnection DryCleanInv = new SqlConnection();
        DataTable orderTable = new DataTable();

        protected void Page_Load(object sender, EventArgs e)
        {

            var cstr = System.Configuration.ConfigurationManager.ConnectionStrings["DryCleanInventory"];
            string strConn = cstr.ConnectionString;
            DryCleanInv = new SqlConnection(strConn);

            if (!IsPostBack)
            {
                LoadTable();
                loadName();
                LoadOrderDetailGrid();

            }

        }
        protected void LoadTable()
        {
            DryCleanInv.Open();
            orderTable.Clear();

            string custIdCheck = (string)Session["cusid"];


            //string sql = "SELECT Orders.OrderId, Orders.OrderDate, Orders.PickupDate, Invoice.BillAmount FROM Invoice INNER JOIN Customers ON Invoice.CustomerId = Customers.CustomerId INNER JOIN Orders ON Customers.CustomerId = Orders.CustomerId INNER JOIN Cloth ON Orders.ClothId = Cloth.ClothId where Customers.CustomerId = @id";
            // string sql = "SELECT * FROM Customers where Customers.CustomerId = @id";
            string sql = "SELECT i.InvoiceId, i.OrderDate, i.PickupDate, i.BillAmount, i.OrderNum FROM Customers c INNER JOIN " +
                         "Invoice i ON c.CustomerId = i.CustomerId WHERE c.CustomerId = @id";
            using (SqlCommand cmd = new SqlCommand(sql, DryCleanInv))
            {
                cmd.Parameters.Add("@id", SqlDbType.VarChar);
                cmd.Parameters["@id"].Value = custIdCheck;
                SqlDataReader dr = cmd.ExecuteReader();
                orderTable.Load(dr);
                dr.Close();
            }
            DryCleanInv.Close();
        }


        protected void loadName()
        {
            DryCleanInv.Open();
            SqlCommand cmd = DryCleanInv.CreateCommand();
            string custIdCheck = (string)Session["cusid"];
            cmd.CommandText = "select customerFName FROM Customers WHERE CustomerId = @id";

            cmd.Parameters.Add("@id", SqlDbType.VarChar);
            cmd.Parameters["@id"].Value = custIdCheck;
            cNameLbl.Text = (cmd.ExecuteScalar()).ToString();
            cIdLbl.Text = custIdCheck;
            DryCleanInv.Close();
        }


        protected void pickUpTime(object sender, EventArgs e)
        {
            string check = null;
            LoadTable();
            if (orderTable.Rows.Count > 0)
            {

                for (int i = 0; i < orderDetail.Rows.Count; i++) //Check if item is selected  
                {
                    if (((RadioButton)orderDetail.Rows[i].FindControl("RowSelector")).Checked)
                    {
                        check = orderDetail.Rows[i].Cells[5].Text; // get the order number

                    }
                }

                Session["custOrderNum"] = check;
                Response.Redirect("showInvoice.aspx");


            }
            else
            {
                Response.Write("<script>alert('There are no orders for this customer');</script>");
            }

        }


        protected void LoadOrderDetailGrid()
        {

            if (orderTable.Rows.Count > 0)
            {
                orderDetail.DataSource = orderTable;
                orderDetail.DataBind();
                ((RadioButton)orderDetail.Rows[0].FindControl("RowSelector")).Checked = true;
            }
            else
            {
                Label msg = new Label();
                msg.Text = "There are no previous orders for this customer";
                msg.Attributes.CssStyle.Add("margin", "40px");
                this.Controls.Add(msg);
            }
        }
    }
}