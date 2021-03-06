package com.example.user.vietnamtuor_support.View.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.vietnamtuor_support.Adapter.HttpRequestAdapter;
import com.example.user.vietnamtuor_support.Config;
import com.example.user.vietnamtuor_support.Helper.JsonHelper;
import com.example.user.vietnamtuor_support.R;
import com.example.user.vietnamtuor_support.Model.SessionManager;
import com.example.user.vietnamtuor_support.View.Main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.user.vietnamtuor_support.View.User.Activity_user.avatar;
import static com.example.user.vietnamtuor_support.View.User.Activity_user.userId;
import static com.example.user.vietnamtuor_support.View.User.Activity_user.userName;
import static com.example.user.vietnamtuor_support.View.User.Activity_user.userType;
import static com.example.user.vietnamtuor_support.Model.ModelService.setImage;

/**
 * Created by zzacn on 12/7/2017.
 */

public class Activity_Login extends AppCompatActivity {
    EditText etUserId, etPassword;
    Button btnLogin;
    int id;
    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserId = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        id = getIntent().getIntExtra("id", 0);
        String mess = getIntent().getStringExtra("mess");
        if (mess != null) {
            Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
        }

        sessionManager = new SessionManager(getApplicationContext());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etUserId.getText().toString().equals("")) {
                    etUserId.setError("Tài khoản không được để trống");
                } else if (etPassword.getText().toString().equals("")) {
                    etPassword.setError("Mật khẩu không được để trống");
                } else {
                    try {
                        JSONObject jsonPost = new JSONObject("{" + Config.POST_KEY_LOGIN.get(0) + ":\""
                                + etUserId.getText().toString() + "\"," + Config.POST_KEY_LOGIN.get(1) + ":\""
                                + etPassword.getText().toString() + "\"}");
                        String rs = new HttpRequestAdapter.httpPost(jsonPost).execute(Config.URL_HOST + Config.URL_LOGIN).get();
                        JSONObject jsonGet = new JSONObject(rs);
                        // nếu status = error
                        if (jsonGet.getString(Config.GET_KEY_JSON_LOGIN.get(2)).toString().equals(Config.GET_KEY_JSON_LOGIN.get(3))) {
                            Toast.makeText(Activity_Login.this, "tài khoản hoặc mật khẩu không đúng",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            ArrayList<String> arrayUser =
                                    JsonHelper.parseJson(new JSONObject(jsonGet.getString(Config.GET_KEY_JSON_LOGIN.get(0))),
                                            Config.GET_KEY_JSON_USER);

                            userId = Integer.parseInt(arrayUser.get(0));
                            userName = arrayUser.get(1);
                            userType = arrayUser.get(3);
                            if (!arrayUser.get(2).equals(Config.NULL)) {
                                avatar = setImage("", Config.FOLDER_AVATAR, arrayUser.get(2));
                            } else {
                                avatar = null;
                            }

                            sessionManager.createLoginSession(userId + "", userName, userType, avatar);
                            Intent i = new Intent(Activity_Login.this, MainActivity.class);
                            startActivity(i);
                        }
                    } catch (JSONException | ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
