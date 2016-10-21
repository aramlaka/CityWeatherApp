package com.aramlaka.hw6;

/**
 * Created by akhil on 10/20/2016.
 */

public class City {
    private long _id;
    private String cityName;
    private String country;
    private String temperature;
    private int favorite;

    public City () {
        this._id = 0;
        this.cityName = null;
        this.country = null;
        this.temperature = null;
        this.favorite = 0;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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
                "_id=" + _id +
                ", cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}
