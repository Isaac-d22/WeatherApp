package com.example.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalTime;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private Controller appController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        Parent root = fxmlLoader.load();
        appController = fxmlLoader.getController();
        Scene scene = new Scene(root, 450, 800);
        stage.setTitle("Hello!");
        stage.centerOnScreen();
        stage.setScene(scene);
        this.setBackground();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setBackground(){
        LocalTime start = LocalTime.parse("09:00:00");
        LocalTime stop = LocalTime.parse("21:00:00");
        LocalTime current = LocalTime.now();
        appController.setBackgroundColor(current.isAfter(start) && current.isBefore(stop));
    }
}