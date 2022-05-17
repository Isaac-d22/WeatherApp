package com.example.weatherapp.OWM;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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
        System.out.println(json.main.get("feels_like")); //Seems to be a rounding error
        //JsonObject json = gson.fromJson(response.string(), JsonObject.class);
        System.out.println(json.sys.get("sunrise"));
    }
}

//{"coord":{"lon":139,"lat":35},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}]
// ,"base":"stations","main":{"temp":286.1,"feels_like":285.96,"temp_min":286.1,"temp_max":286.1,
// "pressure":1016,"humidity":96},"visibility":10000,"wind":{"speed":0.32,"deg":320,"gust":0.7},
// "rain":{"1h":0.11},"clouds":{"all":100},"dt":1652783611,
// "sys":{"type":2,"id":2019346,"country":"JP","sunrise":1652729970,"sunset":1652780488},
// "timezone":32400,"id":1851632,"name":"Shuzenji","cod":200}
