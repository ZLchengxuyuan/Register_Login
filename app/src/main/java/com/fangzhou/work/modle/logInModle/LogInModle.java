package com.fangzhou.work.modle.logInModle;

import com.fangzhou.work.modle.api.LoginApi;
import com.fangzhou.work.modle.api.RegisterApi;
import com.fangzhou.work.modle.utils.RetrofitManager;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/12/1.
 */

public class LogInModle implements ILoginModle{

    @Override
    public Observable<ResponseBody> login(String mobile, String password) {
        return RetrofitManager.getDefault().create(LoginApi.class).register(mobile, password);
    }
}
