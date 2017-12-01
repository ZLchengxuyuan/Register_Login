package com.fangzhou.work.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangzhou.work.R;


/**
 * Created by Administrator on 2017/12/1.
 */

public class ShopFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shop, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
