package edu.mu.pizzaStore.pizzaTypes;

import java.util.ArrayList;
import java.util.List;
import edu.mu.pizzaStore.pizzaOrdering.Toppings;

public class HawaiianPizza extends AbstractPizza{
	
	/*
	 * Student: Aaron Trebus
	 * 
	 * This class makes the constructors for all hawaiianPizza objects.
	 */
	
	//Arraylist that defines the default toppings for a Hawaiian Pizza
	protected final static List<Toppings> defaultToppings = new ArrayList<>(List.of(Toppings.CHEESE, Toppings.CANADIAN_BACON, Toppings.PINEAPPLE));
	
	/*
	 * Above is the list of toppings to add to a hawaiian pizza's toppingList on construction
	 * 
	 * The constructor will make a pizza, but we'll user input in order to make a complete pizza,
	 * with attributes of totalPrice, cookingStrategy, and cookingPrice. I'll
	 * make an example of this in main.
	 */
	public HawaiianPizza() {
		super();
		this.toppingList.addAll(defaultToppings);
		this.priceWithoutToppings = 3.00;
		this.pizzaOrderID = orderIDCounter++;
	}

	//copy constructor
	public HawaiianPizza(HawaiianPizza original) {
		super(original);
	}
	
	public HawaiianPizza(AbstractPizza original) {
		super(original);
	}

	public void callAddToppingsToPrice(double priceWithoutToppings) {
		super.addToppingsToPrice(priceWithoutToppings);
	}

}
