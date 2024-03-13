package edu.mu.pizzaStore.pizzaOrdering;

import edu.mu.pizzaStore.cooking.*;
import edu.mu.pizzaStore.cooking.cookingStrategies.BrickOvenCookingStrategy;
import edu.mu.pizzaStore.cooking.cookingStrategies.ConventionalOvenCookingStrategy;
import edu.mu.pizzaStore.cooking.cookingStrategies.MicrowaveCookingStrategy;
import edu.mu.pizzaStore.pizzaTypes.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
	@SuppressWarnings("unused")
	private PizzaCookingFactory pizzaFactory;
	private List<AbstractPizza> pizzaOrderList;
	
	// Default Constructor
	public PizzaOrder() {
		pizzaFactory = new PizzaCookingFactory();
		pizzaOrderList = new ArrayList<AbstractPizza>();
	}

	public void printListOfToppingsByPizzaOrderID(int orderID) {
 		// Gets the pizza order associated with orderID and prints the toppings associated if the order exists.
		boolean orderExists = false;
		
		for (AbstractPizza pizza : pizzaOrderList) {
			// Order found
			if (pizza.getPizzaOrderID() == orderID) {
				orderExists = true;
				
				System.out.println("The toppings on order " + Integer.toString(orderID) + " are:");
				// Iterate through toppings and print them one by one. This is done for formatting reasons.
				for (Toppings t : pizza.getToppingList()) {
					System.out.printf("\t%s\n", t.toString());
				}
				
				break;  // Order found.
			}
		}
		
		// Did not find order
		if (!orderExists) {
			System.out.println("Order #" + Integer.toString(orderID) + " does not exist.");
		}
	}


	public void printPizzaOrderCart() {
		// Prints all of the pizzas currently in the order.
		System.out.println("The pizzas currently in the order are: ");
		for (AbstractPizza pizza : pizzaOrderList) {
			System.out.println(pizza.toString());
		}
	}
	

	
	public AbstractPizza getPizzaByOrderID(int orderID) {
		// This method returns the pizza associated with the given orderID if it exists.
		// If the pizza does not exist, null is returned.
		
		for (AbstractPizza pizza : pizzaOrderList) {
			if (pizza.getPizzaOrderID() == orderID) {
				return pizza;
			}
		}
		
		return null;
	}
	
	public boolean addPizzaToCart(PizzaType pizzaType) {
		// Creates a new pizza of type pizzaType and adds it to the pizzaOrderList.
		AbstractPizza pizza = PizzaCookingFactory.createPizza(pizzaType);
		pizzaOrderList.add(pizza);
		
		return true;
	}
	
	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
		// This method finds the pizza order with the given ID and adds the given topping to its topping list
		//if the given topping is added, it also updates the pizza pricve and returns true.
		//if the topping already exists inn the topping list of the pizza, it returns false.
		
		for (AbstractPizza pizza : pizzaOrderList) {
			if (pizza.getPizzaOrderID() == orderID) {
				//check if the topping is present
				if (pizza.getToppingList().contains(topping)){
					return false; //the topping is already on the pizza, do not add
				} else {
					pizza.getToppingList().add(topping); // add topping
					pizza.setTotalPrice(pizza.getTotalPrice() + topping.getToppingPrice()); //update the price
					return true; //topping added 
				}
			}
		}
		return false; //pizza with given order ID not found
	}
	
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		//this method finds the pizza order with the given ID and removes the iven toppig if it exists in the list
		// if the given topping is removed, it also updates the pizza price and returns true
		//if the topping doesnt exist it returns false
		
		
		// find the pizza with the given order ID.
	    for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	        	//check if topping is present in topping list	    
	        	List<Toppings> toppingsList = pizza.getToppingList();
	        	boolean isRemoved = toppingsList.remove(topping);
	        	if (isRemoved) {
	        		// if topping was removed, update the pizza price
	        		double newPrice = pizza.getPriceWithoutToppings(); //set newPrice = to the price without toppings
	        		for (Toppings existingTopping : toppingsList) { 	
	        			newPrice += existingTopping.getToppingPrice();	//update price based on what toppings are still on the pizza
	        		}
	        		pizza.setTotalPrice(newPrice);
	        		return true; //topping was removed successfully
	        	}
	        	break; //exit the loop
	        }
	    }
		return false; //pizza with given ID not found
	}
	
	public boolean isThereAnyUncookedPizza() {
		//checks the pizzas in the pizzaOrderList and checks their cooking strategies.
		// returns true if there are any pizzas without assigned cooking strategy, false if there are none
		
		
	    // check each pizza in the order list.
	    for (AbstractPizza pizza : pizzaOrderList) {
	        // If the cookingStrategy for a pizza is null, the pizza is uncooked
	        if (pizza.getCookingStrategy() == null) {
	            return true; // found an uncooked pizza, return true
	        }
	    }
	    // all pizzas have a cooking strategy, return false
	    return false;
	}
	
	public double checkout() throws Exception {
	    // check for uncooked pizzas using the previous method
	    if (isThereAnyUncookedPizza()) {
	        throw new Exception("There are uncooked pizzas in the order. Cannot proceed to checkout.");
	    }

	    // If all pizzas are cooked, calculate the total price
	    double totalCartPrice = 0.0;
	    for (AbstractPizza pizza : pizzaOrderList) {
	        totalCartPrice += pizza.getTotalPrice();
	    }
	    
	    // return the total cart price
	    return totalCartPrice;
	}
	
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
	    // find the pizza with the given orderID
	    AbstractPizza pizzaToCook = getPizzaByOrderID(orderID);
	    if (pizzaToCook == null) {
	        return false; // pizza with the given order ID was not found.
	    }

	    // instantiate the cooking strategy based on the provided cookingStrategyType.
	    ICookingStrategy cookingStrategy;
	    switch (cookingStrategyType) {
	        case MICROWAVE:
	            cookingStrategy = new MicrowaveCookingStrategy();
	            break;
	        case CONVENTIONAL_OVEN:
	            cookingStrategy = new ConventionalOvenCookingStrategy();
	            break;
	        case BRICK_OVEN:
	            cookingStrategy = new BrickOvenCookingStrategy();
	            break;
	        default:
	            return false; // if type is not recognized, return false
	    }

	    // set the strategy and cook the pizza.
	    pizzaToCook.setCookingStrategy(cookingStrategy);
	    return cookingStrategy.cook(pizzaToCook);
	}
	
}
