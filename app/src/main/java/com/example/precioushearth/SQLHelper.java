//Class helper to manage de Database
package com.example.precioushearth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class SQLHelper extends SQLiteOpenHelper {
    //Declaring variables for the names on the table and the database
    //public static final String databaseName = Utilities.dataBaseName;
    public static final String tableName = Utilities.tableName;
    public static final String id = "ID";
    public static final String date = Utilities.date;
    public static final String time = Utilities.time;
    public static final String systolic = Utilities.systolic;
    public static final String diastolic = Utilities.diastolic;

    public SQLHelper(Context context) {
        super(context, Utilities.dataBaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
