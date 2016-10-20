package com.aramlaka.hw6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akhil on 10/20/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "cities.db";
    static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context mContext) {
        super(mContext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
