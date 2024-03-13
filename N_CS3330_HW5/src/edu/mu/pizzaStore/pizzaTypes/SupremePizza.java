package edu.mu.pizzaStore.pizzaTypes;

import java.util.ArrayList;
import java.util.List;

import edu.mu.pizzaStore.pizzaOrdering.Toppings;

public class SupremePizza extends AbstractPizza{
	
	/*
	 * Student: Aaron Trebus
	 * 
	 * This class makes the constructors for all supremePizza objects.
	 */
	
	//Arraylist that defines the default toppings for a Supreme Pizza
	protected final static List<Toppings> defaultToppings = new ArrayList<>(List.of(Toppings.TOMATO, Toppings.CHEESE,
				Toppings.BELL_PEPPER, Toppings.ITALIAN_SAUSAGE, Toppings.PEPPERONI, Toppings.BLACK_OLIVE, Toppings.MUSHROOM));
		
		/*
		 * Above is the list of toppings to add to a supreme pizza's toppingList on construction
		 * A hawaiian pizza's default price is 3.50
		 * 
		 * The constructor will make a pizza, but we'll user input in order to make a complete pizza,
		 * with attributes of totalPrice, cookingStrategy, and cookingPrice. I'll
		 * make an example of this in main.
		 */
		
	public SupremePizza() {
	super();
	this.toppingList.addAll(defaultToppings);
	this.priceWithoutToppings = 3.50;
	this.pizzaOrderID = orderIDCounter++;
	}

	//copy constructor
	public SupremePizza(SupremePizza original) {
		super(original);
	}
	
	public SupremePizza(AbstractPizza original) {
		super(original);
	}

	public void callAddToppingsToPrice(double priceWithoutToppings) {
		super.addToppingsToPrice(priceWithoutToppings);
	}
}