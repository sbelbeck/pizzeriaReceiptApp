/*
        Drinks.java
        Author: Sam Belbeck
        Date: March 20, 2020

        Description:
        enum to store the drinks and their prices.

    */

package belbecsa;

/**
 *
 * @author S.B.
 */
public enum Drinks {
    
    /**
     * Coke constant
     */
    COKE("Coke",  1.25),
    
    /**
     * Juice constant
     */
    JUICE("Juice", 1.95),
    
    /**
     * Chocolate Milk constant
     */
    CHOCOLATE_MILK("Chocolate Milk", 2.25),
    
    /**
     * No drink constant
     */
    NONE("None", 0.00);

    /**
     * instance variables for name and price of drink
     */
    private String name;
    private double price;
    
    /**
     * Constructor to initiate the drink name and price when a drink is set for
     * a pizza order
     * @param name full name of the drink as a String
     * @param price price of the drink
     */
    Drinks(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    /**
     * getter method to get the String name of the drink
     * @return the String name of the drink
     */
    public String getName() {
        return name;
    }
    
    /**
     * getter method to get the price of the drink
     * @return the price of the drink as a double
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * method to print out the drink and price on the receipt
     * @param drink drink ordered
     * @param numDrinks number of drinks ordered
     * @return Drinks portion of the receipt
     */
    public String toString(Drinks drink, int numDrinks) {
        return String.format("%-30s$%8.2f\n  %d %s @ $%.2f\n", "Drinks:", 
                    numDrinks * drink.getPrice(), numDrinks, drink.getName(), 
                    drink.getPrice());
    }
    
    
}
