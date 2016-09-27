<%@ Page Title="" Language="C#" MasterPageFile="~/Site2.Master" AutoEventWireup="true" CodeBehind="createLogin.aspx.cs" Inherits="DryCleaningManagementSystem.createLogin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div class="container">

        <div class="row clearfix">
            <div class="col-md-4 col-md-offset-4">

                <div class="form-group">
                    <label>Please Enter customer details.</label>

                    <br />
                    <br />

                    <label>FirstName: </label>
                    <input type="text" id="fname" class="form-control" runat="server" />

                    <br />

                    <label>LastName: </label>
                    <input type="text" id="lname" class="form-control" runat="server" />

                    <br />

                    <label>Address: </label>
                    <input type="text" id="address" class="form-control" runat="server" />

                    <br />

                    <label>Phone Number: </label>
                    <input type="number" id="phone" class="form-control" runat="server" />

                    <br />

                    <%--<label> Password: </label>
    <input id="newPassword" type="password" />

    <label> Phone Number: </label>--%>

                    <asp:Button ID="createbtn" runat="server" CssClass="btn btn-default" Text="Create New User" OnClick="createbtn_Click" />


                    <asp:Button ID="backbtn" runat="server" CssClass="btn btn2 btn-default" Text="Back" OnClick="backbtn_Click" />

                </div>
            </div>

        </div>
    </div>

</asp:Content>
