package com.zyz.decorator.decoration;


import com.zyz.decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
