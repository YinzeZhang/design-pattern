package com.zyz.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsConditions()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void brew();
    abstract void addCondiments();
    boolean customerWantsConditions() {
        return true;
    }
}

class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}

class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and Milk");
    }

    @Override
    boolean customerWantsConditions() {
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }
    private String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk and sugar with you coffee (y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
    }
}
