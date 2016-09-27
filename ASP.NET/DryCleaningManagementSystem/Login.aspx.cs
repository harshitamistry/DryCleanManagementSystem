using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

// adding libraries
using System.Data;
using System.Data.SqlClient;

namespace DryCleaningManagementSystem
{
    public partial class Login : System.Web.UI.Page
    {
        SqlConnection DryClean = new SqlConnection();
        DataTable maintable = new DataTable();

        bool phNotFound = false;
        String field1;

        protected void Page_Load(object sender, EventArgs e)
        {
            var cstr = System.Configuration.ConfigurationManager.ConnectionStrings["DryCleanInventory"];
            string strConn = cstr.ConnectionString;
            DryClean = new SqlConnection(strConn);

            if (!IsPostBack)
            {
                //LoadTable();

            }
        }


        // redirecting the page to create a new user page
        protected void newUserbtn_Click(object sender, EventArgs e)
        {
            Response.Redirect("createLogin.aspx");
        }

        protected void LoadTable()
        {
            maintable.Clear();
            DryClean.Open();

            string sql = "SELECT Customers.CustomerID FROM Customers where Customers.CustomerContactNo = @phone";

            using (SqlCommand cmd = new SqlCommand(sql, DryClean))
            {
                cmd.Parameters.Add("@phone", SqlDbType.VarChar);
                cmd.Parameters["@phone"].Value = loginid.Value;

                SqlDataReader dr = cmd.ExecuteReader();
                maintable.Load(dr);
                if (maintable.Rows.Count == 0)
                {
                    // Response.Write("<script>alert('Customer with this phone number doesnt exist. Create new customer.');</script>");
                    phNotFound = true;
                }
                dr.Close();
            }


            DryClean.Close();
        }




        public void sessionGenetate()
        {
            DryClean.Open();
            SqlCommand cmd = DryClean.CreateCommand();
            cmd.CommandText = "SELECT Customers.CustomerID FROM Customers where Customers.CustomerContactNo = @phone";

            cmd.Parameters.Add("@phone", SqlDbType.VarChar);
            cmd.Parameters["@phone"].Value = loginid.Value;
            Session["cusid"] = (cmd.ExecuteScalar()).ToString();

            DryClean.Close();


        }

        protected void submitbtn_Click(object sender, EventArgs e)
        {
            bool idInvalid = false;



            //bool idFound = false;

            if (loginid.Value == "" || loginid.Value.Length > 10 || loginid.Value.Length < 10)
            {
                idInvalid = true;
            }
            LoadTable();


            if (idInvalid)
            {
                Response.Write("<script>alert('Please enter valid phone number');</script>");
                loginid.Value = "";

            }
            else if (phNotFound)
            {
                Response.Write("<script>alert('Customer with this phone number doesnt exist. Create new customer.');</script>");
                loginid.Value = "";
            }
            else
            {
                DetailsView1.DataSource = maintable;
                DetailsView1.DataBind();
                //Cache["data"] = maintable.ToString();
                //Server.Transfer("WebForm3.aspx");
                //Session["cusid"] = maintable;
                sessionGenetate();
                Response.Redirect("OrderStatus.aspx");
            }



        }

    }
}