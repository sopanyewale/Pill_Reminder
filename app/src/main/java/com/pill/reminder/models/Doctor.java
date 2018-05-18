package com.pill.reminder.models;

import java.io.Serializable;

public class Doctor implements Serializable{
    String name;
    Long ContactNumber;
    String Speciality;
    String address1;
    String address2;
    String email;

    public Doctor(String name, Long contactNumber, String speciality, String address1, String address2, String email) {
        this.name = name;
        ContactNumber = contactNumber;
        Speciality = speciality;
        this.address1 = address1;
        this.address2 = address2;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
