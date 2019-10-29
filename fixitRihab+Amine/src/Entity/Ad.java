/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author aymen
 */
public class Ad {

    private int ad_id;
    private int provider_id;
    private String ad_name;
    private Date availability;
    private String description;
    private Timestamp published_at;
    private String image;
    private int Nb_Likes;

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public void setAvailability(Date availability) {
        this.availability = availability;
    }

    public void setPublished_at(Timestamp published_at) {
        this.published_at = published_at;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Ad() {
    }

    public Ad(int Nb_Likes) {
        this.Nb_Likes = Nb_Likes;
    }

    public int getNb_Likes() {
        return Nb_Likes;
    }

    public void setNb_Likes(int Nb_Likes) {
        this.Nb_Likes = Nb_Likes;
    }
    

    public Ad(int ad_id, Date availability, Timestamp published_at, int provider_id, String description, String image) {
        this.ad_id = ad_id;
        this.availability = availability;
        this.published_at = published_at;
        this.provider_id = provider_id;
        this.description = description;
        this.image = image;
    }

    public int getAd_id() {
        return ad_id;
    }

    public Date getAvailability() {
        return availability;
    }

    public Timestamp getPublished_at() {
        return published_at;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_name() {
        return ad_name;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Ad{" + "ad_id=" + ad_id + ", provider_id=" + provider_id + ", ad_name=" + ad_name + ", availability=" + availability + ", description=" + description + ", published_at=" + published_at + ", image=" + image + ", Nb_Likes=" + Nb_Likes + '}';
    }

}
