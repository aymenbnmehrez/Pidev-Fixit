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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.DataSource;


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
        
  
    }
         @FXML
        private void addService(ActionEvent event) throws IOException{         
            Service s=new Service();
            Category c=new Category();
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
        
        
    } 

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("readalls.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    }
       
    
    

