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

    public static WeatherApiResponse getStats(String location){
        try{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            Request geocodeRequest = new Request.Builder()
                    .url(String.format(
                            "https://api.myptv.com/geocoding/v1/locations/by-text?searchText=%s&apiKey=%s", location, geocodeKey)).build();

            ResponseBody geocodeResponse = client.newCall(geocodeRequest).execute().body();

            Gson geocodeGson = new Gson();
            GeocodeApiResponse geocode = geocodeGson.fromJson(geocodeResponse.string(), GeocodeApiResponse.class);
            Map coords = (Map<String, Double>)geocode.locations.get(0).get("referencePosition");
            double latitudeDouble = (double)coords.get("latitude");
            double longitudeDouble = (double)coords.get("longitude");
            String lat = String.valueOf(latitudeDouble);
            String lon = String.valueOf(longitudeDouble);

            Request weatherRequest = new Request.Builder()
                    .url(String.format(
                            "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s", lat, lon, weatherKey)).build();

            ResponseBody weatherResponse = client.newCall(weatherRequest).execute().body();
            Gson weatherGson = new Gson();
            return weatherGson.fromJson(weatherResponse.string(), WeatherApiResponse.class);
        } catch (IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
