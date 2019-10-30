/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author aymen
 */
public class Admin {
    private int admin_id;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(int admin_id, String username, String password) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    @Override
    public String toString() {
        return "Admin{" + "admin_id=" + admin_id + ", username=" + username + ", password=" + password + '}';
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
