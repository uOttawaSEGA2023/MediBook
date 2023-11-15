package com.example.medibook;

public class DoctorShift {
    private String date;
    private String startTime;
    private String endTime;
    private String doctorID;

    public String year;
    public String month;
    public String dayOfMonth;

    private String uid;



    public DoctorShift(String date, String startTime, String endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public DoctorShift(String date, String startTime, String endTime, String uid) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
    }


    public DoctorShift(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDoctorID () {
        return doctorID;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setId(String id) {
        this.doctorID = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}