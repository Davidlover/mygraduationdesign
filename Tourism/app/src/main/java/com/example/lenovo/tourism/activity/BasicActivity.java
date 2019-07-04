package com.example.lenovo.tourism.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.tourism.R;

public class BasicActivity extends Activity {


    private ImageView mIback,mIme;
    private TextView mItitle;
    /**
     * 初始化nav_bar
     * */
    protected <T extends View>T fd(@IdRes int id){
     return findViewById(id);
    }
    /**
     * 为了复用
     * */
    protected  void  initNavBar(boolean isShowBack,String title,boolean isshowme){
        mIback=findViewById(R.id.Imback);
        mIme=findViewById(R.id.Imme);
        mItitle=findViewById(R.id.Imtitle);
        mIback.setVisibility(isShowBack?View.VISIBLE:View.INVISIBLE);
        mIme.setVisibility(isshowme?View.VISIBLE:View.INVISIBLE);
        mItitle.setText(title);
        mIback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

    }

}
