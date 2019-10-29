/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import java.sql.*;
import Entity.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aymen
 */
public class ServiceProvider {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceProvider() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void addProvider(Provider p) throws SQLException {
        String requete = "INSERT INTO `provider` (`provider_id`, `username`, `password`, `first_name`, `last_name`, `adress`, `phone`, `mail`) VALUES (NULL, '" + p.getUsername() + "', '" + p.getPassword() + "', '" + p.getFirst_name() + "', '" + p.getLast_name() + "', '" + p.getAdress()+ "', '" + p.getPhone() + "', '" + p.getMail() + "');";
        ste.executeUpdate(requete);
    }

    public List<Provider> readAll() throws SQLException {
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider");
        Provider prov = null;
        while (res.next()) {
            prov = new Provider(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
            System.out.println("username : " + prov.getUsername() + " pwd : " + prov.getPassword() + " name : " + prov.getFirst_name() + " last name : " + prov.getLast_name() + " adress : " + prov.getAdress()+ "phone number : " + prov.getPhone() + " mail : " + prov.getMail());
        }
        return list;
    }

    public void updateProvider(int id, String userName, String pwd, String firstName, String lastName, String adress, int phone, String mail) throws SQLException {
        String requete = "UPDATE `provider` SET `username`='" + userName + "',`password`='" + pwd + "',`first_name`='" + firstName + "',`last_name`='" + lastName + "',`adress`='" + adress + "',`phone`='" + phone + "',`mail`='" + mail + "' WHERE provider_id='" + id + "'";
        ste.executeUpdate(requete);

    }
    public void deleteProvider(int id) throws SQLException{
        String requete="DELETE FROM `provider` WHERE provider_id='"+id+"'";
        ste.executeUpdate(requete);
    }
     public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Provider> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from provider ");
        Provider cl = null;
           while (res.next()) {
            cl = new Provider( res.getString(2), res.getString(3));
            if(username.equals(cl.getUsername())&&pwd.equals(cl.getPassword()))
                return true;
        }
        return false;
    }
}
