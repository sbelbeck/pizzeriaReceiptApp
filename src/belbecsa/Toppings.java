/*
        Toppings.java
        Author: Sam Belbeck
        Date: March 20, 2020

        Description:
        enum to store the name and price of pizza toppings    
        
    */

package belbecsa;

import java.util.ArrayList;

/**
 *
 * @author S.B.
 */
public enum Toppings {
    /**
     * cheese constant
     */
    CHEESE("Cheese", 1.00),
    
    /**
     * pepperoni constant
     */
    PEPPERONI("Pepperoni", 1.75),
    
    /**
     * mushroom constant
     */
    MUSHROOMS("Mushrooms", 1.25),
    
    /**
     * olives constant
     */
    OLIVES("Olives", 1.50);
    
    /**
     * instance variables for topping name and price
     */
    private String name;
    private double price;
    
    /**
     * constructor to initiate the name and price of the pizza topping
     * @param name name of the pizza topping
     * @param price price of the pizza topping
     */
    Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    /**
     * getter method to get the name of the topping
     * @return name of the topping
     */
    public String getName() {
        return name;
    }

    /**
     * getter method to get the price of the topping
     * @return price of the topping
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * method to print the toppings and their prices on the receipt
     * @param topping toppings selected
     * @param numPizzas number of pizzas ordered
     * @return Toppings portion of the receipt
     */
    public String toString(Toppings topping, int numPizzas) {
        return String.format("  %d %s @ $%.2f\n", numPizzas, topping.getName(), 
                        topping.getPrice()); 
    }
    
}
