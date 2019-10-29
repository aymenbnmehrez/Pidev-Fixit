package Service;
import DataBase.DataBase;
import Entity.Ads;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class serviceProviderJoinAd {
    
     private Connection con = DataBase.getInstance().getConnection();

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

        ResultSet res = ste.executeQuery("SELECT ad.ad_id,ad.ad_name,provider.first_name,provider.last_name,provider.city,ad.availability,provider.phone,provider.mail,provider.rating,ad.image,ad.published_at FROM provider,ad WHERE provider.provider_id = ad.provider_id AND ad_id="+ad_id);
        Ads adss = null;
        while (res.next()) {
            adss = new Ads(res.getInt("ad.ad_id"),res.getString("ad.ad_name"), res.getString("provider.first_name"), res.getString("provider.last_name"),res.getString("provider.city"),res.getDate("ad.availability"),res.getInt("provider.phone"),res.getString("provider.mail"),res.getFloat("provider.rating"),res.getString("ad.image"),res.getTimestamp("ad.published_ad"));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(adss);
        }
        return list;
    }
}
