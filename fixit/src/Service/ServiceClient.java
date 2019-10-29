/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aymen
 */
public class ServiceClient {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceClient() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void addClient(Client c) throws SQLException {
        String requete = "INSERT INTO `client` (`client_id`, `username`, `password`, `first_name`, `last_name`, `adress`, `phone`, `mail`) VALUES (NULL, '" + c.getUsername() + "', '" + c.getPassword() + "', '" + c.getFirst_name() + "', '" + c.getLast_name() + "', '" + c.getAdress()+ "', '" + c.getPhone() + "', '" + c.getMail() + "');";
        ste.executeUpdate(requete);
    }

    public List<Client> displayClient() throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client");
        Client cl = null;
        while (res.next()) {
            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
        }
        return list;
    }
    
    public void updateClient(int id,String userName,String pwd,String firstName,String lastName,String adress,int phone,String mail) throws SQLException{
        String requete = "UPDATE `client` SET `username`='" + userName + "',`password`='" + pwd + "',`first_name`='" + firstName + "',`last_name`='" + lastName + "',`adress`='" + adress + "',`phone`='" + phone + "',`mail`='" + mail + "' WHERE client_id='" + id + "'";
        ste.executeUpdate(requete);
    }
    public void deleteClient(int id)throws SQLException{
        String requete="DELETE FROM `client` WHERE client_id='"+id+"'";
        ste.executeUpdate(requete);
    }
    public boolean isAuthenticated(String username,String pwd) throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client ");
        Client cl = null;
           while (res.next()) {
            cl = new Client( res.getString(2), res.getString(3));
            if(username.equals(cl.getUsername())&&pwd.equals(cl.getPassword()))
                return true;
        }
        return false;
    }
// public void displayClientUsername(String username) throws SQLException {
//        ResultSet res = ste.executeQuery("select * from client where username='"+username+"'");
//        Client cl = null;
//            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
//   
//            
//    }
 public List<Client> displayClient2(String username) throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from client where username='"+username+"'");
        Client cl = null;
        while (res.next()) {
            cl = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(cl);
        }
        return list;
    }
 
}
