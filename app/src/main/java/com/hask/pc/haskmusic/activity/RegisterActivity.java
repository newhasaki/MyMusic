package com.hask.pc.haskmusic.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import com.hask.pc.haskmusic.MainActivity;
import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.domain.Message;
import com.hask.pc.haskmusic.domain.User;

import java.util.List;

public class RegisterActivity extends BaseTitleActivity {

    private static final String PHONE_REGEX = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    private Button bt_register;
    private EditText et_nickname;
    private EditText et_phone;
    private EditText et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_nickname = (EditText)findViewById(R.id.et_nickname);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_password = (EditText)findViewById(R.id.et_password);
        bt_register = (Button)findViewById(R.id.bt_register);
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfo();
            }
        });
    }

    @Override
    protected void initViews() {
        super.initViews();
        enableBackMenu();
    }

    private void getUserInfo(){
            String nickName = et_nickname.getText().toString();
            String phone = et_phone.getText().toString();
            String passwd = et_password.getText().toString();

            if(StringUtils.isBlank(nickName)){
                Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
                return;
            }

            if(nickName.contains(" ")){
                Toast.makeText(this, "昵称不能包含空格", Toast.LENGTH_SHORT).show();
                return;
            }
            
            if(isNickNameInSqlite(nickName)){
                Toast.makeText(this, "昵称已被注册", Toast.LENGTH_SHORT).show();
                return;
            }

            if(StringUtils.isBlank(phone)){
                Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            if(isPhoneInSqlite(phone)){
                Toast.makeText(this, "手机号已注册", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!phone.matches(PHONE_REGEX)){
                Toast.makeText(this, "手机号格式错误", Toast.LENGTH_SHORT).show();
                return;
            }

            if(StringUtils.isBlank(passwd)){
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            if(passwd.length()<6){
                Toast.makeText(this, "密码格式错误", Toast.LENGTH_SHORT).show();
                return;
            }

            String token = String.valueOf((phone + passwd).hashCode());


            //保存用户信息到数据库
            User user = new User();
            user.setNickname(nickName);
            user.setPhone(encryptinInfo(phone));
            user.setPassword(encryptinInfo(passwd));
            user.setUsertoken(token);
            user.setType(User.TYPE_PHONE);
            user.save();

            //在共享参数中存token
            sp.setUserToken(token);

            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

            //关闭主登陆界面
            EventBus.getDefault().post(new Message());


            startActivity(MainActivity.class);
            //跳转播放主界面
            finish();
    }

    private String encryptinInfo(String info){
        return String.valueOf(info.hashCode());
    }

    private boolean isPhoneInSqlite(String data){
        String temp = String.valueOf(data.hashCode());
        List<User> userList = LitePal.where("phone == ?",temp).find(User.class);
        if (userList.isEmpty()){
            return false;
        }
        return true;
    }

    private boolean isNickNameInSqlite(String data){
        List<User> userList = LitePal.where("nickname == ?",data).find(User.class);
        if (userList.isEmpty()){
            return false;
        }
        return true;
    }

}
