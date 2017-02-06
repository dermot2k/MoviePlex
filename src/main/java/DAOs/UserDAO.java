/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DTOs.Users;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jimmy_2u626cl
 */
public class UserDAO extends DAOs.DAO implements Interfaces.UserInterface {

    public int addUser(Users user) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users newUser = user;

        int rowsAffected = 0;

        try {

            java.util.Date date = new java.util.Date();
            java.util.Date date3 = new java.util.Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date3);
            cal.add(Calendar.DATE, 60); // 60 is the lifespan of password  
            date3 = cal.getTime();

            conn = getConnection();

            ps = conn.prepareStatement("INSERT into Users values(?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, 0);
            ps.setString(2, newUser.getFirstname());
            ps.setString(3, newUser.getLastname());
            ps.setString(4, newUser.getAddress());
            ps.setString(5, newUser.getPhone());
            ps.setString(6, newUser.getEmail());
            ps.setString(7, newUser.getUsername());
            ps.setString(8, newUser.getPassword());
            ps.setString(9, newUser.getSalt());
            ps.setInt(10, 0);
            ps.setTimestamp(12, new Timestamp(date3.getTime()));

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

        if (rowsAffected > 0) {
            System.out.println("User added successfully.");
            //System.out.println(rowsAffected);
        } else if (rowsAffected == -1) {
            System.out.println("The User id supplied already exists. Please check the User details and try again.");
        } else {
            System.out.println("The User could not be added at this time.");
        }
        return rowsAffected;
    }

    @Override
    public ArrayList<Users> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users loginUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUsernameTaken(String username) {

        boolean check = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "Select * from Users WHERE Username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (!rs.next()) {

                check = true;
            }

            return check;
        } catch (SQLException e) {
            System.out.println("Exception in isUsernameTaken() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the isUsernameTaken() method: " + e.getMessage());
            }
        }
        return check;
    }

    @Override
    public boolean registerUser(Users user) {
        boolean registered = false;
        Connection con = null;
        PreparedStatement ps = null;
        int regcheck = 0;
        try {
            con = getConnection();

            String query = "INSERT INTO Users (Firstname, Lastname, Address, Phone, Email, Username, Password, Salt, isAdmin, PasswordExpDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            java.util.Date date = new java.util.Date();
            java.util.Date date3 = new java.util.Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date3);
            cal.add(Calendar.DATE, 30); // 30 is the lifespan of password  
            date3 = cal.getTime();

            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getSalt());
            ps.setInt(9, 0);
            ps.setTimestamp(10, new Timestamp(date3.getTime()));

            regcheck = ps.executeUpdate();
            registered = true;
        } catch (SQLException e) {
            System.out.println("Exception in register method: \n\n" + e.getMessage());
        } finally {
            try {
                //clean up
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception in finally section of register method: \n\n" + e.getMessage());
            }
        }
        if (regcheck > 0) {
            System.out.println("\nRegistration successfull!\n");
            //  System.out.println("press ENTER to Continue.\n");
        } else if (regcheck == -1) {
            System.out.println("User already exists.");
        } else {
            System.out.println("\nRegistration Failed!\n");
        }
        return registered;
    }

    @Override
    public boolean IsAdminUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeMember(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addMember(Users user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserType(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int type = 0;

        try {
            con = getConnection();

            String query = "Select isAdmin from users WHERE Username = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, username);
            // ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                type = rs.getInt("isAdmin");

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserType() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the  getUserType() method: " + e.getMessage());
            }
        }

        return type;
    }

    @Override
    public Date getExpireDate(String username) {

        boolean check = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.util.Date date1 = new java.util.Date();

        try {
            con = getConnection();

            String query = "Select PasswordExpDate from Users WHERE Username = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, username);
            // ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                date1 = rs.getDate("PasswordExpDate");

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getExpireDate() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the  getExpireDate() method: " + e.getMessage());
            }
        }

        return date1;
    }

    @Override
    public String getSalt(String username) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String mySalt = null;
        try {

            conn = getConnection();

            String query = "Select salt from users WHERE Username = ? ";

            ps = conn.prepareStatement(query);

            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {

                mySalt = rs.getString("salt");

            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the changeDeatails(String username, String password): " + e.getMessage());
        } finally {
            // Close prepared statement
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the changeDeatails(String username, String password): " + e.getMessage());
            }

            freeConnection(conn);
        }

        return mySalt;
    }

    @Override
    public Users login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;
        String checkPass = null;
        int check = 0;

        try {
            con = getConnection();

            String query = "Select * from users WHERE Username = ? AND Password = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                u = new Users(
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Salt"));

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in login method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the Member login(String username, String password) method: " + e.getMessage());
            }
        }

        return u;
    }

    @Override
    public boolean checkLifeSpan(String username, String password) {

        boolean check = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        long difference = 0;
        try {
            con = getConnection();

            String query = "Select * from users WHERE Username = ? AND Password = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {

                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();

                java.util.Date date1 = rs.getDate("PasswordExpDate");

                java.util.Date date2 = new java.util.Date();

                cal1.setTime(date2);
                cal2.setTime(date1);

                date2 = cal1.getTime();

                if (date2.after(date1)) {
                    // ("Date1 is after Date2");
                    check = false;
                } else if (date2.before(date1)) {
                    //("Date1 is before Date2");
                    check = true;
                } else if (date2.equals(date1)) {
                    //("Date1 is equals Date2");
                    check = true;
                }

            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the checkLifeSpan() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the  checkLifeSpan() method: " + e.getMessage());
            }
        }

        return check;
    }

    @Override
    public Users checkMemberUsernameAndPassword(String Username, String Password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;

        try {
            conn = getConnection();
            String query = "Select * from users WHERE Username = ? AND Password = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, Username);
            ps.setString(2, Password);

            rs = ps.executeQuery();
            // Loop through the result set
            if (rs.next()) {

                u = new Users(rs.getString("Firstname"), rs.getString("Lastname"), rs.getString("Address"), rs.getString("Phone"),
                        rs.getString("Email"), rs.getString("Username"), rs.getString("Password"), rs.getString("Salt"));

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the checkMemberByFirsrLastName() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of thecheckMemberByFirsrLastName() method: " + e.getMessage());
            }
        }
        return u;
    }

//    @Override
//    public boolean ajaxCall(String uname) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        
//        try {
//
//            conn = getConnection();
//            String uname = request.getParameter("uname");
//            // PreparedStatement ps = connection.prepareStatement("select Username from users where Username=?"); // users is the table containg used usernemes
//            ps.setString(1, uname);
//            ResultSet rs = ps.executeQuery();
//
//            if (!rs.next()) {
//                out.println("<font color=green><b>" + uname + "</b> is avaliable");
//
//            } else {
//                out.println("<font color=red><b>" + uname + "</b> is already in use</font>");
//            }
//            out.println();
//
//        } catch (Exception ex) {
//
//            out.println("Error123 ->" + ex.getMessage());
//
//        } finally {
//            out.close();
//        }
//       return null;
//    }
}
