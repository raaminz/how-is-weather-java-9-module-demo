package com.compilepodcast.weather.service.internal;

import com.compilepodcast.weather.service.exception.WeatherException;
import com.compilepodcast.weather.service.model.WeatherResponse;
import org.junit.Assert;
import org.junit.Test;

public class DarkskyAPIWeatherServiceTest {

    @Test
    public void howIsWeather() throws WeatherException {
        DarkskyAPIWeatherService service = new DarkskyAPIWeatherService();
        WeatherResponse response = service.howIsWeather(35.715298 , 51.404343);
        Assert.assertEquals(response.getTimezone() , "Asia/Tehran" );
        Assert.assertNotNull(response.getCurrently() );
        Assert.assertNotNull(response.getCurrently().getSummary() );
        Assert.assertNotNull(response.getCurrently().getTemperature() );
    }
}