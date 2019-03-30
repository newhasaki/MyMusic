package com.hask.pc.haskmusic.activity;

import com.hask.pc.haskmusic.util.SharedPreferencesUtil;

public class BaseCommonActivity extends BaseActivity {
    protected SharedPreferencesUtil sp;

    @Override
    protected void initViews() {
        super.initViews();
        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
    }
}
