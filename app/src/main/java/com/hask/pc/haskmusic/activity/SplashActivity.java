package com.hask.pc.haskmusic.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.hask.pc.haskmusic.MainActivity;
import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.util.PackageUtil;

public class SplashActivity extends BaseCommonActivity {

    public static final int MSG_GUIDE = 100;
    private static final long DEFAULT_DELAY_TIME = 3000;
    private static final int MSG_HOME = 110;


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @SuppressWarnings("unused")
        public void handleMessage(Message msg){
            switch (msg.what){
                case MSG_GUIDE:
                    startActivityAfterFinishThis(GuideActivity.class);
                    break;
                case MSG_HOME:
                    //假如打完广告

                    if(sp.isLogin()) {
                        startActivityAfterFinishThis(MainActivity.class);
                    }else{
                        startActivityAfterFinishThis(LoginActivity.class);
                    }
            }
            //next();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initDatas() {
        super.initDatas();
        if(isShowGuide()) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mHandler.sendEmptyMessage(MSG_GUIDE);
                }
            }, DEFAULT_DELAY_TIME);
        }else{
            //打广告未实现

            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mHandler.sendEmptyMessage(MSG_HOME);
                }
            }, DEFAULT_DELAY_TIME);

            //startActivity(LoginActivity.class);
        }
    }

    private void next(){

    }


    private boolean isShowGuide(){
        return sp.getBoolean(String.valueOf(PackageUtil.getVersionCode(getApplicationContext())),true);

    }

}
