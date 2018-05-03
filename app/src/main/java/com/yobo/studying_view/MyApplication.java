package com.yobo.studying_view;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by YoBo on 2018/4/9.
 * 1
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
