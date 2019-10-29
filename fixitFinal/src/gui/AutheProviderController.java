/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceClient;
import service.serviceProvider;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AutheProviderController implements Initializable {
private String id;
     @FXML
    private TextField pwd ;
    @FXML
    private TextField username;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
    private void versFormProvider(ActionEvent event) throws IOException{
      
       FXMLLoader loader = new FXMLLoader(getClass().getResource("formProv.fxml"));
            Parent root = loader.load();  
            //ClientController controller = loader.<ClientController>getController();
            //controller.setUser(user);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
                      

                 //   } catch (IOException ex) {
          //  Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
       // }
   
        
    }
    @FXML
    private void auth(ActionEvent event) throws SQLException, IOException {
        serviceProvider cl = new serviceProvider();
        String user = username.getText();
        String password = pwd.getText();
        int conf=0;
       conf=cl.select(user);
        //conf=username.getConfirmation;
       String message="mdp incorrect";
        if (cl.isAuthenticated(user, password,conf) == true) {
            System.out.println("connected");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("acProvider.fxml"));
            Parent root = loader.load();
           AcProviderController controller = loader.<AcProviderController>getController();
           controller.setUser(user);
        
        

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } else {
            System.out.println("not connected");
          //mssg.setText(message);
          Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("password incorrect or account not yet confirmed!");

alert.showAndWait();

        }

    }
    
}
