package com.hask.pc.haskmusic.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.hask.pc.haskmusic.util.Consts;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;

    protected void initViews(){

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     *设置数据
     */
    protected void initDatas() {

    }

    protected void initListener(){

    }

    private void init() {
        initViews();
        initDatas();
        initListener();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        init();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        init();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    protected void startActivity(Class<?> clazz) {
        startActivity(new Intent(getActivity(),clazz));
    }

    protected void startActivityAfterFinishThis(Class<?> clazz) {
        startActivity(new Intent(getActivity(),clazz));
        finish();
    }

    protected void startActivityExtraId(Class<?> clazz, String id) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.putExtra(Consts.ID,id);
        startActivity(intent);
    }

    protected void startActivityExtraString(Class<?> clazz, String string) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.putExtra(Consts.STRING,string);
        startActivity(intent);
    }

    protected BaseActivity getActivity() {
        return this;
    }

}
