<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
   
--%>

<%@page import="DTOs.Users"%>
<%@page import="DAOs.UserDAO"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <title>Error Page</title>
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
        
        <br /><br />

        <%
            Object msg = session.getAttribute("errorMessage");
            String error = (String) msg;
        %>

        <div class="alert alert-danger">
            <strong><%=error%></strong>
        </div>

        <%
            session.removeAttribute("errorMessage");
        %>
        <br /><br />
        <center><input type="button" value="Back" onclick="window.history.back()" /></center> 
    </body>
</html>
