package com.aramlaka.hw6;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akhil on 10/21/2016.
 */

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
