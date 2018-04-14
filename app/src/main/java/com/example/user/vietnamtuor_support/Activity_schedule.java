package com.example.user.vietnamtuor_support;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;

public class Activity_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        menuBotNavBar(this, 1);
    }
}
