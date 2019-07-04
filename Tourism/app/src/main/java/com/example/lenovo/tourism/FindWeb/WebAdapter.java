package com.example.lenovo.tourism.FindWeb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.tourism.R;

import java.util.List;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.ViewHolder> {
    private List<Web> mWebList;
    private WebfoundActivity webfoundActivity;
    private WebView webView;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        webView = webfoundActivity.getWebview();
//        webView.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.web_item, viewGroup, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position == 0) {
                    webView.loadUrl("http://www.mafengwo.cn/");
                    webView.setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    webView.loadUrl("https://www.airbnb.cn/");
                    webView.setVisibility(View.VISIBLE);
                } else if (position == 2) {
                    webView.loadUrl("https://www.ctrip.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 3) {
                    webView.loadUrl("https://www.qunar.com");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 4) {
                    webView.loadUrl("http://www.elong.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 5) {
                    webView.loadUrl("http://www.tuniu.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 6) {
                    webView.loadUrl("http://www.lvmama.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 7) {
                    webView.loadUrl("https://www.booking.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 8) {
                    webView.loadUrl("https://www.fliggy.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 9) {
                    webView.loadUrl("https://www.ly.com/");
                    webView.setVisibility(View.VISIBLE);
                }
                else if (position == 10) {
                    webView.loadUrl("http://www.jinmalvyou.com");
                    webView.setVisibility(View.VISIBLE);
                }
//                Web web = mWebList.get(position);
//                Toast.makeText(v.getContext(), "你点击了" + web.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    public WebAdapter(List<Web> WebList, WebfoundActivity webfoundActivity) {
        mWebList = WebList;
        this.webfoundActivity = webfoundActivity;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Web web = mWebList.get(i);
        viewHolder.webimage.setImageResource(web.getImageId());
        viewHolder.webname.setText(web.getName());
    }

    @Override
    public int getItemCount() {
        return mWebList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View webView;
        ImageView webimage;
        TextView webname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView;
            webimage = (ImageView) itemView.findViewById(R.id.web_image);
            webname = (TextView) itemView.findViewById(R.id.web_name);
        }
    }

}
