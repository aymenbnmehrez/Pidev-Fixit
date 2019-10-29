/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITE;

/**
 *
 * @author LENOVO
 */
public class client {
    private int client_id;
    private String username ; 
    private String password;
    private String first_name,last_name,city;
    private int phone;
    private String mail;
    private int fidelity_pt;
    private String image;

    public client() {

    
    }
    public client(String first_name) {
        this.first_name = first_name;}

    public client(String password, String first_name, String last_name, String city, int phone, String mail) {
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
    }
    
        

    public client(int client_id, String username, String password, String first_name, String last_name, String city, int phone, String mail, int fidelity_pt, String image) {
        this.client_id = client_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.fidelity_pt = fidelity_pt;
        this.image = image;
    }

    public client(String username, String password, String first_name, String last_name, String city, int phone, String mail, int fidelity_pt, String image) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.fidelity_pt = fidelity_pt;
        this.image = image;
    }

    

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getFidelity_pt() {
        return fidelity_pt;
    }

    public client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setFidelity_pt(int fidelity_pt) {
        this.fidelity_pt = fidelity_pt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    @Override
//    public String toString() {
//        return "client{" + "provider_id=" + provider_id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", city=" + city + ", phone=" + phone + ", mail=" + mail + ", fidelity_pt=" + fidelity_pt + ", image=" + image + '}';
//    }
    
    
    
    
}
