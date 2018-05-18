package com.pill.reminder.models;

import java.io.Serializable;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class Appointment implements Serializable{
    String userName;
    String doctorName;
    String doctorSpeciality;
    String date;
    String time;
    boolean shouldRemind;
    String remindBefore;


    public Appointment(String doctorName, String doctorSpeciality, String date, String time) {
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
        this.date = date;
        this.time = time;
    }

    public Appointment(String userName, String doctorName, String doctorSpeciality, String date, String time, boolean shouldRemind, String remindBefore) {
        this.userName = userName;
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
        this.date = date;
        this.time = time;
        this.shouldRemind = shouldRemind;
        this.remindBefore = remindBefore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isShouldRemind() {
        return shouldRemind;
    }

    public void setShouldRemind(boolean shouldRemind) {
        this.shouldRemind = shouldRemind;
    }

    public String getRemindBefore() {
        return remindBefore;
    }

    public void setRemindBefore(String remindBefore) {
        this.remindBefore = remindBefore;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
