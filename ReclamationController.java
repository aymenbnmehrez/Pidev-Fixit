/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.reclamation_C;
import Entite.reclamation_p;
import Service.ServiceReclamation_C;
import Service.ServiceReclamation_P;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextArea claimDescription;
    @FXML
    private RadioButton claimFromC;
    @FXML
    private RadioButton ClaimFromP;
    @FXML
    private Button SendClaimBtn;
    @FXML
    private ToggleGroup User;
    @FXML
    private ImageView Home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void AjouterReclamationC(reclamation_C r) {
        
        r.setDescription(claimDescription.getText());
      
       // p.setAge(Integer.valueOf(pfAge.getText()));
        ServiceReclamation_C sr=new ServiceReclamation_C();
        try{
            sr.ajouterReclamation(r);
        }
        catch(SQLException ex){
     Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     private void AjouterReclamationP(reclamation_p r) {
    
        
        r.setDescription(claimDescription.getText());
      
       // p.setAge(Integer.valueOf(pfAge.getText()));
        ServiceReclamation_P sr=new ServiceReclamation_P();
        try{
            sr.ajouterReclamation(r);
        }
        catch(SQLException ex){
     Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void SendClaim(MouseEvent event) {
        
        if (claimFromC.isSelected()) {
            reclamation_C r=new reclamation_C();
            r.setDescription(claimDescription.getText());
            r.setClient_id(r.getClient_id());
            AjouterReclamationC(r); 
            
            
        }
         else if (ClaimFromP.isSelected()) {
           reclamation_p r=new reclamation_p();
            r.setDescription(claimDescription.getText());
            r.setProvider_id(r.getProvider_id());
           AjouterReclamationP(r);  
           
         }
    }

    @FXML
    private void BackHome(MouseEvent event) {
    }


}