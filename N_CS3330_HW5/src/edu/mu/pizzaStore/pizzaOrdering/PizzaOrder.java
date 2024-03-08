package edu.mu.pizzaStore.pizzaOrdering;

import edu.mu.pizzaStore.cooking.*;
import edu.mu.pizzaStore.pizzaTypes.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
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
	
	
}
