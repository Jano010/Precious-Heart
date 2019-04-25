package com.example.preciousheart2;

import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Create SQLHelper
    public static SQLHelper dbHelper;

    //Boolean that will help to see if the edittext are empty or not
    Boolean emptyEditText;

    //Create reference for objects in activity
    EditText systolicInputET, diastolicInputET, heartRateInputET;
    TextView systolicViewTV, diastolicViewTV, heartRateViewTV;
    TextView systolicStatusTV, diastolicStatusTV , heartRateStatusTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new SQLHelper(this);

        //Create EditText objects to adquire data
        systolicInputET = (EditText) findViewById(R.id.systolicInput);
        diastolicInputET = (EditText) findViewById(R.id.diastolicInput);
        heartRateInputET = (EditText) findViewById(R.id.heartRateInput);

        //Create TextView reference to change the status of the pressure
        systolicViewTV = (TextView) findViewById(R.id.systolicView);
        diastolicViewTV = (TextView) findViewById(R.id.diastolicView);
        heartRateViewTV = (TextView) findViewById(R.id.heartRateView);
        systolicStatusTV = (TextView) findViewById(R.id.systolicStatus);
        diastolicStatusTV = (TextView) findViewById(R.id.diastolicStatus);
        heartRateStatusTV = (TextView) findViewById(R.id.heartRateStatus);

    }


    //Method to add data to the database once the button save is clicked
    public void saveDate(View view) {
        CheckEditTextStatus();
        if(emptyEditText){
            long isInserted = dbHelper.insertData(systolicInputET.getText().toString(),
                diastolicInputET.getText().toString(),heartRateInputET.getText().toString());
            if (isInserted == -1){
                Toast.makeText(MainActivity.this, Utilities.dataInserted, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, Utilities.dataInserted, Toast.LENGTH_SHORT).show();
            }

            checkSystolicStatus();

            checkDiastolicStatus();

            checkHeartRateStatus();
        }else{
            Toast.makeText(MainActivity.this, Utilities.emptyEditText, Toast.LENGTH_SHORT).show();
        }

        emptyEditText();
    }

    //Method to see if the editText bos are empty
    public void CheckEditTextStatus(){

        String systolicHolder = systolicInputET.getText().toString() ;
        String diastolicHolder = diastolicInputET.getText().toString();
        String heartRateHolder = heartRateInputET.getText().toString();

        if(TextUtils.isEmpty(systolicHolder) || TextUtils.isEmpty(diastolicHolder) || TextUtils.isEmpty(heartRateHolder)){

            emptyEditText = false ;

        }
        else {

            emptyEditText = true ;
        }
    }

    //Method to clear al the textedit fields after saving data on the database
    public void emptyEditText(){

        systolicInputET.getText().clear();
        diastolicInputET.getText().clear();
        heartRateInputET.getText().clear();

    }

    //Method to check how high or low is the systolic pressure once the data has been saved on the database
    public void checkSystolicStatus(){
        int systolicPressure = Integer.parseInt(systolicInputET.getText().toString());
        systolicStatusTV.setText("");
        systolicViewTV.setText(Utilities.systolicMessage);
        if(systolicPressure < Utilities.normalLimitSystolic){
            systolicStatusTV.setText(Utilities.normalStatus);
        }else if (systolicPressure >= Utilities.normalLimitSystolic &&
                systolicPressure < Utilities.highLimitSystolic){
            systolicStatusTV.setText(Utilities.elevatedStatus);
        }else if (systolicPressure >= Utilities.highLimitSystolic &&
                systolicPressure < Utilities.high2LimitSystolic){
            systolicStatusTV.setText(Utilities.high1Status);
        }else if (systolicPressure >= Utilities.high2LimitSystolic &&
                systolicPressure < Utilities.crisisLimitSystolic){
            systolicStatusTV.setText(Utilities.high2Status);
        }else if (systolicPressure >= Utilities.crisisLimitSystolic){
            systolicStatusTV.setText(Utilities.crisisStatus);
        }
    }

    //Method to check how high or low is the diastolic pressure once the data has been saved on the database
    public void checkDiastolicStatus(){
        int diastolicPressure = Integer.parseInt(diastolicInputET.getText().toString());
        diastolicStatusTV.setText("");
        diastolicViewTV.setText(Utilities.diastolicMessage);
        if(diastolicPressure < Utilities.normalLimitDiastolic){
            diastolicStatusTV.setText(Utilities.normalStatus);
        }else if (diastolicPressure >= Utilities.normalLimitDiastolic &&
                diastolicPressure < Utilities.highLimitDiastolic){
            diastolicStatusTV.setText(Utilities.high1Status);
        }else if (diastolicPressure >= Utilities.highLimitDiastolic &&
                diastolicPressure < Utilities.crisisLimitDiastolic){
            diastolicStatusTV.setText(Utilities.high2Status);
        }else if (diastolicPressure >= Utilities.crisisLimitDiastolic){
            diastolicStatusTV.setText(Utilities.crisisStatus);
        }
    }

    //Method to check the Heart Rate of the user
    public void checkHeartRateStatus(){
        int heartRate = Integer.parseInt(heartRateInputET.getText().toString());
        heartRateStatusTV.setText("");
        heartRateViewTV.setText(Utilities.heartRateMessage);
        if(heartRate < Utilities.lowRange){
            heartRateStatusTV.setText(Utilities.lowStatus);
        }else if(heartRate >= Utilities.lowRange && heartRate < Utilities.highRange){
            heartRateStatusTV.setText(Utilities.normalStatus);
        }else {
            heartRateStatusTV.setText(Utilities.elevatedStatus);
        }
    }

    //Method to change activity to the activity where is the history table
    public void openTableActivity(View view) {
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }

    public void openAlarmActivity(View view) {
        Intent intent = new Intent(this, alarmActivity.class);
        startActivity(intent);
    }

}
