package com.bignerdranch.android.zhbj.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *
 * 不允许滑动的viewpager
 * Created by lfs-ios on 2017/5/2.
 */

public class NoScrollViewPager extends ViewPager {


    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //重新此方法，触摸时什么都不做，实现对滑动事件的禁用
        return true;
    }
}
