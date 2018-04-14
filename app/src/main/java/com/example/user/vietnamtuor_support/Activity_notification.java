package com.example.user.vietnamtuor_support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;


public class Activity_notification extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        menuBotNavBar(this, 2);
    }
}
