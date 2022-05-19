package com.example.weatherapp;

public class WeatherInfo {
    private String placeName;
    private String temperature;
    private String rainChance;
    private String windSpeed;

    public WeatherInfo(String placeName, String temperature, String rainChance, String windSpeed) {
        this.placeName = placeName;
        this.temperature = temperature;
        this.rainChance = rainChance;
        this.windSpeed = windSpeed;
    }

    public String getLocation1() {
        return placeName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getRain(){
        return rainChance;
    }

    public String getWind() {
        return windSpeed;
    }
}