package com.zyz.decorator.beverage;

public class HouseBlend extends Beverage{

    public String getDescription() {
        return "House Blend";
    }

    @Override
    public double cost() {
        return 9.9;
    }
}
