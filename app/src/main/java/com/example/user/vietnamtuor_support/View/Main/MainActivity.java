package com.example.user.vietnamtuor_support.View.Main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.vietnamtuor_support.View.Notification.Activity_notification;
import com.example.user.vietnamtuor_support.View.Schedule.Activity_schedule;
import com.example.user.vietnamtuor_support.View.User.Activity_user;
import com.example.user.vietnamtuor_support.Adapter.AdapterMain;
import com.example.user.vietnamtuor_support.Adapter.HttpRequestAdapter;
import com.example.user.vietnamtuor_support.Config;
import com.example.user.vietnamtuor_support.Helper.BottomNavigationViewHelper;
import com.example.user.vietnamtuor_support.Model.ObjectClass.DataMain;
import com.example.user.vietnamtuor_support.R;
import com.example.user.vietnamtuor_support.Model.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.user.vietnamtuor_support.Helper.JsonHelper.parseJson;
import static com.example.user.vietnamtuor_support.Helper.JsonHelper.parseJsonNoId;


public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;

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

    public static Bitmap setImage(String url, String folderName, String fileName) {
        Bitmap bitmap = null;
        // nếu có trả về tên hình + id hình để đặt tên cho file + folder
        if (!folderName.equals(Config.NULL) && !fileName.equals(Config.NULL)) {
            File path = new File(Environment.getExternalStorageDirectory().toString() + Config.FOLDER + "/" + folderName);
            path.mkdirs();
            File file = new File(path, fileName);
            if (file.exists()) {
                // nếu file đã tồn tại thì load lên
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                bitmap = BitmapFactory.decodeFile(file.toString(), options);
            } else {
                // nếu file không tồn tại thì tải hình về và lưu hình vào bộ nhớ
                try {
                    bitmap = new HttpRequestAdapter.httpGetImage().execute(url).get();
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
        initView();
        menuBotNavBar(this, 0);
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_Place);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        ArrayList<DataMain> arrayList = new ArrayList<>();
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Vạn Xuân"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Cơm tấm bà bảy"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));
        arrayList.add(new DataMain(R.drawable.ninh_kieu, "Khách sạn Ninh Kiều"));

        AdapterMain adapterMain = new AdapterMain(arrayList, getApplicationContext());
        recyclerView.setAdapter(adapterMain);
    }

    public ArrayList<DataMain> getServiceList(String url, ArrayList<String> formatJson) {

        ArrayList<String> arr, arrayList;
        ArrayList<DataMain> services = new ArrayList<>();

        try {
            String rs = new HttpRequestAdapter.httpGet().execute(url).get();
            arr = parseJsonNoId(new JSONObject(rs), Config.GET_KEY_JSON_MAIN_LIST);
            JSONArray jsonArray = new JSONArray(arr.get(0));

            int limit = jsonArray.length() > 5 ? 5 : jsonArray.length();

            for (int i = 0; i < limit; i++) {

                DataMain dataMain = new DataMain();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                arrayList = parseJson(jsonObject, formatJson);

                dataMain.setImage(setImage(Config.URL_HOST + Config.URL_GET_THUMB + arrayList.get(3),
                        arrayList.get(2), arrayList.get(3)));
                dataMain.setId(Integer.parseInt(arrayList.get(0)));
                dataMain.setName(arrayList.get(1));

                services.add(dataMain);
            }
        } catch (JSONException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return services;
    }
}
