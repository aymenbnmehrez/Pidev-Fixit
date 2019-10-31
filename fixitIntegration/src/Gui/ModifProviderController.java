/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Provider;
import Service.ServiceProvider;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Koala girl
 */
public class ModifProviderController implements Initializable {
private String username;
    @FXML
    private TextField pfnom;
    @FXML
    private TextField pmail;
    @FXML
    private TextField plnom;
    @FXML
    private TextField ppass;
    @FXML
    private TextField pph;
    @FXML
    private TextField padd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }
  
    public void setInfo(String fn,String ln,String pwd,String adr,String ml,int ph) throws SQLException {
   
pfnom.setText(fn);
plnom.setText(ln);
ppass.setText(pwd);
padd.setText(adr);
pmail.setText(ml);
pph.setText(Integer.toString(ph));

    }    
 public String setUser(String username) {

        this.username = username;
        return this.username;
             
    }

    @FXML
    private void updateProvider(ActionEvent event) throws IOException, SQLException {
             Provider c= new Provider();
         ServiceProvider sp =new ServiceProvider();
        
       String prenom=pfnom.getText();
String mail=pmail.getText();
String nom=plnom.getText();
String password=ppass.getText();
//String username=punom.getText();
String city=padd.getText();
String phone=pph.getText();

       if(sp.validname(prenom)){
        c.setFirst_name(pfnom.getText());}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your first name is not valid");
alert.showAndWait();
       }
        if(sp.validname(nom)){
        c.setLast_name(plnom.getText());}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your last name is not valid");
alert.showAndWait();
       } 
        
          if(sp.validpassword(password)){
                c.setPassword(ppass.getText());
}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("the password is not valid");
alert.showAndWait();
       } 
          
          
          
          
                if(sp.validcity(city)){
        c.setAddress(padd.getText());

}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your city is not valid");
alert.showAndWait();
       } 
                
                 if(sp.validphone(phone)){
        c.setPhone(Integer.valueOf(pph.getText()));

}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your phone number is not valid");
alert.showAndWait();
       }
        
           
        
        
        if(sp.validMail(mail)){
        c.setMail(pmail.getText());
              
                }else {
         Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your mail adress is not valid");
alert.showAndWait();
        }
        if((sp.validname(nom))&&(sp.validMail(mail))&&(sp.validcity(city))&&(sp.validphone(phone))&&(sp.validpassword(password))&&(sp.validname(nom))){
         
       
            sp.upProvider(username,c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("Your profile has been updated successfully");

alert.showAndWait();
}
    }
    
}
