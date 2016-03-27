package com.example.liuya.cartoonproject.Base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ken on 2016/3/8.
 * 重构的适配器 -- 适用于ListView的分类多布局适配器
 */
public abstract class AbsMoreBaseAdapter<T> extends BaseAdapter{

    private Context context;
    protected List<T> datas;
    private int[] resid;

    public AbsMoreBaseAdapter(Context context, int... resid){
        this.context = context;
        this.resid = resid;
        datas = new ArrayList<>();
    }

    public void setDates(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDates(List<T> datas){
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(resid[getItemViewType(position)], parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        //数据绑定
        bindDatas(viewHolder, datas.get(position), position);

        return convertView;
    }

    protected abstract void bindDatas(ViewHolder viewHolder, T data, int position);

    /**
     * ViewHolder主要用于缓存布局中的控件，避免多次findViewByID
     */
    public class ViewHolder{
        //缓存控件的集合
        Map<Integer, View> cachemap = new HashMap<>();
        //item布局对象
        View layoutView;

        public ViewHolder(View layoutView){
            this.layoutView = layoutView;
        }

        public View getView(int id){
            if(cachemap.containsKey(id)){
                return cachemap.get(id);
            } else {
                View view = layoutView.findViewById(id);
                cachemap.put(id, view);
                return view;
            }
        }

        /**
         * textview绑定数据的封装
         * @param id
         * @param data
         * @return
         */
        public ViewHolder bindTextView(int id, String data){
            TextView tv = (TextView) this.getView(id);
            tv.setText(data);
            return this;
        }

        /**
         * ImageViewChangede  的数据绑定
         * @param id
         * @param url
         * @return
         */

    }

    @Override
    public int getViewTypeCount() {
        return resid.length;
    }
}
