package com.aramlaka.hw6;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by akhil on 10/20/2016.
 */
public class ForecastUtil {
    public static CityBundle parseJSON(String jsonString) {
        ArrayList<DailyForecast> dailyForecasts = null;
        City city = null;

        try {
            dailyForecasts = new ArrayList<>();
            DailyForecast dailyForecast = new DailyForecast();
            ArrayList<Forecast> forecasts = new ArrayList<>();
            city = new City();

            JSONObject weatherJSONObj = new JSONObject(jsonString);
            JSONObject cityJson = weatherJSONObj.getJSONObject("city");
            JSONArray hourlyForecast = weatherJSONObj.getJSONArray("list");

            String id, cityName, country;
            id = cityJson.getString("id");
            cityName = cityJson.getString("name");
            country = cityJson.getString("country");

            city.set_id(id);
            city.setCityName(cityName);
            city.setCountry(country);

            int indexHolder = 7;

            for (int i = 0; i < hourlyForecast.length(); i++) {
                String time, temperature, iconUrl,
                        windSpeed, windDirection, wind, condition, humidity,
                        maximumTemp, minimumTemp, pressure;

                JSONObject itemsObj = hourlyForecast.getJSONObject(i); // starts at array item 0
                JSONObject mainObj = itemsObj.getJSONObject("main");
                JSONArray weatherArray = itemsObj.getJSONArray("weather"); // array of size 1
                JSONObject weatherObj = weatherArray.getJSONObject(0);
                JSONObject windObj = itemsObj.getJSONObject("wind");

                time = itemsObj.getString("dt_txt");
                // get time
                Date dTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
                String t = new SimpleDateFormat("H:mm").format(dTime);
                // get date
                Date dDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
                String date = new SimpleDateFormat("MMM dd, yyyy").format(dDate);

                String finalTime = new SimpleDateFormat("h:mm").format(dTime);

                temperature = mainObj.getString("temp");
                minimumTemp = mainObj.getString("temp_min");
                maximumTemp = mainObj.getString("temp_max");
                // sea_level; grnd_level; temp_kf
                humidity = mainObj.getString("humidity");
                pressure = mainObj.getString("pressure");
                condition = weatherObj.getString("description");
                windSpeed = windObj.getString("speed");
                windDirection = windObj.getString("deg");
                wind = windSpeed + " mph, " + windDirection + "°";
                iconUrl = weatherObj.getString("icon"); // gives value like 10n
                // image url example: http://openweathermap.org/img/w/10n.png
                iconUrl = "http://openweathermap.org/img/w/" + iconUrl + ".png";

                if ((i+1) % 8 > 4) {
                    finalTime += "PM";
                } else {
                    finalTime += "AM";
                }

                forecasts.add(new Forecast(finalTime, date, temperature, iconUrl,
                        windSpeed, wind, windDirection, condition, humidity,
                        maximumTemp, minimumTemp, pressure));

                if ((i+1) % 4 == 0) {
                    dailyForecast.setTemp(temperature);
                    dailyForecast.setIconUrl(iconUrl);
                    city.setTemperature(temperature);
                }

                if (i < 8) {
                    if (finalTime.equals("9:00PM")) {
                        dailyForecast.setForecasts(forecasts);
                        dailyForecast.setDate(date);
                        dailyForecasts.add(dailyForecast);

                        forecasts = new ArrayList<>();
                        dailyForecast = new DailyForecast();

                        indexHolder = i;
                    }
                } else if ((i - indexHolder) % 7 == 0) {
                    dailyForecast.setForecasts(forecasts);
                    dailyForecast.setDate(date);
                    dailyForecasts.add(dailyForecast);

                    forecasts = new ArrayList<>();
                    dailyForecast = new DailyForecast();
                }
            }

            return new CityBundle(city, dailyForecasts);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}

