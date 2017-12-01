package com.fangzhou.work.modle.registerModle;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by xxsj on 2017/11/8.
 */

public interface IRegistermodel {

    Observable<ResponseBody> register(String mobile, String password, String code, String deviceKey);
}
