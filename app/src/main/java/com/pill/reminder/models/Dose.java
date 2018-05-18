package com.pill.reminder.models;

import java.io.Serializable;

public class Dose implements Serializable{
    String medicine_name;
    String medicine_type;
    int quantity;
    boolean taken;
    String time;
    boolean shouldRemind;
    String userName;
    String medicineUnit;
    String medicineFrequency;

    public Dose(String medicine_name, String medicine_type, int quantity, boolean taken, String time,
                boolean shouldRemind, String userName, String medicineUnit, String medicineFrequency) {
        this.medicine_name = medicine_name;
        this.medicine_type = medicine_type;
        this.quantity = quantity;
        this.taken = taken;
        this.time = time;
        this.shouldRemind = shouldRemind;
        this.userName = userName;
        this.medicineUnit = medicineUnit;
        this.medicineFrequency = medicineFrequency;
    }

    public boolean isShouldRemind() {
        return shouldRemind;
    }

    public void setShouldRemind(boolean shouldRemind) {
        this.shouldRemind = shouldRemind;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    public String getMedicineFrequency() {
        return medicineFrequency;
    }

    public void setMedicineFrequency(String medicineFrequency) {
        this.medicineFrequency = medicineFrequency;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_type() {
        return medicine_type;
    }

    public void setMedicine_type(String medicine_type) {
        this.medicine_type = medicine_type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
