package com.example.weatherapp;

import java.util.HashMap;
import java.util.List;

public class WeatherApiResponse {
    double lat;
    double lon;
    String timezone;
    double timezone_offset;
    Current current;
    List<Hourly> hourly;
}

class Weather {
    double id;
    String main;
    String description;
    String icon;
}

class Current{
    String dt;
    String sunrise;
    String sunset;
    String temp;
    String feels_like;
    String pressure;
    String humidity;
    String dew_point;
    String uvi;
    String clouds;
    String visibility;
    String wind_speed;
    String wind_deg;
    String wind_gust;
    List<Weather> weather;
}

class Hourly{
    String dt;
    String temp;
    String feels_like;
    String pressure;
    String humidity;
    String dew_point;
    String uvi;
    String clouds;
    String visibility;
    String wind_speed;
    String wind_deg;
    String wind_gust;
    List<Weather> weather;
    String pop;
}

