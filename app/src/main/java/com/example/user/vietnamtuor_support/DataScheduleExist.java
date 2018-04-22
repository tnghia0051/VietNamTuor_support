package com.example.user.vietnamtuor_support;

/**
 * Created by User on 22/04/2018.
 */

public class DataScheduleExist {
        private int image;
        private String name;
        private String user;

        public DataScheduleExist(int image, String name, String address) {
            this.image = image;
            this.name = name;
            this.user = user;
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

        public String getAddress() {
            return user;
        }

        public void setAddress(String user) {
            this.user = user;
        }

}
