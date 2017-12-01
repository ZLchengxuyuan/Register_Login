package com.fangzhou.work.modle.logInModle;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/12/1.
 */

public interface ILoginModle {

    Observable<ResponseBody> login(String mobile, String password);

}
