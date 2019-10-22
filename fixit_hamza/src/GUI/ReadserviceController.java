/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReadserviceController implements Initializable {

   
    @FXML
    private TextField readcategory;
    @FXML
    private TextField readname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  

public void setreadcategory (String message ){
    this.readcategory.setText(message);}
        // TODO
public void setreadname (String message ){
    this.readname.setText(message); }

    
}
