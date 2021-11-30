package com.zyz.state.state;

import com.zyz.state.GamballMachine;

public class SoldState implements State{

    GamballMachine gamballMachine;

    public SoldState(GamballMachine gamballMachine){
        this.gamballMachine = gamballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense(){
        gamballMachine.releaseBall();
        if(gamballMachine.getCount() > 0){
            gamballMachine.setState(gamballMachine.getNoQuarterState());
        }else{
            System.out.println("Oops, out of gamballs");
            gamballMachine.setState(gamballMachine.getSoldOutState());
        }

    }
}
