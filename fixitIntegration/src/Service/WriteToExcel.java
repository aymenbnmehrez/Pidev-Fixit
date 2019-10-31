/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Db.DataSource;
import com.sun.rowset.internal.Row;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Cell;
import jxl.Workbook; 
import jxl.write.*; 
/**
 *
 * @author Koala girl
 */
public class WriteToExcel {
         private Connection con = DataSource.getInstance().getConnection();
        private Statement ste;
       
    public WriteToExcel() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println("connexion"+ex);  
        }}
   
 public  void WriteFromDBP() throws InterruptedException {

        	WritableWorkbook wworkbook;
            try {
           	wworkbook = Workbook.createWorkbook(new File("C:\\Users\\Koala girl\\Documents\\NetBeansProjects\\fixit\\Reclamation.xls"));
          			
	 			 ResultSet rs=ste.executeQuery("select * from p_claim");
				
				
				
				 WritableSheet wsheet2 = wworkbook.createSheet("Sheet 2", 2);
                                 
                                
				 Label label = new Label(1, 1, "ID");
				  wsheet2.addCell(label);
		          int i=0;
				 
		           
		           int j=1;
                         

				while(rs.next()){
					
					i=0;
					
					 label = new Label(i++, j, j+"");
					  wsheet2.addCell(label);
					 label = new Label(i++, j, rs.getString(2));
					  wsheet2.addCell(label);
					  label = new Label(i++, j, rs.getString("p_claim_id"));
					  wsheet2.addCell(label);
					  label = new Label(i++, j, rs.getString("description"));
					  wsheet2.addCell(label);
					  
					  
					  
					  
					 
					j++;
				}
                                 WritableSheet wsheet = wworkbook.createSheet("Sheet 1", 1);
				 Label label1 = new Label(1, 1, "ID");
				  wsheet2.addCell(label1);
                                 i=0;
				 
		           
		            j=1;
				ResultSet res=ste.executeQuery("select * from c_claim");
				while(res.next()){
					
					i=0;
					
					 label1 = new Label(i++, j, j+"");
					  wsheet.addCell(label1);
					 label1 = new Label(i++, j, res.getString(2));
					  wsheet.addCell(label1);
					  label1 = new Label(i++, j, res.getString(1));
					  wsheet.addCell(label1);
					  label1 = new Label(i++, j, res.getString(3));
					  wsheet.addCell(label1);
					  
					  
					  
					  
					 
					j++;
				}
				
				
            
            wworkbook.write();
            wworkbook.close();
            System.out.println("fineshed");
            } catch (Exception e) {
            System.out.println(e);
			}
        }
      
}
