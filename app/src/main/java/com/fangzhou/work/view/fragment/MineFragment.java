package com.fangzhou.work.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fangzhou.work.R;
import com.fangzhou.work.view.activity.LoginActivity;


/**
 * Created by Administrator on 2017/12/1.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btn_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine, container, false);

        initView();


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView() {
        btn_login = (Button) view.findViewById(R.id.btn_Login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(),LoginActivity.class));
    }
}
