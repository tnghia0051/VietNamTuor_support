package com.example.user.vietnamtuor_support.Model.ObjectClass;

/**
 * Created by User on 15/04/2018.
 */

public class DataNotification {
    private int image;
    private String name;

    public DataNotification(int image, String name) {
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
