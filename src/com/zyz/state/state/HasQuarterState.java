package com.zyz.state.state;

import com.zyz.state.GamballMachine;

public class HasQuarterState implements State {
    GamballMachine gamballMachine;

    public HasQuarterState(GamballMachine gamballMachine){
        this.gamballMachine = gamballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gamballMachine.setState(gamballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned...");
        gamballMachine.setState(gamballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispense");
    }
}
