package com.zyz.decorator;

import com.zyz.decorator.beverage.Beverage;
import com.zyz.decorator.beverage.DarkRoast;
import com.zyz.decorator.decoration.Mocha;
import com.zyz.decorator.decoration.Whip;

public class DecoratorDemo {

    public static void main(String[] args) {
	    Beverage beverage = new DarkRoast();
	    beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + ": $" + beverage.cost());
    }
}
