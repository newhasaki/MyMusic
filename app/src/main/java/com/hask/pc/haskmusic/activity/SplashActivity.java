package com.hask.pc.haskmusic.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.hask.pc.haskmusic.R;

public class SplashActivity extends BaseCommonActivity {

    public static final int MSG_GUIDE = 100;
    private static final long DEFAULT_DELAY_TIME = 3000;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @SuppressWarnings("unused")
        public void handleMessage(Message msg){
            switch (msg.what){
                case MSG_GUIDE:
                    startActivityAfterFinishThis(GuideActivity.class);
                    break;
            }
            next();
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
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(MSG_GUIDE);
            }
        }, DEFAULT_DELAY_TIME);
    }

    private void next(){

    }


    private boolean isShowGuide(){
        return true;
    }

}
