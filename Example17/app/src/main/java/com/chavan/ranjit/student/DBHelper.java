package com.chavan.ranjit.student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ranjit on 13/11/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME  , null    , DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Student ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'firstname' varchar,'lastname' varchar)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Student ");
        onCreate(sqLiteDatabase);
    }
}
