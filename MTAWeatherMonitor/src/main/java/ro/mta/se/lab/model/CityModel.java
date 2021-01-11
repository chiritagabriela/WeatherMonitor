package ro.mta.se.lab.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class defining city model
 *
 * @author Chirita Gabriela
 */
public class CityModel {

    /**
     * Member description
     */
    StringProperty cityID;
    StringProperty cityName;
    StringProperty cityLat;
    StringProperty cityLon;
    StringProperty cityCountryCode;

    /**
     * CityModel class constructor
     * @param cityID represents the id of the city.
     * @param cityName represents the name of the city.
     * @param cityLat represents the latitude of the city.
     * @param cityLon represents the longitude of the city.
     * @param cityCountryCode represents the country code of the city.
     */
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
