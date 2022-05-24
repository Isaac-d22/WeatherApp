package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.time.LocalTime;


public class OtherLocationsController implements IPageController {
    private AppController app;

    @FXML
    private AnchorPane background;
    @FXML
    private Label currentTemperature;

    @FXML
    private void initialize() {
        AppController.setBackground(background);
    }

    @FXML
    protected void openHome() {
        app.openPage(Page.Home);
    }

    @Override
    public void setApp(AppController app) {
        this.app = app;
    }
}