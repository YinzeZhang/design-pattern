package com.zyz.decorator.beverage;

public abstract class Beverage {
    private String description = "UnKnown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
