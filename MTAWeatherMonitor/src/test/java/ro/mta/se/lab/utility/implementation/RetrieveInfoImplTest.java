package ro.mta.se.lab.utility.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.utility.GetCityTest;
import ro.mta.se.lab.utility.RetrieveInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RetrieveInfoImplTest {

    RetrieveInfo retrieveInfo;
    GetCityTest getCityTest;
    ObservableList<CityModel> observableList;
    File filename;
    CityModel cityModel;
    Scanner myReader;

    @Before
    public void setUp() throws FileNotFoundException {
        filename = new File("C:\\Users\\gabri\\Desktop\\WeatherMonitor\\WeatherMonitor\\MTAWeatherMonitor\\" +
                "src\\main\\resources\\inputFile\\input.txt");
        observableList = FXCollections.observableArrayList();
        cityModel = new CityModel("524901","Moscow","55.7522","37.6156","RU");
        observableList.add(cityModel);
        retrieveInfo = new RetrieveInfoImpl();
        myReader = new Scanner(filename);
    }

    @Test
    public void getCities() {
        assertEquals(retrieveInfo.getCities().size(),16);
    }

    @Test
    public void getWeatherString(){
        getCityTest = mock(GetCityTest.class);
        when(getCityTest.getCity("input.txt")).thenReturn(observableList);
        String data = retrieveInfo.getWeatherString(observableList.get(0).getCityName());
        assertNotNull(data);
    }
}