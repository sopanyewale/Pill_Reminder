package com.pill.reminder.models;

import java.io.Serializable;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class User implements Serializable{

    String userName;
    Enum gender;
    String dateOfBirth;

    public static enum GENDER{
        MALE,
        FEMALE
    }

    public User(String userName, Enum gender, String dateOfBirth) {
        this.userName = userName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
