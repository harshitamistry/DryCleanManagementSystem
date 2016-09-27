<%@ Page Title="" Language="C#" MasterPageFile="~/Site2.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="DryCleaningManagementSystem.Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">


                <h2 class="form-signin-heading">Please enter your phone number</h2>
                <label class="sr-only">Phone Number: </label>
                <br />
                <input type="text" id="loginid" runat="server" class="form-control" placeholder="Phone Number" />

                <br />
                <br />
                <br />


                <asp:Button ID="newUserbtn" CssClass="btn btn-lg btn-primary btn-block" runat="server" Text="Create New User" OnClick="newUserbtn_Click" />

                <br />
                <br />

                <asp:Button ID="submitbtn" CssClass="btn btn-lg btn-primary btn-block" runat="server" Text="Login" OnClick="submitbtn_Click" />

                <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px"></asp:DetailsView>



            </div>
        </div>
    </div>

</asp:Content>

