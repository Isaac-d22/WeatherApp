package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class AppController {
	private HashMap<Page, Node> pageNodes = new HashMap<>();
	private HashMap<Page, IPageController> pageControllers = new HashMap<>();
	public ArrayList<String> locations;

	@FXML
	private AnchorPane background;
	@FXML
	private AnchorPane page;

	@FXML
	private void initialize() throws IOException {
		locations = new ArrayList<String>();
		for (Page page: new Page[] {Page.Home, Page.Settings, Page.RoutePlanning, Page.MoreInfo, Page.ViewRoute, Page.OtherLocations}) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(page.fxml));
			AnchorPane pagePane = loader.load();
			IPageController pageController = loader.getController();
			pageController.setApp(this);
			pageNodes.put(page, pagePane);
			pageControllers.put(page, pageController);
		}

		setBackground(background);

		background.getChildren().remove(0);
		background.getChildren().add(pageNodes.get(Page.Home));
	}

	public void openPage(Page page) {
		if(page.equals(Page.Home) || page.equals(Page.MoreInfo)){
			IPageController pageController = pageControllers.get(page);
			pageController.update();
		}
		background.getChildren().remove(0);
		background.getChildren().add(pageNodes.getOrDefault(page, pageNodes.get(Page.Home)));
	}

	public static void setBackground(Pane page) {
		LocalTime start = LocalTime.parse("09:00:00");
		LocalTime stop = LocalTime.parse("21:00:00");
		LocalTime current = LocalTime.now();
		page.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));

	}
}