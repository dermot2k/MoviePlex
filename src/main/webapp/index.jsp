<%-- 
    Author     : Dermot Rogan
    Author     : Jimmy Treanor
    Project    : Book Store (Web Patterns)
    Year       : 3
--%>

<%@page import="DTOs.Movie"%>
<%@page import="DAOs.MoviesDAO"%>
<%@page import="DTOs.Users"%>
<%@page import="DAOs.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>

<title>Multiplex Cinema</title>

<body>

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

    <%
        MoviesDAO allMovies = new MoviesDAO();
        ArrayList<Movie> movies = allMovies.getAllMovies();

        for (Movie m : movies) {
            out.println(m.getMovieName());
            out.println(m.getGenre());
            out.println(m.getLength());
            out.println(m.getIMDBnumber());
            out.println(m.getPosterURL());

        }

    %>

