package com.zyz.state.state;

import com.zyz.state.GamballMachine;

public class NoQuarterState implements State {
    GamballMachine gamballMachine;

    public NoQuarterState(GamballMachine gamballMachine){
        this.gamballMachine = gamballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you inserted a quarter");
        gamballMachine.setState(gamballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned, but there is no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }
}
