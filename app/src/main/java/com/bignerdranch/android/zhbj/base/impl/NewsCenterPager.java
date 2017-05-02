package com.bignerdranch.android.zhbj.base.impl;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.zhbj.MainActivity;
import com.bignerdranch.android.zhbj.base.BasePager;
import com.bignerdranch.android.zhbj.domain.NewsMenu;
import com.bignerdranch.android.zhbj.fragment.LeftMenuFragment;
import com.bignerdranch.android.zhbj.utils.NetworkUtils;
import com.bignerdranch.android.zhbj.utils.OpenNewsJsonUtils;
import com.bignerdranch.android.zhbj.utils.PrefUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by liubin on 2017/5/1.
 */

public class NewsCenterPager extends BasePager{

    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        TextView view = new TextView(mActivity);
        view.setText("新闻");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        mFrameLayout.addView(view);

        mTextView.setText("新闻");
        Log.i("NewsCenterPager", "你好");

        //显示菜单按钮
        mImageButton.setVisibility(View.VISIBLE);

        //判断是否由缓存，如果由缓存就加载缓存，没有就网络请求
        String cache = PrefUtils.getCache(mActivity, NetworkUtils.CATEGORY_URL);

        Log.i("NewsCenterPager", "cache=" + cache);
        NewsMenu newsMenu = OpenNewsJsonUtils.handleNewsResponse(cache);
        if (!TextUtils.isEmpty(cache)) {

            //加载缓存
            processData(newsMenu);

        } else {
            //网络请求
            getDataFromServer();

            Log.i("NewsCenterPager", "你好 啊啊啊啊啊");
        }


    }



    //请求服务器，获取数据
    private void getDataFromServer() {

        NetworkUtils.sendOkHttpRequest(NetworkUtils.CATEGORY_URL, new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responseString = response.body().string();
                Log.i("NewsCenterPager", "responseString=" + responseString);

                final NewsMenu newsMenu = OpenNewsJsonUtils.handleNewsResponse(responseString);
                Log.i("NewsCenterPager", "newsMenu=" + newsMenu);
                Log.i("NewsCenterPager", String.valueOf("ok".equals(newsMenu.retcode)));
                Log.i("NewsCenterPager", String.valueOf(newsMenu.retcode));

                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (newsMenu != null && (newsMenu.retcode) == 200) {

                            //设置缓存

                            PrefUtils.setCache(mActivity, NetworkUtils.CATEGORY_URL, responseString);



                            processData(newsMenu);


                        }
                    }
                });


            }

            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();

                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mActivity, "获取新闻信息失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    protected void processData(NewsMenu newsMenu) {

        Log.i("newMenu", "newsMenu" + newsMenu);

        MainActivity mainUI = (MainActivity) mActivity;
        LeftMenuFragment fragment = mainUI.getLeftMenuFragment();


    }

}
