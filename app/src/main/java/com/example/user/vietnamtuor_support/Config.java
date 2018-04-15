package com.example.user.vietnamtuor_support;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 14/04/2018.
 */

public class Config {

    public static final String URL_HOST = "http://192.168.40.1/doan3_canthotour/public/";
    public static final String URL_LOGIN = "login";
    public static final String FOLDER = "/vietnamtour";
    public static final String FOLDER_AVATAR = "avatar";
    public static final ArrayList<String> GET_KEY_JSON_USER =
            new ArrayList<>(Arrays.asList("username", "avatar", "level"));
    public static final String NULL = "null";
    public static final ArrayList<String> GET_KEY_JSON_LOGIN =
            new ArrayList<>(Arrays.asList("result", "error", "status", "ERROR", "OK"));
    public static final ArrayList<String> POST_KEY_LOGIN =
            new ArrayList<>(Arrays.asList("\"username\"", "\"password\""));
}
