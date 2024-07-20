package com.example.Lab3.entity;

import java.util.Date;

public class Staff {
    private String fullname;
    private Date birthday;
    private boolean gender;
    private String country;
    private boolean maried;
    private String [] hobies;
    private String note;
    private String photo;

    public Staff() {
    }

    public Staff(String fullname, Date birthday, boolean gender, String country, boolean maried, String[] hobies, String note) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.maried = maried;
        this.hobies = hobies;
        this.note = note;
    }

    public Staff(String fullname, Date birthday, boolean gender, String country, boolean maried, String[] hobies, String note, String photo) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.maried = maried;
        this.hobies = hobies;
        this.note = note;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isMaried() {
        return maried;
    }

    public void setMaried(boolean maried) {
        this.maried = maried;
    }

    public String[] getHobies() {
        return hobies;
    }

    public void setHobies(String[] hobies) {
        this.hobies = hobies;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
