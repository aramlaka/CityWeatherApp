package com.aramlaka.hw6;

import java.io.Serializable;

/**
 * Created by akhil on 10/20/2016.
 */

public class City implements Serializable {
    private String id;
    private String cityName;
    private String country;
    private String temperature;
    private int favorite;

    public City () {
        this.id = null;
        this.cityName = null;
        this.country = null;
        this.temperature = null;
        this.favorite = 0;
    }

    public String get_id() {
        return id;
    }

    public void set_id(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}
