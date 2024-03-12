package edu.mu.pizzaStore.pizzaOrdering;

import edu.mu.pizzaStore.pizzaTypes.AbstractPizza;
import edu.mu.pizzaStore.pizzaTypes.HawaiianPizza;
import edu.mu.pizzaStore.pizzaTypes.MargheritaPizza;
import edu.mu.pizzaStore.pizzaTypes.SupremePizza;
import edu.mu.pizzaStore.pizzaTypes.VegetarianPizza;

public class PizzaCookingFactory {

	static int orderIDcounter = 0;
	public AbstractPizza createPizza(PizzaType pizzaType) {
	        AbstractPizza pizza = null;
	        if(pizzaType.equals(PizzaType.HAWAIIAN)) {
	        	pizza = new HawaiianPizza();
	        }else if(pizzaType.equals(PizzaType.MARGHERITA)) {
	        	pizza = new MargheritaPizza();
	        } else if(pizzaType.equals(PizzaType.SUPREME)) {
	        	pizza = new SupremePizza();
	        }else if(pizzaType.equals(PizzaType.VEGETARIAN)) {
	        	pizza = new VegetarianPizza();
	        }
			orderIDcounter ++;
			pizza.setPizzaOrderID(orderIDcounter);
			return pizza;
	 }
	
}
