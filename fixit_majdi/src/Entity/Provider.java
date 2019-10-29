
package Entity;


public class Provider {
    
    private int provider_id;
    private String username ; 
    private String password;
    public String first_name,last_name,city;
    public int phone;
    public String mail;
    public float rating;
    public String image;
    private int like_nb;

    public Provider() {
    }

    public Provider(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Provider(int provider_id) {
        this.provider_id = provider_id;
    }

    public Provider(int provider_id, String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating, String image, int like_nb) {
        this.provider_id = provider_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.rating = rating;
        this.image = image;
        this.like_nb = like_nb;
    }

    public Provider(String username, String password, String first_name, String last_name, String city, int phone, String mail, float rating, String image, int like_nb) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
        this.rating = rating;
        this.image = image;
        this.like_nb = like_nb;
    }

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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLike_nb() {
        return like_nb;
    }

    public void setLike_nb(int like_nb) {
        this.like_nb = like_nb;
    }
    
}
