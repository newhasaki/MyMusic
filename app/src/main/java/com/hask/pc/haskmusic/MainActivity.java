package com.hask.pc.haskmusic;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hask.pc.haskmusic.activity.BaseMusicPlayerActivity;
import com.hask.pc.haskmusic.activity.SettingActivity;
import com.hask.pc.haskmusic.adapter.HomeAdapter;
import com.hask.pc.haskmusic.domain.User;
import com.hask.pc.haskmusic.util.ImageUtil;

import org.greenrobot.eventbus.EventBus;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMusicPlayerActivity
        implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private final String DESCRIPTION = "这个人很懒，没有填写个人介绍";

    private DrawerLayout drawer_layout;
    ImageView iv_avatar;
    TextView tv_nickname;
    TextView tv_description;
    private ViewPager vp;
    private HomeAdapter adapter;
    private ImageView iv_music;
    private ImageView iv_recommend;
    private ImageView iv_video;
    private LinearLayout ll_settings;
    private LinearLayout ll_my_friend;
    private LinearLayout ll_message_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        super.initViews();
        //也可以延迟注册，比如：当前用户点击到设置界面是才注册
        //EventBus.getDefault().register(this);

        drawer_layout = findViewById(R.id.drawer_layout);
//
        iv_avatar = findViewById(R.id.iv_avatar);
        tv_nickname = findViewById(R.id.tv_nickname);
        tv_description = findViewById(R.id.tv_description);
//
        iv_music = findViewById(R.id.iv_music);
        iv_recommend = findViewById(R.id.iv_recommend);
        iv_video = findViewById(R.id.iv_video);
//
        ll_settings = findViewById(R.id.ll_settings);
//        ll_my_friend = findViewById(R.id.ll_my_friend);
//        ll_message_container = findViewById(R.id.ll_message_container);

        vp = findViewById(R.id.vp);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        //缓存三个页面
        vp.setOffscreenPageLimit(3);
    }

    @Override
    protected void initDatas() {
        super.initDatas();

        adapter = new HomeAdapter(getActivity(), getSupportFragmentManager());
        vp.setAdapter(adapter);

        ArrayList<Integer> datas = new ArrayList<>();
        datas.add(0);
        datas.add(1);
        datas.add(2);
        adapter.setDatas(datas);
        showUserInfo();
    }

    @Override
    protected void initListener() {
        super.initListener();
        iv_music.setOnClickListener(this);
        iv_recommend.setOnClickListener(this);
        iv_video.setOnClickListener(this);
        ll_settings.setOnClickListener(this);


        vp.addOnPageChangeListener(this);
        vp.setCurrentItem(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_music:
                vp.setCurrentItem(0,true);
                break;
            case R.id.iv_recommend:
                vp.setCurrentItem(1,true);
                break;
            case R.id.iv_video:
                vp.setCurrentItem(2,true);
            case R.id.ll_settings:
                startActivity(SettingActivity.class);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position == 0){
            iv_music.setImageResource(R.drawable.ic_play_selected);
            iv_recommend.setImageResource(R.drawable.ic_music);
            iv_video.setImageResource(R.drawable.ic_video);
        }else if(position == 1){
            iv_music.setImageResource(R.drawable.ic_play);
            iv_recommend.setImageResource(R.drawable.ic_music_selected);
            iv_video.setImageResource(R.drawable.ic_video);
        }else{
            iv_music.setImageResource(R.drawable.ic_play);
            iv_recommend.setImageResource(R.drawable.ic_music);
            iv_video.setImageResource(R.drawable.ic_video_selected);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void showUserInfo(){

        String usertoken = sp.getUserToken();

        String nickName = isTokenInSqliteReturnName(usertoken);

        //设置昵称
        tv_nickname.setText(nickName);
        //设置头像
        Glide.with(getActivity()).load(R.drawable.cd_bg).into(iv_avatar);
        //设置个性签名
        tv_description.setText(DESCRIPTION);
    }

    private String isTokenInSqliteReturnName(String token){
        List<User> userList = LitePal.where("usertoken = ?",token).find(User.class);
        if (userList.isEmpty()){
            return null;
        }
        return userList.get(0).getNickname();
    }
}
