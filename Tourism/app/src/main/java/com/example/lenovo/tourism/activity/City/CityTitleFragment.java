package com.example.lenovo.tourism.activity.City;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.tourism.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CityTitleFragment extends Fragment {
    private boolean isTwoPane;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.city_display, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.city_title_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        CityAdapter adapter = new CityAdapter(getCity());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<City> getCity() {
        List<City> cityList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            City city = new City();
            city.setC_name("Cityname" + i);
            city.setContent("content" + i);
            cityList.add(city);
        }
        return cityList;
    }


    /**
     * 兼容性处理
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

        private List<City> mCityList;

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView cityTitleText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cityTitleText = (TextView) itemView.findViewById(R.id.city_title);
            }
        }

        public CityAdapter(List<City> CityList) {
            mCityList = CityList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_item, viewGroup, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    City city = mCityList.get(holder.getAdapterPosition());


                    /**
                     * 直接启动CityContentActivity
                     * */

                  StrategyContentActivity.actionStart(getActivity(), city.getC_name(), city.getContent());
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull CityAdapter.ViewHolder viewHolder, int i) {
            City city = mCityList.get(i);
            viewHolder.cityTitleText.setText(city.getC_name());
        }

        @Override
        public int getItemCount() {
            return mCityList.size();
        }


    }


}
