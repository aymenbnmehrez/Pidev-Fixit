/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ENTITE.client;
import ENTITE.provider;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceClient;
import service.serviceProvider;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AcProviderController implements Initializable {
    String username;
    @FXML
    private TextField fnom ;
    @FXML
    private TextField fprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 public String setUser(String username) {

        this.username = username;
        return this.username;    
    
}
  public void afficheusername(ActionEvent event) throws SQLException {
        List<provider> list = new ArrayList<>();

        serviceProvider sc = new serviceProvider();
        provider c = new provider();
       list= sc.readAll2(username);
        c = list.get(0);
        System.out.println(c.getFirst_name()+c.getLast_name());
       String nom =c.getFirst_name();
       String prenom =c.getLast_name();
       fnom.setText(nom);
       fprenom.setText(prenom);
      
    }
  public void del(ActionEvent event) throws SQLException, IOException {
   
  serviceProvider sp =new serviceProvider();
        try{
            sp.delProvider(username);
        }catch (SQLException ex){
            System.out.println(ex);
            
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AutheProvider.fxml"));
            Parent root = loader.load();
          

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
  
  public void update(ActionEvent event) throws SQLException, IOException {
   
 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifProvider.fxml"));
            Parent root = loader.load();
           ModifProviderController controlleer = loader.<ModifProviderController>getController();
           controlleer.setUser(username);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
   
        
  
}
