<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Cinema Booking and Seating system
    Year       : 3
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
     <%@include file="navForGuest.jsp" %>
    <body>
        <h1>You Have Loged Out...</h1>

        <%
            session.removeAttribute("login");
            session.removeAttribute("register");
            session.invalidate();
             response.sendRedirect("index.jsp");
        %>

        <a href="index.jsp">Back To index</a>
    </body>
</html>
