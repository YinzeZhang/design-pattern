package com.zyz.observer;

public class DecoratorDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(10, 50,40);
        weatherData.setMeasurements(20,60,50);
    }
}
