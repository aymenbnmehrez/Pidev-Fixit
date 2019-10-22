/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.sql.*;
import utils.DataSource;
import entite.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class ServiceFixit {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
    public ServiceFixit() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
     public void addService(Service s) throws SQLException{
      String requete = "INSERT INTO `service` (`Id_service`, `Id_category` , `name_service`) "
              + "VALUES (NULL, '"+s.getId_category()+"', '"+s.getName_service()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inste");
     }
        public List<Service> readAll() throws SQLException
    {
        List<Service> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select * from service");
        Service ser=null;
        while (res.next()) {            
        ser=new Service(res.getInt(1), res.getInt(2),res.getString(3));
        list.add(ser);
          }
    return list;
}
        
        public void deleteService(int Id_service)throws SQLException {
            String requete = "DELETE FROM service WHERE Id_service = '"+Id_service+"'";
                ste.executeUpdate(requete);
         
        }
         public void updateService(int Id_service, String name_service, int Id_category) throws SQLException {
            String requete = "UPDATE service SET `name_service`='" + name_service + "' WHERE Id_service ='" + Id_service + "'";
                ste.executeUpdate(requete);

    }

         public List searchService(String name_service) throws SQLException {
             List<Service> search=new ArrayList<>();
              ResultSet res=ste.executeQuery("select * from service WHERE name_service = '"+ name_service +"'");
              Service ser=null;
              while (res.next()) {            
              ser=new Service(res.getInt(1), res.getInt(2),res.getString(3));
              search.add(ser);
        }
                return search;
             
         }
       
}
