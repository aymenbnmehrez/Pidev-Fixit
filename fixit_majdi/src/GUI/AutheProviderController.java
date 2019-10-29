/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entity.CurrentProvider;
import Service.ServiceProvider;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AutheProviderController implements Initializable {

    @FXML
    private Button btn_auth;
    @FXML
    private TextField tf_username;
    @FXML
    private Label txt_username;
    @FXML
    private PasswordField tf_pwd;
    @FXML
    private Label txt_pwd;
    @FXML
    private Button btn_singnup;
    @FXML
    private Label mssg;
    @FXML
    private Button btn_backPage0;
    private Statement ste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void authentification(ActionEvent event) throws SQLException, IOException {
        ServiceProvider c = new ServiceProvider();
        String user = tf_username.getText();
        String password = tf_pwd.getText();
       
        if (c.isAuthenticated(user, password) == true) {
            CurrentProvider cu = new CurrentProvider(c.getProviderByUsername(user));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeProvider.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            
            
        } else {
            mssg.setText("wrong user name or password!");

        }
    }

    @FXML
    private void signupProvider(ActionEvent event) {
    }

    @FXML
    private void back_page0(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("page_0.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
   
   
    
}
