package com.example.weatherapp;

import java.util.Map;

public final class Geolocation {
	public final double latitude;
	public final double longitude;
	public final String state;
	public final String city;

	public Geolocation(GeocodeApiResponse geocode) {
		Map<String, Double> coords = (Map<String, Double>) geocode.locations.get(0).get("referencePosition");
		Map<String, String> address = (Map<String, String>) geocode.locations.get(0).get("address");
		this.latitude = (double)coords.get("latitude");
		this.longitude = (double)coords.get("longitude");
		this.state = address.get("state");
		this.city = address.get("city");
	}
}