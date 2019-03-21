package com.hask.pc.haskmusic.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.hask.pc.haskmusic.MainActivity;
import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.adapter.GuideAdapter;

import java.util.ArrayList;
;

/**
 * Created by abc on 2019/3/17.
 */

public class GuideActivity extends BaseCommonActivity {

    private GuideAdapter adapter;
    public ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_guide);

    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    @Override
    protected void initDatas() {
        super.initDatas();
        vp = findViewById(R.id.vp);
        adapter = new GuideAdapter(getActivity(),getSupportFragmentManager());
        ArrayList<Integer> datas = new ArrayList<>();
        datas.add(R.drawable.guide1);
        datas.add(R.drawable.guide2);
        datas.add(R.drawable.guide3);
        adapter.setDatas(datas);
        vp.setAdapter(adapter);
    }
}
