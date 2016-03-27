package com.example.liuya.cartoonproject.Base;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by liuya on 2016/3/8.
 */
public abstract class BaseActivity extends AppCompatActivity {



    protected abstract int getContentResid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResid());
        init();
        loadDatas();
    }

    /**
     * 初始化
     */
    protected void init() {

    }

    /**
     * 数据加载
     */
    protected void loadDatas() {

    }


    /**
     * k开场动画
     *
     * @param intent
     * @param enterAnim
     * @param exitAnim
     */
    public void startActivity(Intent intent, int enterAnim, int exitAnim) {
        super.startActivity(intent);
        overridePendingTransition(enterAnim, exitAnim);
    }


}

