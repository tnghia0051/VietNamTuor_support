package com.example.user.vietnamtuor_support.View.Schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.vietnamtuor_support.R;

import static com.example.user.vietnamtuor_support.View.Main.MainActivity.menuBotNavBar;

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
