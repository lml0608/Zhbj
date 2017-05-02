package com.bignerdranch.android.zhbj;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.bignerdranch.android.zhbj.fragment.ContentFragment;
import com.bignerdranch.android.zhbj.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * 引入silidingmenu库
 */
public class MainActivity extends SlidingFragmentActivity {

    private static final String TAG = "MainActivity";
    private SlidingMenu mSlidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉标题栏。,在setContentView(R.layout.activity_guide);之前调用
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_fragment);


        //侧边栏
        setBehindContentView(R.layout.left_menu);
        mSlidingMenu = getSlidingMenu();
        //触摸模式TOUCHMODE_FULLSCREEN 全屏,TOUCHMODE_MARGIN边界
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        mSlidingMenu.setBehindOffset(500);//屏幕预留500像素宽度

        initFrtagment();

    }




    private void initFrtagment() {

        //获取FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fl_left_menu, new LeftMenuFragment());
        fragmentTransaction.replace(R.id.fragment_container, new ContentFragment());
        fragmentTransaction.commit();


    }
}
