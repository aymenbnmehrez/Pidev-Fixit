/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Db.DataSource;

/**
 *
 * @author Koala girl
 */
public class ServiceRating {
        private Connection con = DataSource.getInstance().getConnection();
        private Statement ste;
        public ServiceRating() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println("connexion"+ex);  
        }}
        
        public void AjoutRating(String username,double rate) throws SQLException{  
           double x=(AfficheRating("aymenbm")+rate)/5;
    String req="UPDATE provider SET rating = ? WHERE `provider`.`username` ='aymenbm'";
    PreparedStatement pres=con.prepareStatement(req); 
    pres.setFloat(1,(float) x);
 // pres.setInt(2, getId_provider());
  pres.executeUpdate(req);
  System.out.println("element modifier"); }
        
        
      public double AfficheRating(String usrname) throws SQLException{
           ResultSet res=ste.executeQuery("select `rating` from provider where `username` ='aymenbm'");
           double rate=0.0;
           while(res.next()){
           Provider p=new Provider(res.getFloat("rating"));}
           return rate;
}}
