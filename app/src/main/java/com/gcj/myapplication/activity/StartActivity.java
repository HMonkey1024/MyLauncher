package com.gcj.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by gcj on 2017/11/28
 */

public class StartActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*try {
            Thread.sleep(1000); //线程休眠1s，使出现白屏时的效果更加明显
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        super.onCreate(savedInstanceState);
        // 注意：此处将setContentView()方法注释掉
        //setContentView(R.layout.activity_start);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoLogin();
            }
        }, 2000);
    }

    /**
     * 前往注册、登录主页
     */
    private void gotoLogin() {
        Intent intent = new Intent(StartActivity.this, LoginMainActivity.class);
        startActivity(intent);
        finish();
        //取消界面跳转时的动画，使启动页的logo图片与注册、登录主页的logo图片完美衔接
        overridePendingTransition(0, 0);
    }

    /**
     * 屏蔽物理返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            //If token is null, all callbacks and messages will be removed.
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
