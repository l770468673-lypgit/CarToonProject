package com.example.liuya.cartoonproject;


import android.widget.RadioGroup;

import com.example.liuya.cartoonproject.Base.BaseActivity;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_btn;


    @Override
    protected int getContentResid() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        rg_btn = (RadioGroup) findViewById(R.id.rg_btn);
        rg_btn.setOnCheckedChangeListener(this);

        rg_btn.getChildAt(0).performClick();//模拟点击第一个RB
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


        switch (checkedId){

            case R.id.btn1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new ShouYeFrgment()).commit();

                break;
            case R.id.btn2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new FenLei()).commit();
                break;
            case R.id.btn3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new GuanLi()).commit();
                break;

        }
    }
}
