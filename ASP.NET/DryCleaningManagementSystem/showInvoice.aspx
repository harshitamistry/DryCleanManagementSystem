<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="showInvoice.aspx.cs" Inherits="DryCleaningManagementSystem.showInvoice" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="orderAlign">
                    <asp:DetailsView ID="orderInvoice" runat="server">
                    </asp:DetailsView>

                    <%--</div> --%>
                    <div class="checkoutOrder">
                        <asp:Button ID="checkOutOrder" CssClass="btn btn-success" runat="server" Text="Check out Order" OnClick="deleteOrder" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
