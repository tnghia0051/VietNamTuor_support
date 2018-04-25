package com.example.user.vietnamtuor_support;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.user.vietnamtuor_support.MainActivity.menuBotNavBar;

public class Activity_user extends AppCompatActivity {

    public static int userId = 1;
    public static String userName, userType;
    public static Bitmap avatar;
    Button btnAddPlace, btnAddservice, btnSearch, Logout;
    TextView txtUserName, txtUserType;
    CircleImageView Cavatar;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        txtUserName = findViewById(R.id.txtUserName);
        txtUserType = findViewById(R.id.txtUserType);
        Cavatar = findViewById(R.id.avatar);
        btnAddPlace = findViewById(R.id.btnAddPlace);
        btnAddservice = findViewById(R.id.btnAddService);
        btnSearch = findViewById(R.id.btnAdvancedSearch);
        Logout = findViewById(R.id.buttonLogout);

        txtUserName.setText(userName);
        txtUserType.setText(userType);
        Cavatar.setImageBitmap(avatar);

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
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager = new SessionManager(getApplicationContext());
                userId = 0;
                userName = null;
                userType = null;
                avatar = null;
                txtUserName.setText(userName);
                txtUserType.setText(userType);
                Cavatar.setImageBitmap(avatar);
                sessionManager.logoutUser();
                startActivity(new Intent(Activity_user.this, Activity_user.class));
            }
        });

        menuBotNavBar(this, 3);
    }
}