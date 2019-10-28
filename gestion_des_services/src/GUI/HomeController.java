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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class HomeController implements Initializable {

    @FXML
    private ImageView Home;
    @FXML
    private Button btnShowAd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void optionsClicked(MouseEvent event) {
    }

    @FXML
    private void NotifBClicked(MouseEvent event) {
    }

    @FXML
    private void MessageClicked(MouseEvent event) {
    }

    @FXML
    private void BackHome(MouseEvent event) {
    }

    @FXML
    private void GoToCategorys(MouseEvent event) {
    }

    @FXML
    private void showAd(ActionEvent event) {
    }
    
}
