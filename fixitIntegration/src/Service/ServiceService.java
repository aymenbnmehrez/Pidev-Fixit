/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import Entity.Client;
import Entity.Service;
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
public class ServiceService {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Service> readAll() throws SQLException {
        List<Service> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from service");
        Service serv = null;
        while (res.next()) {
            serv = new Service(res.getInt(1), res.getInt(2), res.getString(3));
            System.out.println("service id : : " + serv.getService_id() + " category id : " + serv.getCategory_id() + " name : " + serv.getName());
        }
        return list;
    }

    public List<Service> getIdService(String nameService) throws SQLException {
        List<Service> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("SELECT * FROM `service` WHERE `name`='" + nameService + "'");
        Service s = null;
        while (res.next()) {
            s = new Service(res.getInt(1), res.getInt(2), res.getString(3));
//            System.out.println("id client : "+cl.getClient_id()+" username : "+cl.getUsername()+" pwd : "+cl.getPassword()+" first name : "+cl.getFirst_name()+" last name : "+cl.getLast_name()+" adress : "+cl.getAdress()+" phone : "+cl.getPhone()+" mail :"+cl.getMail());
            list.add(s);
        }
        return list;
    }
       public List<Service> getListService(int categoryId) throws SQLException {
        List<Service> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select name from service where category_id='"+categoryId+"'");
        Service serv = null;
        while (res.next()) {
            serv = new Service( res.getString("name"));
            list.add(serv);
        }
        return list;
    }
    
        public void addService(Service s) throws SQLException{
      String requete = "INSERT INTO `service` (`service_id`, `category_id` , `name`) "
              + "VALUES (NULL, '"+s.getCategory_id()+"', '"+s.getName()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inste");
     }
        public List<Service> readAll5() throws SQLException
    {
        List<Service> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select service.name,category.name,category.picture_category,service.service_id , service.category_id from category join service ON service.category_id = category.category_id");
        Service ser=null;
        while (res.next()) { 
        ser=new Service(res.getInt(4),res.getInt(5) ,res.getString(1), res.getString(2),res.getString(3));
        list.add(ser);
          }
       
    return list;
    
}
         public void deleteService(String name)throws SQLException {
            String requete = "DELETE FROM service WHERE name = '"+name+"'";
                ste.executeUpdate(requete);
         
        }
         public void updateService(int service_id , String name , int category_id) throws SQLException {
            String requete = "UPDATE `service` SET `category_id` = '"+ category_id +"', `name` = '"+ name +"'  WHERE `service_id` = '"+ service_id +"'";
            
            ste.executeUpdate(requete);    

    }
         

         public List searchService(String name_service) throws SQLException {
             List<Service> search=new ArrayList<>();
              ResultSet res=ste.executeQuery("select * from service WHERE name = '"+ name_service +"'");
              Service ser=null;
              while (res.next()) {            
              ser=new Service(res.getInt(1), res.getInt(2),res.getString(3));
              search.add(ser);
        }
                return search;
             
         }
        
        public List<Service> getdata(Integer Id_service) throws SQLException {
             List<Service>list=new ArrayList<>();
             ResultSet res=ste.executeQuery("select * from service where service_id= '"+ Id_service +"'");
             Service s=null;
             while(res.next()){
                 s=new Service(res.getInt(1),res.getInt(2),res.getString(3));
                 list.add(s);
                 
             }
        
         return list;
         }
         public List<Service> filtreService(String s) throws SQLException {
        List<Service> services = new ArrayList<>();
         String requette = "select * from category join service ON service.category_id = category.category_id where service_id like'%"+s+"%' or service.name like'%"+s+"%' or category.name like'%"+s+"%' or picture_category like'%"+s+"%'";
        // String requette = "select * from service  where Id_service like'%"+s+"%' or name_service like'%"+s+"%' or name_category like'%"+s+"%' or picture_category like'%"+s+"%' ";
           
         Statement st = con.createStatement();
         ResultSet rst = st.executeQuery(requette);
           while (rst.next()) {
            Service s1=new Service(rst.getInt("service_id"),rst.getString("service.name"),rst.getString("category.name"),rst.getString("picture_category"));
            services.add(s1);
              
        }
         return services;
    }
        
        
        
        
}
