<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Book Store (Web Patterns)
    Year       : 3
--%>

<%@page import="DAOs.UserDAO"%>
<%@page import="DTOs.Users"%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <title>Registration Page</title>
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
        String userN = logedUser.getUsername();
        
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
            <strong>Registration has been Successful!</strong>
    </div>
    <br />
        <%
            // Get the result from the session (how many customers were updated)

            Users newUser = (Users) session.getAttribute("login");

            String userN = newUser.getFirstname();

            java.util.Date date = new java.util.Date();
            UserDAO getDate = new UserDAO();
            date = getDate.getExpireDate(newUser.getUsername());
            //String passW = logedUser.;
            String mgs = "";
            // If we have a result value to use, then display it
            if (newUser != null) {
                mgs = "Welcome to MultiPlex Cinema " + userN;
                // Cast it to a number
                //  Integer result = (Integer) resultValue;
            } else {
                mgs = "Failed Registration..";
            }
        %>
        <!-- display the number of customers updated -->

        <h3><%=mgs%>!</h3>
        <br /><br />
    </body>
    <%@include file="footer.jsp" %>
</html>
