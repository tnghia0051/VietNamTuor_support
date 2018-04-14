package com.example.user.vietnamtuor_support;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;

public class Activity_user extends AppCompatActivity {

    Button btnAddPlace, btnAddservice, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btnAddPlace = findViewById(R.id.btnAddPlace);
        btnAddservice = findViewById(R.id.btnAddService);
        btnSearch = findViewById(R.id.btnAdvancedSearch);

        btnAddPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_user.this, Activity_addlocation.class);
                startActivity(intent);
            }


        });
        btnAddservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Activity_user.this, Activity_addservice.class);
                startActivity(intent2);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Activity_user.this, Activity_search.class);
                startActivity(intent3);
            }
        });

        menuBotNavBar(this, 3);
    }
}