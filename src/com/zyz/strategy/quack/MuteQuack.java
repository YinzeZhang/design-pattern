package com.zyz.strategy.quack;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("MuteQuack");
    }
}
