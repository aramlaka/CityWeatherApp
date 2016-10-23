package com.aramlaka.hw6;

import java.io.Serializable;
import java.util.ArrayList;

public class DailyForecast implements Serializable {

    private ArrayList<Forecast> forecasts;
    private String date;
    private String iconUrl;
    private String temp;

    public DailyForecast () {
    }

    public ArrayList<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(ArrayList<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "forecasts=" + forecasts +
                ", date='" + date + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
