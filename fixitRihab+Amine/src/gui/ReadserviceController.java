/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import static com.oracle.util.Checksums.update;
import entite.Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.ServiceFixit;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReadserviceController implements Initializable {

   private int Id_service;
      private int Id_category;
         private String name_service;


    @FXML
    private TextField readcategory;
    @FXML
    private TextField readname;
    @FXML
    private Button refreshservice;
    @FXML
    private Button modify;
     public int setId_service(int Id_service) {
        this.Id_service = Id_service;
        return this.Id_service;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  

/*public void setreadcategory (String message ){
    
    this.readcategory.setText(message);}
        // TODO
public void setreadname (String message ){
    this.readname.setText(message); }*/

    @FXML
    private void getinfo(ActionEvent event) throws SQLException {
          List<Service> list=new ArrayList<>();
          ServiceFixit sf = new ServiceFixit();
          Service s = new Service();
        list= sf.getdata(Id_service);
        list= sf.getdata(Id_category);

//        s=list.get(Id_service);
        readname.setText(s.getName_service());
        readcategory.setText(String.valueOf(s.getId_category()));

          
    }

    @FXML
    private void updateser(ActionEvent event) throws IOException {
       // update.setOnAction((ActionEvent e)->{Service s = new Service(Integer.parseInt(newid.getText()),newnom.getText()
                
                //}))
        Service s= new Service();
        s.setName_service(readname.getText());
        s.setId_category(Integer.valueOf(readcategory.getText()));
        ServiceFixit sf =new ServiceFixit();
        //try{
         //   sf.updateService(Id_service, name_service , Id_category );
        //}catch (SQLException ex){
           // System.out.println(ex);
            
        }
        
    }

    

