/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Client;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import Service.ServiceClient;
import javafx.scene.control.TextField;




/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FormClientController implements Initializable {

   
     @FXML
    private TextField cfnom;
    @FXML
    private TextField clnom; 
    @FXML
    private TextField cunom;
    @FXML
    private TextField cpass; 
     @FXML
    private TextField cadd;
    @FXML
    private TextField cmail; 
     @FXML
    private TextField cph;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        

// TODO
    }    
    @FXML
    private void ajouterClient(ActionEvent event) throws SQLException {
        Client c= new Client();
                ServiceClient sp =new ServiceClient();
String prenom=cfnom.getText();
String mail=cmail.getText();
String nom=clnom.getText();
String password=cpass.getText();
String username=cunom.getText();
String city=cadd.getText();
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
          
          
           if(sp.validusername(username)){
                        c.setUsername(cunom.getText());

}
       else{
       Alert alert = new Alert(Alert.AlertType.WARNING);
alert.setTitle("Alert");
alert.setHeaderText(null);
alert.setContentText("your username is not valid");
alert.showAndWait();
       } 
          
                if(sp.validcity(city)){
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
        if((sp.validname(nom))&&(sp.validMail(mail))&&(sp.validusername(username))&&(sp.validcity(city))&&(sp.validphone(phone))&&(sp.validpassword(password))&&(sp.validname(nom))){
         try{
            sp.ajouterClient(c);
                        ((Node) (event.getSource())).getScene().getWindow().hide();

        }catch (SQLException ex){
            System.out.println(ex);
            
        }}
        //c.setFidelity_pt(Integer.valueOf(cpf.getText()));
       // c.setImage(cima.getText());
        
      //  try{
         //   sp.ajouterClient(c);
       // }catch (SQLException ex){
       //     System.out.println(ex);
            
       // }
    }}
