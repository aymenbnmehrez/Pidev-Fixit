package Service;

import DataBase.DataBase;
import Entity.Ad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceAd {

    private Connection con = DataBase.getInstance().getConnection();

    private Statement ste;

    public ServiceAd() {

        try {
            ste = con.createStatement();

        } catch (SQLException ex) {

            System.out.println(ex);
        }
    }

    public void createAd(Ad ad) throws SQLException {
        String req = "INSERT INTO ad (`ad_id`,`provider_id`, `ad_name`, `availability`, `description`,  `published_at`,`image`)" + "VALUES (NULL,'" + ad.getProvider_id() + "','" + ad.getAd_name() + "','" + ad.getAvailability() + "','" + ad.getDescription() + "','" + ad.getPublished_at() + "','" + ad.getImage() + "');";
        ste.executeUpdate(req);
        System.out.println("element insere!!");

    }

    public void updateAd(int ad_id, Ad ad) throws SQLException {
        String requete = "UPDATE ad SET `ad_name`='" + ad.getAd_name() + "',`availability`='" + ad.getAvailability()+ "',`description`='" + ad.getDescription() + "' WHERE ad_id ='" + ad_id + "'";
        ste.executeUpdate(requete);
        System.out.println("element updated !");
    }

    public void deleteAd(int id) throws SQLException {
        String requete = "DELETE FROM `ad` WHERE `ad_id` = " + id + ";";
        ste.executeUpdate(requete);
        System.out.println("elment deleted!!");

    }

    public List<Ad> readAll() throws SQLException {
        List<Ad> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT `ad_id`,`ad_name`, `availability`,`description`, `published_at` FROM `ad`");
        Ad ad = null;
        while (res.next()) {
            ad = new Ad(res.getInt(1),res.getString(2), res.getDate(3),res.getString(4), res.getTimestamp(5));
            list.add(ad);
        }
        return list;

    }
    public List<Ad> readAdById(int id) throws SQLException {
        List<Ad> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT `ad_id`,`ad_name`, `availability`,`description`, `published_at` FROM `ad` where provider_id="+id);
        Ad ad = null;
        while (res.next()) {
            ad = new Ad(res.getInt(1),res.getString(2), res.getDate(3),res.getString(4), res.getTimestamp(5));
            list.add(ad);
        }
        return list;

    }
    
        public List<Ad> filtrerAd(String s) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        String rq = "select * from ad where ad_id like'%"+s+"%' or ad_name like'%"+s+"%' or availability like'%"+s+"%'  or description like'%"+s+"%' or published_at like'%"+s+"%'";
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(rq);
        while (rst.next()) {
            Ad ad=new Ad(rst.getInt("ad_id"),rst.getString("ad_name"),rst.getDate("availability"),rst.getString("description"),rst.getTimestamp("published_at"));
            ads.add(ad);
        }

        return ads;
    }
    

    public Ad getAdById(int id_ad) throws SQLException {
        String req = "SELECT ad.ad_name,ad.description,provider.first_name,provider.last_name,provider.city,ad.availability,provider.phone,provider.mail,provider.rating,ad.published_at FROM provider JOIN ad ON provider.provider_id = ad.provider_id WHERE ad.ad_id='"+id_ad+"';";
        ResultSet rst = ste.executeQuery(req);
        Ad ad = new Ad();
        while (rst.next()) {
            ad.setAd_name(rst.getString("ad_name"));
            ad.setAvailability(rst.getDate("availability"));
            ad.setPublished_at(rst.getTimestamp("published_at"));
            ad.setDescription(rst.getString("description"));
            ad.setFirst_name(rst.getString("provider.first_name"));
            ad.setLast_name(rst.getString("provider.last_name"));
            ad.setCity(rst.getString("provider.city"));
            ad.setPhone(rst.getInt("provider.phone"));
            ad.setMail(rst.getString("provider.mail"));
            ad.setRating(rst.getFloat("provider.rating"));
        }
        return ad;
    }
    
    

        //public List<Ad> readAll_Ad_Client() throws SQLException{
//        List<Ad> list = new ArrayList<>();
//        ResultSet res = ste.executeQuery("SELECT ad.ad_name,provider.first_name,provider.last_name,provider.city,ad.availability,provider.phone,provider.mail,provider.rating, provider.image,ad.image,ad.published_at,ad.description FROM provider JOIN ad ON provider.provider_id = ad.provider_id;");
//        Ad ad = null;
//        while (res.next()) {
//        ad = new Ad(res.getString(1),res.getString(2),res.getString(3),res.getString(4), res.getDate(5),res.getInt(6),res.getString(7),res.getFloat(8),res.getString(9),res.getString(10),res.getTimestamp(11),res.getString(12));
//           list.add(ad);
//        }
//        return list; }   
    
}