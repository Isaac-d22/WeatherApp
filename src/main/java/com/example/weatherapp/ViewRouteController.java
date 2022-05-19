package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import java.time.LocalTime;

public class ViewRouteController implements IPageController{
    private AppController app;
    @FXML
    private AnchorPane background;

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
}