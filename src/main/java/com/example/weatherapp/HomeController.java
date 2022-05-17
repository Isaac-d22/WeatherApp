package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;

public class HomeController {
	@FXML
	private AnchorPane page;
	@FXML
	private Label currentTemperature;

	@FXML
	protected void onButtonClick() {
		currentTemperature.setText("-2°");
	}
}