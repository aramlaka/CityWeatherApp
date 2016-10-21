package com.aramlaka.hw6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static DataManager dm;
    ArrayList<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dm = new DataManager(this);

        cities = dm.getAllCities();

        City city = new City();
        city.setCityName("Noxville");
        city.setCountry("ethan");
        city.setTemperature("temp");

        cities.add(city);
        cities.add(city);
        cities.add(city);
        cities.add(city);
        cities.add(city);
        cities.add(city);
        cities.add(city);
        cities.add(city);

        RecyclerView rvCities = (RecyclerView) findViewById(R.id.rvCities);
        CityAdapter adapter = new CityAdapter(this, cities);
        rvCities.setAdapter(adapter);
        rvCities.setLayoutManager(new LinearLayoutManager(this));

        if (cities.size() > 0) {
            rvCities.setVisibility(View.VISIBLE);
            findViewById(R.id.noCitiesText).setVisibility(View.INVISIBLE);
        }
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
}
