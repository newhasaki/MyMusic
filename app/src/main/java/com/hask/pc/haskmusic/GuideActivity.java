package com.hask.pc.haskmusic;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import butterknife.BindView;

/**
 * Created by abc on 2019/3/17.
 */

public class GuideActivity extends MainActivity {

    @BindView(R.id.vp)
    public ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
    }

    void initDatas(){


    }
}
