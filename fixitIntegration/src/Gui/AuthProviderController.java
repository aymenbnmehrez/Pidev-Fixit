/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Provider;
import Service.ServiceClient;
import Service.ServiceProvider;
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

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class AuthProviderController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField pwd;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    private void auth(ActionEvent event) throws SQLException, IOException {
        ServiceProvider sp = new ServiceProvider();
        String user = username.getText();
        String password = pwd.getText();
           ServiceProvider sevc = new ServiceProvider();       //getting client_id of the authentificated client
        List<Provider> listC = new ArrayList<>();
        listC = sevc.displayProvider2(user);
        Provider c = listC.get(0);
        int idProvider = c.getProvider_id();
        if (sp.isAuthenticated(user, password) == true) {
            System.out.println("connected");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Provider.fxml"));
            Parent root = loader.load();
            ProviderController controller = loader.<ProviderController>getController();
            controller.setUser(user);
            controller.setIdP(idProvider);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("not connected");
        }

    }
}
