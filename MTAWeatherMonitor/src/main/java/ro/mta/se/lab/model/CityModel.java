package ro.mta.se.lab.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CityModel {
    StringProperty cityID;
    StringProperty cityName;
    StringProperty cityLat;
    StringProperty cityLon;
    StringProperty cityCountryCode;

    public CityModel(String cityID, String cityName, String cityLat, String cityLon, String cityCountryCode) {
        this.cityID = new SimpleStringProperty(cityID);
        this.cityName = new SimpleStringProperty(cityName);
        this.cityLat = new SimpleStringProperty(cityLat);
        this.cityLon = new SimpleStringProperty(cityLon);
        this.cityCountryCode = new SimpleStringProperty(cityCountryCode);
    }

    public String getCityID() {
        return this.cityID.get();
    }

    public void setCityID(String cityID) {
        this.cityID.set(cityID);
    }

    public String getCityName() {
        return this.cityName.get();
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }

    public String getCityLat() {
        return this.cityLat.get();
    }

    public void setCityLat(String cityLat) {
        this.cityLat.set(cityLat);
    }

    public String getCityLon() {
        return cityLon.get();
    }

    public void setCityLon(String cityLon) {
        this.cityLon.set(cityLon);
    }

    public String getCityCountryCode() {
        return this.cityCountryCode.get();
    }

    public void setCityCountryCode(String cityCountryCode) {
        this.cityCountryCode.set(cityCountryCode);
    }

    public CityModel(){

    }
}
