package com.example.liuya.cartoonproject.Bean;

/**
 * Created by liuya on 2016/3/27.
 */
public class Bean_fenlei {
/*
*         "name": "冒险",
        "icon": "http://biggame1.b0.upaiyun.com/imgv/752840b946bd0215dba114bdc78b4ea1.jpg"*/
    private String name;
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Bean_fenlei{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
