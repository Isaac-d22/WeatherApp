package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

public class ViewRouteController implements IPageController{
    private AppController app;
    @FXML
    private Pane backgroundPane;
    @FXML
    private Label currentTemperature;

    @FXML
    protected void openRoutePlanning() {
        app.openPage(Page.RoutePlanning);
    }


    @FXML
    protected void onHome() {
        currentTemperature.setText("-2°");
    }

    @Override
    public void setApp(AppController app) {
        this.app = app;
    }
}