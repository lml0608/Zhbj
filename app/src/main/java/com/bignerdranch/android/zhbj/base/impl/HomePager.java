package com.bignerdranch.android.zhbj.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.base.BasePager;

/**
 * Created by liubin on 2017/5/1.
 */

public class HomePager extends BasePager {


    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        TextView view = new TextView(mActivity);
        view.setText("首页");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        mFrameLayout.addView(view);

        mTextView.setText("智慧北京");

    }
}
