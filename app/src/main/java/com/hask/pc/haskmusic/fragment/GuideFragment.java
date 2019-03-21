package com.hask.pc.haskmusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.util.Consts;
import com.hask.pc.haskmusic.util.ImageUtil;

/**
 * Created by abc on 2019/3/20.
 */

public class GuideFragment extends BaseFragment {

    private  ImageView iv;
    private Integer imageId;
    public static GuideFragment newInstance(int imageId){
        Bundle args = new Bundle();
        args.putSerializable(Consts.ID,imageId);
        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_guide,null);
    }

    @Override
    protected void initViews() {
        super.initViews();
        iv= getView().findViewById(R.id.iv);
    }

    @Override
    protected void initDatas() {
        super.initDatas();
        imageId = getArguments().getInt(Consts.ID, -1);

        if (imageId == -1) {
            getMainActivity().finish();
            return;
        }


        ImageUtil.showLocalImage(getMainActivity(),iv,imageId);

    }
}
