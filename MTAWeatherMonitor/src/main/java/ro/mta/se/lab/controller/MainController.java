package ro.mta.se.lab.controller;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.model.WeatherInfoModel;
import ro.mta.se.lab.utility.JSONParser;
import ro.mta.se.lab.utility.RetrieveInfo;
import ro.mta.se.lab.utility.implementation.JSONParserImpl;
import ro.mta.se.lab.utility.RetrieveInfo;
import ro.mta.se.lab.utility.implementation.RetrieveInfoImpl;

import java.util.ArrayList;
import java.util.List;
/**
 * Class defining main controller
 * Main controller is the controller that takes the CityModel and maps
 * it to its view, MainView.
 *
 * @author Chirita Gabriela
 */

public class MainController {

    /**
     * Member description
     */
    final private ObservableList<CityModel> cities;
    RetrieveInfo retrieveInfo = new RetrieveInfoImpl();
    JSONParser jsonParser = new JSONParserImpl();

    @FXML
    private ComboBox<String> countryComboBox;
    @FXML
    private ComboBox<String> cityComboBox;
    @FXML
    private Label cityName;
    @FXML
    private Label currentTime;
    @FXML
    private Label weatherDesc;
    @FXML
    private Label degrees;
    @FXML
    private Label humidityValue;
    @FXML
    private Label windValue;
    @FXML
    private Label icon;

    /**
     * MainController class constructor
     * @param cities represents the list of cities available in the application.
     */
    public MainController(ObservableList<CityModel> cities) {
        this.cities = cities;
    }

    /**
     * Method countryExists
     * @param country indicates the country that needs to be searched.
     * @param position indicates the last index that needs to be checked in searching the country.
     */
    boolean countryExists(String country, int position) {

        for (int i=0;i<position;i++) {
            if(cities.get(i).getCityCountryCode().equals(country)) {
                return true;
            }
        }
       return false;
    }

    /**
     * Method initialize
     * Initializes the view, clearing every label and removing the
     * countries that are duplicated.
     */
    @FXML
    private void initialize(){

        List<String> countries = new ArrayList<String>();
        for (int i=0;i<cities.size();i++) {
            if (!countryExists(cities.get(i).getCityCountryCode(),i)) {
                countries.add(cities.get(i).getCityCountryCode());
            }
        }

        for (String country : countries) {
            countryComboBox.getItems().add(country);
        }

        cityName.setText("");
        currentTime.setText("");
        weatherDesc.setText("");
        degrees.setText("");
        humidityValue.setText("");
        windValue.setText("");
    }

    /**
     * Method selectCity
     * Sets the parameters in the view that are collected from the OpenWeatherMap.
     *
     */
    @FXML
    private void selectCity() {
        if(cityComboBox.getSelectionModel().getSelectedItem() != null) {
            String retrievedInfo = retrieveInfo.getWeatherString(cityComboBox.getSelectionModel().getSelectedItem());
            WeatherInfoModel weatherInfoModel = jsonParser.parseJSON(retrievedInfo);

            cityName.setText(cityComboBox.getSelectionModel().getSelectedItem());
            currentTime.setText(weatherInfoModel.getTime());
            weatherDesc.setText(weatherInfoModel.getWeatherDescription());
            degrees.setText(weatherInfoModel.getDegrees());
            humidityValue.setText(weatherInfoModel.getHumidity());
            windValue.setText(weatherInfoModel.getWind());
            ImageView img = new ImageView("http://openweathermap.org/img/w/" + weatherInfoModel.getIcon() + ".png");
            img.setFitHeight(35);
            img.setFitWidth(35);
            icon.setGraphic(img);
        }
    }

    /**
     * Method selectCountry
     * Gets the cities that are available for the selected country.
     *
     */
    @FXML
    private void selectCountry() {
        cityComboBox.getItems().clear();
        for (CityModel city : cities) {
            if (city.getCityCountryCode().equals(countryComboBox.getSelectionModel().getSelectedItem())) {
                cityComboBox.getItems().add(city.getCityName());
            }
        }
    }
}
