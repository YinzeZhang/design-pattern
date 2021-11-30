package com.zyz.factorymethod.factorymethod;


abstract class Pizza {
    private String name;
    Pizza(String name) {
        this.name = name;
    }

    abstract void prepare();

    abstract void bake();

    abstract void cut();

    abstract void box();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class NYStyleCheesePizza extends Pizza {

    NYStyleCheesePizza(String name) {
        super(name);
    }

    @Override
    void prepare() {
        System.out.println("NYStyle cheese pizza prepare");
    }

    @Override
    void bake() {
        System.out.println("NYStyle cheese pizza bake");
    }

    @Override
    void cut() {
        System.out.println("NYStyle cheese pizza cut");
    }

    @Override
    void box() {
        System.out.println("NYStyle cheese pizza box");
    }
}

class ChicagoStyleCheesePizza extends Pizza {

    ChicagoStyleCheesePizza(String name) {
        super(name);
    }

    @Override
    void prepare() {
        System.out.println("Chicago Style cheese pizza prepare");
    }

    @Override
    void bake() {
        System.out.println("Chicago Style cheese pizza bake");
    }

    @Override
    void cut() {
        System.out.println("Chicago Style cheese pizza cut");
    }

    @Override
    void box() {
        System.out.println("Chicago Style cheese pizza box");
    }
}

abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}

class NYStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type == "cheese") {
            pizza = new NYStyleCheesePizza("NY cheese pizza");
        }
        return pizza;
    }
}

class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type == "cheese") {
            pizza = new ChicagoStyleCheesePizza("chicago cheese pizza");
        }
        return pizza;
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new ChicagoStylePizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName());

        pizzaStore = new NYStylePizzaStore();
        pizza = pizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }
}
