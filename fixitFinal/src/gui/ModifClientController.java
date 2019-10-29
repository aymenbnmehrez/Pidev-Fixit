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
    private void updateClient(ActionEvent event) throws SQLException {
         ServiceClient sp =new ServiceClient();
        client c= new client();
        
       //ServiceClient sp =new ServiceClient();
String prenom=cfnom.getText();
String mail=cmail.getText();
String nom=clnom.getText();
String password=cpass.getText();
//String username=cunom.getText();
String city=ccity.getText();
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
          
          
           
          
                if(sp.validcity(city)){
        c.setCity(ccity.getText());

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
        if((sp.validname(nom))&&(sp.validMail(mail))&&(sp.validcity(city))&&(sp.validphone(phone))&&(sp.validpassword(password))&&(sp.validname(nom))){
        
        
       
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
        // TODO
    }    
    
}
