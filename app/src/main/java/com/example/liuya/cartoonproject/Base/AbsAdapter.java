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
 * Created by liuya on 2016/3/10.
 */
public abstract class AbsAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> datas;
    private int resid;

    public AbsAdapter(Context context, int resid){
        this.context = context;
        this.resid = resid;
        datas = new ArrayList<>();
    }

    public void setDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addDatas(List<T> datas){
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
            convertView = LayoutInflater.from(context).inflate(resid, parent, false);
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
//        public ViewHolder bindImageView(int id, String url){
//            ImageViewChange iv = (ImageViewChange) this.getView(id);
//            //iv.setImageResource(R.drawable.news_default_img);
//            iv.setImageurl(url);
//            return this;
//        }


    }

}
