/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DTOs.Movie;
import Interfaces.MovieInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jimmy_2u626cl
 */
public class MoviesDAO extends DAOs.DAO implements MovieInterface {

    @Override
    public ArrayList<Movie> getAllMovies() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            con = getConnection();
            String query = "Select * from movie";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            // Movie m = new Movie();

            while (rs.next()) {

                Movie m = new Movie();

                m.setMovieName(rs.getString("movieName"));
                m.setLength(rs.getString("length"));
                m.setGenre(rs.getString("genre"));
                m.setIMDBnumber(rs.getInt("IMDBnumber"));
                m.setPosterURL(rs.getString("posterURL"));

                movies.add(m);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllMovies() method");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the  getAllMovies() method");
            }
        }
        return movies;
    }

    @Override
    public void addMovie(Movie aMovie) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Movie newMovie = aMovie;

        int rowsAffected = 0;

        try {

            conn = getConnection();

            ps = conn.prepareStatement("INSERT into movies values(?,?,?,?,?,?)");

            ps.setInt(1, 0);
            ps.setString(2, newMovie.getMovieName());
            ps.setString(3, newMovie.getLength());
            ps.setString(4, newMovie.getGenre());
            ps.setString(5, newMovie.getPosterURL());
            ps.setInt(6, newMovie.getIMDBnumber());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close the PreparedStatement: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Exception occurred when attempting to close the Connection: " + ex.getMessage());
                }
            }
        }
    }

    @Override
    public int removeMovie(Movie movieID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getFrameWork(String frameWork) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<String> list = new ArrayList<String>();

        String data;
        try {
            ps = conn
                    .prepareStatement("SELECT * FROM movies  WHERE movieName LIKE ?");
            ps.setString(1, frameWork + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                data = rs.getString("movieName");
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
