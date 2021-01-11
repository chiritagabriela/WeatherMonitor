package ro.mta.se.lab.model;

public class WeatherInfoModel {
    String time;
    String weatherDescription;
    String degrees;
    String humidity;
    String wind;
    String icon;

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
