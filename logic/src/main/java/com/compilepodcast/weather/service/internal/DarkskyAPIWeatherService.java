package com.compilepodcast.weather.service.internal;

import com.compilepodcast.weather.service.WeatherService;
import com.compilepodcast.weather.service.exception.WeatherException;
import com.compilepodcast.weather.service.model.WeatherResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DarkskyAPIWeatherService implements WeatherService {
    //Sign up in https://darksky.net and give your own API_KEY
    private static final String API_KEY = "e5858ea93887d8943a6e1ce7af5b82b5";

    @Override
    public WeatherResponse howIsWeather(double latitude, double longitude) throws WeatherException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        String.format("https://api.darksky.net/forecast/%s/%f,%f?exclude=hourly,daily&units=auto",API_KEY ,latitude,longitude)))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
           throw new WeatherException(e);
        }
        String responseString = response.body();
        System.out.println(responseString);
        return new Gson().fromJson(responseString, WeatherResponse.class);
    }
}
