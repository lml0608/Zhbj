package com.bignerdranch.android.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lfs-ios on 2017/4/26.
 */

public class PrefUtils {

    /**
     * 是否第一次进入应用
     */
    private static final String IS_FIRST_ENTER = "is_first_enter";


    //boolean
    public static boolean getStoryEnter(Context context) {

        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(IS_FIRST_ENTER, true);
    }

    public static void putStoryEnter(Context context, boolean defValue) {


        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(IS_FIRST_ENTER, defValue)
                .commit();
    }

//    //String
//    public static String getString(Context context, String key, String defValue) {
//
//
//        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);
//
//        return sPrefs.getString(key, defValue);
//    }
//
//    public static void putString(Context context, String key, String defValue) {
//
//
//        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);
//
//        sPrefs.edit().putString(key, defValue);
//    }
//
//    //int
//
//
//    public static int getInt(Context context, String key, int defValue) {
//
//
//        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);
//
//        return sPrefs.getInt(key, defValue);
//    }
//
//    public static void putInt(Context context, String key, int defValue) {
//
//
//        sPrefs = context.getSharedPreferences("config", MODE_PRIVATE);
//
//        sPrefs.edit().putInt(key, defValue);
//    }



}
