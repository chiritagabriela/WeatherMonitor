package ro.mta.se.lab.utility.implementation;

import javafx.collections.FXCollections;
import org.junit.Before;
import org.junit.Test;
import ro.mta.se.lab.model.CityModel;
import ro.mta.se.lab.model.WeatherInfoModel;
import ro.mta.se.lab.utility.JSONParser;
import ro.mta.se.lab.utility.RetrieveInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class JSONParserImplTest {

    JSONParser jsonParser;
    RetrieveInfo retrieveInfo;
    WeatherInfoModel weatherInfoModel;

    @Before
    public void setUp(){
        retrieveInfo = new RetrieveInfoImpl();
        weatherInfoModel = new WeatherInfoModel();
    }

    @Test
    public void parseJSON() {
       String retrievedInfo = retrieveInfo.getWeatherString("Bucharest");
       weatherInfoModel.setWeatherDescription("Rain");
       weatherInfoModel.setDegrees("1");
       weatherInfoModel.setHumidity("93%");
       weatherInfoModel.setWind("4.63km/h");
       assertEquals(jsonParser.parseJSON(retrievedInfo).getHumidity(),weatherInfoModel.getHumidity());
       assertEquals(jsonParser.parseJSON(retrievedInfo).getWeatherDescription(),weatherInfoModel.getWeatherDescription());
       assertEquals(jsonParser.parseJSON(retrievedInfo).getDegrees(),weatherInfoModel.getDegrees());
       assertEquals(jsonParser.parseJSON(retrievedInfo).getWind(),weatherInfoModel.getWind());
    }
}