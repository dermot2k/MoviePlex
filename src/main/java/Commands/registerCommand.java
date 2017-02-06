/*
 * @Author: Dermot Rogan
 * @Author: Jimmy Treanor
 * @Project: LibaryApp_BookStoreCA
 */
package Commands;

import DAOs.UserDAO;
import DTOs.Users;
import static Encryption.SaltedPasswords.generateHash;
import static Encryption.SaltedPasswords.generateSalt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Dermot
 * @author Jimmy
 */
public class registerCommand implements Command {

    /**
     *
     * @param request
     * @param response
     * @return register a new user if all required fields are set & met in
     * register form
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

       
        String forwardToJsp;
        boolean regCheck = false;
        Users newUser = null;

        String Firstname = request.getParameter("Firstname");
        String Lastname = request.getParameter("Lastname");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");

        UserDAO checkUsername = new UserDAO();
        boolean check = checkUsername.isUsernameTaken(Username);

        if (check
                == true) {
            if (Firstname != null && !Firstname.equals("")
                    && Lastname != null && !Lastname.equals("")
                    && Phone != null && !Phone.equals("")
                    && Email != null && !Email.equals("")
                    && Address != null && !Address.equals("")
                    && Username != null && !Username.equals("")
                    && Password != null && !Password.equals("")) {

                String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{10,}";

                if (Password.matches(pattern)) {

                    //(?=.*[0-9]) a digit must occur at least once
                    //(?=.*[a-z]) a lower case letter must occur at least once
                    //(?=.*[A-Z]) an upper case letter must occur at least once
                    //(?=\\S+$) no whitespace allowed in the entire string
                    //.{10,} at least 10 characters
                    byte[] salt = generateSalt();

                    Base64.Encoder enc = Base64.getEncoder();

                    String theSalt = enc.encodeToString(salt);

                    String pass = generateHash(Password + theSalt);

                    newUser = new Users(Firstname, Lastname, Address, Phone, Email, Username, pass, theSalt);

                    UserDAO registerUser = new UserDAO();
                    regCheck = registerUser.registerUser(newUser);
                }

                if (regCheck == true) {

                    HttpSession session = request.getSession();
                    session.setAttribute("login", newUser);

                    forwardToJsp = "sucessfullRegistration.jsp";
                } else {
                    forwardToJsp = "error.jsp";

                    HttpSession session = request.getSession();

                    session.setAttribute("errorMessage", "Password Needs To Be 10 charactors Long With 1 UpperCase letter "
                            + "And At Least 1 Number And No Spaces!!..\nEnter Details And Try Again!!");
                }

            } else {
                forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMessage", "Some Fields Empty..Check Details And Try Again!!");
            }
        } else {
            forwardToJsp = "error.jsp";

            HttpSession session = request.getSession();

            session.setAttribute("errorMessage", "Username already Taken..Please Try a different username!!..");
        }

        return forwardToJsp;
    }
}
