package com.hask.pc.haskmusic.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.hask.pc.haskmusic.fragment.GuideFragment;

/**
 * Created by abc on 2019/3/20.
 */

public class GuideAdapter extends BaseFragmentPagerAdapter {
    public GuideAdapter(Context context, FragmentManager fragmentManager){
        super(context,fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        GuideFragment guideFragment
        getData(position);
    }
}
