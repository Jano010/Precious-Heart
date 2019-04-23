package com.example.precioushearth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Create SQL Helper
    SQLHelper historyDB;

    //Create variables for the elements on the activity
    EditText sysInput, diasInput, hRInput;
    Button saveButton, showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set SQL Helper
        historyDB = new SQLHelper(this);

        //Set value for elements on the activity
        sysInput = (EditText) findViewById(R.id.systolicInput);
        diasInput = (EditText) findViewById(R.id.diastolicInput);
        hRInput = (EditText) findViewById(R.id.heartRateInput);
        saveButton = (Button) findViewById(R.id.saveButton);
        showButton = (Button) findViewById(R.id.historyButton);

        addData();
    }

    public void addData() {
        //Create button behaviour
        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    //Save data on the database
                    public void onClick(View v) {
                        boolean insertWorked = historyDB.insertDate(Integer.parseInt(sysInput.getText().toString()), //Saving in integer form data
                                Integer.parseInt(diasInput.getText().toString()),
                                Integer.parseInt(hRInput.getText().toString()));
                        if(insertWorked){
                            Toast.makeText(MainActivity.this, Utilities.insertSucced, Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this, Utilities.insertFail, Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void showHistory(){
        showButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }
        );
    }
}
