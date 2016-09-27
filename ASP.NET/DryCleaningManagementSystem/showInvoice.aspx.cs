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
    public partial class showInvoice : System.Web.UI.Page
    {
        SqlConnection DryCleanInv = new SqlConnection();

        protected void Page_Load(object sender, EventArgs e)
        {
            var cstr = System.Configuration.ConfigurationManager.ConnectionStrings["DryCleanInventory"];
            string strConn = cstr.ConnectionString;
            DryCleanInv = new SqlConnection(strConn);
            if (!IsPostBack)
            {
                LoadTable();

            }

        }

        protected void LoadTable()
        {
            string check = (string)Session["custOrderNum"];
            DryCleanInv.Open();
            DataTable dtable = new DataTable();
            string sql = "";
            sql = "SELECT c.CustomerId, c.CustomerFName, i.* FROM invoice i INNER JOIN customers c " +
                "ON i.CustomerId = c.CustomerId WHERE i.OrderNum = @id";
            using (SqlCommand cmd = new SqlCommand(sql, DryCleanInv))
            {
                cmd.Parameters.Add("@id", SqlDbType.VarChar);
                cmd.Parameters["@id"].Value = check;

                SqlDataReader dr = cmd.ExecuteReader();
                dtable.Load(dr);
                dr.Close();
            }

            orderInvoice.DataSource = dtable;
            orderInvoice.DataBind();

            DryCleanInv.Close();
        }

        protected void deleteOrder(object sender, EventArgs e)
        {
            string check = (string)Session["custOrderNum"];

            //delete row when customer picks up
            DryCleanInv.Open();
            DataTable dtable = new DataTable();
            DataTable delOrders = new DataTable();
            string sql = "DELETE FROM Invoice " +
                        "where OrderNum = @id";

            using (SqlCommand cmd = new SqlCommand(sql, DryCleanInv))
            {
                cmd.Parameters.Add("@id", SqlDbType.VarChar);
                cmd.Parameters["@id"].Value = check;

                SqlDataReader dr = cmd.ExecuteReader();
                dtable.Load(dr);
                dr.Close();
            }

            string sql2 = "DELETE FROM  Orders " +
                        "where OrderNum = @id";

            using (SqlCommand cmd = new SqlCommand(sql2, DryCleanInv))
            {
                cmd.Parameters.Add("@id", SqlDbType.VarChar);
                cmd.Parameters["@id"].Value = check;

                SqlDataReader dr = cmd.ExecuteReader();
                delOrders.Load(dr);
                dr.Close();
            }

            Response.Write("<script>alert('Order successfully checked out from inventory');</script>");
            DryCleanInv.Close();

            Response.Redirect("OrderStatus.aspx");

        }
    }
}