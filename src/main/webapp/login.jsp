<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Book Store (Web Patterns)
    Year       : 3
--%>

<%@page import="DTOs.Users"%>
<%@page import="DAOs.UserDAO"%>
<%@include file="header.jsp" %>
 <title>Login Page</title>
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
       
         <div class="container">
            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">                  
                        <h3 class="title">Please Login</h3>
                    </div>
                </div> 
                <div class="main-login main-center">
                    <form class="form-horizontal" method="post" action="FrontController">

                        <div class="form-group">
                            <label class="cols-sm-2 control-label">Username</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="username" id="name" required  placeholder="Enter your Name"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="email" required  placeholder="Enter your password"/>
                                </div>
                            </div>
                        </div>
                        <div class="buttonHolder">
                            <input type="submit" value="Login" class="btn btn-default" />
                            <!-- Include a hidden field to identify what the user wants to do -->
                            <input type="hidden" name ="action" value="login" />

                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
