<%-- 
    Document   : BookingForm
    Created on : 03-Feb-2017, 09:54:34
    Author     : jimmy_2u626cl
--%>

<%@page import="DTOs.Users"%>
<%@page import="DAOs.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>

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
    <head>
        <script src="autocompleter.js"></script>
        <script>
            $(document).ready(function () {
                $(function () {
                    $("#search").autocomplete({
                        source: function (request, response) {
                            $.ajax({
                                url: "SearchController",
                                type: "GET",
                                data: {
                                    term: request.term
                                },
                                dataType: "json",
                                success: function (data) {
                                    response(data);
                                }
                            });
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <h1>Make A Booking</h1>
        <div class="container2">
            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <h3 class="title">Bookings</h3>
                    </div>
                </div> 
                <div class="main-login main-center">

                    <form class="form-horizontal" method="post" action="FrontController">


                        <div class="row">
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <h3><span class="label label-default">Select Screen</span></h3>
                                    <select class="selectpicker form-control"  >
                                        <option>IMAXX</option>
                                        <option>2D</option>
                                        <option>3D</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <h3><span class="label label-default">Select Movie</span></h3>
                                    <input  class="form-control" type="text" id="search" name="search" class="search">

                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="cols-sm-2 control-label">Select Time</label>
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
</html>
