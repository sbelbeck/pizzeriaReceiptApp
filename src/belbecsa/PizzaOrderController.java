/*
        PizzaOrderController.java
        Author: Sam Belbeck
        Date: March 20, 2020

        Description:
        class to control/adjust the output on the GUI based on user input

    */
package belbecsa;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author sbelb
 */
public class PizzaOrderController implements Initializable {
    
    /**
     * constant HST rate 
     */
    @FXML 
    private final double HST_RATE = 0.13;
    
    /**
     * variable to control the title
     */
    @FXML
    private Label title;
    
    /**
     * variable to control the small radio button
     */
    @FXML
    private RadioButton small; 
    
    /**
     * variable to control the medium radio button
     */
    @FXML
    private RadioButton medium;
    
    /**
     * variable to control the large radio button
     */
    @FXML
    private RadioButton large;    
    
    /**
     * variable to control the number of pizzas text field
     */
    @FXML
    private TextField numPizzas;
    
    /**
     * variable to control the cheese checkbox
     */
    @FXML
    private CheckBox cheese;
    
    /**
     * variable to control the pepperoni checkbox
     */
    @FXML
    private CheckBox pepperoni;
    
    /**
     * variable to control the mushrooms checkbox
     */
    @FXML
    private CheckBox mushrooms;
    
    /**
     * variable to control the olives checkbox
     */
    @FXML
    private CheckBox olives;
    
    /**
     * variable to control the coke radio button
     */
    @FXML
    private RadioButton coke;
    
    /**
     * variable to control the coke radio button
     */
    @FXML
    private RadioButton juice;
    
    /**
     * variable to control the chocolateMilk radio button
     */
    @FXML
    private RadioButton chocolateMilk; 
    
    /**
     * variable to control the number of drinks text field
     */
    @FXML
    private TextField numDrinks;
        
    /**
     * variable to control the text area
     */
    @FXML
    private TextArea orderedItems;

    /**
     * variable to control the pizza picture
     */
    @FXML 
    private ImageView pizzaPic;
    
    /**
     * variable to control the submit button
     */
    @FXML
    private Button submit;
    
    /**
     * variable to control the clear button
     */
    @FXML
    private Button clear;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {         
        title.setFont(Font.loadFont("file:resources/fonts/Bruzh.otf", 70));
    }
    /**
     * method to exit the system
     * @param event user action event - close
     */
    @FXML
    private void clickExit(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * method to check user information submitted and display either a receipt
     * or error message with how to correct
     * @param event user submitting the form
     */
    @FXML
    private void buttonClick(ActionEvent event) {
        pizzaPic.setImage(new Image("file:resources/images/pizza.jpg"));
        try {
            if(event.getSource() == submit) {
                // set size, drinks and toppings
                PizzaSize size = getSize(small.isSelected(), 
                        medium.isSelected(), large.isSelected());
                Drinks drink = getDrink(coke.isSelected(), juice.isSelected(), 
                        chocolateMilk.isSelected());
                ArrayList<Toppings> toppings = getToppings(cheese.isSelected(),
                        pepperoni.isSelected(), mushrooms.isSelected(), 
                        olives.isSelected());
                
                // set numbers to 0 if no input
                String numberOfPizzas = numPizzas.getText();
                int numPizza;
                if(numPizzas.getText().equals("")){
                    numPizza = 0;
                } else  {
                    numPizza = Integer.parseInt(numberOfPizzas);
                }
                String numberOfDrinks = numDrinks.getText();
                int numDrink;
                if(numDrinks.getText().equals("")) {
                    numDrink = 0;
                }else {
                    numDrink = Integer.parseInt(numberOfDrinks);
                }

                // create order if a pizza
                PizzaOrder order = new PizzaOrder(size, numPizza, numDrink, 
                        drink, toppings, HST_RATE);
                orderedItems.setText(order.toString(HST_RATE));
                pizzaPic.setImage(new Image("file:resources/images/pizza2.gif"));
            }
        }catch (IllegalArgumentException t){
            orderedItems.setText("Error: Value entered must be a whole number.");
        }catch (Exception e){
            orderedItems.setText(e.getMessage());
        }
        
        //clear all inputs
            if(event.getSource() == clear) {
                small.setSelected(false);
                medium.setSelected(false);
                large.setSelected(false);
                numPizzas.clear();
                cheese.setSelected(false);
                pepperoni.setSelected(false);
                mushrooms.setSelected(false);
                olives.setSelected(false);
                coke.setSelected(false);
                juice.setSelected(false);
                chocolateMilk.setSelected(false);
                numDrinks.clear();
                orderedItems.clear();
                pizzaPic.setImage(null);
            }
    }
    
    /**
     * method to set the pizza size of the order
     * @param small small radio button option
     * @param medium medium radio button option
     * @param large large radio button option
     * @return pizza size
     */
    private PizzaSize getSize(boolean small, boolean medium, boolean large){
        PizzaSize size;
        if(small) {
            size = PizzaSize.SMALL;
        } else if (medium) {
            size = PizzaSize.MEDIUM;
        } else if (large) {
            size = PizzaSize.LARGE;
        } else size = PizzaSize.NONE;
        return size;
    }
    
    /**
     * method to set the drink of the order
     * @param coke coke radio button option
     * @param juice juice radio button option
     * @param chocolateMilk chocolate milk radio button option
     * @return drink
     */
    private Drinks getDrink(boolean coke, boolean juice, boolean chocolateMilk){
        Drinks drink;
        if(coke) {
            drink = Drinks.COKE;
        } else if (juice) {
            drink = Drinks.JUICE;
        } else if (chocolateMilk) {
            drink = Drinks.CHOCOLATE_MILK;
        } else drink = Drinks.NONE;
        return drink;
    }
    
    /**
     * method to set the toppings of the order
     * @param cheese cheese checkbox option
     * @param pepperoni pepperoni checkbox option
     * @param mushrooms mushrooms checkbox option
     * @param olives olives checkbox option
     * @return topping list
     */
    private ArrayList getToppings(boolean cheese, boolean pepperoni, 
            boolean mushrooms, boolean olives){
        ArrayList<Toppings> toppings = new ArrayList();
        if(cheese) {
            toppings.add(Toppings.CHEESE);
        }
        if (pepperoni) {
            toppings.add(Toppings.PEPPERONI);
        } 
        if (mushrooms) {
            toppings.add(Toppings.MUSHROOMS);
        } 
        if (olives) {
            toppings.add(Toppings.OLIVES);
        } 
        return toppings;
    }   
}
