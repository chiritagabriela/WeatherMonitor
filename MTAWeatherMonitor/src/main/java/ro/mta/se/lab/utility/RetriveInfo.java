package ro.mta.se.lab.utility;

import javafx.collections.ObservableList;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.model.WeatherInfoModel;

public interface RetriveInfo {
    public String getWeatherString(String cityName);
    public ObservableList<CityModel> getCities();
}
