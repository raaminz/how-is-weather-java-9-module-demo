package com.compilepodcast.weather.service;

import com.compilepodcast.weather.service.exception.WeatherException;
import com.compilepodcast.weather.service.model.WeatherResponse;

public interface WeatherService {
    WeatherResponse howIsWeather(double latitude, double longitude) throws WeatherException;
}
