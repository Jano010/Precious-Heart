package com.example.precioushearth;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableActovoty extends Activity {
    SQLHelper historyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        //Create DatabaseHelper
        historyDB = new SQLHelper(this);

        //Reference to TableLayout
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tablelayout);

        //Add header row
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor(Utilities.headerColor));
        header.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText = {Utilities.dateAndTime, Utilities.systolic, Utilities.diastolic, Utilities.heartRate};
        for (String c:headerText){
            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(18);
            textView.setPadding(5, 5, 5, 5);
            textView.setText(c);
            header.addView(textView);
        }
        tableLayout.addView(header);


        //Get data from sqlite database and add them to the table
        SQLiteDatabase db = historyDB.getReadableDatabase(); // Open the database for reading
        //Star the transaction
        db.beginTransaction();

        try
        {
            String query = "SELECT * FROM " + Utilities.tableName;
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.getCount() > 0){
                while(cursor.moveToNext()){
                    //Read columns data
                    String dateAndTime = cursor.getString(cursor.getColumnIndex(Utilities.dateAndTime));
                    int systolic = cursor.getInt(cursor.getColumnIndex(Utilities.systolic));
                    int diastolic = cursor.getInt(cursor.getColumnIndex(Utilities.diastolic));
                    int heartRate = cursor.getInt(cursor.getColumnIndex(Utilities.heartRate));

                    //Data Rows
                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                    String [] colText = {dateAndTime, Integer.toString(systolic), Integer.toString(diastolic), Integer.toString(heartRate)};
                    for (String text:colText){
                        TextView textView = new TextView(this);
                        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        textView.setGravity(Gravity.CENTER);
                        textView.setTextSize(16);
                        textView.setPadding(5, 5, 5, 5);
                        textView.setText(text);
                        row.addView(textView);
                    }
                    tableLayout.addView(row);
                }

            }
            db.setTransactionSuccessful();
        }
        catch(SQLiteAbortException exception){
            exception.printStackTrace();
        }

        finally{
            //End the transaction
            db.endTransaction();
            //Claso database
            db.close();
        }
    }

}
