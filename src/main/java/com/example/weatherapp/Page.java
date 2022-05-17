package com.example.weatherapp;

public enum Page {
	Home("home.fxml"),
	MoreInfo("MoreInfo.fxml"),
	OtherLocations("OtherLocations.fxml"),
	RoutePlanning("routePlanning.fxml"),
	ViewRoute("viewRoute.fxml"),
	Settings("settings.fxml");

	public final String fxml;

	private Page(String fxml) {
		this.fxml = fxml;
	}
}

