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

	@Override
	public void setApp(AppController app) {
		this.app = app;
	}
}