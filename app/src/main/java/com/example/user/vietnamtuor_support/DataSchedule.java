package com.example.user.vietnamtuor_support;

/**
 * Created by User on 22/04/2018.
 */


public class DataSchedule {
        private int image;
        private String name;
        private String user;
        private String date;

        public DataSchedule(int image, String name, String user, String date) {
            this.image = image;
            this.name = name;
            this.user = user;
            this.date = date;
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

        public String getDate() {
        return date;
    }

        public void setDate(String name) {
        this.date = date;
    }


    public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

}

