package com.example.user.vietnamtuor_support;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddlocation, btnAddservice, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnAddlocation = findViewById(R.id.btnAddPlace);
        btnAddservice = findViewById(R.id.btnAddService);
        btnSearch = findViewById(R.id.btnAdvancedSearch);

        btnAddlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.user.vietnamtuor_support.Activity_addlocation.class);
                startActivity(intent);
            }


        });
        btnAddservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, com.example.user.vietnamtuor_support.Activity_addservice.class);
                startActivity(intent2);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, com.example.user.vietnamtuor_support.Activity_search.class);
                startActivity(intent3);
            }
        });
    }

    public static void menuBotNavBar(final Activity activity,int i) {
        BottomNavigationView bottomNavigationView = activity.findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(i);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_trangchu:
                        activity.startActivity(new Intent(activity, MainActivity.class));
                        break;
                    case R.id.ic_phancong:
                        activity.startActivity(new Intent(activity, com.example.user.vietnamtuor_support.Activity_schedule.class));
                        break;
                    case R.id.ic_thongbao:
                        activity.startActivity(new Intent(activity, com.example.user.vietnamtuor_support.Activity_notification.class));
                        break;
                    case R.id.ic_canhan:
                        activity.startActivity(new Intent(activity, com.example.user.vietnamtuor_support.Activity_user.class));
                        break;
                }
                return false;
            }
        });
    }

}
