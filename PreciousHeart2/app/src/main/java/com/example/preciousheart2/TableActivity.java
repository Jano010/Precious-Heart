package com.example.preciousheart2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        // Create DatabaseHelper instance
        SQLHelper dbHelperTA = MainActivity.dbHelper;

        // Reference to TableLayout
        TableLayout tableLayout =(TableLayout)findViewById(R.id.table);

        // Add header row
        TableRow rowHeader = new TableRow(this);
        rowHeader.setBackgroundColor(Color.parseColor(Utilities.backGroundColorHeader));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] header = {Utilities.SYSTOLIC,Utilities.DIASTOLIC,Utilities.HEARTH_RATE};
        for(String c:header) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(18);
            textView.setPadding(5, 5, 5, 5);
            textView.setText(c);
            rowHeader.addView(textView);
        }
        tableLayout.addView(rowHeader);

            // Open the database for reading
            SQLiteDatabase db = dbHelperTA.getReadableDatabase();
            // Start the transaction.
            db.beginTransaction();

        try
        {
            String selectQuery = "SELECT * FROM "+ Utilities.TABLE_NAME; //}posiblemente falte un ;
            Cursor cursor = db.rawQuery(selectQuery,null);
            if(cursor.getCount() >0)
            {
                while (cursor.moveToNext()) {
                    // Read columns data
                    String showSystolic= cursor.getString(cursor.getColumnIndex(Utilities.SYSTOLIC));
                    String showDiastolic= cursor.getString(cursor.getColumnIndex(Utilities.DIASTOLIC));
                    String showHeartRate= cursor.getString(cursor.getColumnIndex(Utilities.HEARTH_RATE));

                    // dara rows
                    TableRow row = new TableRow(this);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                    String[] columns={showSystolic+"",showDiastolic,showHeartRate};
                    for(String text:columns) {
                        TextView tv = new TextView(this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextSize(16);
                        tv.setPadding(5, 5, 5, 5);
                        tv.setText(text);
                        row.addView(tv);
                    }
                    tableLayout.addView(row);

                }

            }
            db.setTransactionSuccessful();

        }
        catch (SQLiteException e)
        {
            e.printStackTrace();

        }
        finally
        {
            db.endTransaction();
            // End the transaction.

        }

    }
}
