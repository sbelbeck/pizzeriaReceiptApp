/*
        PizzaSize.java
        Author: Sam Belbeck
        Date: March 20, 2020

        Description:
        enum to store pizza sizes and their price

    */

package belbecsa;

/**
 *
 * @author S.B.
 */
public enum PizzaSize {
    
    /**
     * small constants
     */
    SMALL("Small", 5.25),
    
    /**
     * medium constant
     */
    MEDIUM("Medium", 7.50),
    
    /**
     * large constant
     */
    LARGE("Large", 9.95),
    
    /**
     * no pizza constant
     */
    NONE("None", 0.00);
    
    /**
     * instance variables for full name and price of pizza
     */
    private String name;
    private double price;
    
    /**
     * constructor to initiate the size name as a String and price when the 
     * pizza is ordered
     * @param name size name of the pizza
     * @param price price of the pizza
     */
    PizzaSize(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    /**
     * getter method to get the price of the pizza size
     * @return price of the pizza size
     */
    public double getPrice() {
        return price;
    }

    /**
     * getter method to get the name of the pizza size as a String
     * @return name of the pizza size as a String
     */
    public String getName() {
        return name;
    }

    /**
     * method to print out pizza size and price info on the receipt
     * @param numPizzas number of pizzas ordered
     * @return pizza portion of the receipt
     */
    public String toString(int numPizzas) {
       String order = "";
        if(!getName().equals("None")){
            order += String.format("%-30s$%8.2f\n  %d %s @ $%.2f\n", "Pizza:", 
                    numPizzas * this.getPrice(), numPizzas, 
                    this.getName(),this.getPrice());                    
        }
        return order;    
    }
}
