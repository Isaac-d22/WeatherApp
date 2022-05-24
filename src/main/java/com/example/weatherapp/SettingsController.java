package com.example.weatherapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import java.time.LocalTime;

import java.time.LocalTime;

public class SettingsController implements IPageController {
    private AppController app;
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane page;
    @FXML
    private Label currentTemperature;

    @FXML
    private ChoiceBox weatherUnits;

    @FXML
    private ChoiceBox windSpeed;

    @FXML
    private ChoiceBox distance;

    @FXML
    private void initialize() {
        AppController.setBackground(background);
        String[] units = {"Metric", "Imperial"};
        weatherUnits.setItems(FXCollections.observableArrayList(units));
        windSpeed.getItems().addAll("km/h", "mph");
        distance.getItems().addAll("kilometers", "miles");

        weatherUnits.setValue("Metric");
        windSpeed.setValue("km/h");
        distance.setValue("kilometers");

        weatherUnits.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {

                // set the text for the label to the selected item
                ApiCaller.setUnits(units[(int) new_value]);
            }
        });
    }

    @FXML
    protected void onButtonClick() {
        currentTemperature.setText("-2°");
    }

    @FXML
    protected void input(){

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