package com.hask.pc.haskmusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hask.pc.haskmusic.activity.BaseActivity;
import com.hask.pc.haskmusic.util.Consts;

/**
 * Created by abc on 2019/3/20.
 */

public abstract class BaseFragment extends Fragment {

//    找控件
    protected void initViews(){

    }

//    动态设置样式,颜色，宽高，背景
    protected void initStyles(){

    }

//    设置数据

    protected void initListener(){

    }

    protected void initDatas() {

    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initViews();
        initStyles();
        initDatas();
        initListener();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        ButterKnife(this);
    }

    protected void startActivityExtraId(Class<?> clazz,String id){
        Intent intent = new Intent(getActivity(),clazz);
        if(!TextUtils.isEmpty(id)){
            intent.putExtra(Consts.ID,id);
        }
        startActivity(intent);
    }

    protected void startActivityAfterFinishThis(Class<?> clazz){
        startActivity(new Intent(getActivity(),clazz));
        getActivity().finish();
    }

    protected void startActivity(Class<?> clazz){
        Intent intent = new Intent(getActivity(),clazz);
        startActivity(intent);
    }

    public BaseActivity getMainActivity() {
        return (BaseActivity) getActivity();
    }

    protected abstract View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

}
