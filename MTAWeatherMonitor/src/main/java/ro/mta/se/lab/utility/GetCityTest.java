package ro.mta.se.lab.utility;

import javafx.collections.ObservableList;
import ro.mta.se.lab.model.CityModel;

/**
 * Interface defining an unimplemented function in order
 * to test the application with mockito.
 * @author Chirita Gabriela
 */
public interface GetCityTest {
    public ObservableList<CityModel> getCity(String filename);
}
