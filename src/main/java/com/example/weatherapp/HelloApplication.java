package com.example.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.time.LocalTime;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 365, 650);
        stage.setTitle("Hello!");
        stage.centerOnScreen();
        setBackground(scene);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setBackground (Scene scene){
        LocalTime start = LocalTime.parse( "09:00:00" );
        LocalTime stop = LocalTime.parse( "21:00:00" );
        LocalTime current = LocalTime.now();

        if (current.isAfter(start) && current.isBefore(stop)){
            System.out.println("Working");
            scene.setFill(Color.web("#010128"));
        }

        scene.setFill(Color.web("#77C7EC"));
    }
}