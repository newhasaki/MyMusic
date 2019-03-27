package com.hask.pc.haskmusic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.domain.Message;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginActivity extends BaseCommonActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button bt_register = (Button)findViewById(R.id.bt_register);
        Button bt_login = (Button)findViewById(R.id.bt_login);
        View.OnClickListener click =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_register:
                        startActivity(RegisterActivity.class);
                        break;
                    case R.id.bt_login:
                        startActivity(LoginPhoneActivity.class);
                        break;
                    default:
                        break;

                }
            }
        };

        bt_register.setOnClickListener(click);
        bt_login.setOnClickListener(click);

        EventBus.getDefault().register(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEvent(Message message){
        Log.d(TAG, "onMessageEvent: ");
        finish();
    }
}
