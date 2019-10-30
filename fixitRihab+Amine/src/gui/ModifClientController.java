/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ENTITE.client;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.ServiceClient;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModifClientController implements Initializable {
    private String username;
    @FXML
    private TextField cfnom;
    @FXML
    private TextField clnom; 
    //@FXML
    //private TextField cunom;
    @FXML
    private TextField cpass; 
     @FXML
    private TextField ccity;
    @FXML
    private TextField cmail; 
   // @FXML
    //private TextField cpf;
    //@FXML
    //private TextField cima;
     @FXML
   private TextField cph; 
    
     
     
        
      public String setUser(String username) {

        this.username = username;
        return this.username;
    }
     
    @FXML 
    public void getInfo(ActionEvent event) throws SQLException, IOException {
            List<client> list=new ArrayList<>();

        ServiceClient sc = new ServiceClient();
        client c = new client();
        list= sc.getdata(username);
        c=list.get(0);
cfnom.setText(c.getFirst_name());
clnom.setText(c.getLast_name());
cpass.setText(c.getPassword());
ccity.setText(c.getCity());
cmail.setText(c.getMail());
cph.setText(String.valueOf(c.getPhone()));


    }
    
        @FXML
    private void updateClient(ActionEvent event) {
        client c= new client();
        c.setFirst_name(cfnom.getText());
        c.setLast_name(clnom.getText());
        c.setPassword(cpass.getText());
    
        c.setCity(ccity.getText());
        c.setPhone(Integer.valueOf(cph.getText()));
        c.setMail(cmail.getText());
        //c.setFidelity_pt(Integer.valueOf(cpf.getText()));
       // c.setImage(cima.getText());
        
        ServiceClient sp =new ServiceClient();
        try{
            sp.upClient(username,c);
        }catch (SQLException ex){
            System.out.println(ex);
            
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("Your profile has been updated successfully");

alert.showAndWait();
}
     
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
