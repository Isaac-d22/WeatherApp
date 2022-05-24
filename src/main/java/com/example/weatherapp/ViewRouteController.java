package com.example.weatherapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.time.LocalTime;

public class ViewRouteController implements IPageController{
    private AppController app;
    @FXML
    private AnchorPane background;

    @FXML
    private Button loadResults;

    @FXML
    private TableView<WeatherInfo> table;

    @FXML
    private TableColumn<WeatherInfo, String> location1;

    @FXML
    private TableColumn<WeatherInfo, String> temperature;

    @FXML
    private TableColumn<WeatherInfo, String> rain;

    @FXML
    private TableColumn<WeatherInfo, String> wind;

    @FXML
    private Button loadButton;

    @FXML
    private void initialize() {
        LocalTime start = LocalTime.parse("09:00:00");
        LocalTime stop = LocalTime.parse("21:00:00");
        LocalTime current = LocalTime.now();
        background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
        location1.setCellValueFactory(new PropertyValueFactory<>("location1"));
        temperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        rain.setCellValueFactory(new PropertyValueFactory<>("rain"));
        wind.setCellValueFactory(new PropertyValueFactory<>("wind"));
        AppController.setBackground(background);
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
        ObservableList<WeatherInfo> data = FXCollections.observableArrayList();
        for (String location : app.locations) {
            String placeName = location;
            location = location.replaceAll(" ", "%20");
            location = location.replaceAll("'", "%27");
            location = location.replaceAll(",", "%2C");
            WeatherApiResponse weatherAtLocation = ApiCaller.getWeather(ApiCaller.getGeocode(location));
            String temp, rainChance, windSpeed;
            if (weatherAtLocation == null) {
                temp = "N/A";
                rainChance = "N/A";
                windSpeed = "N/A";
            } else {
                temp = weatherAtLocation.current.temp;
                rainChance = String.valueOf(Double.parseDouble(weatherAtLocation.hourly.get(0).pop) * 100);
                windSpeed = weatherAtLocation.current.wind_speed;
            }
            WeatherInfo info = new WeatherInfo(placeName, temp, rainChance, windSpeed);
            data.add(info);
        }
        this.table.setItems(data);
        loadButton.setText("Update results");
    }
}