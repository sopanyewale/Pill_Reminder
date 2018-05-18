package com.pill.reminder.models;

import java.io.Serializable;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class Measurement implements Serializable{
    double value;
    String factor;
    String unit;
    String datetime;

    public Measurement(double value, String factor, String unit, String datetime) {
        this.value = value;
        this.factor = factor;
        this.unit = unit;
        this.datetime = datetime;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
