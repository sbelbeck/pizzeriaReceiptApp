/*
        Name:  Sam Belbeck
        Assignment: 4
        Program: Pizzeria
        Date:  March 20, 2020
    
        Description:
        program to take user input for a pizza/drink order and then print their
        receipt

@createdby: Sam Belbeck

*/

package belbecsa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author S.B.
 */
public class Pizzeria extends Application {

    Stage window;
    
    /**
     * main method of the program
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * create graphical user interface for getting and displaying info
     * @param primaryStage stage of the interface
     * @throws Exception for if user input is incorrect
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Pane root = FXMLLoader.load(getClass().getResource("FXMLPizzaOrder.fxml"));
        Scene scene = new Scene(root, 650, 800);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Indie+Flower&display=swap");      
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Permanent+Marker&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Amatic+SC&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Caveat&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto+Mono&display=swap");
        window.setTitle("Assignment 4");
        window.setScene(scene);
        window.show();
        
    }
    
}
