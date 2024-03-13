package edu.mu.pizzaStore.pizzaOrdering;

import edu.mu.pizzaStore.pizzaTypes.AbstractPizza;
import edu.mu.pizzaStore.pizzaTypes.HawaiianPizza;
import edu.mu.pizzaStore.pizzaTypes.MargheritaPizza;
import edu.mu.pizzaStore.pizzaTypes.SupremePizza;
import edu.mu.pizzaStore.pizzaTypes.VegetarianPizza;

public class PizzaCookingFactory {

	public static AbstractPizza createPizza(PizzaType pizzaType) {
	        if(pizzaType.equals(PizzaType.HAWAIIAN)) {
	        	return new HawaiianPizza();
	        }else if(pizzaType.equals(PizzaType.MARGHERITA)) {
	        	return new MargheritaPizza();
	        } else if(pizzaType.equals(PizzaType.SUPREME)) {
	        	return new SupremePizza();
	        }else if(pizzaType.equals(PizzaType.VEGETARIAN)) {
	        	return new VegetarianPizza();
	        }
			return null;
	 }
	
}
