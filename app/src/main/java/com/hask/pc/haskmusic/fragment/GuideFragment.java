package com.hask.pc.haskmusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hask.pc.haskmusic.R;

/**
 * Created by abc on 2019/3/20.
 */

public class GuideFragment extends BaseFragment {




    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_guide,null);
    }
}
