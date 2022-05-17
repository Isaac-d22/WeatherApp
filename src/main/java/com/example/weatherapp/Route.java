package com.example.weatherapp;

import java.util.ArrayList;
import java.util.List;

public class Route {
    List<Location> locations;

    Route(String[] addresses) {
        locations = new ArrayList<>();

        for(String address : addresses) {
            locations.add(new Location(address));
        }
    }

    void addLocation(String address) {
        this.locations.add(new Location(address));
    }

    void removeLocation(int id) {
        locations.remove(id);
    }

    void refreshRouteWeather() {
        for(Location location : locations) {
            location.refreshWeather();
        }
    }
}
