package com.hask.pc.haskmusic.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hask.pc.haskmusic.R;

public class BaseMusicPlayerActivity extends BaseTitleActivity {
    protected LinearLayout ll_play_small_container;
    protected ImageView iv_icon_small_controller;
    protected ImageView iv_play_small_controller;
    protected ImageView iv_play_list_small_controller;
    protected ImageView iv_next_small_controller;
    protected TextView tv_title_small_controller;
   // protected LyricSingleLineView tv_info_small_controller;
    protected ProgressBar pb_progress_small;

    //protected PlayListManager playListManager;
   // protected MusicPlayerManager musicPlayerManager;
   // private PlayListDialogFragment playListDialog;

    @Override
    protected void initViews() {
        super.initViews();
        ll_play_small_container = findViewById(R.id.ll_play_small_container);
        iv_icon_small_controller = findViewById(R.id.iv_icon_small_controller);
        tv_title_small_controller = findViewById(R.id.tv_title_small_controller);
        //tv_info_small_controller = findViewById(R.id.tv_info_small_controller);
       // iv_play_small_controller = findViewById(R.id.iv_play_small_controller);
       // iv_play_list_small_controller = findViewById(R.id.iv_play_list_small_controller);
       // iv_next_small_controller = findViewById(R.id.iv_next_small_controller);
      //  pb_progress_small = findViewById(R.id.pb_progress_small);
    }
}
