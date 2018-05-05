package com.example.user.vietnamtuor_support;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 14/04/2018.
 */

public class Config {

    public static final String URL_HOST = "http://192.168.1.17:8888/vntour_api/";
    public static final String URL_LOGIN = "login";
    public static final String FOLDER = "/vietnamtour";
    public static final String NULL = "null";
    public static final String URL_GET_TASK_LIST = "get-task-list";

    public static final String URL_GET_LINK_THUMB_1 = "get-thumb-1/";
    public static final String URL_GET_LINK_THUMB_2 = "get-thumb-2/";
    public static final String URL_GET_LINK_DETAIL_1 = "get-detail-1/";
    public static final String URL_GET_LINK_DETAIL_2 = "get-detail-2/";
    public static final String URL_GET_LINK_BANNER = "get-banner/";
    public static final String URL_GET_THUMB = "thumbnails/";
    public static final ArrayList<String> GET_KEY_JSON_MAIN_LIST =
            new ArrayList<>(Arrays.asList("data", "next_page_url", "total"));
    public static final ArrayList<String> GET_KEY_JSON_TASK_LIST =
            new ArrayList<>(Arrays.asList("date_start", "task_title", "assigner"));
    public static final String FOLDER_AVATAR = "avatar";
    public static final ArrayList<String> GET_KEY_JSON_USER =
            new ArrayList<>(Arrays.asList("username", "avatar", "level"));
    public static final ArrayList<String> GET_KEY_JSON_LOGIN =
            new ArrayList<>(Arrays.asList("result", "error", "status", "ERROR", "OK"));
    public static final ArrayList<String> POST_KEY_LOGIN =
            new ArrayList<>(Arrays.asList("\"username\"", "\"password\""));
}
