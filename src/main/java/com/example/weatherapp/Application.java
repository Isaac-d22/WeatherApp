package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private AppController appController;

    @FXML
    private Label location;

    @FXML
    private Label windSpeed;

    @FXML
    private Label chanceOfRain;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent root = fxmlLoader.load();
        appController = fxmlLoader.getController();
        Scene scene = new Scene(root, 450, 800);
        stage.setTitle("Hello!");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}