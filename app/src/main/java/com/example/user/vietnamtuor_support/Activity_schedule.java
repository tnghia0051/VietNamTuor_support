package com.example.user.vietnamtuor_support;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;

public class Activity_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        initView();
        menuBotNavBar(this, 1);
    }

    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerView_ScheduleList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        //recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ArrayList<DataSchedule> arrayList = new ArrayList<>();
        arrayList.add(new DataSchedule(R.drawable.cantho_map, "Khu vực 5, P.Châu Văn Liêm", "Admin", "1/1/2018 - 2/1/2018"));
        arrayList.add(new DataSchedule(R.drawable.cantho_map, "Khu vực 4, P.Châu Văn Liêm", "Admin", "1/1/2018 - 2/1/2018"));
        AdapterSchedule adapterSchedule = new AdapterSchedule(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapterSchedule);
    }

}
