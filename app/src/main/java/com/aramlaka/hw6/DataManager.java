package com.aramlaka.hw6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by akhil on 10/20/2016.
 */

public class DataManager {

    Context mContext;
    DatabaseHelper dbOpenHelper;
    SQLiteDatabase db;
    CityDAO cityDao;

    public DataManager(Context mContext) {
        this.mContext = mContext;
        dbOpenHelper = new DatabaseHelper(mContext);
        db = dbOpenHelper.getWritableDatabase();
        cityDao = new CityDAO(db);
    }

    public void close() {
        db.close();
    }

    public long saveCity(City city) {
        return cityDao.save(city);
    }

    public boolean updateCity(City city) {
        return cityDao.update(city);
    }

    public boolean deleteCity(City city) {
        return cityDao.delete(city);
    }

    public ArrayList<City> getAllCities() {
        return cityDao.getAll();
    }
}
