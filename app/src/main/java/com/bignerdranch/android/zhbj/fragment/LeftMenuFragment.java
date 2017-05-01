package com.bignerdranch.android.zhbj.fragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.bignerdranch.android.zhbj.R;

/**
 * Created by liubin on 2017/5/1.
 */

public class LeftMenuFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_left_menu, null);
        return view;
    }

    @Override
    public void initData() {
    }
}
