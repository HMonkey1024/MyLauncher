package com.gcj.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by gcj on 2017/11/28
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    public MyApplication() {
        Log.i(TAG, "===>MyApplication");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.i(TAG, "===>attachBaseContext");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "===>onCreate");
    }
}
