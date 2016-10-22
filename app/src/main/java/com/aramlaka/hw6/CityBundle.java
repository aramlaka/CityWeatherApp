package com.aramlaka.hw6;

import java.util.ArrayList;

/**
 * Created by akhil on 10/21/2016.
 */

public class CityBundle {
    private City city;
    private ArrayList<Forecast> forecasts;

    public CityBundle(City city, ArrayList<Forecast> forecasts) {
        this.city = city;
        this.forecasts = forecasts;
    }

    public City getCity() {
        return city;
    }

    public ArrayList<Forecast> getForecasts() {
        return forecasts;
    }
}
