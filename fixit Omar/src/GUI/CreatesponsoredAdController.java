/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CreatesponsoredAdController implements Initializable {

    @FXML
    private TextArea textAdName;
    @FXML
    private TextArea textAdDescription;
    @FXML
    private Button BrowseImage;
    @FXML
    private TextField textURL;
    @FXML
    private TextField ImagePath;
    @FXML
    private Button butcreateAd;

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
    private void BrowseImage(ActionEvent event) {
    }

    @FXML
    private void putImagePath(ActionEvent event) {
    }

    @FXML
    private void createSponsoredAd(ActionEvent event) {
    }
    
}
