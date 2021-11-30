package com.zyz.strategy.duck;

import com.zyz.strategy.fly.FlyWithWings;
import com.zyz.strategy.quack.MuteQuack;

public class RubberDuck extends Duck{

    public RubberDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I am a Rubber Duck!");
    }
}
