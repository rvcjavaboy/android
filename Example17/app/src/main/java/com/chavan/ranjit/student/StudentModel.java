package com.chavan.ranjit.student;

/**
 * Created by ranjit on 13/11/17.
 */

public class StudentModel {
    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    private String fname,lname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

}
