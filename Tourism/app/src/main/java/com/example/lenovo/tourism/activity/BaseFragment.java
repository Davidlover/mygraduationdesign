package com.example.lenovo.tourism.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.tourism.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.Me;
import Adapter.MeAdapter;
import Adapter.Yunnan;

/**
 * Created by bruce on 2016/11/1.
 * BaseFragment
 */

public class BaseFragment extends Fragment {
    private static final String HOME_KEY = "HOME";
    private static final String CIRCLE_KEY = "CIRCLE";
    private static final String ME_KEY = "ME";
    private View view;

    public static BaseFragment newInstance(@LayoutRes int layout_id) {
        Bundle bundle = new Bundle();
        BaseFragment fragment = new BaseFragment();
        bundle.putInt(HOME_KEY, layout_id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        assert getArguments() != null;
        view = inflater.inflate(getArguments().getInt(HOME_KEY), container, false);
        return view;
    }

}
