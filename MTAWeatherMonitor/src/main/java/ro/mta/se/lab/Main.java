package ro.mta.se.lab;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.MainController;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.utility.RetrieveInfo;
import ro.mta.se.lab.utility.implementation.RetrieveInfoImpl;

import java.io.IOException;

/**
 * Class defining the main class of the application.
 * Main class takes care of starting and setting everything up
 * so that the controller,model and view can work together.
 *
 * @author Chirita Gabriela
 */
public class Main extends Application {

    /**
     * Member description
     */
    private RetrieveInfo retrieveInfo = new RetrieveInfoImpl();
    private ObservableList<CityModel> cities = retrieveInfo.getCities();

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
            primaryStage.setOpacity(1);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
