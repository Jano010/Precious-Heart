package com.example.preciousheart2;

public class Utilities {

    //Names for the table and columns of the database
    public static String TABLE_NAME = "History";
    public static String _ID = "id";
    public static String SYSTOLIC = "systolic";
    public static String DIASTOLIC = "diastolic";
    public static String HEARTH_RATE = "heart_rate";

    //Messages for the toast
    public static String dataInserted = "Data Inserted";
    public static String dataNotInserted = "Data Not Inserted";
    public static String emptyEditText = "Please Fill All The Required Fields.";

    //Color of the background of the header for the table database once is display
    public static String backGroundColorHeader = "#c0c0c0";

    //Message to display the status of the differents pressures
    public static String systolicMessage = "Systolic: ";
    public static String diastolicMessage = "Diastolic: ";
    public static String heartRateMessage = "Heart Rate: ";

    //Messages for the diffents status of the pressures
    public static String lowStatus = "Low";
    public static String normalStatus = "Normal";
    public static String elevatedStatus = "Elevated";
    public static String high1Status = "High (Possible Hypertension - Stage 1)";
    public static String high2Status = "High (Possible Hypertension - Stage 2)";
    public static String crisisStatus = "Hypertensive Crisis (Please go see medical care soon)";

    //Limits for the difference stage on systolic pressure
    public static int normalLimitSystolic = 120;
    public static int highLimitSystolic = 130;
    public static int high2LimitSystolic = 140;
    public static int crisisLimitSystolic = 180;

    //Limits for the difference stage on diastolic pressure
    public static int normalLimitDiastolic = 80;
    public static int highLimitDiastolic = 90;
    public static int crisisLimitDiastolic = 120;

    //Range for the Heart Rate
    public static int lowRange = 60;
    public static int highRange = 100;

    //Strings for Alarm notificacion
    public static String contentTitle = "Alarm is On";
    public static String contentText = "You had set up the alarm";

}
