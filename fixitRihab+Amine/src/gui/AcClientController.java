/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ENTITE.client;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceClient;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AcClientController implements Initializable {
    

    private String username;
    @FXML
    private TextField fnom;
    @FXML
    private TextField fprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    public String setUser(String username) {

        this.username = username;
        return this.username;
    }

   public void afficheusername(ActionEvent event) throws SQLException {
        List<client> list = new ArrayList<>();

        ServiceClient sc = new ServiceClient();
        client c = new client();
       list= sc.readAll2(username);
        c = list.get(0);
        System.out.println(c.getFirst_name()+c.getLast_name());
       String nom =c.getFirst_name();
       String prenom =c.getLast_name();
       fnom.setText(nom);
       fprenom.setText(prenom);
       
     } 
   
        public void del(ActionEvent event) throws SQLException, IOException {
   
  ServiceClient sp =new ServiceClient();
        try{
            sp.delClient(username);
        }catch (SQLException ex){
            System.out.println(ex);
            
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AutheClient.fxml"));
            Parent root = loader.load();
          

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
        
   public void update(ActionEvent event) throws SQLException, IOException {
   
 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifClient.fxml"));
            Parent root = loader.load();
           ModifClientController controlleer = loader.<ModifClientController>getController();
           controlleer.setUser(username);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
   
}
