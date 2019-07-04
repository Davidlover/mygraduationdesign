package com.example.lenovo.tourism.activity.City;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lenovo.tourism.R;

public class StrategyContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String cityTitle, String cityContent) {
        Intent intent = new Intent(context, StrategyContentActivity.class);
        intent.putExtra("city_title", cityTitle);
        intent.putExtra("city_content", cityContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.city_content);
        /**
         * 获取传入的标题以及内容
         * */
        String cityTitle = getIntent().getStringExtra("city_title");
        String cityContent = getIntent().getStringExtra("city_content");


     // replacementFragment(new CityTitleFragment());
        CityContentFragment cityContentFragment = (CityContentFragment) getSupportFragmentManager().findFragmentById(R.id.city_content_fragment);
        assert cityContentFragment != null;
        cityContentFragment.refresh(cityTitle, cityContent);//刷新内容界面
    }


    private void replacementFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frag, new CityTitleFragment());
        fragmentTransaction.commit();
    }
}
