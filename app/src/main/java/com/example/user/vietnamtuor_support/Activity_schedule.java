package com.example.user.vietnamtuor_support;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.user.vietnamtuor_support.Activity_user.userId;
import static com.example.user.vietnamtuor_support.JsonHelper.parseJson;
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
        ArrayList<DataSchedule> arrayList = getNearLocationList(Config.URL_GET_TASK_LIST + "/" + userId);
        AdapterSchedule adapterSchedule = new AdapterSchedule(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapterSchedule);
    }
    public ArrayList<DataSchedule> getNearLocationList(String url) {

        ArrayList<String> arrayList;
        ArrayList<DataSchedule> services = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(new HttpRequestAdapter.httpGet().execute(Config.URL_HOST+url).get());

                for (int i = 0; i < jsonArray.length(); i += 2) {

                    DataSchedule dataSchedule = new DataSchedule();
                    JSONObject jsonObjectData = jsonArray.getJSONObject(i);


                    arrayList = parseJson(jsonObjectData, Config.GET_KEY_JSON_TASK_LIST);

                    //Set hình ảnh
//                    dataSchedule.setImage(setImage(Config.URL_HOST + Config.URL_GET_THUMB + arrayList.get(3),
//                            arrayList.get(2), arrayList.get(3)));
                    //Set mã
                    dataSchedule.setId(Integer.parseInt(arrayList.get(0)));
                    //Set ngày giao việc
                    dataSchedule.setDate(arrayList.get(1));
                    // set tên công việc
                    dataSchedule.setName(arrayList.get(2));
                    // set người giao việc
                    dataSchedule.setUser(arrayList.get(3));

                    services.add(dataSchedule);
                }
        } catch (JSONException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return services;
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
}
