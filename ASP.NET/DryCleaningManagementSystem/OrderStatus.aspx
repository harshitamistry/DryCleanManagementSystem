<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="OrderStatus.aspx.cs" Inherits="DryCleaningManagementSystem.OrderStatus" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="container">

        <small id="cname">Customer Name :</small>
        <asp:Label ID="cNameLbl" runat="server"></asp:Label>

        <br />
        <small id="cId">Customer id :</small>
        <asp:Label ID="cIdLbl" runat="server"></asp:Label>



    </div>

    <br />
    <br />

    <div class="container">
        <span class="label label-default">Order Status</span>
    </div>

    <br />
    <br />

    <div class="container">
        <asp:GridView ID="orderDetail" runat="server" CssClass="table table-hover table-bordered">
            <Columns>
                <asp:TemplateField HeaderText="select order">
                    <ItemTemplate>
                        <asp:RadioButton ID="RowSelector" runat="server" OnClick="javascript:selectOrderRadio(this)" />
                    </ItemTemplate>
                </asp:TemplateField>

            </Columns>
        </asp:GridView>

    </div>

    <asp:Button ID="checkOrders" runat="server" Text="Checkout" CssClass="btn btnCheckOut btn-default" OnClick="pickUpTime" />
</asp:Content>
