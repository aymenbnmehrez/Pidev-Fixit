/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixit;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import entite.HeaderFooter;
import entite.PDFCreator;
import entite.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import service.ServiceFixit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class Fixit {
private static final String TITLE = "TestReport";
    public static final String PDF_EXTENSION = ".pdf";
    /**
     * @param args the command line arguments
     */
    public static List<Service> getDataObjectList(){
        List<Service> dataObjList = new ArrayList<Service>();
        Service d1 = new Service();
        d1.setName_category("ABC");
        d1.setName_service("20000");
        Service d2 = new Service();
        d2.setName_category("XYZ");
        d2.setName_service("30000");
        dataObjList.add(d1);
        dataObjList.add(d2);
        return dataObjList;    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Service s1=new Service(1,"test2");
        ServiceFixit service=new ServiceFixit();
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
}