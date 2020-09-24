 /*
        PizzaOrder.java
        Author:Sam Belbeck
        Date: March 20, 2020

        Description:
        Program to receive and display pizza order.
    */

package belbecsa;

import java.util.ArrayList;

/**
 *
 * @author S.B.
 */
public class PizzaOrder {
    
    /**
     * instance variable to create the size of the pizza
     */
    private PizzaSize pizzaSize;
    
    /**
     * instance variable to create an array list of selected toppings
     */
    private ArrayList<Toppings> toppingList;
    
    /**
     * instance variable to create drink option
     */
    private Drinks drink;
    
    /**
     * instance variable to set number of pizzas
     */
    private int numPizzas;
    
    /**
     * instance variable to set number of drinks
     */
    private int numDrinks;
    
    /**
     * constructor to initiate order
     * @param pizzaSize size of the pizza
     * @param numPizzas number of pizzas
     * @param numDrinks number of drinks
     * @param drink drink
     * @param toppingList toppings selected
     * @param HST_RATE HST rate at 13%
     */
    public PizzaOrder(PizzaSize pizzaSize, int numPizzas, int numDrinks, 
            Drinks drink, ArrayList toppingList, double HST_RATE) {
        if (pizzaSize.equals(PizzaSize.NONE) && drink.equals(Drinks.NONE)){
            throw new ArithmeticException("You must select atleast one pizza or drink");
        }
        else {
            setPizzaSize(pizzaSize);
            setDrink(drink);
            setToppingList(toppingList);
            setNumPizzas(numPizzas);
            setNumDrinks(numDrinks);       
        }  
    }  
    
    /**
     * getter method to get the pizza size
     * @return pizza size
     */
    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    /**
     * assigns pizza size to the order
     * @param pizzaSize size of pizza
     */
    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    /**
     * getter method to get the list of selected toppings
     * @return topping list arrayList
     */
    public ArrayList<Toppings> getToppingList() {
        return toppingList;
    }
    
    /**
     * assigns topping list to order
     * @param toppingList list of toppings selected
     */
    public void setToppingList(ArrayList<Toppings> toppingList) {
        this.toppingList = toppingList;
    }

    /**
     * getter method to get the drink of the order
     * @return the drink of the order
     */
    public Drinks getDrink() {
        return drink;
    }

    /**
     * assigns a drink to the order
     * @param drink drink of the order
     */
    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    /**
     * getter method to get the number of pizzas
     * @return number of pizzas
     */
    public int getNumPizzas() {
        return numPizzas;
    }

    /**
     * assigns number of pizzas to the order
     * @param numPizza number of pizzas
     */
    public void setNumPizzas(int numPizza) {
        if (numPizza < 0 ) {
            throw new ArithmeticException("Number of pizzas can't be negative.");
        } else if(!getPizzaSize().equals(PizzaSize.NONE) && numPizza == 0) {
            throw new ArithmeticException("You must enter number of pizzas.");
        } else if(getPizzaSize().equals(PizzaSize.NONE) && numPizza > 0) {
            throw new ArithmeticException("You forgot to pick your pizza size.");
        } else {
        this.numPizzas = numPizza;
        }        
    }
    
    /**
     * getter method to get the number of drinks
     * @return number of drinks
     */
    public int getNumDrinks() {
        return numDrinks;
    }
    
    /**
     * assigns number of drinks to the order
     * @param numDrink number of drinks
     */
    public void setNumDrinks(int numDrink) {     
        if (numDrink < 0) {
            throw new ArithmeticException("Number of drinks can't be negative");
        } else if(!getDrink().equals(Drinks.NONE) && numDrink == 0) {
            throw new ArithmeticException("You must enter number of drinks.");
        } else if (getDrink().equals(Drinks.NONE) && numDrink > 0) {
            throw new ArithmeticException("You forgot to pick your drink.");
        }  else {
            this.numDrinks = numDrink;
        }      
    }
    
    /**
     * method to calculate the subtotal of the order based on options selected 
     * and their prices
     * @return subtotal of the order
     */
    public double calculateSubtotal() {
        double subtotal = 0;       
        if(!pizzaSize.equals(PizzaSize.NONE)){
            subtotal = numPizzas * pizzaSize.getPrice();
            if (toppingList.size() >= 1) {
                for(int i=0; i < toppingList.size(); i++){
                    subtotal += toppingList.get(i).getPrice() * numPizzas;
                }               
            } 
        }
        if(!drink.equals(Drinks.NONE)) {
            subtotal += numDrinks * drink.getPrice();
        }
        return subtotal;
    }
    
    /**
     * method to calculate the HST on the order
     * @param HST_RATE HST rate at 13%
     * @return HST on the order
     */
    public double calculateHst(double HST_RATE) {
        return HST_RATE * calculateSubtotal();
    }    
    
    /**
     * method to print out the order and total
     * @param HST_RATE
     * @return 
     */
    public String toString(double HST_RATE) {
        String order = "Receipt:\n========================================\n";       
        order += pizzaSize.toString(numPizzas);
        if(!pizzaSize.equals(PizzaSize.NONE) && toppingList.size() == 0) {
            order += String.format("%-30s$%8s\n", "Toppings:", "0.00");
        }else if (!pizzaSize.equals(PizzaSize.NONE) && toppingList.size() != 0){
            double subtotal = 0;        
            for(int i = 0; i < toppingList.size(); i++){
                subtotal += (toppingList.get(i).getPrice() * numPizzas);
            } 
            order += String.format("%-30s$%8.2f\n", "Toppings:", subtotal);
            for(int i = 0; i < toppingList.size(); i++) {
                order += toppingList.get(i).toString(toppingList.get(i), numPizzas);      
            }
        }
        if(!drink.equals(Drinks.NONE)) {
            order += drink.toString(drink, numDrinks);
        }
        
        order += String.format("========================================\n%-30s$%8.2f"
                + "\n%-30s$%8.2f\n%-30S$%8.2f", "Subtotal:", calculateSubtotal()
                ,"HST:", calculateHst(HST_RATE),"TOTAL:", (calculateSubtotal() + calculateHst(HST_RATE)));
        return order;
    } 
}
