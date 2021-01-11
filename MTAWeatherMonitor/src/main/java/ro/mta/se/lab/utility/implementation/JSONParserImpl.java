package ro.mta.se.lab.utility.implementation;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import ro.mta.se.lab.model.WeatherInfoModel;
import ro.mta.se.lab.utility.JSONParser;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import static java.lang.Math.round;

/**
 * Class defining the parsing of JSON
 *
 * @author Chirita Gabriela
 */
public class JSONParserImpl implements JSONParser {

    /**
     * Method convertToCelsius
     * Converts degrees from Kelvin to Celsius
     *
     */
    private float convertToCelsius(double degrees) {
        return (float) (degrees - 273.15);
    }

    /**
     * Method parseJSON
     * Parses the JSON that is received from OpenWeatherMap API
     * and returns a WeatherInfoModel that contains all the information needed for the view.
     */
    @Override
    public WeatherInfoModel parseJSON(String toBeParsed) {

        WeatherInfoModel weatherInfoModel = new WeatherInfoModel();
        JSONObject object = (JSONObject) JSONValue.parse(toBeParsed);

        Map mapper = (Map) object.get("main");
        weatherInfoModel.setDegrees(String.valueOf(round(convertToCelsius((double)mapper.get("temp")))));
        String value = mapper.get("humidity").toString();
        weatherInfoModel.setHumidity(value+"%");

        Map wind = (Map) object.get("wind");
        String windSpeed = wind.get("speed").toString();
        weatherInfoModel.setWind(windSpeed+"km/h");

        JSONArray jsonArray = (JSONArray) object.get("weather");
        Map weather = (Map) jsonArray.iterator().next();
        weatherInfoModel.setWeatherDescription(((String) weather.get("main")));
        weatherInfoModel.setIcon((String) weather.get("icon"));

        LocalDateTime now = LocalDateTime.now();
        String day = now.getDayOfWeek().toString().toLowerCase();
        day = day.substring(0, 1).toUpperCase() + day.substring(1);

        if(now.getHour() > 0 && now.getHour() < 12){
            weatherInfoModel.setTime((day + ",  " + now.getHour() + ":" + now.getMinute()+" AM"));
        }
        else{
            weatherInfoModel.setTime((day + ",  " + now.getHour() + ":" + now.getMinute()+" PM"));
        }
        return weatherInfoModel;
    }
}
