package com.example.weatherapp.OWM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApiResponse {

    HashMap<String, Double> coord;
    List<Weather> weather;
    public String base;
    HashMap<String, Double> main;
    double visibility;
    HashMap<String, Double> wind;
    HashMap<String, Double> clouds;
    double dt;
    HashMap<String, Object> sys;
    double timezone;
    double id;
    String name;
    double cod;

}

class Weather {
    double id;
    String main;
    String description;
    String icon;
}
