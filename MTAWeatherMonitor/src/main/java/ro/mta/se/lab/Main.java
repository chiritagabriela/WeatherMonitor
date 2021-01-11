package ro.mta.se.lab;

import javafx.application.Application;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.MainController;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.utility.RetriveInfo;
import ro.mta.se.lab.utility.implementation.RetriveInfoImpl;

import java.io.IOException;

public class Main extends Application {

    private RetriveInfo retriveInfo = new RetriveInfoImpl();
    private ObservableList<CityModel> cities = retriveInfo.getCities();

    public static void main(String[] args)
    {
        launch(args);

    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();

        try {

            loader.setLocation(this.getClass().getResource("/view/MainView.fxml"));
            loader.setControllerFactory(c -> new MainController(cities));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.setTitle("MTAWeatherMonitor");
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.setOpacity(0.9);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
