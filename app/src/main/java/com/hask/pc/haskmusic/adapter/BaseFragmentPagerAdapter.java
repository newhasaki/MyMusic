package com.hask.pc.haskmusic.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFragmentPagerAdapter<T> extends FragmentPagerAdapter{
    protected final Context context;
    protected final List<T> datas = new ArrayList<T>();

    public BaseFragmentPagerAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        this.context = context;
    }

    public T getData(int positon){
        return  datas.get(positon);
    }

    public void setDatas(List<T> data){
        if(data!=null&&data.size()>0){
            datas.clear();
            datas.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addDatas(List<T> data) {
        if (data != null && data.size() > 0) {
            datas.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}