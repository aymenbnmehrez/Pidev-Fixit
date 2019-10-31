/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Client;
import Service.ServiceClient;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class ModifClientController implements Initializable {
private String username;
    @FXML
    private TextField cfnom;
    @FXML
    private TextField cmail;
    @FXML
    private TextField cph;
    @FXML
    private TextField clnom;
    @FXML
    private TextField cpass;
  
    @FXML
    private TextField cadd;

    /**
     * Initializes the controller class.
     */
    
   public String setUser(String username) {

        this.username = username;
        return this.username;
    }
     
    public void setInfo(String fn,String ln,String pwd,String adr,String ml,int ph) throws SQLException, IOException {
         
cfnom.setText(fn);
clnom.setText(ln);
cpass.setText(pwd);
cadd.setText(adr);
cmail.setText(ml);
cph.setText(String.valueOf(ph));
  

    }
    
        @FXML
    private void updateClient(ActionEvent event) throws SQLException {
         ServiceClient sp =new ServiceClient();
        Client c= new Client();
        
       //ServiceClient sp =new ServiceClient();
String prenom=cfnom.getText();
String mail=cmail.getText();
String nom=clnom.getText();
String password=cpass.getText();
//String username=cunom.getText();
String address=cadd.getText();
String phone=cph.getText();

       if(sp.validname(prenom)){
        c.setFirst_name(cfnom.getText());}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your first name is not valid");
alert.showAndWait();
       }
        if(sp.validname(nom)){
        c.setLast_name(clnom.getText());}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your last name is not valid");
alert.showAndWait();
       } 
        
          if(sp.validpassword(password)){
                c.setPassword(cpass.getText());
}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("the password is not valid");
alert.showAndWait();
       } 
          
          
           
          
                if(sp.validcity(address)){
        c.setAddress(cadd.getText());

}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your city is not valid");
alert.showAndWait();
       } 
                
                 if(sp.validphone(phone)){
        c.setPhone(Integer.valueOf(cph.getText()));

}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your phone number is not valid");
alert.showAndWait();
       }
        
           
        
        
        if(sp.validMail(mail)){
        c.setMail(cmail.getText());
              
                }else {
         Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your mail adress is not valid");
alert.showAndWait();
        }
        if((sp.validname(nom))&&(sp.validMail(mail))&&(sp.validcity(address))&&(sp.validphone(phone))&&(sp.validpassword(password))&&(sp.validname(nom))){
        
        
       
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
}}
     
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    
}}
