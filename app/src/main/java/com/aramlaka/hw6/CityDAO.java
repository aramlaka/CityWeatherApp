package com.aramlaka.hw6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhil on 10/20/2016.
 */
public class CityDAO {
    private SQLiteDatabase db;

    public CityDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long save(City city) {
        ContentValues values = new ContentValues();
        values.put(CitiesTable.CITY_NAME, city.getCityName());
        values.put(CitiesTable.CITY_COUNTRY, city.getCountry());
        values.put(CitiesTable.CITY_FAVORITE, city.getFavorite());
        values.put(CitiesTable.CITY_TEMPERATURE, city.getTemperature());
        return db.insert(CitiesTable.TABLE_NAME, null, values);
    }

    public boolean update(City city) {
        ContentValues values = new ContentValues();
        values.put(CitiesTable.CITY_NAME, city.getCityName());
        values.put(CitiesTable.CITY_COUNTRY, city.getCountry());
        values.put(CitiesTable.CITY_FAVORITE, city.getFavorite());
        values.put(CitiesTable.CITY_TEMPERATURE, city.getTemperature());
        return db.update(CitiesTable.TABLE_NAME, values, CitiesTable.CITY_ID + "=" + city.get_id(), null) > 0;
    }

    public boolean delete(City city) {
        return db.delete(CitiesTable.TABLE_NAME, CitiesTable.CITY_ID + "=" + city.get_id(), null) > 0;
    }

    public ArrayList<City> getAll() {
        ArrayList<City> cities = new ArrayList<City>();

        Cursor c = db.query(CitiesTable.TABLE_NAME,
                new String[]{CitiesTable.CITY_ID, CitiesTable.CITY_NAME, CitiesTable.CITY_COUNTRY,
                CitiesTable.CITY_TEMPERATURE, CitiesTable.CITY_FAVORITE},
                null, null, null, null, CitiesTable.CITY_FAVORITE);

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();

            do {
                City city = buildCityFromCursor(c);
                cities.add(city);
            } while (c.moveToNext());

            if (!c.isClosed()) {
                c.close();
            }
        }

        return cities;
    }

    private City buildCityFromCursor(Cursor c) {
        City city = null;

        if (c != null) {
            city = new City();
            city.set_id(c.getLong(0));
            city.setCityName(c.getString(1));
            city.setCountry(c.getString(2));
            city.setTemperature(c.getString(3));
            city.setFavorite(c.getInt(4));
        }

        return city;
    }
}
