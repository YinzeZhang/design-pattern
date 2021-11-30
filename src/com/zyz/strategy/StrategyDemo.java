package com.zyz.strategy;

import com.zyz.strategy.duck.Duck;
import com.zyz.strategy.duck.RubberDuck;
import com.zyz.strategy.fly.FlyBehavior;
import com.zyz.strategy.fly.FlyNoWay;

public class StrategyDemo {

    public static void main(String[] args) {

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.setFlyBehavior(new FlyNoWay());
        rubberDuck.performFly();
    }
}
