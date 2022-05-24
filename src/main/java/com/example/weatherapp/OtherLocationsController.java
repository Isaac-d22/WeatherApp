package com.example.weatherapp;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Map;


public class OtherLocationsController implements IPageController {
    private AppController app;
    private ArrayList<Geolocation> locations = new ArrayList<>();

    @FXML
    private AnchorPane background;
    @FXML
    private Label currentTemperature;
    @FXML
    private TextField addedLocation;
    @FXML
    private AnchorPane locationsPane;
    @FXML
    private Label errorLocation;

    @FXML
    private void initialize() {
        AppController.setBackground(background);
        locationsPane.setPrefHeight(0);
    }

    @FXML
    protected void openHome() {
        app.openPage(Page.Home);
    }

    @FXML
    protected void addLocation() {
        String input = addedLocation.getText();
        if (!input.matches("[a-zA-Z0-9' ,]+") || input.isBlank()){
            errorLocation.setText("Please enter a valid location!");
            return;
        } else {
            errorLocation.setText("");
        }
        Geolocation apiCall = ApiCaller.getGeocode(input);
        if (apiCall == null) {
            errorLocation.setText("Please enter a valid location!");
            return;
        } else {
            errorLocation.setText("");
        }
        addedLocation.setText("");
        locations.add(apiCall);
        updateLocationsPane();
    }

    private void removeItem(int i) {
        locations.remove(i);
        updateLocationsPane();
    }

    private void updateLocationsPane() {
        locationsPane.getChildren().clear();
        double offset = 0;
        int item = 0;
        for (Geolocation gl : locations) {
            WeatherApiResponse weather = ApiCaller.getWeather(gl);

            Label location = new Label();
            location.setText(gl.city + ", " + gl.state);
            location.setFont(Font.font("Lato Light", 24));
            location.setTextFill(Paint.valueOf("white"));
            location.layoutXProperty().set(40);
            location.layoutYProperty().set(offset);
            locationsPane.getChildren().add(location);

            Label temperature = new Label();
            temperature.setText(ApiCaller.kelvinToCelcius(weather.current.temp));
            temperature.setFont(Font.font("Work Sans Thin", 48));
            temperature.setAlignment(Pos.CENTER_RIGHT);
            temperature.setPrefWidth(370);
            temperature.setTextFill(Paint.valueOf("white"));
            temperature.layoutXProperty().set(40);
            temperature.layoutYProperty().set(offset + 48);
            locationsPane.getChildren().add(temperature);

            Button remove = new Button();
            remove.setText("-");
            int finalItem = item;
            remove.setOnMouseClicked(e -> this.removeItem(finalItem));
            remove.layoutXProperty().set(40);
            remove.layoutYProperty().set(offset + 64);
            locationsPane.getChildren().add(remove);

            ImageView weatherImage = new ImageView();
            WeatherIcon weatherIcon = WeatherIcon.decode(weather.current.weather.get(0).icon);
            weatherImage.setImage(new Image(getClass().getResource("/images/" + weatherIcon.image).toString()));
            weatherImage.layoutXProperty().set(80);
            weatherImage.layoutYProperty().set(offset + 64);
            weatherImage.setPreserveRatio(true);
            weatherImage.setFitHeight(32);
            weatherImage.setFitWidth(32);
            locationsPane.getChildren().add(weatherImage);

            offset += 128;
            ++item;
        }
        locationsPane.setPrefHeight(offset);
    }

    @Override
    public void setApp(AppController app) {
        this.app = app;
    }
}