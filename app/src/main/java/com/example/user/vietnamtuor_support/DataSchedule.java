package com.example.user.vietnamtuor_support;

import android.graphics.Bitmap;

/**
 * Created by User on 22/04/2018.
 */


public class DataSchedule {
    private int id;
    private Bitmap image;
    private String name;
    private String user;
    private String date;

    public DataSchedule() {
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String name) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}

