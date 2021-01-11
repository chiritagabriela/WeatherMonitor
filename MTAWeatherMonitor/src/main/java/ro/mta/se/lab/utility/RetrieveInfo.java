package ro.mta.se.lab.utility;

import javafx.collections.ObservableList;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.model.WeatherInfoModel;

/**
 * Interface defining RetrieveInfoImpl
 *
 * @author Chirita Gabriela
 */
public interface RetrieveInfo {
    public String getWeatherString(String cityName);
    public ObservableList<CityModel> getCities();
}
