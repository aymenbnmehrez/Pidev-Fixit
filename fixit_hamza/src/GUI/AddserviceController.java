/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entite.Service;
import entite.Category;
import java.io.IOException;
import service.ServiceFixit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class AddserviceController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     */
    @FXML
    private TextField servicecategory;
    @FXML
    private TextField servicename;
    @FXML
    private Button addservicebtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
         @FXML
        private void addService(ActionEvent event) throws IOException{
            Service s=new Service();
            s.setName_service(servicename.getText());
            s.setId_category(Integer.valueOf(servicecategory.getText()));
            ServiceFixit sp=new ServiceFixit();
            try{
            sp.addService(s);
        }
        catch(SQLException ex){
            System.out.println(ex);
            
        }
             Parent root = FXMLLoader.load(getClass().getResource("../GUI/readalls.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("readalls.fxml")) ;   
        try {   
            Parent root = loader.load();
            ReadserviceController rs = loader.getController();
    
            rs.setreadcategory(""+s.getId_category());
            rs.setreadname(s.getName_service());
            servicecategory.getScene().setRoot(root);
        } catch (IOException ex) {
               System.out.println("Error: "+ex.getMessage());
               
        }*/
        
    }    
       
    }
    

