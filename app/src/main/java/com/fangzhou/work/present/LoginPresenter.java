package com.fangzhou.work.present;

import com.fangzhou.work.modle.logInModle.LogInModle;
import com.fangzhou.work.view.LoginView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/12/1.
 */

public class LoginPresenter extends IPresenter<LoginView> {

    private LogInModle logInModle;

    public LoginPresenter(LoginView view) {
        super(view);
    }

    @Override
    protected void init() {
        logInModle = new LogInModle();
    }


    public void login(String mobile, String password) {

        final Observable<ResponseBody> login = logInModle.login(mobile, password);
        login
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        if (view != null) {
                            view.LoginSucceed();
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (view != null) {
                            view.LoginFail();
                        }
                    }
                });

    }
}
