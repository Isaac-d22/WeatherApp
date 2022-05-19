package com.example.weatherapp;

public enum WeatherIcon {
	PartCloudy("sun-cloud.png"),
	Cloudy("cloud.png"),
	Rainy("shower.png"),
	Disastrous("apocalypse.png");
	public final String image;
	private WeatherIcon(String image) {
		this.image = image;
	}
	public static WeatherIcon decode(String code) {
		switch(code) {
			case "01d":
			case "01n":
			case "02d":
			case "02n":
				return PartCloudy;
			case "03d":
			case "03n":
			case "04d":
			case "04n":
				return Cloudy;
			case "09d":
			case "09n":
			case "10d":
			case "10n":
			case "11d":
			case "11n":
			case "13d":
			case "13n":
				return Rainy;
			case "50d":
			case "50n":
				return Disastrous;
			default:
				System.out.println("WARNING: unexpected weather icon code found, defaulting!");
				return Disastrous;
		}
	}
}
