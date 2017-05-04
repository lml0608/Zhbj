package com.bignerdranch.android.zhbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bignerdranch.android.zhbj.MainActivity;
import com.bignerdranch.android.zhbj.R;
import com.bignerdranch.android.zhbj.base.BasePager;
import com.bignerdranch.android.zhbj.base.impl.GovAffairsPager;
import com.bignerdranch.android.zhbj.base.impl.HomePager;
import com.bignerdranch.android.zhbj.base.impl.NewsCenterPager;
import com.bignerdranch.android.zhbj.base.impl.SettingPager;
import com.bignerdranch.android.zhbj.base.impl.SmartServicePager;
import com.bignerdranch.android.zhbj.view.NoScrollViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubin on 2017/4/27.
 */

public class ContentFragment extends BaseFragment {


    private NoScrollViewPager mViewPager;
    private RadioGroup mRadioGroup;

    private ArrayList<BasePager> mBasePagers;

    @Override
    public View initView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
        mViewPager = (NoScrollViewPager) view.findViewById(R.id.vp_centent);
        mRadioGroup = (RadioGroup)view.findViewById(R.id.rg_group);


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

        //设置Adapter
        mViewPager.setAdapter(new ContentAdapter());

        //设置导航标签监听事件

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.rb_home:
                        //切换到首页
                        //mViewPager.setCurrentItem(0);
                        mViewPager.setCurrentItem(0, false);//第2个参数表示是否有滑动动画
                        break;
                    case R.id.rb_news:
                        //切换到新闻
                        //mViewPager.setCurrentItem(1);
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_smart:
                        //切换到智慧服务
                        //mViewPager.setCurrentItem(2);
                        mViewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_gov:
                        //切换到政务
                        //mViewPager.setCurrentItem(3);
                        mViewPager.setCurrentItem(3, false);
                        break;
                    case R.id.rb_setting:
                        //切换到设置
                        //mViewPager.setCurrentItem(4);
                        mViewPager.setCurrentItem(4, false);
                        break;
                    default:
                        break;
                }
            }
        });

        //页面监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //某个页面被选中，则加载数据
                BasePager pager = mBasePagers.get(position);
                pager.initData();

                if (position == 0 || position == mBasePagers.size() - 1) {
                    //首页和设置页要禁用侧边栏
                    setSlidingMenuEnable(false);

                } else {
                    //其他页面开去侧边栏
                    setSlidingMenuEnable(true);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //加载默认选中的页面数据（首页）
        mBasePagers.get(0).initData();
        //第一页禁用侧边栏
        setSlidingMenuEnable(false);

    }

    /**
     *
     * 开启和禁用侧边栏
     * @param enable
     */
    private void setSlidingMenuEnable(boolean enable) {

        MainActivity mainUI = (MainActivity) getActivity();

        SlidingMenu slidingMenu = mainUI.getSlidingMenu();

        if (enable) {

            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        } else {
            slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }

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
            //pager.initData(); viewpager回默认加载下一页面（数据），为了节省流量和性能，不要在此处调用初始化数据方法
            //只有页面被选中再加载数据
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    //获取新闻中心页面

    public NewsCenterPager getNewsCenterPager() {
        NewsCenterPager pager = (NewsCenterPager) mBasePagers.get(1);
        return pager;
    }

}
