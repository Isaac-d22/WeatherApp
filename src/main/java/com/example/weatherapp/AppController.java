package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;

public class AppController {
	private HashMap<Page, Node> pageNodes = new HashMap<>();

	@FXML
	private AnchorPane background;
	@FXML
	private AnchorPane page;
	@FXML
	private void initialize() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Page.Home.fxml));
		AnchorPane pagePane = loader.load();
		pageNodes.put(Page.Home, pagePane);

		LocalTime start = LocalTime.parse("09:00:00");
		LocalTime stop = LocalTime.parse("21:00:00");
		LocalTime current = LocalTime.now();
		background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));

		background.getChildren().remove(0);
		background.getChildren().add(pageNodes.get(Page.Home));
	}
}