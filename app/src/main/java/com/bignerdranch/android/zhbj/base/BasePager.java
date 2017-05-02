package com.bignerdranch.android.zhbj.base;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.R;

/**
 * 五个标签页的基类
 * Created by liubin on 2017/5/1.
 */

public class BasePager {

    public Activity mActivity;

    public TextView mTextView;
    public ImageButton mImageButton;
    public FrameLayout mFrameLayout;

    public View mRootView;//当前页面的布局文件对象

    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }


    /**
     * 初始化布局
     * @return
     */
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.base_pager, null);
        mTextView = (TextView)view.findViewById(R.id.tv_title);
        mImageButton = (ImageButton)view.findViewById(R.id.btn_menu);
        mFrameLayout = (FrameLayout)view.findViewById(R.id.fl_content);
        return  view;
    }


    /**
     * 初始化数据
     */
    public void initData() {

    }
}
