using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Threading;

// adding libraries
using System.Data;
using System.Data.SqlClient;


namespace DryCleaningManagementSystem
{
    public partial class createLogin : System.Web.UI.Page
    {
        SqlConnection DryClean = new SqlConnection();
        DataTable verifytable = new DataTable();
        DataTable custid = new DataTable();
        DataTable verifyPhone = new DataTable();

        bool phoneFound = false;
        String num;
        int customerid;
        protected void Page_Load(object sender, EventArgs e)
        {
            var cstr = System.Configuration.ConfigurationManager.ConnectionStrings["DryCleanInventory"];
            string strConn = cstr.ConnectionString;
            DryClean = new SqlConnection(strConn);

            if (!IsPostBack)
            {
                LoadTable();
            }

        }

        protected void backbtn_Click(object sender, EventArgs e)
        {
            Response.Redirect("login.aspx");
        }


        protected void checkPhNumber()
        {
            verifyPhone.Clear();
            DryClean.Open();

            string sql = "SELECT * FROM Customers where Customers.CustomerContactNo = @phone";

            using (SqlCommand cmd = new SqlCommand(sql, DryClean))
            {
                cmd.Parameters.Add("@phone", SqlDbType.VarChar);
                cmd.Parameters["@phone"].Value = phone.Value;

                SqlDataReader dr = cmd.ExecuteReader();
                verifyPhone.Load(dr);
                if (verifyPhone.Rows.Count > 0)
                {
                    // Response.Write("<script>alert('Customer with this phone number doesnt exist. Create new customer.');</script>");
                    phoneFound = true;
                }
                dr.Close();
            }


            DryClean.Close();
        }

        protected void LoadTable()
        {
            DryClean.Open();
            verifytable.Clear();
            string sql = "SELECT * FROM Customers";

            using (SqlCommand cmd = new SqlCommand(sql, DryClean))
            {
                SqlDataReader dr = cmd.ExecuteReader();
                verifytable.Load(dr);
                dr.Close();
            }

            DryClean.Close();
        }

        protected void createbtn_Click(object sender, EventArgs e)
        {
            //counter();
            bool idInvalid = false;
            bool idFound = false;

            LoadTable();
            checkPhNumber();

            if (phoneFound)
            {

                Label label = new Label();
                label.Text = "Phone number already exist! Please enter new one!";
                phone.Value = "";
                label.Attributes.CssStyle.Add("margin", "40px");
                this.Controls.Add(label);

            }

            if (phone.Value == "" || fname.Value == "" || phone.Value.Length < 10 || phone.Value.Length > 10)
            {
                idInvalid = true;
            }




            //customeriderror();

            //for (int crow = 0; crow < verifytable.Rows.Count; crow++)
            //{
            //    if (verifytable.Rows[crow][4] == phone.Value)
            //    {
            //        idFound = true;
            //    }
            //}


            if (idInvalid)
            {
                Response.Write("<script>alert('Check your first name and phone number');</script>");
            }



            if (!idInvalid && !idFound)
            {
                // custidgenerator();
                string custId = numOfRows(verifytable);
                AddToCustomers(custId);
                Reset();
            }

        }

        protected string numOfRows(DataTable tableName)
        {
            int rowNums = tableName.Rows.Count + 1;

            string opString = rowNums.ToString();
            return opString;
        }

        protected void custidgenerator()
        {
            DryClean.Open();

            string sql = "SELECT Customers.* FROM Customers";

            using (SqlCommand cmd = new SqlCommand(sql, DryClean))
            {
                SqlDataReader dr = cmd.ExecuteReader();
                custid.Load(dr);
                dr.Close();
            }

            DryClean.Close();

            //for (int crow = 0; crow < verifytable.Rows.Count; crow++)
            //{
            //    if (verifytable.Rows[crow][4] == phone.Value)
            //    {
            //        idFound = true;
            //    }

            num = (custid.Rows[custid.Rows.Count - 1][0]).ToString();

            customerid = Int32.Parse(num) + 1;

        }

        protected void AddToCustomers(string custIdAdd)
        {
            DryClean.Open();

            custid.Clear();
            string sql = "Insert into Customers (CustomerId, CustomerFName, CustomerLName, CustomerAddress, CustomerContactNo) Values (@cid, @fname, @lname, @address, @phone)";

            using (SqlCommand cmd = new SqlCommand(sql, DryClean))
            {
                // setting up all parameters

                cmd.Parameters.Add("@cid", SqlDbType.VarChar);
                cmd.Parameters["@cid"].Value = custIdAdd;

                cmd.Parameters.Add("@fname", SqlDbType.VarChar);
                cmd.Parameters["@fname"].Value = fname.Value;

                cmd.Parameters.Add("@lname", SqlDbType.VarChar);
                cmd.Parameters["@lname"].Value = lname.Value;

                cmd.Parameters.Add("@address", SqlDbType.VarChar);
                cmd.Parameters["@address"].Value = address.Value;

                cmd.Parameters.Add("@phone", SqlDbType.VarChar);
                cmd.Parameters["@phone"].Value = phone.Value;

                cmd.ExecuteNonQuery();
            }

            DryClean.Close();

            Response.Write("<script>alert('Account Created');</script>");

            Reset();
        }

        protected void Reset()
        {
            fname.Value = "";
            lname.Value = "";
            address.Value = "";
            phone.Value = "";



            Response.Redirect("Login.aspx");

        }
    }
}