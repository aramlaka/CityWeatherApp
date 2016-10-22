package com.aramlaka.hw6;

import java.io.Serializable;

/**
 * Created by akhil on 10/20/2016.
 */

public class Forecast implements Serializable{
    private String time;
    private String temperature;
    private String iconUrl;
    private String windSpeed;
    private String windDirection;
    private String wind;
    private String condition;
    private String humidity;
    private String maximumTemp;
    private String minimumTemp;
    private String pressure;

    public Forecast() {
    }

    public Forecast(String time, String temperature, String iconUrl, String windSpeed,
                    String windDirection, String wind, String condition, String humidity,
                    String maximumTemp, String minimumTemp, String pressure) {
        this.time = time;
        this.temperature = temperature;
        this.iconUrl = iconUrl;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.wind = wind;
        this.condition = condition;
        this.humidity = humidity;
        this.maximumTemp = maximumTemp;
        this.minimumTemp = minimumTemp;
        this.pressure = pressure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getMaximumTemp() {
        return maximumTemp;
    }

    public void setMaximumTemp(String maximumTemp) {
        this.maximumTemp = maximumTemp;
    }

    public String getMinimumTemp() {
        return minimumTemp;
    }

    public void setMinimumTemp(String minimumTemp) {
        this.minimumTemp = minimumTemp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "time='" + time + '\'' +
                ", temperature='" + temperature + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", wind='" + wind + '\'' +
                ", condition='" + condition + '\'' +
                ", humidity='" + humidity + '\'' +
                ", maximumTemp='" + maximumTemp + '\'' +
                ", minimumTemp='" + minimumTemp + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
