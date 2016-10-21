package com.aramlaka.hw6;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by akhil on 10/20/2016.
 */
public class ForecastUtil {
    public static ArrayList<Forecast> parseJSON(String jsonString) {
        try {
            JSONObject forecastJSON = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
