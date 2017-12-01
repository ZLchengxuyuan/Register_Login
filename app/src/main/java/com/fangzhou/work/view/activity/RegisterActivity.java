package com.fangzhou.work.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhou.work.R;
import com.fangzhou.work.present.RegisterPresenter;
import com.fangzhou.work.view.RegisterView;

import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {
    private RegisterPresenter presenter;
    private TextView back_login;
    private Button btn_register;
    private EditText edit_phone;
    private EditText edit_password;
    private EditText edit_again_password;
    private EditText edit_code;
    private EditText edit_qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        presenter = new RegisterPresenter(this);
        // presenter.register("13718232693", "123456", "1234", "1");
    }

    private void initView() {
        back_login = findViewById(R.id.back_Login);
        back_login.setOnClickListener(this);
        btn_register = findViewById(R.id.btn_Register);
        btn_register.setOnClickListener(this);
        //手机号
        edit_phone = findViewById(R.id.edit_phone);
        //输入密码
        edit_password = findViewById(R.id.edit_password);
        //在次输入密码
        edit_again_password = findViewById(R.id.edit_again_password);
        //验证码
        edit_code = findViewById(R.id.edit_code);
        //邀请码
        edit_qrcode = findViewById(R.id.edit_qrcode);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回登录页面
            case R.id.back_Login:
                finish();
                break;
            case R.id.btn_Register:
                setRegister();
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
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            //return telRegex.matches(mobiles);
            return Pattern.matches(telRegex, mobiles);
        }
    }

    //实现注册逻辑的方法
    private void setRegister() {
        String phone_number = edit_phone.getText().toString();
        String password = edit_password.getText().toString();
        String again_password = edit_again_password.getText().toString();
//        String code = edit_code.getText().toString();
//        String qrcode = edit_qrcode.getText().toString();
        if (TextUtils.isEmpty(phone_number)) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断手机号格式是否正确
        if (isMobileNO(phone_number)) {

        } else {
            Toast.makeText(this, "账号格式不正确", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.equals(again_password)) {

        } else {
            Toast.makeText(this, "输入的两次密码不一致", Toast.LENGTH_SHORT).show();
        }
        presenter.register(phone_number, password, "1", "1");
    }

    @Override
    public void RegisterSucceed() {

        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void RegisterFail() {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return this;
    }


}
