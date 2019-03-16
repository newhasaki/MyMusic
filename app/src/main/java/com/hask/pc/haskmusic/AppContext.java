package com.hask.pc.haskmusic;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class AppContext extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
