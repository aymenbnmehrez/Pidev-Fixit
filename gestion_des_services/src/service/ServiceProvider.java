package service;

import entite.Provider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

public class ServiceProvider {

    private Connection con = DataSource.getInstance().getConnection();

    private Statement ste;

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

}
