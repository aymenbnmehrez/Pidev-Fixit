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
public class Client {

    private int client_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String address;
    private int phone;
    private String mail;
    private int fidelity_pt;
    private String image;

    public Client() {
    }

    public Client(int client_id, String username, String password, String first_name, String last_name, String address, int phone, String mail) {
        this.client_id = client_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Client(int client_id, String username, String password, String first_name, String last_name, String address, int phone, String mail, int fidelity_pt, String image) {
        this.client_id = client_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.fidelity_pt = fidelity_pt;
        this.image = image;
    }

    public Client(String username, String password, String first_name, String last_name, String address, int phone, String mail) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getUsername() {
        return username;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFidelity_pt(int fidelity_pt) {
        this.fidelity_pt = fidelity_pt;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public int getFidelity_pt() {
        return fidelity_pt;
    }

    public String getImage() {
        return image;
    }
    
    
    
}
