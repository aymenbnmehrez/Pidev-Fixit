
package Service;

import DataBase.DataBase;
import Entity.Ad;
import Entity.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


public class ServiceClient {
    
        private Connection con = DataBase.getInstance().getConnection();

    private Statement ste;

    public ServiceClient() {

        try {
            ste = con.createStatement();

        } catch (SQLException ex) {

            System.out.println(ex);
        }
    }
    
    public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client ");
        Client c = null;
           while (res.next()) {
            c = new Client( res.getString(2), res.getString(3));
            if((username.equals(c.getUsername()))&&(pwd.equals(c.getPassword())))
                return true;
        }
        return false;
    }
    
    public List<Ad> readAll() throws SQLException {
        List<Ad> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT `ad_name`, `availability`,`description`, `published_at` FROM `ad`");
        Ad ad = null;
        while (res.next()) {
            ad = new Ad(res.getString(1), res.getDate(2),res.getString(3),res.getTimestamp(4));
            list.add(ad);
        }
        return list;

    }
    
    

}
