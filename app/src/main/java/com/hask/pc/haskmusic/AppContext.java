package com.hask.pc.haskmusic;

import android.app.Application;
import android.content.Context;
import android.graphics.ColorSpace;
import android.support.multidex.MultiDex;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class AppContext extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LitePal.initialize(this);
        Connector.getDatabase();
        MultiDex.install(this);
    }
}
