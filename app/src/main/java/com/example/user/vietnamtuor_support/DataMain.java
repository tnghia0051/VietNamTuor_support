package com.example.user.vietnamtuor_support;

/**
 * Created by User on 14/04/2018.
 */

public class DataMain {
    private int image;
    private String name;

    public DataMain(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
