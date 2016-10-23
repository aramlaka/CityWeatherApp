package com.aramlaka.hw6;

import java.io.Serializable;
import java.util.ArrayList;

public class CityBundle implements Serializable{
    private City city;
    private ArrayList<DailyForecast> forecasts;

    public CityBundle(City city, ArrayList<DailyForecast> forecasts) {
        this.city = city;
        this.forecasts = forecasts;
    }

    public City getCity() {
        return city;
    }

    public ArrayList<DailyForecast> getForecasts() {
        return forecasts;
    }
}
