package com.zyz.decorator.beverage;

public class DarkRoast extends Beverage{

    public String getDescription() {
        return "DarkRoast";
    }

    @Override
    public double cost() {
        return 4.7;
    }
}
