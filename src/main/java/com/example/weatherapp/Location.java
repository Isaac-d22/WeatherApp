package com.example.weatherapp;

import java.time.LocalTime;

public class Location {
    String address;
    double latitude;
    double longitude;
    LocalTime time;

    Location(String address) {
        this.address = address;
    }

    void refreshWeather() {

    }
}
