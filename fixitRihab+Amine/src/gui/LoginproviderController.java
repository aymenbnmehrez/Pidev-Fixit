/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.AdminFixit;
import service.ServiceProvider;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginproviderController implements Initializable {

    @FXML
    private Label txt_username;
    @FXML
    private Label txt_pwd;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField tf_pwd;
    @FXML
    private Button btn_auth;
    @FXML
    private Button btn_singnup;
    @FXML
    private Button btn_backPage0;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws SQLException, IOException {
        AdminFixit a = new AdminFixit();
        String user = tf_username.getText();
        String password = tf_pwd.getText();
        String message = "mdp incorrect";
         if (a.isAuthenticated(user, password) == true) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("readalls.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            System.out.println("not connected");

        }
    }

    @FXML
    private void signupprovider(ActionEvent event) {
    }

    @FXML
    private void back_page0(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("page0.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    }
    
