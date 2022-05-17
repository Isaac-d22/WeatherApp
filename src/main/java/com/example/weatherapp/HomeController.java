package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HomeController implements IPageController {
	private AppController app;
	@FXML
	private AnchorPane page;
	@FXML
	private Label currentTemperature;

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