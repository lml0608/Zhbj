package com.bignerdranch.android.zhbj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.bignerdranch.android.zhbj.utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    /**
     * 是否第一次进入应用
     */
    private static final String IS_FIRST_ENTER = "is_first_enter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout activity_splash = (RelativeLayout) findViewById(R.id.activity_splash);
        //透明动画
        AlphaAnimation alphaAnimationha = new AlphaAnimation(0, 1);
        alphaAnimationha.setDuration(1000);
        alphaAnimationha.setFillAfter(true);
        //由小变大缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);

        //旋转
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimationha);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        //启动动画
        activity_splash.startAnimation(animationSet);


        //动画结束后，进入用户引导页面。滑动的3张图片

        animationSet.setAnimationListener(new Animation.AnimationListener() {



            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束


                //第一次进入，跳转新手引导
                //否则跳进主页
                //获取SharedPreferences对象三种方法
                //参数1。文件名，2。操作模式
                SharedPreferences prefs = getSharedPreferences("config", MODE_PRIVATE);
                //参数1。操作模式，该方法使用当前活动的类名作为文件名
                //SharedPreferences pref = getPreferences(MODE_PRIVATE);
                //1.参数 Context
                //SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                //SharedPreferences.Editor edit = pref.edit();
                /*是否第一次进入*/
                //boolean isFirstEnter = prefs.getBoolean(IS_FIRST_ENTER, true);
                Intent mIntent;
                boolean isFirstEnter = PrefUtils.getBoolean(getApplicationContext(), IS_FIRST_ENTER, true);
                Log.i(TAG, String.valueOf(isFirstEnter));
                if (isFirstEnter) {
                    //新手引导
                    mIntent = new Intent(SplashActivity.this, GuideActivity.class);

                } else {
                    //进入主页
                    mIntent = new Intent(SplashActivity.this, MainActivity.class);

                }

                startActivity(mIntent);
                finish();//结束当前页面
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //重复
            }
        });




    }
}
