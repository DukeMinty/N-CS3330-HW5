package edu.mu.pizzaStore.pizzaTypes;

import java.util.ArrayList;
import java.util.List;

import edu.mu.pizzaStore.pizzaOrdering.Toppings;

public class MargheritaPizza extends AbstractPizza{
	
	/*
	 * Student: Aaron Trebus
	 * 
	 * This class makes the constructors for all hawaiianPizza objects.
	 */
	
	//Arraylist that defines the default toppings for a Marg Pizza
	protected final static List<Toppings> defaultToppings = new ArrayList<>(List.of(Toppings.TOMATO, Toppings.CHEESE));

	/*
	 * Above is the list of toppings to add to a marg pizza's toppingList on construction
	 * A hawaiian pizza's default price is 2.50
	 * 
	 * The constructor will make a pizza, but we'll user input in order to make a complete pizza,
	 * with attributes of totalPrice, cookingStrategy, and cookingPrice. I'll
	 * make an example of this in main.
	 */
	public MargheritaPizza() {
		super();
		this.toppingList.addAll(defaultToppings);
		this.priceWithoutToppings = 2.50;
		this.pizzaOrderID = orderIDCounter++;
	}

	//copy constructor
	public MargheritaPizza(MargheritaPizza original) {
		super(original);
	}
	
	public MargheritaPizza(AbstractPizza original) {
		super(original);
	}

	public void callAddToppingsToPrice(double priceWithoutToppings) {
		super.addToppingsToPrice(priceWithoutToppings);
	}
}