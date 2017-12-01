package com.fangzhou.work.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.fangzhou.work.R;
import com.fangzhou.work.modle.adapter.MyViewpagerAdapter;
import com.fangzhou.work.view.custom.MyViewPager;
import com.fangzhou.work.view.fragment.HomeFragment;
import com.fangzhou.work.view.fragment.InformationFragment;
import com.fangzhou.work.view.fragment.MineFragment;
import com.fangzhou.work.view.fragment.ShopFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //设置适配器
        viewpager.setAdapter(new MyViewpagerAdapter(getSupportFragmentManager(), fragments, this));
        //radioButton点击事件
        radioFragment();


    }

    //找控件
    private void initView() {
        viewpager = findViewById(R.id.viewPager);
        radioGroup = findViewById(R.id.radioGroup);


        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new InformationFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MineFragment());

    }


    //radioButton点击事件
    private void radioFragment() {
        //设置RadioGroup中button的点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int current = 0;
                switch (checkedId) {
                    case R.id.rb_fg_punch:
                        current = 0;
                        break;
                    case R.id.rb_fg_report:
                        current = 1;
                        break;
                    case R.id.rb_fg_msg:
                        current = 2;
                        break;

                    case R.id.rb_fg_mine:
                        current = 3;
                        break;
                }
                if (viewpager.getCurrentItem() != current) {
                    viewpager.setCurrentItem(current, false);
                }
            }
        });
    }



}
