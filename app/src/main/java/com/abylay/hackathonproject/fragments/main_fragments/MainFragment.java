package com.abylay.hackathonproject.fragments.main_fragments;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abylay.hackathonproject.R;
import com.abylay.hackathonproject.adapters.MainAdapter;
import com.abylay.hackathonproject.models.MainModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainAdapter.MainListener {

    public MainFragment() { }

    @BindView(R.id.rvMain) RecyclerView rvMain;
    @BindView(R.id.homeConst) ConstraintLayout homeConst;

    private MainAdapter adapter;
    private List<MainModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        filList();

        homeConst.getLayoutParams().height = height();

        adapter = new MainAdapter(list, this);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rvMain.setLayoutManager(manager);
        rvMain.setHasFixedSize(true);
        rvMain.setAdapter(adapter);

        return view;
    }

    private int height() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }


    private void filList() {
        list.add(new MainModel("Дом", R.drawable.home_main));
        list.add(new MainModel("Участок", R.drawable.place_main));
        list.add(new MainModel("Квартира", R.drawable.key_main));
        list.add(new MainModel("Ремонт", R.drawable.calendar_main));
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void setItemSize(View itemView) {
        setSize(itemView);
    }

    private void setSize(View itemView) {
        int width = rvMain.getWidth();
        itemView.getLayoutParams().width = width / 2 - 10;
        itemView.getLayoutParams().height = width / 2 - 10;
    }
}
