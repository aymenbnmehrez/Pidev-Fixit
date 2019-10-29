package Service;

import DataBase.DataBase;
import Entity.Ad;
import Entity.Client;
import Entity.Provider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvider {

    private Connection con = DataBase.getInstance().getConnection();

    private Statement ste;
    private String username;

    public ServiceProvider() {

        try {
            ste = con.createStatement();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }
        public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider ");
        Provider p = null;
           while (res.next()) {
            p = new Provider( res.getString(2), res.getString(3));
            if((username.equals(p.getUsername()))&&(pwd.equals(p.getPassword())))
                return true;
        }
        return false;
    }
        
        public Provider getProviderByUsername(String username)throws SQLException{
        
            String req ="select provider_id from provider where username='"+username+"'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(req);
            Provider p=new Provider();
            if (rs.next()) {
            p.setProvider_id(rs.getInt("provider_id"));
            }
            return p;
        }
        
         
    
       
}
