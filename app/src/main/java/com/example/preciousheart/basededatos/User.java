package com.example.preciousheart.basededatos;

public class User {

    private Integer id;
    private String day;
    private Integer systolic;
    private Integer diastolic;
    private Integer heartRate;

    public User(Integer id, String day, Integer systolic, Integer diastolic, Integer heartRate) {
        this.id = id;
        this.day = day;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }
}
