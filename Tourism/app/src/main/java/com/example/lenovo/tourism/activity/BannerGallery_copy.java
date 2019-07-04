package com.example.lenovo.tourism.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.tourism.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.Beijing;
import Adapter.BeijingAdapter;
import Adapter.Home_icon_Adapter;
import Adapter.home_icon;

public class BannerGallery_copy extends Activity {
private List<home_icon> beijingList=new ArrayList<>();
//定义beijing的泛型
//private List<Beijing> beijingList=new ArrayList<>();
//    private String[] data={
//  "Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apples","Apples","Apples","Apples","Apples","Apples"
//};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_icon);
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(BannerGallery.this,android.R.layout.simple_list_item_1,data);

        /**
         * 初始化北京数据以及实例化适配器
         * */
       // initBeijing();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_view);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
       Home_icon_Adapter adapter=new Home_icon_Adapter(beijingList);
        recyclerView.setAdapter(adapter);
//        BeijingAdapter adapter=new BeijingAdapter(BannerGallery.this,R.layout.beijing_item,beijingList);
//        ListView  listView=(ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
//    private  void initBeijing(){
//        for (int i=0;i<2;i++)
//        {
//            Beijing beijing=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing);
//            Beijing beijing1=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing1);
//            Beijing beijing2=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing2);
//            Beijing beijing3=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing3);
//            Beijing beijing4=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing4);
//            Beijing beijing5=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing5);
//            Beijing beijing6=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing6);
//            Beijing beijing7=new Beijing("beijing",R.mipmap.beijing1);
//            beijingList.add(beijing7);
//        }
//    }
}
