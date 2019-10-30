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
public class Provider {

    private int provider_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String adress;
    private int phone;
    private String mail;
    private float rating;
    private String image;
    private int like_nb;

    public Provider() {
    }

    public int getProvider_id() {
        return provider_id;
    }

    public String getUsername() {
        return username;
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

    public String getAdress() {
        return adress;
    }

    public int getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public float getRating() {
        return rating;
    }

    public String getImage() {
        return image;
    }

    public int getLike_nb() {
        return like_nb;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
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

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Provider(String username, String password, String first_name, String last_name, String adress, int phone, String mail) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLike_nb(int like_nb) {
        this.like_nb = like_nb;
    }

    public Provider(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
