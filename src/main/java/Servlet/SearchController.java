/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAOs.MoviesDAO;
import DTOs.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author jimmy_2u626cl
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})

public class SearchController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
//            JSONArray jsonArr = new JSONArray();
//
//            JSONObject json = new JSONObject();
//
//            json.put("name", "abc");
//            json.put("value", "abc101");
//            jsonArr.add(json);
            String term = request.getParameter("term");
            System.out.println("Data from ajax call " + term);

            MoviesDAO dataDao = new MoviesDAO();
            ArrayList<String> list = dataDao.getFrameWork(term);

            //       out.write(list);
            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
