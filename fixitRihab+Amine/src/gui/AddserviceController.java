/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entite.Service;
import entite.Category;
import java.awt.Insets;
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
import javafx.application.Application;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import utils.DataSource;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;


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
    int nombre = 0; String chaine = "Bonjour à tous les 3.";
    @FXML
    private Spinner<Integer> spin;
    @FXML
    private Label verif;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SpinnerValueFactory<Integer>  x = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,4);
        spin.setValueFactory(x);
        
  
    }
         @FXML
        private void addService(ActionEvent event) throws IOException, SQLException{ 
            Service s=new Service();
            Category c=new Category();
          
        
                
                spin.getValueFactory().setValue(s.getId_category());
               Integer a =(Integer) spin.getValue();
               s.setId_category( a);
               s.setName_service(servicename.getText());
                if(!validname(servicename.getText())){
             verif.setText("nom non valide");}
                else
                { 
       //      s.setId_category(Integer.valueOf(servicecategory.getText()));
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
        
        
    } }

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
     public boolean validname(String name) throws SQLException {
            if (name.length()==0){return false;}
        
            for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(((c >= 'a' && c <= 'z'))||((c >= 'A' && c <= 'Z'))||(c==' '))){return false;}
                }return true;}


 


    
    
    
    }
       
    
    

