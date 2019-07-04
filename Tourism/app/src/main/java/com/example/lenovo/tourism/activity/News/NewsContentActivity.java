package com.example.lenovo.tourism.activity.News;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

import com.example.lenovo.tourism.R;
import com.example.lenovo.tourism.activity.City.CityTitleFragment;

public class NewsContentActivity extends AppCompatActivity {

    public  static  void actionStart(Context context, String newsTitle,String newsContent)
    {
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle=getIntent().getStringExtra("news_title");
        String newsContent=getIntent().getStringExtra("news_content");
//        NewsContentFragment newsContentFragment=(NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
//
//        newsContentFragment.refresh(newsTitle,newsContent);
        replacementFragment(new NewsTitleFragment());
    }


    private void replacementFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frag, new NewsTitleFragment());
        fragmentTransaction.commit();
    }
}
