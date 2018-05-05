package com.example.user.vietnamtuor_support.View.Schedule;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.user.vietnamtuor_support.Adapter.AdapterSchedule;
import com.example.user.vietnamtuor_support.Model.ObjectClass.DataSchedule;
import com.example.user.vietnamtuor_support.R;
import com.example.user.vietnamtuor_support.View.User.Activity_addservice;

import java.util.ArrayList;

import static com.example.user.vietnamtuor_support.View.Main.MainActivity.menuBotNavBar;

/**
 * Created by User on 25/04/2018.
 */

public class Activity_schedule_main extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_main);
        //initView();
        menuBotNavBar(this, 1);

        button = findViewById(R.id.btnExistLocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Existlocation();

            }
        });
        button2 = findViewById(R.id.btnScheduleAdd);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addlocation();

            }
        });
    }
    public void Existlocation(){
        Intent intent = new Intent(this, Activity_schedule_exist.class);
        startActivity(intent);
    }
    public void Addlocation(){
        Intent intent = new Intent(this, Activity_addservice.class);
        startActivity(intent);
    }

    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerView_Schedule_ServiceDone);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        ArrayList<DataSchedule> arrayList = new ArrayList<>();
        AdapterSchedule adapterSchedule = new AdapterSchedule(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapterSchedule);
    }
}
