<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Book Store (Web Patterns)
    Year       : 3
--%>

<%@page import="DTOs.Users"%>
<%@page import="DAOs.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<title>Register Page</title>
<head>
    <script type="text/javascript">
            $(document).ready(function () {
                $(".uname").change(function () {
                    var uname = $(this).val();
                    if (uname.length > 3) {
                        $(".status").html("<img src='./img/loading.gif'><font color=gray>Checking Availability...</font>");
                        $.ajax({
                            type: "POST",
                            url: "AjaxController",
                            data: "uname=" + uname,
                            success: function (msg) {

                                $(".status").ajaxComplete(function (event, request, settings) {

                                    $(".status").html(msg);

                                });
                            }
                        });
                    } else {

                        $(".status").html("<font color=red>Enter at least 4 Chars</font>");
                    }

                });
            });
        </script>

</head>
<%
    try {
        if (session.getAttribute("login") == null) {
%>
<%@include file="navForGuest.jsp" %>
<% }
    if (session.getAttribute("login") != null) {

        UserDAO checkuser = new UserDAO();
        Users logedUser = (Users) session.getAttribute("login");
        String userN = logedUser.getFirstname();

        if (checkuser.getUserType(userN) == 1) {

%>
<%@include file="navForAdmin.jsp" %>
<%} else {%>
<%@include file="nav.jsp" %>
<%}
        }
    } catch (Exception ex) {
        out.println(ex.getMessage());
    }
%>
<body>

    <div class="container2">
        <div class="row main">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <h3 class="title">Registration</h3>
                </div>
            </div> 
            <div class="main-login main-center">
                
                <form class="form-horizontal" method="post" action="FrontController">

                <div class="form-group">
                    <label class="cols-sm-2 control-label">Username</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-male fa-lg" aria-hidden="true"></i></span>
                            <input placeholder="Enter Your Username" style="width:428px; height:30px;padding-left: 10px; border-radius:0px 6px 0px 0px;" type="text" name="Username" class="uname"  /><span class="status"></span>

                        </div>
                    </div>

                </div>


                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon" id="username_message"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input class="form-control" type="password" class="form-control" name="Password" id="confirm"  placeholder="Enter Your Password"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="cols-sm-2 control-label">First Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="Firstname" id="name" required  placeholder="Enter your First Name" pattern="[A-Za-z]+"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="cols-sm-2 control-label">Last Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="Lastname" id="email"  placeholder="Enter your Last Name" pattern="[A-Za-z]+"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Phone Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-phone fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="Phone" id="username"  placeholder="Enter your Phone Number" pattern="[0-9]{3}[0-9]{7}" title="Enter 10 Digit Number ie(08612341212)"/>

                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="Email" id="username"  placeholder="Enter your Email Address" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Address</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-address-book-o fa" aria-hidden="true"></i></span>
                                <input  class="form-control" name="Address" id="confirm"  placeholder="Enter Your Address"/>
                            </div>
                        </div>
                    </div>




                    <div class="buttonHolder">
                        <input type="submit" value="Register" class="btn btn-default" />
                        <!-- Include a hidden field to identify what the user wants to do--> 
                        <input type="hidden" name="action" value="register" />
                        <!--  <input type="hidden" name="action2" value="checkUsername" />-->
                    </div>

                    <div class="login-register">

                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<%@include file="footer.jsp" %>
</html>
