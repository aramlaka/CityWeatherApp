package com.aramlaka.hw6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CityWeather extends AppCompatActivity implements CityDayAdapter.CityHourSet {

    private ArrayList<Forecast> forecasts;
    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            if (extras.get(MainActivity.CITY_BUNDLE_KEY) != null) {
                CityBundle cb = (CityBundle) extras.get(MainActivity.CITY_BUNDLE_KEY);

                city = cb.getCity();
                forecasts = cb.getForecasts();
            }
        }

        TextView cityText = (TextView) findViewById(R.id.cityForecastText);

        cityText.setText(city.getCityName() + ", " + city.getCountry());

        RecyclerView rvDailyCity = (RecyclerView) findViewById(R.id.rvDailyCity);
        CityDayAdapter dayAdapter = new CityDayAdapter(this, forecasts, this);
        rvDailyCity.setAdapter(dayAdapter);
        rvDailyCity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        RecyclerView rvHourCity = (RecyclerView) findViewById(R.id.rvHourlyCity);
        CityHourAdapter hourAdapter = new CityHourAdapter(this, forecasts.get(0));
        rvHourCity.setAdapter(hourAdapter);
        rvHourCity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_preferences) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setHourAdapter(Forecast forecast) {
        RecyclerView rvHourCity = (RecyclerView) findViewById(R.id.rvHourlyCity);
        CityHourAdapter hourAdapter = new CityHourAdapter(this, forecast);
        rvHourCity.setAdapter(hourAdapter);
        rvHourCity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
