package com.example.weatherapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
        loadButton.setText("Loading...");
        ArrayList<WeatherInfo> weatherInfo;
        for (String location : app.locations) {
            String placeName = location;
            location = location.replaceAll(" ", "%20");
            location = location.replaceAll("'", "%27");
            location = location.replaceAll(",", "%2C");
            WeatherApiResponse weatherAtLocation = ApiCaller.getStatsAtStreetName(location);
            String temp = weatherAtLocation.current.temp;
            String rainChance = "";
            String windSpeed = weatherAtLocation.current.wind_speed;
            WeatherInfo info = new WeatherInfo(placeName, temp, rainChance, windSpeed);
            data.add(info);
        }
        this.table.setItems(data);
        loadButton.setText("Update results");
    }
}