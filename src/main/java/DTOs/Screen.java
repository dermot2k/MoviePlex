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
public class Screen {
    
    private String Name;
    private String Description;
    private int UserId;
    
    public Screen(){
        
    }

    public Screen(String Name, String Description, int UserId) {
        this.Name = Name;
        this.Description = Description;
        this.UserId = UserId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    @Override
    public String toString() {
        return "Screen{" + "Name=" + Name + ", Description=" + Description + ", UserId=" + UserId + '}';
    }
    
}
