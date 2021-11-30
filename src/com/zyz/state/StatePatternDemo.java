package com.zyz.state;

public class StatePatternDemo {

    public static void main(String[] args) {

	    GamballMachine gamballMachine = new GamballMachine(5);
        System.out.println(gamballMachine);

        gamballMachine.insertQuarter();
        gamballMachine.turnCrank();

        gamballMachine.insertQuarter();
        gamballMachine.turnCrank();
        gamballMachine.turnCrank();
    }
}
