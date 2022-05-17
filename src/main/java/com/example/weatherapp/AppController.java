package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import java.time.LocalTime;

import java.time.LocalTime;

public class AppController {
	@FXML
	private AnchorPane background;
	@FXML
	private AnchorPane page;
	@FXML
	private Label currentTemperature;

	@FXML
	private void initialize() {
		LocalTime start = LocalTime.parse("09:00:00");
		LocalTime stop = LocalTime.parse("21:00:00");
		LocalTime current = LocalTime.now();
		background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
	}

	@FXML
	protected void onButtonClick() {
		currentTemperature.setText("-2°");
	}
}