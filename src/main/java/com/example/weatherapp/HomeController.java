package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private ImageView weatherIcon;

	@FXML
	private Label chanceOfRain;

	@FXML
	private void initialize() {
		WeatherApiResponse info = ApiCaller.getWeather(ApiCaller.getGeocode("Cambridge, England"));
		AppController.setBackground(page);
		currentTemperature.setText(" " + info.current.temp);
		currentTemp.setText(info.current.temp);

		windspeed.setText(info.current.wind_speed);
		chanceOfRain.setText(String.valueOf(Double.parseDouble(info.hourly.get(0).pop) * 100) + "%");
		assert(info.current.weather.size() == 1);
		WeatherIcon icon = WeatherIcon.decode(info.current.weather.get(0).icon);
		weatherIcon.setImage(new Image(getClass().getResource("/images/" + icon.image).toString()));
	}

	@Override
	public void update(){
		WeatherApiResponse info = ApiCaller.getWeather(ApiCaller.getGeocode("Cambridge, England"));
		AppController.setBackground(page);
		currentTemperature.setText(" " + info.current.temp);
		currentTemp.setText(info.current.temp);
		windspeed.setText(info.current.wind_speed);
		chanceOfRain.setText(String.valueOf(Double.parseDouble(info.hourly.get(0).pop) * 100) + "%");
		assert(info.current.weather.size() == 1);
		WeatherIcon icon = WeatherIcon.decode(info.current.weather.get(0).icon);
		weatherIcon.setImage(new Image(getClass().getResource("/images/" + icon.image).toString()));
	}


	@FXML
	protected void onButtonClick() {
		//currentTemperature.setText("-2°");
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