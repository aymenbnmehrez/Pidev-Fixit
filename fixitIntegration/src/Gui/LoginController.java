/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Admin;
import Entity.Client;
import Entity.Provider;
import Service.ServiceAdmin;
import Service.ServiceClient;
import Service.ServiceProvider;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class LoginController implements Initializable {

    @FXML
    private Pane ProviderLogin;
    @FXML
    private TextField username1;
    @FXML
    private PasswordField pwd1;
    @FXML
    private Button signin1;
    
    @FXML
    private TextField username;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button signin;
    @FXML
    private Pane firstPage;
    @FXML
    private JFXButton ClientCnx;
    @FXML
    private JFXButton ProviderCnx;
    @FXML
    private JFXButton inscriClient;
    @FXML
    private JFXButton InscriProvider;
    @FXML
    private JFXButton back;
    @FXML
    private Pane ClientLogin;
    @FXML
    private JFXButton back1;
    @FXML
    private Pane AdminLogin;
    @FXML
    private TextField Adminname;
    @FXML
    private PasswordField AdminPW;
    @FXML
    private Button signin11;
    @FXML
    private JFXButton back11;
    @FXML
    private JFXButton ConnectAsAdmin;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == ClientCnx) {
            ClientLogin.toFront();
            firstPage.toBack();
        } else if (event.getSource() == ProviderCnx) {
            ProviderLogin.toFront();
        } else if (event.getSource() == inscriClient) {
          Parent loader=FXMLLoader.load(getClass().getResource("formClient.fxml"));
           
           Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == InscriProvider) {
      Parent loader=FXMLLoader.load(getClass().getResource("formProv.fxml"));
    
          Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else if (event.getSource() == back) {
           firstPage.toFront();
        } else if (event.getSource() == back1) {
           firstPage.toFront();
        } else if (event.getSource() == ConnectAsAdmin ) {
           AdminLogin.toFront();
        } else if (event.getSource() == back11) {
           firstPage.toFront();
        } 

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void auth(ActionEvent event) throws IOException, SQLException {
        if (event.getSource() == signin){
        ServiceClient cl = new ServiceClient();
        String user = username.getText();
        String password = pwd.getText();
        if (cl.isAuthenticated(user, password) == true) {
            System.out.println("client connected");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Parent root = loader.load();
            ClientController controller = loader.<ClientController>getController();
            controller.setUser(user);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("not connected");
 Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("password incorrect !");

alert.showAndWait();            
        }}
        else if(event.getSource() == signin1){
              ServiceProvider cl = new ServiceProvider();
        String user = username1.getText();
        String password = pwd1.getText();
        int conf=0;
       conf=cl.select(user);
        //conf=username.getConfirmation;
       String message="mdp incorrect";
        if (cl.isAuthenticated(user, password,conf) == true) {
            System.out.println("connected");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Provider.fxml"));
            Parent root = loader.load();
           ProviderController controller = loader.<ProviderController>getController();
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

alert.showAndWait();}
            } else if (event.getSource() == signin11) {
                ServiceAdmin cl = new ServiceAdmin();
                String userAd = Adminname.getText();
                String passwordAd = AdminPW.getText();
                 System.out.println(cl.isAuthenticated(userAd, passwordAd));
                String message = "mdp incorrect";
                if (cl.isAuthenticated(userAd, passwordAd) == true) {
                    System.out.println("connected");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                    Parent root = loader.load();
                    
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();

                } else {
                    System.out.println("not connected");
                    //mssg.setText(message);
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Alert");
                    alert.setHeaderText(null);
                    alert.setContentText("password incorrect!");

                    alert.showAndWait();
                }
            }
        
    }

    public Client authClient() throws SQLException {
        String user = username.getText();

        ServiceClient sevc = new ServiceClient();
        List<Client> list = new ArrayList<>();
        list = sevc.displayClient2(user);
        Client c = list.get(0);
        return c;
    }

    public Provider authProvider() throws SQLException {
        String user = username.getText();

        ServiceProvider sevp = new ServiceProvider();
        List<Provider> list = new ArrayList<>();
        list = sevp.displayProvider(user);
        Provider p = list.get(0);
        return p;
    }
  
        public String getUsername() {
        String user = username.getText();
        return user;
    }

    private void FbAuthC(ActionEvent event) {
        String domaine="https://www.facebook.com";
        String AppId="412625109435126";
        String AuthUrl="";
        
    }

    
}
