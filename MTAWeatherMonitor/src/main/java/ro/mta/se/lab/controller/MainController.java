package ro.mta.se.lab.controller;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.model.WeatherInfoModel;
import ro.mta.se.lab.utility.JSONParser;
import ro.mta.se.lab.utility.implementation.JSONParserImpl;
import ro.mta.se.lab.utility.RetriveInfo;
import ro.mta.se.lab.utility.implementation.RetriveInfoImpl;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    final private ObservableList<CityModel> cities;
    public AnchorPane anchor;
    RetriveInfo retriveInfo = new RetriveInfoImpl();
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

    public MainController(ObservableList<CityModel> cities) {
        this.cities = cities;
    }

    boolean countryExists(String country, int position) {

        for (int i=0;i<position;i++) {
            if(cities.get(i).getCityCountryCode().equals(country)) {
                return true;
            }
        }
       return false;
    }

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
    @FXML
    private void selectCity() {
        if(cityComboBox.getSelectionModel().getSelectedItem() != null) {
            String retrivedInfo = retriveInfo.getWeatherString(cityComboBox.getSelectionModel().getSelectedItem());
            WeatherInfoModel weatherInfoModel = jsonParser.parseJSON(retrivedInfo);

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