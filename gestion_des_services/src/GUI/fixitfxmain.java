/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entite.Service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.DataSource;

/**
 *
 * @author asus
 */
public class fixitfxmain extends Application {
    
    private  Connection conn = DataSource.getInstance().getConnection();
     @Override
     public void start(Stage primaryStage)  {
        try{
        
            Parent root = FXMLLoader.load(getClass().getResource("page0.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();}
        catch (IOException ex){
            Logger.getLogger(fixitfxmain.class.getName()).log(Level.SEVERE, null,ex);
        }}

     public static void main(String[] args) {
        launch(args);
       }
}

