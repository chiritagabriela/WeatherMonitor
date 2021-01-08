package ro.mta.se.lab.model;

public class CityModel {
    String cityID;
    String cityName;
    String cityLat;
    String cityLon;
    String cityCountryCode;

    public CityModel(String cityID, String cityName, String cityLat, String cityLon, String cityCountryCode) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityLat = cityLat;
        this.cityLon = cityLon;
        this.cityCountryCode = cityCountryCode;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityLat() {
        return cityLat;
    }

    public void setCityLat(String cityLat) {
        this.cityLat = cityLat;
    }

    public String getCityLon() {
        return cityLon;
    }

    public void setCityLon(String cityLon) {
        this.cityLon = cityLon;
    }

    public String getCityCountryCode() {
        return cityCountryCode;
    }

    public void setCityCountryCode(String cityCountryCode) {
        this.cityCountryCode = cityCountryCode;
    }
}
