<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Orders.aspx.cs" Inherits="DryCleaningManagementSystem.Orders" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <div class="container-fluid">

        <small id="cname">Customer Name :</small>
        <asp:Label ID="cNameLbl" runat="server"></asp:Label>

        <br />
        <small id="cId">Customer id :</small>
        <asp:Label ID="custIde" runat="server"></asp:Label>



    </div>
    <div class="container">
        <div class="row ">
            <div class="col-md-8 col-md-offset-2">
                <%--<div class ="orderAlign">--%>
                <div id="userCreate">

                    <div class="form-group">

                        <table>
                            <tr>
                                <td>
                                    <asp:Button ID="C1" runat="server" Text="Shirt (S)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C2" runat="server" Text="Shirt (M)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C3" runat="server" Text="Shirt (L)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C4" runat="server" Text="Pant (S)" CssClass="btn btn-default" OnClick="addToBill" /></td>

                            </tr>
                            <tr>
                                <td>
                                    <asp:Button ID="C5" runat="server" Text="Pant (M)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C6" runat="server" Text="Pant (L)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C7" runat="server" Text="Dress (S)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C8" runat="server" Text="Dress (M)" CssClass="btn btn-default" OnClick="addToBill" /></td>

                            </tr>
                            <tr>
                                <td>
                                    <asp:Button ID="C9" runat="server" Text="Dress (L)" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C10" runat="server" Text="Bedsheet" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C11" runat="server" Text="Winter Coat" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C12" runat="server" Text="Jeans" CssClass="btn btn-default" OnClick="addToBill" /></td>

                            </tr>
                            <tr>
                                <td>
                                    <asp:Button ID="C13" runat="server" Text="Blazer" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C14" runat="server" Text="Sweater" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C15" runat="server" Text="Table Cloth" CssClass="btn btn-default" OnClick="addToBill" /></td>
                                <td>
                                    <asp:Button ID="C16" runat="server" Text="Towel" CssClass="btn btn-default" OnClick="addToBill" /></td>

                            </tr>


                        </table>
                        <div class="orderAlign">


                            <asp:GridView ID="OrdersGrid" runat="server" />


                            <br />
                            <label>Order Date:</label>
                            <input type="date" id="orderDate" runat="server" />
                            <br />
                            <br />
                            <label>Pickup Date:</label>
                            <input type="date" id="pickupDate" runat="server" /><br />
                            <br />
                            <label>This is total </label>
                            <asp:TextBox ID="TotalAmt" runat="server"></asp:TextBox>

                            <br />
                            <br />
                        </div>
                    </div>

                    <asp:Button ID="submitBtn" runat="server" Text="Submit" CssClass="btn btnCheckOut btn-default" OnClick="checkTotalAmount" />
                </div>
            </div>

        </div>
    </div>
</asp:Content>
