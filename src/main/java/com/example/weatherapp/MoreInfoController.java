package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.time.LocalTime;

public class MoreInfoController {
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane page;
    @FXML
    private Label currentTemperature;
    @FXML
    private Label currentWind;
    @FXML
    private VBox v;


    @FXML
    private void initialize() {
        //ApiResponse info = ApiCaller.getStats();
        LocalTime start = LocalTime.parse("09:00:00");
        LocalTime stop = LocalTime.parse("21:00:00");
        LocalTime current = LocalTime.now();
        background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
        //currentTemperature.setText("Temperature: " + info.main.get("temp"));
        //currentWind.setText("Rain: " + info.wind.get("speed"));
        //v = new VBox(currentTemperature, currentWind);
    }

    @FXML
    protected void onButtonClick() {
        currentTemperature.setText("-2°");
    }
}
