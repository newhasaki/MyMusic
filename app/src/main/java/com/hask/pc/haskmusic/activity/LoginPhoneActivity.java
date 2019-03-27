package com.hask.pc.haskmusic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hask.pc.haskmusic.R;
import com.hask.pc.haskmusic.domain.User;

import org.apache.commons.lang3.StringUtils;
import org.litepal.LitePal;

import java.util.List;

public class LoginPhoneActivity extends BaseTitleActivity {

    private static final String PHONE_REGEX = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    private Button bt_login;
    private EditText et_phone;
    private EditText et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone);

        et_phone = (EditText)findViewById(R.id.et_phone);
        et_password = (EditText)findViewById(R.id.et_password);

        bt_login = (Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyLogier();
            }
        });
    }

    @Override
    protected void initViews() {
        super.initViews();
        enableBackMenu();
    }

    private void verifyLogier(){
        String phone = et_phone.getText().toString();
        String passwd = et_password.getText().toString();


        if(StringUtils.isBlank(phone)){
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
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

        if(isPhoneInSqlite(phone)&&isPasswordInSqlite(passwd)){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            startActivity(StartPlayActivity.class);
            finish();
            //跳转播放界面
        }else{
            Toast.makeText(this, "手机号或者密码错误", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    private boolean isPhoneInSqlite(String data){
        String temp = String.valueOf(data.hashCode());
        List<User> userList = LitePal.where("phone == ?",temp).find(User.class);
        if (userList.isEmpty()){
            return false;
        }
        return true;
    }

    private boolean isPasswordInSqlite(String data){
        String temp = String.valueOf(data.hashCode());
        List<User> userList = LitePal.where("password == ?",temp).find(User.class);
        if (userList.isEmpty()){
            return false;
        }
        return true;
    }
}
