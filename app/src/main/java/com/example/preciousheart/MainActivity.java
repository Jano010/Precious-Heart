package com.example.preciousheart;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//Main activity where the user will input the measurements of their blood pressure
public class MainActivity extends AppCompatActivity {

    //Variables where we will receive user inputs
    String date;
    String time;
    Integer systolic;
    Integer diastolic;
    Integer heatRate;

    //Create object for the fields in the main activity
    EditText dateInput;
    EditText timeInput;
    EditText systolicInput;
    EditText diastolicInput;
    EditText heartRateInput;
    Button saveButton;

    //Creating SQLiteHelper object to manage database
    SQLiteHelper connection = new SQLiteHelper(this, "dbHistory", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning valure of the main activity to the created objects
        dateInput = (EditText) findViewById(R.id.dateInput);
        timeInput = (EditText) findViewById(R.id.timeInput);
        systolicInput = (EditText) findViewById(R.id.systolicInput);
        diastolicInput = (EditText) findViewById(R.id.diastolicInput);
        heartRateInput = (EditText) findViewById(R.id.heartRateInput);
        saveButton = (Button) findViewById(R.id.saveButton);

        //Creating method for clicking the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerMeasurement();
            }
        });


    }

    private void registerMeasurement(){
        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues values = new ContentValues();
    }
}
