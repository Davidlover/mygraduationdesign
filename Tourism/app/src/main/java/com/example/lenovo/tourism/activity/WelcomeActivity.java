package com.example.lenovo.tourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lenovo.tourism.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BasicActivity {
/**延迟三秒
 * 跳转页面
 * */
private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();

    }
    /**
     * 跳转到主页
     * */
    private void  init(){
        mTimer=new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
             Log.e("welcome","当前线程为："+Thread.currentThread());
             toLogin();
            }
        },3*1000);

    }
    private void toLogin(){
        Intent intent_tologin=new Intent(this,LoginActivity.class);
        startActivity(intent_tologin);
        finish();
    }
}
