package com.compilepodcast.weather.service.model;

public class WeatherResponseCurrently {
    private String summary;
    private Float temperature;
    private String icon;


    public Float getTemperature() {
        return temperature;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }
}
