package ro.mta.se.lab.model;

public class WeatherInfoModel {
    String time;
    String weatherDescription;
    String degrees;
    String precipitation;
    String humidity;
    String wind;

    public WeatherInfoModel(String time, String weatherDescription, String degrees, String precipitation,
                            String humidity, String wind) {
        this.time = time;
        this.weatherDescription = weatherDescription;
        this.degrees = degrees;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.wind = wind;
    }

    public String getTime() {
        return time;
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

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
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
