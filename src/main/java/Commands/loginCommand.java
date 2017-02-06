/*
 * @Author: Dermot Rogan
 * @Author: Jimmy Treanor
 * @Project: LibaryApp_BookStoreCA
 */

package Commands;

import DAOs.UserDAO;
import DTOs.Users;
import static Encryption.SaltedPasswords.generateHash;
import Encryption.SaltedPasswords;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Dermot
 * @author Jimmy
 */
public class loginCommand implements Command {

    /**
     *
     * @param request
     * @param response
     * @return log a user into system if all credentials are valid
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = null;
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

       
        if (username != null && !username.equals("") && password != null && !password.equals("")) {

            UserDAO getSalt = new UserDAO();
            String salt = getSalt.getSalt(username);

            String pass = generateHash(password + salt);

             UserDAO checkUserType = new  UserDAO();
            int type = checkUserType.getUserType(username);

             UserDAO checkLogin = new  UserDAO();
             Users checkDetails = checkLogin.checkMemberUsernameAndPassword(username, pass);

            switch (type) {
                case 0:
                    if (checkDetails != null) {

                        UserDAO loginUser = new UserDAO();

                        Users logedIn = loginUser.login(username, pass);

                        session.setAttribute("login", logedIn);

                        forwardToJsp = "sucessfullLogin.jsp";

                    } else {

                       
                        forwardToJsp = "error.jsp";

                        session.setAttribute("errorMessage", "Username or Password Incorrect..Please Try Again!!..");
                        
                    }
                    break;
                case 1:                  
                     if (checkDetails != null) {

                        UserDAO loginUser = new UserDAO();

                        Users logedIn = loginUser.login(username, pass);

                        session.setAttribute("login", logedIn);

                        forwardToJsp = "adminLoginPage.jsp";

                    } else {
                     
                        forwardToJsp = "error.jsp";

                        session.setAttribute("errorMessage", "Username or Password Incorrect..Please Try Again!!..");
                       
                    }

                    break;
                case 2:
                    forwardToJsp = "bannedUser.jsp";
                    break;
                default:
                   
                    forwardToJsp = "error.jsp";
                    session.setAttribute("errorMessage", "Username or Password Incorrect..Please Try Again!!..");
                   
                    break;
            }

        } else {

            forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Login Details Cannot Be Empty!!..");
        }
      
        return forwardToJsp;
    }

}
