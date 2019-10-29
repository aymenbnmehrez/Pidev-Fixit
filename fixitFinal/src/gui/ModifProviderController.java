/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ENTITE.client;
import ENTITE.provider;
import java.io.IOException;
import java.net.URL;
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
import service.serviceProvider;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModifProviderController implements Initializable {

    private String username;
    @FXML
    private TextField pfnom;
     @FXML
    private TextField plnom;
      @FXML
    private TextField pcity;
     @FXML
    private TextField pph;
      @FXML
    private TextField pmail;
     @FXML
    private TextField ppass;
    
    public String setUser(String username) {

        this.username = username;
        return this.username;
    }
    @FXML 
    public void getInfo(ActionEvent event) throws SQLException, IOException {
            List<provider> list=new ArrayList<>();

        serviceProvider sc = new serviceProvider();
        provider c = new provider();
        list= sc.getdata(username);
        c=list.get(0);
pfnom.setText(c.getFirst_name());
plnom.setText(c.getLast_name());
ppass.setText(c.getPassword());
pcity.setText(c.getCity());
pmail.setText(c.getMail());
pph.setText(String.valueOf(c.getPhone()));


    }
    
    @FXML
    private void updateProvider(ActionEvent event) throws SQLException {
        provider c= new provider();
         serviceProvider sp =new serviceProvider();
        
       String prenom=pfnom.getText();
String mail=pmail.getText();
String nom=plnom.getText();
String password=ppass.getText();
//String username=punom.getText();
String city=pcity.getText();
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
        c.setCity(pcity.getText());

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
         
       
        try{
            sp.upProvider(username,c);
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
