/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
        ResultSet res=ste.executeQuery("select name_service,name_category,picture_category,id_service , service.id_category from category join service ON service.id_category = category.id_category");
        Service ser=null;
        while (res.next()) { 
        ser=new Service(res.getInt(4),res.getInt(5) ,res.getString(1), res.getString(2),res.getString(3));
        list.add(ser);
          }
       
    return list;
}
        
        public void deleteService(String name_service)throws SQLException {
            String requete = "DELETE FROM service WHERE name_service = '"+name_service+"'";
                ste.executeUpdate(requete);
         
        }
         public void updateService(int Id_service , String name_service , int Id_category) throws SQLException {
            String requete = "UPDATE `service` SET `Id_category` = '"+ Id_category +"', `name_service` = '"+ name_service +"'  WHERE `Id_service` = '"+ Id_service +"'";
            
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
         public List<Service> getdata(Integer Id_service) throws SQLException {
             List<Service>list=new ArrayList<>();
             ResultSet res=ste.executeQuery("select * from service where Id_service= '"+ Id_service +"'");
             Service s=null;
             while(res.next()){
                 s=new Service(res.getInt(1),res.getInt(2),res.getString(3));
                 list.add(s);
                 
             }
        
         return list;
         }
         public List<Service> filtreService(String s) throws SQLException {
        List<Service> services = new ArrayList<>();
         String requette = "select * from category join service ON service.id_category = category.id_category where Id_service like'%"+s+"%' or name_service like'%"+s+"%' or name_category like'%"+s+"%' or picture_category like'%"+s+"%'";
        // String requette = "select * from service  where Id_service like'%"+s+"%' or name_service like'%"+s+"%' or name_category like'%"+s+"%' or picture_category like'%"+s+"%' ";
           
         Statement st = con.createStatement();
         ResultSet rst = st.executeQuery(requette);
           while (rst.next()) {
            Service s1=new Service(rst.getInt("Id_service"),rst.getString("name_service"),rst.getString("name_category"),rst.getString("picture_category"));
            services.add(s1);
              
        }
         return services;
    }
        
         }
       

