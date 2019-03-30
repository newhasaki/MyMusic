package com.hask.pc.haskmusic.domain;

import android.print.PrinterId;

public class User extends Base{

    public static  int TYPE_PHONE = 0;
    public static  int TYPE_QQ = 1;


    private String nickname;
    private String phone;
    private String password;
    private String usertoken;
    private int type;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public void setUsertoken(String usertoken){
        this.usertoken = usertoken;
    }

    public String getUsertoken(){
        return this.usertoken;
    }
}
