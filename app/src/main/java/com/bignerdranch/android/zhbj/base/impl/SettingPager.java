package com.bignerdranch.android.zhbj.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.base.BasePager;

/**
 * Created by liubin on 2017/5/1.
 */

public class SettingPager extends BasePager {

    private static final String TAG = "SettingPager";
    public SettingPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        TextView view = new TextView(mActivity);
        view.setText("设置");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        mFrameLayout.addView(view);

        Log.i(TAG, "你好评啊 啊啊啊啊");

    }
}
