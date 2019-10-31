/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Provider;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import Service.ServiceProvider;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FormProvController implements Initializable {

   
    @FXML
    private TextField pfnom;
    @FXML
    private TextField plnom; 
    @FXML
    private TextField punom;
    @FXML
    private TextField ppass; 
     @FXML
    private TextField pcity;
    @FXML
    private TextField pmail; 
    @FXML
    private TextField pr;
    @FXML
    private TextField pexp;
    @FXML
    private TextField pph;
    @FXML
    private TextField pnb;
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void ajouterProvider(ActionEvent event) throws SQLException {
        Provider c= new Provider();
         ServiceProvider sp =new ServiceProvider();
        
       String prenom=pfnom.getText();
String mail=pmail.getText();
String nom=plnom.getText();
String password=ppass.getText();
String username=punom.getText();
String city=pcity.getText();
String phone=pph.getText();
String exp=pexp.getText();
       if(sp.validname(prenom)){
        c.setFirst_name(pfnom.getText());}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your first name is not valid");
alert.showAndWait();
       }
       
       if(sp.validexp(exp)){
        c.setExperience(pexp.getText());}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("you must fill in the experience box with less than 40 caracters");
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
          
          
           if(sp.validusername(username)){
                        c.setUsername(punom.getText());

}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your username is not valid");
alert.showAndWait();
       } 
          
                if(sp.validcity(city)){
        c.setAddress(pcity.getText());

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
        if((sp.validname(nom))&&(sp.validMail(mail))&&(sp.validusername(username))&&(sp.validcity(city))&&(sp.validphone(phone))&&(sp.validpassword(password))&&(sp.validname(nom))){
         
       
        try{
            sp.ajouterProvider(c);
                        ((Node) (event.getSource())).getScene().getWindow().hide();

        }catch (SQLException ex){
            System.out.println(ex);
            
        }}}}
    
    

