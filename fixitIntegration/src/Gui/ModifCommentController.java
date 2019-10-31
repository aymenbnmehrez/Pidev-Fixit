/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Service.ServiceComment;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class ModifCommentController implements Initializable {

    @FXML
    private TextField UpdatedComment;
    private int idComment;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        UpdatedComment.setText(comment);

    }    
    public void setIdComment(int idComment){
        this.idComment=idComment;
    }
public void setComment(String comment){
        UpdatedComment.setText(comment);
}
    @FXML
    private void SendComment(MouseEvent event) throws SQLException{
          ServiceComment sc = new ServiceComment();
        sc.ModifierCommentaire(idComment, UpdatedComment.getText());
                    ((Node) (event.getSource())).getScene().getWindow().hide();

    }
    
}
