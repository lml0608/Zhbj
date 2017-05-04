package com.bignerdranch.android.zhbj.base.impl.menu;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.base.BaseMenuDetailPager;

/**
 * Created by liubin on 2017/5/4.
 */

public class PhotoMenuDetailPager extends BaseMenuDetailPager {


    public PhotoMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {

        //首页初始化
        TextView view = new TextView(mActivity);
        view.setText("菜单详情页-组图");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);
        return view;
    }
}
