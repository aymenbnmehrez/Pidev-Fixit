/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author aymen
 */
public class FixitFXMain extends Application {
    
 @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
          
                    Scene scene = new Scene(root);      
                    primaryStage.setScene(scene);
                    primaryStage.getIcons().add(new Image("/Gui/images/log.png"));
                  
                    primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FixitFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
