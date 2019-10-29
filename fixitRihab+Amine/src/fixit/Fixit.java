/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixit;

import Entity.AskService;
import Entity.Cclaim;
import Entity.Provider;
import Entity.Client;
import Entity.Comment;
import Entity.Pclaim;
import Service.*;
import static java.io.FileDescriptor.out;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static javax.xml.bind.DatatypeConverter.parseDate;

/**
 *
 * @author aymen
 */
public class Fixit {

    static String aymen = "aymen";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        String AccessToken ="EAAF3R8USwvYBAIY1xKHEW6XxzV8t8Ifyu76YRtB2IVJHtnHIeutw54DwbrEF2OQPjsVOqFzKWwLZCXnqYCqOSWAI3HvZBQvYefgvPIijPovP0P1uNSdizDIvNqyN7xv8JpZBxjWdahjEfABwAxZB3Xk4BI3iMdywYULLGO0HbQZDZD";
        /*  Provider p1 = new Provider("aymenbm2", "azerty", "aymen2", "ben mehrez2", "ariana2", 20843310, "aymen.benmehrez@esprit.tn2"); // TODO code application logic here
        ServiceProvider sev = new ServiceProvider();
        ServiceClient sevc = new ServiceClient();
        sev.addProvider(p1);
        System.out.println(sev.readAll());
        sev.updateProvider(2, "aymenbm2", "azerty", "aymen", "ben mehrez", "ariana", 20843310, "aymen.benmehrez@esprit.tn");
        System.out.println(sev.readAll());
        sev.deleteProvider(3);
        System.out.println(sev.readAll());
        Client c1 = new Client("aymen", "aze", "aymbm", "ben", "ar", 123456789, "aym@esprit.tn");
        sevc.displayClient();
        sevc.addClient(c1);
        sevc.displayClient();
        sevc.updateClient(2, "aymenbm", "qsdf", "ay", "bn", "ariana", 0, "***@***.**");
        sevc.displayClient();
        sevc.deleteClient(1);
        sevc.displayClient();*/
//              ServiceClient sevc = new ServiceClient();
////      
//                    List<Client> list = new ArrayList<>();
//                 list=  sevc.displayClient2(aymen);
//               Client a = list.get(0);
//
//                 System.out.println(a.getLast_name());
//                   Client c =((list=sevc.displayClient()).get(1));
//        System.out.println(c);
//            Client a = list.get(0); 
//            System.out.println(a.getFirst_name());

//Date date =new SimpleDateFormat("yyyy/MM/dd").parse("2007/01/01");
//java.util.Date utilDate = new java.util.Date(date.getTime());
//Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-06");
//    java.sql.Date.valueOf( date );
//
//        AskService as = new AskService(11,"date","aze", "aze", 2, "s");
//        ServiceAskService sas = new ServiceAskService();
//        sas.addAskService(as);

        /*List<AskService> list = new ArrayList<>();
        AskService ass =null;
ServiceAskService as = new ServiceAskService();
list=as.getAskServiceById(11);
ass=list.get(0);
        System.out.println(as);
        */
//list =as.getDataAskServiceRequest(2);
//for(int i =0;i<list.size();i++){
//    
//ass=list.get(i);
//        System.out.println(ass.getDate());
//}
//;
//System.out.println(as.getDataAskServiceRequest2(2));
/*Cclaim r=new Cclaim(aymen);
ServiceCclaim spc=new ServiceCclaim();
spc.ajouterReclamation("help !!", aymen);*/
 List<Comment> list2=null;
        int nbr=0;
           ServiceComment sc=new ServiceComment();
        try {
            
            list2=sc.readByAd("aymenbm2");
            nbr= sc.NbrComments("aymenbm2");
        } catch (SQLException ex) {
            System.out.println("Affichage:"+ex);
        }
        
  System.out.println(list2);
  System.out.println(nbr);

    }
//String nom=nomechange.getText();
//   String description=Description.getText();
//   
//   
//  
//  LocalDate locald =date.getValue();
//        String date =locald.toString();
//   Echange E = new Echange(nom,description,date);

    
}
