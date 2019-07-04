package com.example.lenovo.tourism.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.lenovo.tourism.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Adapter.Beijing;
import Adapter.BeijingAdapter;
import Adapter.Yunnan;
import Adapter.YunnanAdapter;


public class BannerGallery_yunnan extends Activity {
private List<Yunnan> yunnanList=new ArrayList<>();
//定义beijing的泛型
//private List<Beijing> beijingList=new ArrayList<>();
//    private String[] data={
//  "Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apples","Apples","Apples","Apples","Apples","Apples"
//};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_gallery_yunnan);
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(BannerGallery.this,android.R.layout.simple_list_item_1,data);

        /**
         * 初始化yunnan数据以及实例化适配器
         * */
        initYunan();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_view_yunnan);
        //LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        YunnanAdapter adapter=new YunnanAdapter(yunnanList);
        recyclerView.setAdapter(adapter);
//        BeijingAdapter adapter=new BeijingAdapter(BannerGallery.this,R.layout.beijing_item,beijingList);
//        ListView  listView=(ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
    private  void initYunan(){
        for (int i=0;i<2;i++)
        {
            Yunnan yunnan1=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan1);
            yunnanList.add(yunnan1);
            Yunnan yunnan2=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan2);
            yunnanList.add(yunnan2);
            Yunnan yunnan3=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan3);
            yunnanList.add(yunnan3);
            Yunnan yunnan4=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan4);
            yunnanList.add(yunnan4);
            Yunnan yunnan5=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan5);
            yunnanList.add(yunnan5);
            Yunnan yunnan6=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan6);
            yunnanList.add(yunnan6);
            Yunnan yunnan7=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan7);
            yunnanList.add(yunnan7);
            Yunnan yunnan8=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan8);
            yunnanList.add(yunnan8);
            Yunnan yunnan9=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan9);
            yunnanList.add(yunnan9);
            Yunnan yunnan10=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan10);
            yunnanList.add(yunnan10);
            Yunnan yunnan11=new Yunnan(getRandomLengthName("yunnan"),R.mipmap.yunnan11);
            yunnanList.add(yunnan11);
        }

    }
    private  String getRandomLengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<builder.length();i++)
            builder.append(name);
        return  builder.toString();
    }
}
