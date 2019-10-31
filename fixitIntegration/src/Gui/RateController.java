/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Service.ServiceRating;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class RateController implements Initializable {

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
    private ImageView checked;
 private String username;
 private int idP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setIdP(int idP){
    this.idP=idP;
    
}
    @FXML
    private void Rated(MouseEvent event) throws SQLException {
           ServiceRating sr = new ServiceRating();
        double Rating = sr.AfficheRating(idP);
       
        Image activate = new Image("Gui/images/etoileOn.png");
        Image validated = new Image("Gui/images/etoileSelect.png");

        while (star5.isPressed() || star4.isPressed() || star3.isPressed() || star2.isPressed() || star1.isPressed()) {
            if (star5.isPressed()) {
                System.out.println("star5 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(activate);
                star5.setImage(activate);
                 
                Rating = Rating + 10;
                sr.AjoutRating(idP, Rating);
                lblRating.setText(String.valueOf(Rating));
                break;
            } else if (star4.isPressed()) {   //win tableau N? 
                System.out.println("star4 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(activate);
                star5.setImage(validated);
                   Rating = Rating + 8;
                sr.AjoutRating(idP, Rating);
                lblRating.setText(String.valueOf(Rating));
                break;
            } else if (star3.isPressed()) {
                System.out.println("star3 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(activate);
                star4.setImage(validated);
                star5.setImage(validated);
               Rating = Rating + 6;
                sr.AjoutRating(idP, Rating);
                lblRating.setText(String.valueOf(Rating));
                break;
            } else if (star2.isPressed()) {
                System.out.println("star2 selected");
                star1.setImage(activate);
                star2.setImage(activate);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated);
                Rating = Rating + 4;
                sr.AjoutRating(idP, Rating);
                lblRating.setText(String.valueOf(Rating));
                break;
            } else if (star1.isPressed()) {
                System.out.println("star selected");
                star1.setImage(activate);
                star2.setImage(validated);
                star3.setImage(validated);
                star4.setImage(validated);
                star5.setImage(validated);
               Rating = Rating + 2;
                sr.AjoutRating(idP, Rating);
                lblRating.setText(String.valueOf(Rating));
                
                
                break;
            }
        }
    }

}
