package MainClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FXMLControllers.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * 
 */
public class MainClass extends Application {
    
    /* Create variable to hold the controller of the scene */
    public static MainController controller;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        /* Create new window from custom fxml template */
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../FXMLTemplates/HHMedicalSoftware.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 500);
    
        primaryStage.setTitle("HH Medical Software");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        controller = loader.getController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}