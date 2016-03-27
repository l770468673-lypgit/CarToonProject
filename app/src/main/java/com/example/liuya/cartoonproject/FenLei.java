package com.example.liuya.cartoonproject;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.liuya.cartoonproject.Base.BaseFragment;

/**
 * Created by liuya on 2016/3/27.
 */
public class FenLei extends BaseFragment {
    private RecyclerView recyclerView;
    @Override
    protected int getContentResid() {
        return R.layout.fenlei;

    }

    @Override
    protected void init(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        // 设置布局管理器
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4,RecyclerView.VERTICAL,false));
        // 设置适配器

     //   recyclerView.setAdapter();

    }
}
