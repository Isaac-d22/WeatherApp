package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.Map;


public class OtherLocationsController implements IPageController {
    private AppController app;

    @FXML
    private AnchorPane background;
    @FXML
    private Label currentTemperature;
    @FXML
    private TextField addedLocation;

    @FXML
    private void initialize() {
        AppController.setBackground(background);
    }

    @FXML
    protected void openHome() {
        app.openPage(Page.Home);
    }

    @FXML
    protected void addLocation() {
        String locationString = addedLocation.getText();
        System.out.println(locationString);
        Geolocation gl = ApiCaller.getGeocode(locationString);
        System.out.println(gl.city + ", " + gl.state);
    }

    @Override
    public void setApp(AppController app) {
        this.app = app;
    }
}