package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

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
		for (Page page: new Page[] {Page.Home, Page.Settings, Page.RoutePlanning, Page.MoreInfo, Page.ViewRoute}) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(page.fxml));
			AnchorPane pagePane = loader.load();
			IPageController pageController = loader.getController();
			pageController.setApp(this);
			pageNodes.put(page, pagePane);
		}

		LocalTime start = LocalTime.parse("09:00:00");
		LocalTime stop = LocalTime.parse("21:00:00");
		LocalTime current = LocalTime.now();
		background.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));

		background.getChildren().remove(0);
		background.getChildren().add(pageNodes.get(Page.Home));
	}

	public void openPage(Page page) {
		background.getChildren().remove(0);
		background.getChildren().add(pageNodes.getOrDefault(page, pageNodes.get(Page.Home)));
	}
}