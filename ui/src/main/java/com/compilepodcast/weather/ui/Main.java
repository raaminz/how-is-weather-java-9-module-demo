package com.compilepodcast.weather.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(WeatherContext.INSTANCE.getTitle());
        FXMLLoader loader = new FXMLLoader();
        Parent page = loader.load( getClass().getResourceAsStream("WeatherUI.fxml"));
        Scene scene = new Scene(new StackPane(page));

        // load the stylesheet
        String style = getClass().getResource("style/style.css").toExternalForm();
        scene.getStylesheets().addAll(style);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() {
        Font.loadFont(Main.class.getResourceAsStream("style/RiseofKingdom.ttf"),20);
    }
}