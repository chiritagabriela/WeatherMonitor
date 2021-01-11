package ro.mta.se.lab.model;

/**
 * Class defining weather info model
 *
 * @author Chirita Gabriela
 */
public class WeatherInfoModel {
    /**
     * Member description
     */
    String time;
    String weatherDescription;
    String degrees;
    String humidity;
    String wind;
    String icon;

    /**
     * WeatherInfoModel class constructor
     * @param time represents the current time.
     * @param weatherDescription represents the weather description of the city.
     * @param degrees represents the temperature of the city.
     * @param humidity represents the humidity of the city.
     * @param wind represents the wind of the city.
     * @param icon represents the image representing the weather of the city.
     */
    public WeatherInfoModel(String time, String weatherDescription, String degrees,
                            String humidity, String wind, String icon) {
        this.time = time;
        this.weatherDescription = weatherDescription;
        this.degrees = degrees;
        this.humidity = humidity;
        this.wind = wind;
        this.icon = icon;
    }

    public WeatherInfoModel(){

    }

    public String getTime() {
        return time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
