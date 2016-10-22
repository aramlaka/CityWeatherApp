package com.aramlaka.hw6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetForecastJSON.SetForecast {

    public final static String WEATHER_URL_KEY = "weather_url";
    public final static String CITY_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private final static String API_KEY = "4012b350504085a7a6f9ffacb1b97d97";
    public static DataManager dm;
    ArrayList<City> cities;
    ArrayList<Forecast> forecasts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching weather...");

        dm = new DataManager(this);

        cities = dm.getAllCities();

        RecyclerView rvCities = (RecyclerView) findViewById(R.id.rvCities);
        CityAdapter adapter = new CityAdapter(this, cities);
        rvCities.setAdapter(adapter);
        rvCities.setLayoutManager(new LinearLayoutManager(this));

        if (cities.size() > 0) {
            rvCities.setVisibility(View.VISIBLE);
            findViewById(R.id.noCitiesText).setVisibility(View.INVISIBLE);
        }

        Button searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("debug", "clicky");

                EditText cityEdit = (EditText) findViewById(R.id.cityEdit);
                EditText countryEdit = (EditText) findViewById(R.id.countryEdit);

                String city = cityEdit.getText().toString();
                String country = countryEdit.getText().toString();

                String url = CITY_URL + city + "," + country +
                        "&appid=" + API_KEY;

                Log.d("debug", "url=" + url);

                progressDialog.show();
                new GetForecastJSON(MainActivity.this, progressDialog).execute(url);
            }
        });
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

    @Override
    protected void onDestroy() {
        dm.close();
        super.onDestroy();
    }

    @Override
    public void setForecast(CityBundle cityBundle) {
        if (cityBundle.getForecasts() != null)
            Log.d("debug", "forecast(0)=" + cityBundle.getForecasts().forecasts.get(0).toString());
        else
            Log.d("debug", "ruh roh");
    }
}
