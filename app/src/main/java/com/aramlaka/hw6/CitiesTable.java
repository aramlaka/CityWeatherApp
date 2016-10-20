package com.aramlaka.hw6;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by akhil on 10/20/2016.
 */
public class CitiesTable {
    public static final String TABLE_NAME = "cities";
    public static final String CITY_ID = "_id";
    public static final String CITY_NAME = "city_name";
    public static final String CITY_COUNTRY = "country";
    public static final String CITY_TEMPERATURE = "temperature";
    public static final String CITY_FAVORITE = "favorite";

    private static void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE " + CitiesTable.TABLE_NAME + "(");
        sb.append(CitiesTable.CITY_ID + " integer primary key autoincrement, ");
        sb.append(CitiesTable.CITY_NAME + " text not null, ");
        sb.append(CitiesTable.CITY_COUNTRY + " text not null, ");
        sb.append(CitiesTable.CITY_TEMPERATURE + " text not null, ");
        sb.append(CitiesTable.CITY_FAVORITE + " integer not null");
        sb.append(");");

        try {
            db.execSQL(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CitiesTable.TABLE_NAME);
        CitiesTable.onCreate(db);
    }
}
