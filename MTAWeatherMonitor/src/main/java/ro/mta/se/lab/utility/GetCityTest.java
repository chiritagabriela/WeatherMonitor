package ro.mta.se.lab.utility;

import javafx.collections.ObservableList;
import ro.mta.se.lab.model.CityModel;

public interface GetCityTest {
    public ObservableList<CityModel> getCity(String filename);
}
