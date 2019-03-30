package com.hask.pc.haskmusic.util;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by abc on 2019/3/17.
 */

//public static String getVersionName(Context context) {
//        PackageManager packageManager = context.getPackageManager();
//        try {
//        return packageManager.getPackageInfo(context.getPackageName(),0).versionName;
//        } catch (PackageManager.NameNotFoundException e) {
//        e.printStackTrace();
//        }
//        return null;
//        }

public class PackageUtil {

    public static String getVersionName(Context context){ //本应用程序的上下文环境
        PackageManager pm = context.getPackageManager();
        try {
            return pm.getPackageInfo(context.getPackageName(),0).versionName;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static int getVersionCode(Context context){
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getPackageInfo(context.getPackageName(),0).versionCode;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return  -1;
    }
}
