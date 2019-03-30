package com.hask.pc.haskmusic.activity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hask.pc.haskmusic.MainActivity;
import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.adapter.GuideAdapter;
import com.hask.pc.haskmusic.util.PackageUtil;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
;import me.relex.circleindicator.CircleIndicator;

/**
 * Created by abc on 2019/3/17.
 */

public class GuideActivity extends BaseCommonActivity {
    private CircleIndicator circleIndicator;
    private GuideAdapter adapter;
    public ViewPager vp;

    private Button bt_login_or_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        Connector.getDatabase();

        bt_login_or_register = (Button)findViewById(R.id.bt_login_or_register);
        bt_login_or_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFirst();
                startActivity(LoginActivity.class);
                finish();
            }
        });
    }

    private void setFirst(){
        sp.putBoolean(String.valueOf(PackageUtil.getVersionCode(getApplicationContext())),false);
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    @Override
    protected void initDatas() {
        super.initDatas();
        adapter = new GuideAdapter(getActivity(),getSupportFragmentManager());
        vp = findViewById(R.id.vp);
        circleIndicator =findViewById(R.id.indicator);

        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        vp.setAdapter(adapter);
        circleIndicator.setViewPager(vp);

        ArrayList<Integer> datas = new ArrayList<>();
        datas.add(R.drawable.guide1);
        datas.add(R.drawable.guide2);
        datas.add(R.drawable.guide3);
        adapter.setDatas(datas);

    }
}
