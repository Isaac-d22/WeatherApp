package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class MoreInfoController implements IPageController{
    private AppController app;
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane page;
    @FXML
    private ListView lv;
    @FXML
    private Label name;

    @FXML
    private void initialize() {
        WeatherApiResponse info = ApiCaller.getWeather(ApiCaller.getGeocode("Cambridge, England"));
        AppController.setBackground(background);
        lv.getItems().add("Temperature: " + info.current.temp);
        lv.getItems().add("Wind: " + info.current.wind_speed);
        lv.getItems().add("Pressure: " + info.current.pressure + "Pa");
        lv.getItems().add("Visibility: " + info.current.visibility + "m");
        lv.getItems().add("Cloud cover: " + info.current.clouds + "%");
        lv.getItems().add("UV Index: " + info.current.uvi);
        lv.getItems().add("Wind bearing " + info.current.wind_deg + "º");
        lv.getItems().add("Feels like temp: " + info.current.feels_like);
        lv.getItems().add("Humidity: " + info.current.humidity + "%");
    }

    @FXML
    protected void onButtonClick() {
        return;
    }

    @Override
    public void setApp(AppController app) {
            this.app = app;
    }

    @FXML
    protected void returnHome() {
        app.openPage(Page.Home);
    }
}
