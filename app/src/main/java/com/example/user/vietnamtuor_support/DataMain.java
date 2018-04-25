package com.example.user.vietnamtuor_support;

import android.graphics.Bitmap;

/**
 * Created by User on 14/04/2018.
 */

public class DataMain {
    private int id;
    private Bitmap image;
    private String name;

    public DataMain(){

    }

    public DataMain(int image, String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
