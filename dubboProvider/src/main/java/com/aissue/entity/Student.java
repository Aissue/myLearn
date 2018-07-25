package com.aissue.entity;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private String height;
    private String gender;
    private String id;

    public Student(){

    }

    public Student(String name,String height,String gender,String id){
        this.name=name;
        this.height=height;
        this.gender=gender;
        this.id=id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
