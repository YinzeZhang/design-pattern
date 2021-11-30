package com.zyz.factorymethod.simplefactorymethod;

abstract class Pizza {
    private String name;

    Pizza(String name) {
        this.name = name;
    }

    void prepare() {

    };
    void bake() {

    };
    void cut() {

    };
    void box() {

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CheesePizza extends Pizza {

    CheesePizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("prepare cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("bake cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("cut cheese pizza");
    }

    @Override
    public void box() {
        System.out.println("box cheese pizza");
    }
}

class ClamPizza extends Pizza {

    ClamPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("prepare clam pizza");
    }

    @Override
    public void bake() {
        System.out.println("bake clam pizza");
    }

    @Override
    public void cut() {
        System.out.println("cut clam pizza");
    }

    @Override
    public void box() {
        System.out.println("box clam pizza");
    }
}

class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type == "cheese") {
            pizza = new CheesePizza("cheese pizza");
        } else if (type == "clam") {
            pizza = new ClamPizza("clam pizza");
        }
        return pizza;
    }
}


class PizzaStore {
    SimplePizzaFactory simplePizzaFactory;

    PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

public class SimpleFactoryMethodDemo {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }
}
