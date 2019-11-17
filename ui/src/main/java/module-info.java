module com.compilepodcast.weather.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.compilepodcast.weather.logic;
    uses com.compilepodcast.weather.service.WeatherService;

    opens com.compilepodcast.weather.ui to javafx.fxml;

    exports com.compilepodcast.weather.ui;

}

