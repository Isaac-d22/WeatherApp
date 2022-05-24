package com.example.weatherapp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

public class ApiCaller {

    private static final String geocodeKey = "ZmMyYjdmMjc1ZTQ2NGM4NjhjYTBkNTg2YTNmYzBhYWE6NTZlNTM1ZWYtMTlkZi00ODUzLWJjMTAtOTdlMmJiYTRlMGE0";
    private static final String weatherKey = "afcc86076e8c2f5fb1627987be38d419";
    private static String weatherUnits = "metric";

    public static String kelvinToCelcius(String temp) {
        return (int)(Double.parseDouble(temp) - 273.15 + 0.5) + "°";
    }

    public static Geolocation getGeocode(String location) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request geocodeRequest = new Request.Builder()
                .url(String.format(
                        "https://api.myptv.com/geocoding/v1/locations/by-text?searchText=%s&apiKey=%s", location, geocodeKey)).build();

        String geocodeResponseString;

        try {
            return new Geolocation(new Gson().fromJson(client.newCall(geocodeRequest).execute().body().string(), GeocodeApiResponse.class));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static WeatherApiResponse getWeather(Geolocation gl) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request weatherRequest = new Request.Builder()
                .url(String.format("https://api.openweathermap.org/data/2.5/onecall?lat=%s&lon=%s&units=%s&exclude=minutely,daily&appid=%s", String.valueOf(gl.latitude), String.valueOf(gl.longitude), weatherUnits, weatherKey)).build();
        try {
            WeatherApiResponse info = new Gson().fromJson(client.newCall(weatherRequest).execute().body().string(), WeatherApiResponse.class);
            info.prettify(weatherUnits.equals("metric"));
            return info;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void setUnits(String unit){
        unit = unit.toLowerCase();
        if(unit.equals("metric") || unit.equals("imperial")){
            weatherUnits = unit;
        }
    }
}
