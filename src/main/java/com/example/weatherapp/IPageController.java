package com.example.weatherapp;

public interface IPageController {
	void setApp(AppController app);

	default void update(){
	}
}
