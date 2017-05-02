package com.bignerdranch.android.zhbj.domain;

import java.util.ArrayList;

/**
 * 分类信息
 * Created by liubin on 2017/5/2.
 */

public class NewsMenu {

    public int retcode;
    public ArrayList<Integer> extend;
    public ArrayList<NewsMenuData> data;

    // 侧边栏菜单对象
    public class NewsMenuData {
        public int id;
        public String title;
        public int type;

        public ArrayList<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsMenuData [title=" + title + ", children=" + children
                    + "]";
        }
    }

    // 页签的对象
    public class NewsTabData {
        public int id;
        public String title;
        public int type;
        public String url;

        @Override
        public String toString() {
            return "NewsTabData [title=" + title + "]";
        }

    }

    @Override
    public String toString() {
        return "NewsMenu [data=" + data + "]";
    }


}
