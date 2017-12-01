package com.fangzhou.work.modle.registerModle;


import com.fangzhou.work.modle.api.RegisterApi;
import com.fangzhou.work.modle.utils.RetrofitManager;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by xxsj on 2017/11/8.
 */

public class Registermodel implements IRegistermodel {


    @Override
    public Observable<ResponseBody> register(String mobile, String password, String code, String deviceKey) {
        return RetrofitManager.getDefault().create(RegisterApi.class).register(mobile, password, code, deviceKey);
    }
}
