package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import java.time.LocalTime;
import java.util.ArrayList;

public class ViewRouteController implements IPageController{
    private AppController app;
    @FXML
    private AnchorPane background;
    @FXML
    private TableView locationTable;
    @FXML
    private Button loadResults;

    @FXML
    private void initialize() {
        LocalTime start = LocalTime.parse("09:00:00");
        LocalTime stop = LocalTime.parse("21:00:00");
        LocalTime current = LocalTime.now();
        background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
    }


    @FXML
    protected void openRoutePlanning() {
        app.openPage(Page.RoutePlanning);
    }

    @Override
    public void setApp(AppController app) {
        this.app = app;
    }

    public void loadRoute(MouseEvent mouseEvent) {
        ArrayList<WeatherInfo> weatherInfo;
        for (String location : app.locations) {
            WeatherInfo info = new WeatherInfo();
            info.placeName = location;
            location = location.replaceAll(" ", "%20");
            location = location.replaceAll("'", "%27");
            location = location.replaceAll(",", "%2C");
            WeatherApiResponse weatherAtLocation = ApiCaller.getStatsAtStreetName(location);
            //info.temperature = weatherAtLocation.temperature;
            //info.rainChance = weatherAtLocation.rainChance;
            //info.windSpeed = weatherAtLocation.windSpeed;
        }
    }
}

class WeatherInfo {
    String placeName;
    String temperature;
    String rainChance;
    String windSpeed;
}