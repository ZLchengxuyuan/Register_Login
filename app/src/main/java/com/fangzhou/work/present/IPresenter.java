package com.fangzhou.work.present;

import android.content.Context;

import com.fangzhou.work.modle.app.App;
import com.fangzhou.work.view.IView;


/**
 * Created by xxsj on 2017/11/8.
 */

public class IPresenter<T extends IView>{

    protected T view;
    public IPresenter(T view){
        this.view = view;
        init();
    }

    protected void init() {

    }

    public Context context(){

        if (view!=null&&view.context()!=null){
            return view.context();
        }
        return App.context();
    }
}
