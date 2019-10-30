/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Client;
import Service.ServiceClient;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class FXMLFixitController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField pwd;
    @FXML
    private Button signin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void auth(ActionEvent event) throws SQLException, IOException {
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

    public String getUsername() {
        String user = username.getText();
        return user;
    }
}
