module com.compilepodcast.weather.logic {

    requires java.net.http;
    requires com.google.gson;

    exports com.compilepodcast.weather.service;
    exports com.compilepodcast.weather.service.model;
    exports com.compilepodcast.weather.service.exception;

    opens com.compilepodcast.weather.service.model to com.google.gson;
    provides com.compilepodcast.weather.service.WeatherService with com.compilepodcast.weather.service.internal.DarkskyAPIWeatherService;

}