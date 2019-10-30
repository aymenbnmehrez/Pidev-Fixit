/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Service.ServiceAskService;
import Service.ServicePaiement;
import com.jfoenix.controls.JFXTextField;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class PaimentController implements Initializable {

    @FXML
    private JFXTextField tf_yearexp;
    @FXML
    private JFXTextField tf_card;
    @FXML
    private JFXTextField tf_monthexp;
    @FXML
    private JFXTextField tf_cvc;
    @FXML
    private Label lb_succes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private int price;
    private int idAskService;
    public void setPrice(int price) {
        this.price = price;
    }
        public void setId(int id) {
        this.idAskService = id;
    }

    public void confirmPaiement(ActionEvent event) throws InvalidRequestException, CardException, StripeException,SQLException, IOException {
        String cardNumber = tf_card.getText();
        int expYear = Integer.parseInt(tf_yearexp.getText());
        int expMonth = Integer.parseInt(tf_monthexp.getText());
        String cvc = tf_cvc.getText();
        ServicePaiement sp = new ServicePaiement();
        if (sp.payer(cardNumber, expYear, expMonth, cvc, price) == true) {
            System.out.println("succes");
            lb_succes.setText("your "+price+"$ payment has been successfully completed !!");
            ServiceAskService sas = new ServiceAskService();
                            sas.payAskService(idAskService);

                            ((Node) (event.getSource())).getScene().getWindow().hide();
                            
                            
                            
        } else {
            System.out.println("fail");
        }

    }

}
