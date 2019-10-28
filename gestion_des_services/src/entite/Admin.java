/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author asus
 */
public class Admin {
      private int Id_admin;
    private String username ; 
    private String password;

    public Admin(int Id_admin, String username, String password) {
        this.Id_admin = Id_admin;
        this.username = username;
        this.password = password;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId_admin() {
        return Id_admin;
    }

    public void setId_admin(int Id_admin) {
        this.Id_admin = Id_admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "Id_admin=" + Id_admin + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
