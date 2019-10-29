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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceClient;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AutheClientController implements Initializable {
    
    @FXML
    private TextField username;
    @FXML
    private TextField pwd;
    @FXML
    private TextField mssg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    @FXML
    private void versFormClient(ActionEvent event) throws IOException{
      
       FXMLLoader loader = new FXMLLoader(getClass().getResource("formClient.fxml"));
            Parent root = loader.load();  
            //ClientController controller = loader.<ClientController>getController();
            //controller.setUser(user);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

                 //   } catch (IOException ex) {
          //  Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
       // }
   
        
    }
    
    @FXML
    private void auth(ActionEvent event) throws SQLException, IOException {
        ServiceClient cl = new ServiceClient();
        String user = username.getText();
        String password = pwd.getText();
       String message="mdp incorrect";
        if (cl.isAuthenticated(user, password) == true) {
            System.out.println("connected");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("acClient.fxml"));
            Parent root = loader.load();
           AcClientController controller = loader.<AcClientController>getController();
           controller.setUser(user);
           

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("not connected");
          //mssg.setText(message);
          Alert alert = new Alert(AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("password incorrect!");

alert.showAndWait();

        }

    }
}
