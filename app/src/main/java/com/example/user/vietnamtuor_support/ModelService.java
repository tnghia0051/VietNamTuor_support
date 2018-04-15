package com.example.user.vietnamtuor_support;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.example.user.vietnamtuor_support.HttpRequestAdapter.httpGetImage;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by sieut on 12/20/2017.
 */

public class ModelService {
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
                    bitmap = new httpGetImage().execute(url).get();
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
