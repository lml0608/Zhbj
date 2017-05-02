package com.bignerdranch.android.zhbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.zhbj.R;
import com.bignerdranch.android.zhbj.base.BasePager;
import com.bignerdranch.android.zhbj.base.impl.GovAffairsPager;
import com.bignerdranch.android.zhbj.base.impl.HomePager;
import com.bignerdranch.android.zhbj.base.impl.NewsCenterPager;
import com.bignerdranch.android.zhbj.base.impl.SettingPager;
import com.bignerdranch.android.zhbj.base.impl.SmartServicePager;
import com.bignerdranch.android.zhbj.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubin on 2017/4/27.
 */

public class ContentFragment extends BaseFragment {


    private NoScrollViewPager mViewPager;

    private List<BasePager> mBasePagers;

    @Override
    public View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
        mViewPager = (NoScrollViewPager) view.findViewById(R.id.vp_centent);


        return view;
    }

    @Override
    public void initData() {
        mBasePagers = new ArrayList<BasePager>();
        //添加五个标签页
        mBasePagers.add(new HomePager(getActivity()));
        mBasePagers.add(new NewsCenterPager(getActivity()));
        mBasePagers.add(new SmartServicePager(getActivity()));
        mBasePagers.add(new GovAffairsPager(getActivity()));
        mBasePagers.add(new SettingPager(getActivity()));

        mViewPager.setAdapter(new ContentAdapter());
    }

    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mBasePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            BasePager pager = mBasePagers.get(position);
            View view = pager.mRootView;
            pager.initData();
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
