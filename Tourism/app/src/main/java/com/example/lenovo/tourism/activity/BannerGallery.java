package com.example.lenovo.tourism.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.tourism.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Adapter.Beijing;
import Adapter.BeijingAdapter;

    public class BannerGallery extends Activity {
private List<Beijing> beijingList=new ArrayList<>();
//定义beijing的泛型
//private List<Beijing> beijingList=new ArrayList<>();
//    private String[] data={
//  "Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apple","Apples","Apples","Apples","Apples","Apples","Apples"
//};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_gallery);
       // ArrayAdapter<String> adapter=new ArrayAdapter<String>(BannerGallery.this,android.R.layout.simple_list_item_1,data);

        /**
         * 初始化北京数据以及实例化适配器
         * */
        initBeijing();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_view);
        //LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        BeijingAdapter adapter=new BeijingAdapter(beijingList);
        recyclerView.setAdapter(adapter);
//        BeijingAdapter adapter=new BeijingAdapter(BannerGallery.this,R.layout.beijing_item,beijingList);
//        ListView  listView=(ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
    private  void initBeijing(){
        for (int i=0;i<2;i++)
        {
            Beijing beijing=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing1);
            beijingList.add(beijing);
            Beijing beijing1=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing2);
            beijingList.add(beijing1);
            Beijing beijing2=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing3);
            beijingList.add(beijing2);
            Beijing beijing3=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing4);
            beijingList.add(beijing3);
            Beijing beijing4=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing5);
            beijingList.add(beijing4);
            Beijing beijing5=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing6);
            beijingList.add(beijing5);
            Beijing beijing6=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing7);
            beijingList.add(beijing6);
            Beijing beijing7=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing8);
            beijingList.add(beijing7);
            Beijing beijing8=new Beijing(getRandomLengthName("beijing"),R.mipmap.beijing9);
            beijingList.add(beijing8);
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
