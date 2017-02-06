/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DTOs.Users;
import java.util.ArrayList;

/**
 *
 * @author jimmy_2u626cl
 */
public interface UserInterface {

    public ArrayList<Users> getAllUsers();

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Users loginUser(String username, String password);

    /**
     *
     * @param username
     * @return
     */
    public boolean isUsernameTaken(String username);

    /**
     *
     * @param user
     * @return
     */
    public boolean registerUser(Users user);

    /**
     *
     * @param username
     * @return
     */
    public boolean IsAdminUsername(String username);

    /**
     *
     * @param username
     * @return
     */
    public boolean removeMember(String username);

    public int addMember(Users user);

    public int getUserType(String username);

    public java.util.Date getExpireDate(String username);

    public String getSalt(String username);

    public Users login(String username, String password);

    public boolean checkLifeSpan(String username, String password);

    /**
     *
     * @param Username
     * @param Password
     * @return
     */
    public Users checkMemberUsernameAndPassword(String Username, String Password);

  //  public boolean ajaxCall(String uname);
}
