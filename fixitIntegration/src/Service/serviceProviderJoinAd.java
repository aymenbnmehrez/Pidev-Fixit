package Service;

import Db.DataSource;
import Entity.Ad;
import Entity.Ads;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class serviceProviderJoinAd {
    
     private Connection con = DataSource.getInstance().getConnection();

    private Statement ste;

    public serviceProviderJoinAd() {

        try {
            ste = con.createStatement();

        } catch (SQLException ex) {

            System.out.println(ex);
        }
    }
    
    
    public List<Ads> getAd(int ad_id) throws SQLException {
        List<Ads> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT ad.ad_id,ad.ad_name,provider.first_name,provider.last_name,provider.adress,ad.availability,provider.phone,provider.mail,provider.rating,ad.image,ad.published_at FROM provider,ad WHERE provider.provider_id = ad.provider_id AND ad_id="+ad_id);
        Ads adss = null;
        while (res.next()) {
            adss = new Ads(res.getInt("ad.ad_id"),res.getString("ad.ad_name"), res.getString("provider.first_name"), res.getString("provider.last_name"),res.getString("provider.adress"),res.getDate("ad.availability"),res.getInt("provider.phone"),res.getString("provider.mail"),res.getFloat("provider.rating"),res.getString("ad.image"),res.getTimestamp("ad.published_ad"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(adss);
        }
        return list;
    }
    
        public Ads getAdById(int id_ad) throws SQLException {
        String req = "SELECT ad.ad_name,ad.description,provider.first_name,provider.last_name,provider.address,ad.availability,provider.phone,provider.mail,provider.rating,ad.published_at FROM provider JOIN ad ON provider.provider_id = ad.provider_id WHERE ad.ad_id='"+id_ad+"';";
        ResultSet rst = ste.executeQuery(req);
        Ads ad = new Ads();
        
        while (rst.next()) {
            ad.setAd_name(rst.getString("ad.ad_name"));
            ad.setAvailability(rst.getDate("ad.availability"));
            ad.setPublished_at(rst.getTimestamp("ad.published_at"));
            ad.setDescription(rst.getString("ad.description"));
            ad.setFirst_name(rst.getString("provider.first_name"));
            ad.setLast_name(rst.getString("provider.last_name"));
            ad.setAdress(rst.getString("provider.address"));
            ad.setPhone(rst.getInt("provider.phone"));
            ad.setMail(rst.getString("provider.mail"));
            ad.setRating(rst.getFloat("provider.rating"));
        }
        return ad;
    }
    
    
}
