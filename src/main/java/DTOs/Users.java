/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author jimmy_2u626cl
 */
public class Users {

//    private int userId;
//    private static int oldId = 100;
    private String Firstname;
    private String Lastname;
    private String Address;
    private String Phone;
    private String Email;
    private String Username;
    private String Password;
    private String salt;

   

    public Users() {

//        this.Firstname = "joe";
//        this.Lastname = "Bloggs";
//        this.Address = "Default";
//        this.Email = "Default";
//        this.Phone = "000000000";
//        this.Password = "password";
//        this.Username = "joebloggs";

    }

    public Users(String firstName, String lastName, String address, String phone, String email, String username, String password, String Salt) {

//        userId = oldId +1;
//        oldId = userId +1;
        this.Firstname = firstName;
        this.Lastname = lastName;
        this.Address = address;
        this.Phone = phone;
        this.Email = email;
        this.Username = username;
        this.Password = password;
        this.salt = Salt;
    }

    public String getSalt() {
        return salt;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public static int getOldId() {
//        return oldId;
//    }
//
//    public static void setOldId(int oldId) {
//        Users.oldId = oldId;
//    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

//    @Override
//    public String toString() {
//        return "Users{" + "userId=" + userId + ", firstName=" + Firstname + ", lastName=" + Lastname + ", address=" + Address + ", phone=" + Phone + ", email=" + Email + ", username=" + Username + ", password=" + Password + '}';
//    }
//    
    @Override
    public String toString() {
        return "Users{" + "Firstname=" + Firstname + ", Lastname=" + Lastname + ", Address=" + Address + ", Phone=" + Phone + ", Email=" + Email + ", Username=" + Username + ", Password=" + Password + '}';
    }

}
