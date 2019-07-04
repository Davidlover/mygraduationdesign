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
import Adapter.Hainan;
import Adapter.Yunnan;
import Adapter.hainanAdapter;


public class BannerGallery_hainan extends Activity {
private List<Hainan> hainanList=new ArrayList<>();
//定义beijing的泛型
//private List<Beijing> beijingList=new ArrayList<>();
//    private String[] data={
//  "Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apples","Apples","Apples","Apples","Apples","Apples"
//};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_gallery_hainan);
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(BannerGallery.this,android.R.layout.simple_list_item_1,data);

        /**
         * 初始化北京数据以及实例化适配器
         * */
        inirHainan();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_view_hainan);
        //LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        hainanAdapter adapter=new hainanAdapter(hainanList);
        recyclerView.setAdapter(adapter);
//        BeijingAdapter adapter=new BeijingAdapter(BannerGallery.this,R.layout.beijing_item,beijingList);
//        ListView  listView=(ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
    private  void inirHainan(){
        for (int i=0;i<2;i++)
        {
            Hainan hainan=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya1);
            hainanList.add(hainan);
            Hainan hainan1=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya2);
            hainanList.add(hainan1);
            Hainan hainan2=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya3);
            hainanList.add(hainan2);
            Hainan hainan3=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya4);
            hainanList.add(hainan3);
            Hainan hainan4=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya5);
            hainanList.add(hainan4);
            Hainan hainan5=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya6);
            hainanList.add(hainan5);
            Hainan hainan6=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya7);
            hainanList.add(hainan6);
            Hainan hainan7=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya8);
            hainanList.add(hainan7);
            Hainan hainan8=new Hainan(getRandomLengthName("beijing"),R.mipmap.sanya9);
            hainanList.add(hainan8);
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
