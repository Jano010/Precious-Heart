//Class helper to manage de Database
package com.example.precioushearth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.support.annotation.Nullable;


public class SQLHelper extends SQLiteOpenHelper {
    //Declaring variables for the names on the table and the database
    //public static final String databaseName = Utilities.dataBaseName;
    public static final String tableName = Utilities.tableName;
    public static final String date = Utilities.dateAndTime;
    public static final String systolic = Utilities.systolic;
    public static final String diastolic = Utilities.diastolic;
    public static final String heartRate = Utilities.heartRate;

    public SQLHelper(Context context) {

        super(context, Utilities.dataBaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Command to create the table for the database each line is a columm
        db.execSQL("CREATE TABLE " + tableName +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                date + " TEXT," +
                systolic + " INT," +
                diastolic + " INT," +
                heartRate + " INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Verify that a table with the same name doesn't exist already, and if it does, it deletes it
        db.execSQL("DROP TABLE IF EXISTS " + Utilities.tableName);
        onCreate(db);
    }

    //Method to return datetime in string form to insert on database
    private String dateAndTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(Utilities.dateFormat, Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //Method to insert data on the database
    public boolean insertDate (int sys, int dias, int hR){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(date, dateAndTime());
        values.put(systolic, sys);
        values.put(diastolic, dias);
        values.put(heartRate, hR);
        long result = db.insert(tableName, null, values);
        if (result == -1){
            return false; //If return false then the insert fail
        }else {
            return true; //If true then insert worked
        }
    }

    public Cursor showHistory() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor showDB = db.rawQuery("select * from " + tableName, null);
    }

}


