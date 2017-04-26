package com.bignerdranch.android.zhbj;

import android.media.Image;
import android.nfc.Tag;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private static final String TAG = "GuideActivity";

    private ViewPager mViewPager;
    //页面图片资源id数组
    private int[] mImageIds = new int[] {
            R.drawable.guide_1,
            R.drawable.guide_2,
            R.drawable.guide_3};

    private ArrayList<ImageView> mImageViewsList;//存放ImageView
    private LinearLayout mLinearLayout;
    private ImageView mRedimageView;
    //小红点移动距离
    private int mPointDis;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏。,在setContentView(R.layout.activity_guide);之前调用
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);


        mViewPager = (ViewPager) findViewById(R.id.activity_guide_pager_view_pager);

        //LinearLayout控件，放置小圆点
        mLinearLayout = (LinearLayout) findViewById(R.id.layout_container);

        mStartButton = (Button) findViewById(R.id.start_button);

        //红色圆点
        mRedimageView = (ImageView) findViewById(R.id.image_red);

        initData();

        mViewPager.setAdapter(new GuideAdapter());
        //ViewPage滑动事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //当页面滑动过程中回调
                //Log.i(TAG, "当前位置：" + position + "；移动偏移量：" + positionOffset);

                //更新小红点的位置,小红点左边距
                int leftMargin = (int)(mPointDis * positionOffset) + position * mPointDis;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mRedimageView.getLayoutParams();
                params.leftMargin = leftMargin; //修改左边距
                mRedimageView.setLayoutParams(params);



            }

            @Override
            public void onPageSelected(int position) {
                //某个页面被选中，
                if (position == mImageViewsList.size() - 1) {
                    mStartButton.setVisibility(View.VISIBLE);
                } else {
                    mStartButton.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //页面状态发生变化时回调
            }
        });


        //移动距离计算。第二个圆点的left值 - 第一个圆点的left值
//        mPointDis = mLinearLayout.getChildAt(1).getLeft() - mLinearLayout.getChildAt(0).getLeft();
//
//        Log.i(TAG, String.valueOf(mPointDis));

        //需要监听layout方法结束事件，位置确定好之后再获取圆点间距
        //视图树
        mRedimageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //移除监听，避免重复监听
                mRedimageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mRedimageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                //layout方法执行结束回调
                mPointDis = mLinearLayout.getChildAt(1).getLeft() - mLinearLayout.getChildAt(0).getLeft();

                Log.i(TAG, String.valueOf(mPointDis));
            }
        });


    }



    //初始化数据
    private void initData() {
        mImageViewsList = new ArrayList<ImageView>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);//ImageView控件设置背景图片

            mImageViewsList.add(view);
            //初始化底角小圆点

            ImageView point = new ImageView(this);
            //设置图片
            point.setImageResource(R.drawable.shape_point_gray);
            //初始化布局参数，宽高包裹内容，父控件是谁，就是申明谁的布局参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                //设置左边距
                params.leftMargin = 15;
            }
            point.setLayoutParams(params);
            //添加视图到容器
            mLinearLayout.addView(point);
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
