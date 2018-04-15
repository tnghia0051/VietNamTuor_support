package com.example.user.vietnamtuor_support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        menuBotNavBar(this, 0);
    }

    public static void menuBotNavBar(final Activity activity, int i) {
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
                        activity.startActivity(new Intent(activity, Activity_schedule.class));
                        break;
                    case R.id.ic_thongbao:
                        activity.startActivity(new Intent(activity, Activity_notification.class));
                        break;
                    case R.id.ic_canhan:
                        activity.startActivity(new Intent(activity, Activity_user.class));
                        break;
                }
                return false;
            }
        });
    }
    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerView_Place );
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        //recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ArrayList<DataMain> arrayList = new ArrayList<>();
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Vạn Xuân"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Cơm tấm bà bảy"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        AdapterMain adapterMain = new AdapterMain(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapterMain);
    }
}
