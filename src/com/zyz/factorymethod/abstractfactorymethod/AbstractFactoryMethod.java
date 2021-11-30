package com.zyz.factorymethod.abstractfactorymethod;

abstract class Pizza {

    String name;
    Cheese cheese;

    abstract void prepare();
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    };
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    };
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CheesePizza extends Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;
    CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        cheese = pizzaIngredientFactory.createCheese();
    }
}

class Cheese {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ReggianoCheese extends Cheese {

}

interface PizzaIngredientFactory {
    Cheese createCheese();
}

class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
}

abstract class PizzaStore {

    abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza = null;
        pizza = createPizza(type);
        pizza.setName("hello");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if (type == "cheese") {
            pizza = new CheesePizza(pizzaIngredientFactory);
        }
        return pizza;
    }
}

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }
}
