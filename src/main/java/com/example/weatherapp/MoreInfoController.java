package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.VBox;

import java.time.LocalTime;

public class MoreInfoController implements IPageController{
    private AppController app;
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane page;
    @FXML
    private ListView lv;
    @FXML
    private Label name;

    @FXML
    private void initialize() {
        WeatherApiResponse info = ApiCaller.getStatsAtStreetName("aan%27t%20verlaat%2033f%20");
        AppController.setBackground(background);
        lv.getItems().add("Temperature: " + info.current.temp);
        lv.getItems().add("Wind: " + info.current.wind_speed);
    }

    @FXML
    protected void onButtonClick() {
        return;
    }

    @Override
    public void setApp(AppController app) {
            this.app = app;
    }

    @FXML
    protected void returnHome() {
        app.openPage(Page.Home);
    }
}
