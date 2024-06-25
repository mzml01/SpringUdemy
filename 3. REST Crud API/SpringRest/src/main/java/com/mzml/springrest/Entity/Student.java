package com.mzml.springrest.Entity;

public class Student {
    private int id;
    private String firstName;
    private String SecondName;

    public Student( String firstName, String secondName) {
        this.firstName = firstName;
        SecondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }
}

