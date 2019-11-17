package com.compilepodcast.weather.service.model;

public class WeatherResponse {
    private String timezone;
    private WeatherResponseCurrently currently;

    public WeatherResponse(){
    }

    public WeatherResponse(String timezone, WeatherResponseCurrently currently) {
        this.timezone = timezone;
        this.currently = currently;
    }

    public String getTimezone() {
        return timezone;
    }

    public WeatherResponseCurrently getCurrently() {
        return currently;
    }
}
