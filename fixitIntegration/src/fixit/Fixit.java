/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixit;

import Entity.AskService;
import Entity.Provider;
import Entity.Client;
import Entity.ClientJoinServiceJoinAskService;
import Entity.HeaderFooter;
import Entity.PDFCreator;
import Entity.Service;
import Entity.ServiceJoinAskService;
import Service.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.xml.bind.DatatypeConverter.parseDate;

/**
 *
 * @author aymen
 */
public class Fixit {

    static String aymen = "aymen";
    private static final String TITLE = "TestReport";
    public static final String PDF_EXTENSION = ".pdf";
    /**
     * @param args the command line arguments
     */
    public static List<Service> getDataObjectList(){
        List<Service> dataObjList = new ArrayList<Service>();
        Service d1 = new Service();
        d1.setCategoryName("ABC");
        d1.setName("20000");
        Service d2 = new Service();
        d2.setCategoryName("XYZ");
        d2.setName("30000");
        dataObjList.add(d1);
        dataObjList.add(d2);
        return dataObjList; 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
          Service s1=new Service(1,"test2");
        ServiceService service=new ServiceService();
        List<Service> dataObjList = getDataObjectList();
        Document document = null;
        try {
        //Document is not auto-closable hence need to close it separately
            document = new Document(PageSize.A4);            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    new File(TITLE + PDF_EXTENSION)));
            HeaderFooter event = new HeaderFooter();
            event.setHeader("Test Report");
            writer.setPageEvent(event);
            document.open();
            PDFCreator.addMetaData(document, TITLE);
            PDFCreator.addTitlePage(document, TITLE);
            PDFCreator.addContent(document, dataObjList);
        }catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        }finally{
            if(null != document){
                document.close();
            }}
        try {
            service.addService(s1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
        
    
                
            try{
            service.deleteService("tri");
        } catch (SQLException ex) {
            System.out.println(ex);
}
            

    try{
            service.updateService(55,"goodbuyy",2);
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
    
    
    
    
            List<Service> fk=null;
    try{
            fk=service.filtreService("baby");
        } catch (SQLException ex) {
            System.out.println(ex);
           }
    
        System.out.println("fdddddddfdfdddddddddddd" +fk);
    }
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
//        List<AskService> list = new ArrayList<>();
//        AskService ass =null;
//ServiceAskService as = new ServiceAskService();
//list=as.getAskServiceById(11);
//ass=list.get(0);
//        System.out.println(as);
//list =as.getDataAskServiceRequest(2);
//for(int i =0;i<list.size();i++){
//    
//ass=list.get(i);
//        System.out.println(ass.getDate());
//}
//;
//System.out.println(as.getDataAskServiceRequest2(2));
//ServiceServiceJoinAskService s = new ServiceServiceJoinAskService();
//ServiceJoinAskService sa = new ServiceJoinAskService();
//            List<ServiceJoinAskService> list = new ArrayList<>();
//            list= s.getDataAskService2(3);
//            sa=list.get(0);
//            System.out.println(sa.getStatus());


//String nom=nomechange.getText();
//   String description=Description.getText();
//   
//   
//  
//  LocalDate locald =date.getValue();
//        String date =locald.toString();
//   Echange E = new Echange(nom,description,date);


       

}
