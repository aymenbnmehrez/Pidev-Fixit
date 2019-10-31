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
        
        public void AjoutRating(int id,double rate) throws SQLException{  
          double x=(AfficheRating(id)+rate)/2;
    String req="UPDATE provider SET rating = '"+rate+"' WHERE `provider`.`provider_id` ='"+id+"'";

 
  ste.executeUpdate(req);
  System.out.println("element modifier"); }
        
        
      public double AfficheRating(int id) throws SQLException{
           ResultSet res=ste.executeQuery("select `rating` from provider where `provider_id` ='"+id+"'");
           double rate=0.0;
           while(res.next()){
           rate =res.getFloat("rating");}
           return rate;
}
         public double AfficheRating2(String username ) throws SQLException{
           ResultSet res=ste.executeQuery("select `rating` from provider where `username` ='"+username+"'");
           double rate=0.0;
           while(res.next()){
           rate =res.getFloat("rating");}
           return rate;
}
}
