/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixit;

import ENTITE.Service;
import ENTITE.client;
import ENTITE.provider;
import java.sql.SQLException;
import java.util.ArrayList;
import service.serviceProvider;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import service.ServiceClient;

/**
 *
 * @author LENOVO
 */
public class Fixit {
    
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
                     List<client> list=new ArrayList<>();

        ServiceClient sc = new ServiceClient();
        client c = new client();
        //list= sc.getdata("hbiball");
        //c=list.get(0);
        //System.out.println(c);
      
        
//      provider p1=new provider("agfdfc","jsdj","jkl","jkll","dvcl",26222222,"jhjk",5.0f,"kffdvlkln",20);
//        serviceProvider service=new serviceProvider();
//        
//        client c1=new client("agfdfc","jsdj","jkl","jkll","dvcl",26222222,"jhjk",5,"kffdvlkln");
//        ServiceClient Service=new ServiceClient();
//        
//        
//                try {
//            service.ajouterProvider(p1);
//        } catch (SQLException ex) {
//            System.out.println(ex);  
//        }
//                
//                try {
//            Service.ajouterClient(c1);
//        } catch (SQLException ex) {
//            System.out.println(ex);  
//        }
//        
 //       List<provider> list1=null;
  //            try {
 //           list1=service.readAll();
 //       } catch (SQLException ex) {
 //           System.out.println(ex);
            
 //     }
 //      System.out.println(list1);
//        
       // List<client> list2=null;
        //      try {
        //    list2=Service.readAll();
     //  } catch (SQLException ex) {
      //      System.out.println(ex);           
      //  }
//       
//        System.out.println(list2);
//        
//           try {
//          service.deleteProvider(2);
//      } catch (SQLException ex) {
//            System.out.println(ex);  
//       }
//           
//          try {
//        Service.deleteClient(1);
//     } catch (SQLException ex) {
//            System.out.println(ex);  
//      }
//           
//            try {
//          service.updateProvider(3,"aabb","jsdj","jkl","jkll","dvcl",26222222,"jhjk",5.0f,"kffdvlkln",20);
//      } catch (SQLException ex) {
//            System.out.println(ex);  
//       }
//        
//        try {
//        Service.updateClient(4,"aabb","jsdj","jkl","jkll","dvcl",26222222,"jhjk",5,"kffdvlkln");
//        } catch (SQLException ex) {
//        System.out.println(ex);  
//       }
    
//    
//        ServiceClient sc = new ServiceClient();
//        boolean x =sc.isAuthenticated("az", "qsd");
//        System.out.println(x);
    
    }
   
      
        }
