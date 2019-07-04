package com.example.lenovo.tourism.activity.City;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.tourism.R;

public class CityContentFragment extends Fragment {
private View view;
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    view=inflater.inflate(R.layout.strategy_content,container,false);
    return view;
}
    public  void refresh(String newsTitle,String newsContent){
    View visiilityLayout=view.findViewById(R.id.visibility_layout);
    visiilityLayout.setVisibility(View.VISIBLE);
    TextView cityTitleText=(TextView) view.findViewById(R.id.city_title);
    TextView  cityContent=(TextView)view.findViewById(R.id.city_content);
    /**
     * 刷新攻略内容
     * */
    cityTitleText.setText(newsTitle);
    cityContent.setText(newsContent);
    }


}
