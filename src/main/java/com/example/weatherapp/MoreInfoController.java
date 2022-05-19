package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalTime;

public class MoreInfoController implements IPageController{
    private AppController app;
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane page;
    @FXML
    private ListView lv;

    @FXML
    private void initialize() {
        WeatherApiResponse info = ApiCaller.getStatsAtStreetName("aan%27t%20verlaat%2033f%20");
        LocalTime start = LocalTime.parse("09:00:00");
        LocalTime stop = LocalTime.parse("21:00:00");
        LocalTime current = LocalTime.now();
        background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
        lv.getItems().add("Temperature: " + info.main.get("temp"));
        lv.getItems().add("Wind: " + info.wind.get("speed"));
        //currentTemperature.setText("Temperature: " + info.main.get("temp"));
        //currentWind.setText("Rain: " + info.wind.get("speed"));
        //v = new VBox(currentTemperature, currentWind);
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
