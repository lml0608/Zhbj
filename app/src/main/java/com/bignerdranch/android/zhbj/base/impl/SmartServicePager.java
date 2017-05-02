package com.bignerdranch.android.zhbj.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.base.BasePager;

/**
 * Created by liubin on 2017/5/1.
 */

public class SmartServicePager extends BasePager {
    public SmartServicePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        TextView view = new TextView(mActivity);
        view.setText("智慧服务");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        mFrameLayout.addView(view);

        mTextView.setText("生活");

        //显示菜单按钮
        mImageButton.setVisibility(View.VISIBLE);

    }
}
