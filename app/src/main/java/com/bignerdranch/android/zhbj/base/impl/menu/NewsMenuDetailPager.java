package com.bignerdranch.android.zhbj.base.impl.menu;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.R;
import com.bignerdranch.android.zhbj.base.BaseMenuDetailPager;
import com.bignerdranch.android.zhbj.base.BasePager;
import com.bignerdranch.android.zhbj.domain.NewsMenu;

import java.util.ArrayList;
import java.util.List;

import com.bignerdranch.android.zhbj.domain.NewsMenu.NewsTabData;

/**
 * c菜单详情页，新闻
 * Created by liubin on 2017/5/4.
 */

public class NewsMenuDetailPager extends BaseMenuDetailPager {

    private ArrayList<TabDetailPager> mTabDetailPagers;

    private ArrayList<NewsTabData> mNewTabDatas;

    //ViewPage
    private ViewPager mViewPager;

    public NewsMenuDetailPager(Activity activity, ArrayList<NewsTabData> children) {
        super(activity);
        mNewTabDatas = children;
    }
    @Override
    public View initView() {

        View view = LayoutInflater.from(mActivity).inflate(R.layout.pager_news_menu_detail, null);

        //获取ViewPager控件
        mViewPager = (ViewPager)view.findViewById(R.id.vp_news_menu_detail);

        return view;
    }



    class NewsMenuDetailAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mTabDetailPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            TabDetailPager pager = mTabDetailPagers.get(position);
            View view = pager.mRootView;
            //pager.initData(); viewpager回默认加载下一页面（数据），为了节省流量和性能，不要在此处调用初始化数据方法
            //只有页面被选中再加载数据
            container.addView(view);

            pager.initData();
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
            object = null;
        }
    }

    @Override
    public void initData() {

        mTabDetailPagers = new ArrayList<>();

        for (int i = 0; i < mNewTabDatas.size(); i++) {

            TabDetailPager pager = new TabDetailPager(mActivity, mNewTabDatas.get(i));
            mTabDetailPagers.add(pager);
        }

        mViewPager.setAdapter(new NewsMenuDetailAdapter());
    }
}
