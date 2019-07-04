package com.example.lenovo.tourism;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.tourism.FindWeb.WebfoundActivity;
import com.example.lenovo.tourism.activity.ChangeActivity;
import com.example.lenovo.tourism.activity.MainActivity;
import com.example.lenovo.tourism.activity.Mycirle.LbsActivity;
import com.example.lenovo.tourism.activity.Mycirle.Travel_diary;
import com.example.lenovo.tourism.activity.newmodel.MomentActivity;
import com.example.lenovo.tourism.activity.yaweather.WeatherActivity;

import Adapter.YunnanAdapter;
import ui.Sent_Strategy_MainActivity;


public class yunanFragment extends Fragment {

    public static  int  youjinum=0,tianqinum=0,changenum=0;

    public yunanFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static yunanFragment newInstance() {
        yunanFragment fragment = new yunanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        ImageView imageView0 =view.findViewById(R.id.home_1);
        imageView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Sent_Strategy_MainActivity.class);
                startActivity(intent);
            }
        });


        ImageView imageView =view.findViewById(R.id.home_2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),WeatherActivity.class);
                tianqinum++;
                startActivity(intent);
            }
        });

//        ImageView imageView1=view.findViewById(R.id.home_2);
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getActivity(),LbsActivity.class);
//                startActivity(intent);
//            }
//        });
        ImageView imageView2=view.findViewById(R.id.home_3);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Travel_diary.class);
                youjinum++;
                startActivity(intent);
            }
        });
        ImageView imageView3=view.findViewById(R.id.home_4);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MomentActivity.class);
                startActivity(intent);
            }
        });

        ImageView imageView4=view.findViewById(R.id.home_5);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ChangeActivity.class);
                changenum++;
                startActivity(intent);
            }
        });
        ImageView imageView7=view.findViewById(R.id.home_6);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),WebfoundActivity.class);
                startActivity(intent);
            }
        });
//        RecyclerView recyclerView = view.findViewById(R.id.rv_yunnan);
//        YunnanAdapter yunnanAdapter =new YunnanAdapter();
//        recyclerView.setAdapter(yunnanAdapter);
        return view;
    }


}
