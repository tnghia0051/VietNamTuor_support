package com.example.user.vietnamtuor_support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;


/**
 * Created by User on 20/04/2018.
 */

public class Activity_serviceinfo   extends AppCompatActivity{
    int id, serviceType, reviewId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviceinfo);

        menuBotNavBar(this, 0);
    }

}
