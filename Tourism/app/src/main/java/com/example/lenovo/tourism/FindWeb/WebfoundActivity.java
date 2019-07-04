package com.example.lenovo.tourism.FindWeb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lenovo.tourism.R;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class WebfoundActivity extends AppCompatActivity {
    private List<Web> webList = new ArrayList<>();
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webfound);
        webView = (WebView) findViewById(R.id.web_view);
        RecyclerView recyclerView = findViewById(R.id.recyclerView_web);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        initweb();
        recyclerView.setLayoutManager(layoutManager);
        WebAdapter adapter = new WebAdapter(webList, this);
        recyclerView.setAdapter(adapter);

//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://mail.qq.com/");


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.getVisibility() == VISIBLE) {
                webView.setVisibility(GONE);
                return false;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public WebView getWebview() {
        return webView;
    }

    private void initweb() {
        for (int i = 0; i < 1; i++) {
            Web web1 = new Web("马蜂窝", R.drawable.mafengwo);
            webList.add(web1);
            Web web2 = new Web("Airbnb民宿", R.drawable.aibiyin);
            webList.add(web2);
            Web web3 = new Web("携程", R.drawable.xiecheng);
            webList.add(web3);
            Web web4 = new Web("去哪儿", R.drawable.qunaer);
            webList.add(web4);
            Web web5 = new Web("艺龙", R.drawable.yilong);
            webList.add(web5);
            Web web6 = new Web("途牛旅游", R.drawable.tuniu);
            webList.add(web6);
            Web web7 = new Web("驴妈妈", R.drawable.lvmama);
            webList.add(web7);

            Web web8 = new Web("Booking精品酒店", R.drawable.booking);
            webList.add(web8);
            Web web9 = new Web("飞猪旅行", R.drawable.feizhu);
            webList.add(web9);
            Web web10 = new Web("同程旅游", R.drawable.tongchenglvyou);
            webList.add(web10);
            Web web11 = new Web("金马国旅", R.drawable.jinmaguolv);
            webList.add(web11);
        }
    }
}
