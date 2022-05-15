package com.example.weatherapp.OWM;

import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public class ApiCaller {

    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println("hello");
        getStats();
    }

    public static void getStats() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=afcc86076e8c2f5fb1627987be38d419").build();
        ResponseBody response = client.newCall(request).execute().body();
        //System.out.println(response.string());
        Gson gson = new Gson();
        ApiResponse json = gson.fromJson(response.string(), ApiResponse.class);
        System.out.println(json.base); //Seems to be a rounding error
    }
}

//{"coord":{"lon":139,"lat":35},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],
// "base":"stations","main":{"temp":286.66,"feels_like":286.57,"temp_min":286.66,"temp_max":286.66,"pressure":1010,
// "humidity":96},"visibility":6676,"wind":{"speed":1.95,"deg":45,"gust":2.72},"rain":{"1h":0.56},"clouds":{"all":100},
// "dt":1652647599,"sys":{"type":2,"id":2019346,"country":"JP","sunrise":1652643613,"sunset":1652694041},
// "timezone":32400,"id":1851632,"name":"Shuzenji","cod":200}