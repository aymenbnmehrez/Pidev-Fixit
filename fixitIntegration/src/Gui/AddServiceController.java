/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Category;
import Entity.Service;
import Service.ServiceService;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AddServiceController implements Initializable {

    @FXML
    private Button addservicebtn;
    @FXML
    private TextField servicename;
    @FXML
    private Spinner<Integer> spin;
    @FXML
    private Label verif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SpinnerValueFactory<Integer> x = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 30,10,10);
        this.spin.setValueFactory(x);
        // TODO
    }    

    @FXML
    private void addService(ActionEvent event) throws IOException, SQLException {
        Service s = new Service();
        Category c = new Category();

        System.out.println(spin.getValue());
        Integer a = (Integer.valueOf(spin.getValue()));
        s.setCategory_id(a);
        s.setName(servicename.getText());
        if (!validname(servicename.getText())) {
            verif.setText("nom non valide");
        } else {
            //      s.setId_category(Integer.valueOf(servicecategory.getText()));
            ServiceService sp = new ServiceService();
            try {
                sp.addService(s);
            } catch (SQLException ex) {
                System.out.println(ex);

            }
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Admin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
     public boolean validname(String name) throws SQLException {
        if (name.length() == 0) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(((c >= 'a' && c <= 'z')) || ((c >= 'A' && c <= 'Z')) || (c == ' '))) {
                return false;
            }
        }
        return true;
    }
    
}
