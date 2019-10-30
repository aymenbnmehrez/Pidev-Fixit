/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Service.ServicePclaim;
import Service.ServiceRating;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class ProviderController implements Initializable {

    @FXML
    private JFXButton btn_request;
    @FXML
    private JFXButton btn_ask;
    @FXML
    private JFXButton btn_profile;
    @FXML
    private JFXButton btn_claim;
    @FXML
    private AnchorPane pn_all;
    @FXML
    private Pane pn_elect;
    @FXML
    private Pane pn_gard;
    @FXML
    private Pane pn_plumb;
    @FXML
    private JFXComboBox<?> cb_serv;
    @FXML
    private JFXDatePicker dp_as;
    @FXML
    private JFXTextField tf_dur;
    @FXML
    private JFXTextArea tx_desc;
    @FXML
    private JFXButton btn_share;
    @FXML
    private JFXComboBox<?> cb_start;
    @FXML
    private Pane pn_edit;
    @FXML
    private JFXComboBox<?> cb_serv1;
    @FXML
    private JFXDatePicker dp_as1;
    @FXML
    private JFXTextField tf_dur1;
    @FXML
    private JFXTextArea tx_desc1;
    @FXML
    private JFXButton btn_share1;
    @FXML
    private JFXComboBox<?> cb_start1;
    @FXML
    private Pane pn_request;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> cl_date;
    @FXML
    private TableColumn<?, ?> cl_name;
    @FXML
    private TableColumn<?, ?> cl_status;
    @FXML
    private JFXButton btn_delete;
    @FXML
    private JFXButton btn_edit;
    @FXML
    private JFXTextField tf_filter;
    @FXML
    private Pane pn_ask;
    @FXML
    private JFXButton btn_gard;
    @FXML
    private JFXButton btn_plumb;
    @FXML
    private JFXButton btn_elect;
    @FXML
    private Pane pn_claim;
    @FXML
    private TextArea claimDescription;
    @FXML
    private Label champObligatoire;
    @FXML
    private JFXButton SendClaimBtn;
    @FXML
    private JFXSpinner load;
    @FXML
    private Pane pn_profile;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star5;
    @FXML
    private ImageView star1;
    @FXML
    private Label lblRating;
    @FXML
    private ImageView checked;
    @FXML
    private AnchorPane Annonce;
    @FXML
    private TextArea comment1;
    @FXML
    private AnchorPane paneComments;
    @FXML
    private MenuButton MenuBtn;
    @FXML
    private MenuItem SprimComment;
    @FXML
    private TextArea comment;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void handleButtonAction(ActionEvent event) {

        if (event.getSource() == btn_ask) {
            pn_ask.toFront();
        } else if (event.getSource() == btn_request) {
            pn_request.toFront();
        } else if (event.getSource() == btn_gard) {
            pn_gard.toFront();
        } else if (event.getSource() == btn_plumb) {
            pn_plumb.toFront();
        } else if (event.getSource() == btn_elect) {
            pn_elect.toFront();
        }  else if (event.getSource() == btn_profile) {
            pn_profile.toFront();
        }  else if (event.getSource() == btn_claim) {
            pn_claim.toFront();
        }else {
            pn_all.toFront();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 private String username;

    public String setUser(String username) {

        this.username = username;
        return this.username;
    }
  

    @FXML
    private void getNameProvider(ActionEvent event) {
    }

    @FXML
    private void shareAskService(ActionEvent event) {
    }

    @FXML
    private void editAskService(ActionEvent event) {
    }

    @FXML
    private void deleteAskService(ActionEvent event) {
    }

    @FXML
    private void openEditAskService(ActionEvent event) {
    }

    @FXML
    private void SendClaim(MouseEvent event) throws SQLException {
          ServicePclaim srP=new ServicePclaim();
       int rslt= srP.ajouterReclamation(claimDescription.getText(),setUser(username));
        if (rslt==1){
         champObligatoire.opacityProperty().setValue(1);
         champObligatoire.setText("Claim is sent successfully" );}
        else {
             champObligatoire.opacityProperty().setValue(1);
         champObligatoire.setText("Connexion Error" );
    }
    }

    @FXML
    private void Rated(MouseEvent event) throws SQLException {
          ServiceRating sr=new ServiceRating(); 
        double Rating=sr.AfficheRating(setUser(username));
        Image activate=new Image("GUI/Images/etoileOn.png");
        Image validated=new Image("GUI/Images/etoileSelect.png");
        
while(star5.isPressed()||star4.isPressed()||star3.isPressed()||star2.isPressed()||star1.isPressed())
      if (star5.isPressed()){
     System.out.println("star5 selected");
                            star1.setImage(activate);
                            star2.setImage(activate);
                            star3.setImage(activate);
                            star4.setImage(activate);
                            star5.setImage(activate);
                            Rating =Rating+5;
                          //  sr.AjoutRating(p,Rating);
                            lblRating.setText(String.valueOf(Rating));
                            checked.opacityProperty().setValue(1);
        break;                    
} 
      else if (star4.isPressed()){
     System.out.println("star4 selected");
                            star1.setImage(activate);
                            star2.setImage(activate);
                            star3.setImage(activate);
                            star4.setImage(activate);
                            star5.setImage(validated);
                            Rating =Rating+4;
                          //  sr.AjoutRating(p,Rating);
                            lblRating.setText(String.valueOf(Rating));
                            checked.opacityProperty().setValue(1);
                             break;
}
      else if (star3.isPressed()){
     System.out.println("star3 selected");
                            star1.setImage(activate);
                            star2.setImage(activate);
                            star3.setImage(activate);
                            star4.setImage(validated);
                            star5.setImage(validated);
                            Rating =Rating+3;
                           // sr.AjoutRating(p,Rating);
                            lblRating.setText(String.valueOf(Rating));
                            checked.opacityProperty().setValue(1);
                             break;
}
      else if (star2.isPressed()){
     System.out.println("star2 selected");
                            star1.setImage(activate);
                            star2.setImage(activate);
                            star3.setImage(validated);
                            star4.setImage(validated);
                            star5.setImage(validated);
                            Rating =Rating+2;
                           // sr.AjoutRating(p,Rating);
                            lblRating.setText(String.valueOf(Rating));
                            checked.opacityProperty().setValue(1);
                             break;
}
      else if (star1.isPressed()){
     System.out.println("star selected");
                            star1.setImage(activate);
                            star2.setImage(validated);
                            star3.setImage(validated);
                            star4.setImage(validated);
                            star5.setImage(validated);
                            Rating =Rating+1;
                           // sr.AjoutRating(p,Rating);
                            lblRating.setText(String.valueOf(Rating));
                            checked.opacityProperty().setValue(1);
                             break;
}
    }

    @FXML
    private void SendComment(MouseEvent event) throws SQLException {
       }

    @FXML
    private void suprimComment(ActionEvent event) {
    }

    @FXML
    private void ModifComment(ActionEvent event) {
    }
    
}
