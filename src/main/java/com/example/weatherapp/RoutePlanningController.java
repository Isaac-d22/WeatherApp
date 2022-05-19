package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.time.LocalTime;
import java.util.ArrayList;

public class RoutePlanningController implements IPageController {

    private AppController app;
    @FXML
    private Pane background;
    @FXML
    private TextField inputLocation;
    @FXML
    private ListView locationsList;
    @FXML
    private Label errorLocation;

    @FXML
    private void initialize() {
        LocalTime start = LocalTime.parse("09:00:00");
        LocalTime stop = LocalTime.parse("21:00:00");
        LocalTime current = LocalTime.now();
        background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
    }

    @FXML
    protected void openHome() {
        app.openPage(Page.Home);
    }

    @FXML
    protected void openViewRoute() {
        app.openPage(Page.ViewRoute);
    }

    @Override
    public void setApp(AppController app) {
        this.app = app;
    }

    public void addLocation(MouseEvent mouseEvent) {
        String input = inputLocation.getText();
        // Santise input
        if (!input.matches("[a-zA-Z0-9' ,]+") || input.isBlank()){
            errorLocation.setText("Please enter a valid location!");
            return;
        } else {
            errorLocation.setText("");
        }
        locationsList.getItems().add(input);
        inputLocation.setText("");
        input = input.replaceAll(" ", "%20");
        input = input.replaceAll("'", "%27");
        input = input.replaceAll(",", "%2C");
        app.locations.add(input);
    }

    public void clearLocations() {
        locationsList.getItems().clear();
        app.locations.clear();
    }
}