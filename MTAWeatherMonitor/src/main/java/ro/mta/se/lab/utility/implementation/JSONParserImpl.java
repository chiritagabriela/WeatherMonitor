package ro.mta.se.lab.utility.implementation;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import ro.mta.se.lab.model.WeatherInfoModel;
import ro.mta.se.lab.utility.JSONParser;

import java.util.Map;

public class JSONParserImpl implements JSONParser {

    private float convertToCelsius(double degrees) {
        return (float) (degrees - 273.15);
    }

    @Override
    public WeatherInfoModel parseJSON(String toBeParsed) {

        WeatherInfoModel weatherInfoModel = new WeatherInfoModel();
        JSONObject object = (JSONObject) JSONValue.parse(toBeParsed);

        Map mapper = (Map) object.get("main");
        weatherInfoModel.setDegrees(String.valueOf(convertToCelsius((double)mapper.get("temp"))));
        long value = (long) mapper.get("humidity");
        weatherInfoModel.setHumidity(String.valueOf(value));

        Map wind = (Map) object.get("wind");
        double windSpeed = (double) wind.get("speed");
        weatherInfoModel.setWind(String.valueOf(windSpeed));

        JSONArray jsonArray = (JSONArray) object.get("weather");
        Map weather = (Map) jsonArray.iterator().next();
        weatherInfoModel.setWeatherDescription(((String) weather.get("main")));
        weatherInfoModel.setIcon((String) weather.get("icon"));

        return weatherInfoModel;
    }
}
