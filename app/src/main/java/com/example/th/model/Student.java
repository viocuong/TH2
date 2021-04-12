package com.example.th.model;

public class Student {
    private int id, rsImg;
    private String name;
    private String dob;

    public int getId() {
        return id;
    }

    public int getRsImg() {
        return rsImg;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public Student(int id, int rsImg, String name, String dob, String gender) {
        this.id = id;
        this.rsImg = rsImg;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    private String gender;

}
