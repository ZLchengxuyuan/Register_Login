package com.fangzhou.work.modle.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xxsj on 2017/11/8.
 */

public interface RegisterApi {
    @FormUrlEncoded
    @POST("register/")
    Observable<ResponseBody> register(@Field("mobile") String mobile, @Field("password") String password, @Field("code ") String code , @Field("deviceKey ") String deviceKey );



}
