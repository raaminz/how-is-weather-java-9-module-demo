package com.compilepodcast.weather.ui;

import java.io.IOException;
import java.util.Properties;

public final class WeatherContext {

    public static final WeatherContext INSTANCE = new WeatherContext();

    private Properties config;
    private final double latitude ;
    private final double longitude ;
    private final String title;
    private WeatherContext(){
        init();
        latitude= Double.parseDouble( config.getProperty("latitude"));
        longitude = Double.parseDouble(config.getProperty("longitude"));
        title = config.getProperty("title");
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTitle() {
        return title;
    }

    private void init() {
        config = new Properties();
        try {
            config.load(getClass().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            System.err.println("Could not find the file config.properties. it's mandatory");
            System.exit(-1);
        }
    }
}
