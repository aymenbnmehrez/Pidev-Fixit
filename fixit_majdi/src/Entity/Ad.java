package Entity;

import java.sql.*;
import java.util.Objects;

public class Ad extends Provider{

    private int ad_id, provider_id;
    private String ad_name, description, image;
    private Date availability;
    
    private Timestamp published_at;

    public Ad() {
    }

    public Ad(int ad_id, String ad_name, Date availability, Timestamp published_at) {
        this.ad_id = ad_id;
        this.ad_name = ad_name;
        this.availability = availability;
        this.published_at = published_at;
    }

    public Ad(int ad_id, String ad_name, Date availability,String description, Timestamp published_at) {
        this.ad_id = ad_id;
        this.ad_name = ad_name;
        this.description = description;
        this.availability = availability;
        this.published_at = published_at;
    }

    public Ad(String ad_name,Date availability,String description, Timestamp published_at) {
        this.ad_name = ad_name;
        this.availability = availability;
        this.description=description;
        this.published_at = published_at;
        
    }

    public Ad(int ad_id, int provider_id, String ad_name, Date availability, String description, Timestamp published_at, String image) {
        this.ad_id = ad_id;
        this.provider_id = provider_id;
        this.ad_name = ad_name;
        this.availability = availability;
        this.description = description;
        this.published_at = published_at;
        this.image = image;
    }

    public Ad(int provider_id, String ad_name, Date availability, String description, Timestamp published_at, String image) {
        this.provider_id = provider_id;
        this.ad_name = ad_name;
        this.availability = availability;
        this.description = description;
        this.published_at = published_at;
        this.image = image;
    }

   
    

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    @Override
    public int getProvider_id() {
        return provider_id;
    }

    @Override
    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public Date getAvailability() {
        return availability;
    }

    public void setAvailability(Date availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPublished_at() {
        return published_at;
    }

    public void setPublished_at(Timestamp published_at) {
        this.published_at = published_at;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Ad{" + "ad_id=" + ad_id + ", provider_id=" + provider_id + ", ad_name=" + ad_name + ", availability=" + availability + ", description=" + description + ", published_at=" + published_at + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ad other = (Ad) obj;
        if (this.ad_id != other.ad_id) {
            return false;
        }
        if (this.provider_id != other.provider_id) {
            return false;
        }
        if (!Objects.equals(this.ad_name, other.ad_name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.availability, other.availability)) {
            return false;
        }
        if (!Objects.equals(this.published_at, other.published_at)) {
            return false;
        }
        return true;
    }

    


}
