package ro.mta.se.lab.utility;

import ro.mta.se.lab.model.WeatherInfoModel;

public interface JSONParser {
    public WeatherInfoModel parseJSON(String toBeParsed);
}
