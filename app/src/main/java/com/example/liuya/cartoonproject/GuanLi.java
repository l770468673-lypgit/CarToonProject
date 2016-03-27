package com.example.liuya.cartoonproject;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuya.cartoonproject.Base.BaseFragment;

/**
 * Created by liuya on 2016/3/27.
 */
public class GuanLi extends BaseFragment implements View.OnClickListener {

    private TextView tv;
    @Override
    protected int getContentResid() {

        return R.layout.guanli;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        tv= (TextView)view.findViewById(R.id.tv_guanli);
        tv.setOnClickListener(this);
    }

    // text view  的点击事件
    @Override
    public void onClick(View v) {

        Toast.makeText(getActivity(), "点击收藏", Toast.LENGTH_SHORT).show();
    }
}
