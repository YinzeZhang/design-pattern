package com.zyz.decorator.beverage;

public class Espresso extends Beverage{

    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 7.3;
    }
}
