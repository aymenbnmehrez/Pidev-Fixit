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

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


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
    private void showAd(ActionEvent event) throws IOException, SQLException {
        
    FXMLLoader loader = new FXMLLoader(getClass().getResource("showAd.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
           ((Node) (event.getSource())).getScene().getWindow().hide();
           
             
        
                

    
}}
