package com.example.preciousheart2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + Utilities.TABLE_NAME + " (" +
                    Utilities._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Utilities.SYSTOLIC + " VARCHAR, " +
                    Utilities.DIASTOLIC + " VARCHAR, " +
                    Utilities.HEARTH_RATE + " VARCHAR);";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Utilities.TABLE_NAME + ";";


    public SQLHelper(Context context) {
        super(context, "historyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public long insertData(String systolicIn, String diastolicIn, String hearthRateIn ){

        //Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a map of values to insert in the table
        ContentValues values = new ContentValues();
        values.put(Utilities.SYSTOLIC, systolicIn);
        values.put(Utilities.DIASTOLIC, diastolicIn);
        values.put(Utilities.HEARTH_RATE, hearthRateIn);

        // Insert the new row, returning the primary key value of the new row
        long rowID = db.insert(Utilities.TABLE_NAME, null, values);
        return rowID;
    }
}
