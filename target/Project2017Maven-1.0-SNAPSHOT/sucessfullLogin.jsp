<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Book Store (Web Patterns)
    Year       : 3
--%>

<%@page import="DTOs.Users" %>
<%@page import="DAOs.UserDAO" %>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged in Page</title>
        <style>

        </style>
    </head>

    <body>

            <%
        try {
        if (session.getAttribute("login") == null) {
    %>
        <%@include file="navForGuest.jsp" %>
    <% }
        if (session.getAttribute("login") != null){

        UserDAO checkuser = new UserDAO();
        Users logedUser = (Users) session.getAttribute("login");
        String userN = logedUser.getFirstname();
        
        if (checkuser.getUserType(userN) == 1){

    %>
        <%@include file="navForAdmin.jsp" %>
    <%} else {%>
        <%@include file="nav.jsp" %>
    <%}}}
        catch (Exception ex){
        out.println(ex.getMessage());
        }
    %>

        <div class="alert alert-success">
            <strong>Logged in Successfully!</strong>
        </div>
    
        <%

            Users logedUser = (Users) session.getAttribute("login");

            String userN = logedUser.getFirstname();

            java.util.Date date = new java.util.Date();
            String mgs = "", mgs2 = "",mgs3 = "";

            if (logedUser != null) {
                mgs = "Welcome Back to the Omniplex Cinema " + userN;
                UserDAO checkuser = new UserDAO();
       
                if (checkuser.getUserType(userN) == 0){
                mgs3 = "UserType: User";
                }

            }

            UserDAO checkLifespanOfPass = new UserDAO();
            boolean lifeSpan = checkLifespanOfPass.checkLifeSpan(logedUser.getUsername(), logedUser.getPassword());

            UserDAO getDate = new UserDAO();
            date = getDate.getExpireDate(logedUser.getUsername());

            if (lifeSpan == false) {

                mgs2 = "Your Password has expired..update your password now..";
                //need to redirect to reset password page
                response.sendRedirect("changePasswordExp.jsp");
            } else {
                mgs2 = "Password OK.."
                        + "Your Password will expire 0n " + date;
            }
        %>
        <!-- display the number of customers updated -->

        <h3><%=mgs%></h3>
        <div class="alert alert-info">
            <strong><%=mgs3%></strong>
        </div>
        <div class="alert alert-danger">
        <strong><%=mgs2%></strong>
        </div>





    </body>
</html>
