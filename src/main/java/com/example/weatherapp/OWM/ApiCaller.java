package com.example.weatherapp.OWM;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiCaller {

    public static void main(String[] args) {
        // write your code here
        System.out.println("hello");
        try{
            getStats();
        }catch(Exception e){
            System.out.println("Oh NO");
        }
    }

    public static void getStats() throws Exception {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=afcc86076e8c2f5fb1627987be38d419").build();
        Response response = client.newCall(request).execute();
        if(response.body() != null){
        }
    }
}
