package com.example.preciousheart2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class alarmActivity extends AppCompatActivity {

    //Creating reference for objects in activity
    TimePicker time;
    TextView alarm;
    Button setButton;

    //Creating variables for the horu and the minute where the alarm goes off
    int alarmHour;
    int alarmMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        //Giving values to reference
        time = (TimePicker) findViewById(R.id.timePicker);
        alarm = (TextView) findViewById(R.id.alarmText);
        setButton = (Button) findViewById(R.id.setAlarmButton);

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                alarmHour = hourOfDay;
                alarmMinute = minute;
            }
        });
    }

    public void setAlarm(View view) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Date date = new Date();

        //Objects to set the alarm and the actual day and time
        Calendar calendarAlarm = Calendar.getInstance();
        Calendar calendarNow = Calendar.getInstance();

        //Methods to set our calendar objects in the actual hour
        calendarAlarm.setTime(date);
        calendarNow.setTime(date);

        //Set the time were the alarms goes off
        calendarAlarm.set(Calendar.HOUR_OF_DAY, alarmHour);
        calendarAlarm.set(Calendar.MINUTE, alarmMinute);
        calendarAlarm.set(Calendar.SECOND, 0);

        //If to see if the time of the alarm hasn't already pass
        if(calendarAlarm.before(calendarNow)){
            calendarAlarm.add(Calendar.DATE, 1);
        }

        Intent intent = new Intent(alarmActivity.this, BroadCastHelper.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(alarmActivity.this, 24444, intent,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendarAlarm.getTimeInMillis(), pendingIntent);

        Toast.makeText(alarmActivity.this, Utilities.contentText, Toast.LENGTH_SHORT).show();

    }

}
