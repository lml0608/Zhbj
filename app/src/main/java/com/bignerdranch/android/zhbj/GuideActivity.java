package com.bignerdranch.android.zhbj;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    //页面图片资源id数组
    private int[] mImageIds = new int[] {
            R.drawable.guide_01,
            R.drawable.guide_02,
            R.drawable.guide_03};

    private ArrayList<ImageView> mImageViewsList;//存放ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏。,在setContentView(R.layout.activity_guide);之前调用
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);


        mViewPager = (ViewPager) findViewById(R.id.activity_guide_pager_view_pager);

        initData();

        mViewPager.setAdapter(new GuideAdapter());




    }
    //初始化数据
    private void initData() {
        mImageViewsList = new ArrayList<ImageView>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);//ImageView控件设置背景图片

            mImageViewsList.add(view);
        }

    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageViewsList.size();
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        //初始化item布局
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView view = mImageViewsList.get(position);

            container.addView(view);

            return view;
        }

        //销毁item
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
