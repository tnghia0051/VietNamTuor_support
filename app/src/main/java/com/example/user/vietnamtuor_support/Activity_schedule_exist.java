package com.example.user.vietnamtuor_support;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;

/**
 * Created by User on 05/05/2018.
 */

public class Activity_schedule_exist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_exist);
        menuBotNavBar(this, 1);
    }
}
