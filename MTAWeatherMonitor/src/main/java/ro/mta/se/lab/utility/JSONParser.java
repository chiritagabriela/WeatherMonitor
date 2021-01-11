package ro.mta.se.lab.utility;

import ro.mta.se.lab.model.WeatherInfoModel;

/**
 * Interface defining JSONParserImpl
 *
 * @author Chirita Gabriela
 */
public interface JSONParser {
    public WeatherInfoModel parseJSON(String toBeParsed);
}
