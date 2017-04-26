package com.bignerdranch.android.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lfs-ios on 2017/4/26.
 */

public class PrefUtils {


    private static SharedPreferences sPrefs;

    //boolean
    public static boolean getBoolean(Context context, String key, boolean defValue) {


        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);

        return sPrefs.getBoolean(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean defValue) {


        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);

        sPrefs.edit().putBoolean(key, defValue);
    }

    //String
    public static String getString(Context context, String key, String defValue) {


        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);

        return sPrefs.getString(key, defValue);
    }

    public static void putString(Context context, String key, String defValue) {


        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);

        sPrefs.edit().putString(key, defValue);
    }

    //int


    public static int getInt(Context context, String key, int defValue) {


        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);

        return sPrefs.getInt(key, defValue);
    }

    public static void putInt(Context context, String key, int defValue) {


        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);

        sPrefs.edit().putInt(key, defValue);
    }



}
