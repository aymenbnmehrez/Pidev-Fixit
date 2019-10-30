/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITE;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class provider {

    public static List<provider> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int provider_id;
    private String username ; 
    private String password;
    private String first_name,last_name,city;
    private int phone;
    private String mail;
    private float rating;
    private String experience;
    private int like_nb;
    private int confirmation;
    
    public provider(){}

    public provider(String username) {
        this.username = username;
    }

    public provider(int confirmation) {
        this.confirmation = confirmation;
    }
    
    

    public provider(int provider_id, String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating, String experience, int like_nb) {
        this.provider_id = provider_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.rating = rating;
        this.experience = experience;
        this.like_nb = like_nb;
    }

    public provider(String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating, String experience, int like_nb) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.rating = rating;
        this.experience = experience;
        this.like_nb = like_nb;
    }

    public provider(String username, String password, int confirmation) {
        this.username = username;
        this.password = password;
        this.confirmation = confirmation;
    }
    

    public provider(int provider_id, String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating, String experience, int like_nb, int confirmation) {
        this.provider_id = provider_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.rating = rating;
        this.experience = experience;
        this.confirmation = confirmation;
    }
    
    

    public provider(String username, String password) {
        this.username = username;
        this.password = password;
    }

   // public provider(int aInt, String string, String string0, String string1, String string2, String string3, int aInt0, String string4, float aFloat, String string5, int aInt1) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

   // public provider(int aInt, String string, String string0, String string1, String string2, String string3, int aInt0, String string4, float aFloat, String string5, int aInt1) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }
    

    
    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getLike_nb() {
        return like_nb;
    }

    public void setLike_nb(int like_nb) {
        this.like_nb = like_nb;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
    

    @Override
    public String toString() {
        return "provider{" + "provider_id=" + provider_id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", city=" + city + ", phone=" + phone + ", mail=" + mail + ", rating=" + rating + ", experience=" + experience + ", like_nb=" + like_nb + '}';
    }
    
    

   

    
    
    
    
    
    
}
