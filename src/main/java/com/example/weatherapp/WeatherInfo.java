package com.example.weatherapp;

import javafx.beans.property.SimpleStringProperty;

public class WeatherInfo {
    private SimpleStringProperty placeName;
    private SimpleStringProperty temperature;
    private SimpleStringProperty rainChance;
    private SimpleStringProperty windSpeed;

    public WeatherInfo(String placeName, String temperature, String rainChance, String windSpeed) {
        this.placeName = new SimpleStringProperty(placeName);
        this.temperature = new SimpleStringProperty(temperature);
        this.rainChance = new SimpleStringProperty(rainChance);
        this.windSpeed = new SimpleStringProperty(windSpeed);
    }

    public String getLocation1() {
        return placeName.get();
    }

    public String getTemperature() {
        return temperature.get();
    }

    public String getRain(){
        return rainChance.get();
    }

    public String getWind() {
        return windSpeed.get();
    }
}