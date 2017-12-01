package com.fangzhou.work.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhou.work.R;
import com.fangzhou.work.present.LoginPresenter;
import com.fangzhou.work.view.LoginView;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextView btn_register;
    private LoginPresenter loginPresenter;
    private EditText edit_login_phone;
    private EditText edit_login_password;
    private Button btn_login_page;
    private TextView forget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginPresenter = new LoginPresenter(this);


    }

    private void initView() {
        btn_register = findViewById(R.id.btn_Register);
        btn_register.setOnClickListener(this);
        edit_login_phone = findViewById(R.id.edit_login_phone);
        edit_login_password = findViewById(R.id.edit_login_password);
        btn_login_page = findViewById(R.id.btn_Login_page);
        btn_login_page.setOnClickListener(this);

        forget_password = findViewById(R.id.forget_password);
        forget_password.setOnClickListener(this);

    }

    //跳转注册页面
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            //登录页面
            case R.id.btn_Login_page:
                    setlogin();
                break;

            case R.id.forget_password:
                startActivity(new Intent(LoginActivity.this,Forget_PSActivity.class));
                break;
        }


    }

    /**
     * 判断手机格式 是否正确的方法
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)){
            return false;
        }
        else{
            //return telRegex.matches(mobiles);
            return Pattern.matches(telRegex,mobiles);
        }
    }
    //登录成功的逻辑
    private void setlogin() {

        String phone = edit_login_phone.getText().toString();
        String password = edit_login_password.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断手机号格式是否正确
        if (isMobileNO(phone)) {

        } else {
            Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        loginPresenter.login(phone,password);

    }

    @Override
    public void LoginSucceed() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return this;
    }
}
