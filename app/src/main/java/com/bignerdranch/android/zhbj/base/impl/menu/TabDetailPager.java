package com.bignerdranch.android.zhbj.base.impl.menu;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.base.BaseMenuDetailPager;
import com.bignerdranch.android.zhbj.domain.NewsMenu.NewsTabData;

/**
 * Created by liubin on 2017/5/4.
 */

public class TabDetailPager extends BaseMenuDetailPager {

    private NewsTabData mNewsTabData;
    private TextView mView;

    public TabDetailPager(Activity activity, NewsTabData newsTabData) {
        super(activity);
        mNewsTabData = newsTabData;
    }

    @Override
    public View initView() {

        mView = new TextView(mActivity);
        //view.setText(mNewsTabData.title);//不能在此处处理。会出现空指针异常
        mView.setTextColor(Color.RED);
        mView.setTextSize(22);
        mView.setGravity(Gravity.CENTER);

        return mView;
    }

    @Override
    public void initData() {

        mView.setText(mNewsTabData.title);
    }
}
