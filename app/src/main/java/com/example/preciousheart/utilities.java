package com.example.preciousheart;

public class utilities {

    //Entries on the table (Columns)
    public static String tableName = "history";
    public static String id = "Id";
    public static String day = "Day";
    public static String time = "Time";
    public static String systolic = "Systolic";
    public static String diastolic = "Diastolic";
    public static String heartRate = "Heart Rate";

    //Constant for creating a table to register the different types of blood pressure
    public static final String createUserTable = "CREATE TABLE " + tableName + " (" + id + " INTEGER," +
            " " + day + " TEXT, " + time + " TEXT, " + systolic + " INTEGER, " + diastolic + " INTEGER, " + heartRate + " INTEGER)";

    public static String save = "Save";
}
