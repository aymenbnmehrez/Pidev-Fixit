/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author aymen
 */
public class FixitFXMain extends Application {
    
 @Override
    public void start(Stage primaryStage) {

        try {
<<<<<<< HEAD
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
=======
<<<<<<< HEAD
            Parent root = FXMLLoader.load(getClass().getResource("AuthProvider.fxml"));
=======
            Parent root = FXMLLoader.load(getClass().getResource("ReadServices.fxml"));
>>>>>>> 0d0cf9529473dd5badaf188d96a9b4cef0186c11
>>>>>>> 4b6d6d3b1aa0f55c096fb62d55e8e5e550ccbe22
                    Scene scene = new Scene(root);      
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.getIcons().add(new Image("/Gui/images/log.png"));
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
