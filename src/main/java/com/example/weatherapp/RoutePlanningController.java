package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

public class RoutePlanningController {
    @FXML
    private Pane backgroundPane;
    @FXML
    private Label currentTemperature;

    public void setBackgroundColor(boolean isDay) {
        backgroundPane.setStyle("-fx-background-color: #" + (isDay? "3e91cd" : "0b1924"));
    }

    @FXML
    protected void onButtonClick() {
        currentTemperature.setText("-2°");
    }
}