package com.compilepodcast.weather.ui;

import com.compilepodcast.weather.service.WeatherService;
import com.compilepodcast.weather.service.exception.WeatherException;
import com.compilepodcast.weather.service.model.WeatherResponse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.ServiceLoader;

public class WeatherController implements Initializable {
    @FXML
    private Text timeZone ;
    @FXML
    private Text summary;
    @FXML
    private Text temperature;
    @FXML
    private Text day;
    @FXML
    private Text date;
    @FXML
    private ImageView icon;
    @FXML
    private ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image imageLogo = new Image(getClass().getResourceAsStream("logo/compilepodcast_logo.png"), 200d, 100d, true, true);
        logo.setImage(imageLogo);
        WeatherResponse response ;

        day.setText(new SimpleDateFormat("EEEE").format(new Date()));
        date.setText(new SimpleDateFormat("dd/MM/yy (h.a)").format(new Date()).toLowerCase());
        try {
            response = getWeatherService().howIsWeather(WeatherContext.INSTANCE.getLatitude(), WeatherContext.INSTANCE.getLongitude());
            timeZone.setText(response.getTimezone());
            summary.setText(response.getCurrently().getSummary());

            String degree = Integer.toString(Math.round(response.getCurrently().getTemperature()));
            this.temperature.setText(degree + "  °C");

            Image img = new Image(getClass().getResourceAsStream("icons/" + response.getCurrently().getIcon() + ".png"));
            icon.setImage(img);
        } catch (WeatherException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "There is a problem while checking weather. ["+e.getMessage()+"]");
            alert.show();
        }
    }

    private WeatherService getWeatherService(){
        ServiceLoader<WeatherService> services = ServiceLoader.load(WeatherService.class);
        return services.findFirst().orElseThrow(IllegalStateException::new);
    }
}
