package com.example.user.vietnamtuor_support.View.Notification;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.vietnamtuor_support.Adapter.AdapterNotification;
import com.example.user.vietnamtuor_support.Model.ObjectClass.DataNotification;
import com.example.user.vietnamtuor_support.R;

import java.util.ArrayList;

import static com.example.user.vietnamtuor_support.View.Main.MainActivity.menuBotNavBar;


public class Activity_notification extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initView();
        menuBotNavBar(this, 2);
    }


    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerView_NotificationList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        //recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ArrayList<DataNotification> arrayList = new ArrayList<>();
        arrayList.add(new DataNotification(R.drawable.cantho_map, "thong bao 1"));
        arrayList.add(new DataNotification(R.drawable.cantho_map, "thong bao 2"));
        arrayList.add(new DataNotification(R.drawable.cantho_map, "thong bao 3"));
        arrayList.add(new DataNotification(R.drawable.cantho_map, "thong bao 4"));
        arrayList.add(new DataNotification(R.drawable.cantho_map, "thong bao 5"));
        arrayList.add(new DataNotification(R.drawable.cantho_map, "thong bao 6"));
        AdapterNotification adapterNotification = new AdapterNotification(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapterNotification);
    }
}
