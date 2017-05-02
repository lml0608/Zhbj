package com.bignerdranch.android.zhbj.utils;

import com.bignerdranch.android.zhbj.domain.NewsMenu;
import com.google.gson.Gson;

/**
 * Created by liubin on 2017/5/2.
 */

public class OpenNewsJsonUtils {

    public static NewsMenu handleNewsResponse(String response) {
        try {
            Gson gson = new Gson();
            NewsMenu data = gson.fromJson(response, NewsMenu.class);
            return data;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
