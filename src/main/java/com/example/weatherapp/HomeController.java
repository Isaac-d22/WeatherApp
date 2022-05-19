package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.time.LocalTime;

public class HomeController implements IPageController {
	private AppController app;
	@FXML
	private AnchorPane page;
	@FXML
	private Label currentTemperature;
	@FXML
	private Label currentTemp;
	@FXML
	private Label location1;
	@FXML
	private Label windspeed;

	@FXML
	private Label chanceOfRain;

	@FXML
	private void initialize() {
		WeatherApiResponse info = ApiCaller.getStatsAtStreetName("aan%27t%20verlaat%2033f%20");
		LocalTime start = LocalTime.parse("09:00:00");
		LocalTime stop = LocalTime.parse("21:00:00");
		LocalTime current = LocalTime.now();
		page.setStyle("-fx-background-color: #" + ((current.isAfter(start) && current.isBefore(stop))? "3e91cd" : "0b1924"));
		location1.setText(info.name);
		System.out.println(info.main.get("temp"));
		currentTemp.setText(info.main.get("temp").toString());
		windspeed.setText(info.wind.get("speed").toString());
	}


	@FXML
	protected void onButtonClick() {
		currentTemperature.setText("-2°");
	}

	@FXML
	protected void openSettings() {
		app.openPage(Page.Settings);
	}

	@FXML
	protected void openRoutePlanning() {
		app.openPage(Page.RoutePlanning);
	}

	@FXML
	protected void openMoreInfo() {
		app.openPage(Page.MoreInfo);
	}

	@FXML
	protected void openOtherLocations() {
		app.openPage(Page.OtherLocations);
	}


	@Override
	public void setApp(AppController app) {
		this.app = app;
	}
}