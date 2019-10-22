/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixit;
import entite.Service;
import service.ServiceFixit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class Fixit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Service s1=new Service(1,"test2");
        ServiceFixit service=new ServiceFixit();
        
        
        try {
            service.addService(s1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
        
    
                
            try{
            service.deleteService(3);
        } catch (SQLException ex) {
            System.out.println(ex);
}
            

    try{
            service.updateService(4,"hello",1);
        } catch (SQLException ex) {
            System.out.println(ex);
}
        List<Service> list1=null;
        
        
        try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
       
        System.out.println(list1);
        
        
            List<Service> search=null;
    try{
            search=service.searchService("test2");
        } catch (SQLException ex) {
            System.out.println(ex);
           }
    
        System.out.println(search);
    
    
    }
    }