package com.bignerdranch.android.zhbj.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bignerdranch.android.zhbj.MainActivity;
import com.bignerdranch.android.zhbj.R;
import com.bignerdranch.android.zhbj.domain.NewsMenu.NewsMenuData;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by liubin on 2017/5/1.
 */

public class LeftMenuFragment extends BaseFragment {

    private ListView mDataList;

    private List<NewsMenuData> mNewsMenuDatas;
    private int mCurrentPos = 0;
    private leftMenuAdapter mLeftMenuAdapter;

    @Override
    public View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_left_menu, null);
        mDataList = (ListView) view.findViewById(R.id.menu_list_view);
        return view;
    }

    @Override
    public void initData() {

    }
    //设置侧边栏数据
    public void setMenuData(List<NewsMenuData> data) {

        mNewsMenuDatas = data;
        //去掉分割线
        mDataList.setDivider(null);

        mLeftMenuAdapter = new leftMenuAdapter();
        mDataList.setAdapter(mLeftMenuAdapter);


        mDataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mCurrentPos = position;
                //刷新listview
                mLeftMenuAdapter.notifyDataSetChanged();

                //收起侧边栏
                MainActivity.stop1();
            }
        });

    }

    private class leftMenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mNewsMenuDatas.size();
        }

        @Override
        public NewsMenuData getItem(int position) {
            return mNewsMenuDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.list_item_left_menu, null);
            }
            TextView tvMenu = (TextView) convertView.findViewById(R.id.tv_menu);

            NewsMenuData item = getItem(position);

            tvMenu.setText(item.title);
            if (position == mCurrentPos) {
                //被选中条目
                tvMenu.setEnabled(true);
            } else {
                tvMenu.setEnabled(false);
            }

            return convertView;
        }
    }
}
