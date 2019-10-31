
package Entity;

import java.sql.Date;
import java.sql.Timestamp;
import Entity.*;



public class Ads {
    public static int ad_id, provider_id,like_nb,phone;
    public static String ad_name, description,mail, image,first_name,last_name,adress;
    public static Date availability;
    public static Timestamp published_at;
    public static float rating;   

    public Ads() {
    }
    
    public Ads(int ad_id,String ad_name,String first_name,String last_name,String adress,Date availability,int phone,String mail,float rating,String image,Timestamp published_at) {
    
        this.ad_id=ad_id;
        this.ad_name=ad_name;
        this.first_name=first_name;
        this.last_name=last_name;
        this.adress=adress;
        this.availability=availability;
        this.phone=phone;
        this.mail=mail;
        this.rating=rating;
        this.image=image;
        this.published_at=published_at;        
    }
    
    public static int getAd_id() {
        return ad_id;
    }

    public static void setAd_id(int ad_id) {
        Ads.ad_id = ad_id;
    }

    public static int getProvider_id() {
        return provider_id;
    }

    public static void setProvider_id(int provider_id) {
        Ads.provider_id = provider_id;
    }

    public static int getLike_nb() {
        return like_nb;
    }

    public static void setLike_nb(int like_nb) {
        Ads.like_nb = like_nb;
    }

    public static int getPhone() {
        return phone;
    }

    public static void setPhone(int phone) {
        Ads.phone = phone;
    }

    public static String getAd_name() {
        return ad_name;
    }

    public static void setAd_name(String ad_name) {
        Ads.ad_name = ad_name;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Ads.description = description;
    }

    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        Ads.mail = mail;
    }

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        Ads.image = image;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static void setFirst_name(String first_name) {
        Ads.first_name = first_name;
    }

    public static String getLast_name() {
        return last_name;
    }

    public static void setLast_name(String last_name) {
        Ads.last_name = last_name;
    }

    public static String getAdress() {
        return adress;
    }

    public static void setAdress(String adress) {
        Ads.adress = adress;
    }

    public static Date getAvailability() {
        return availability;
    }

    public static void setAvailability(Date availability) {
        Ads.availability = availability;
    }

    public static Timestamp getPublished_at() {
        return published_at;
    }

    public static void setPublished_at(Timestamp published_at) {
        Ads.published_at = published_at;
    }

    public static float getRating() {
        return rating;
    }

    public static void setRating(float rating) {
        Ads.rating = rating;
    }

    public Ads(int aInt, String string, Date date, String string0, Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

