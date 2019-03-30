package com.hask.pc.haskmusic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class SharedPreferencesUtil {

    private static final String USER_TOKEN = "USER_TOKEN";
    public static final String TAG = "SharedPreferencesUtil";
    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static SharedPreferencesUtil mSharedPreferencesUtil;
    private final Context context;

    private SharedPreferencesUtil(Context context) {

        this.context = context.getApplicationContext();
        mPreferences =   this.context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public static SharedPreferencesUtil getInstance(Context context) {
        if (mSharedPreferencesUtil ==null){
            mSharedPreferencesUtil =new SharedPreferencesUtil(context);
        }
        return  mSharedPreferencesUtil;
    }

    public void putBoolean(String key,boolean value) {
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }

    public boolean getBoolean(String key,boolean value){
        return mPreferences.getBoolean(key,value);
    }

    public String get(String key) {
        return mPreferences.getString(key,"");
    }

    public boolean isLogin(){
        return !TextUtils.isEmpty(getUserToken());
    }

    public void setUserToken(String token){
            mEditor.putString(USER_TOKEN,token);
            mEditor.commit();
    }

    public String getUserToken(){
        String token =  get(USER_TOKEN);
        return token;
    }

}
