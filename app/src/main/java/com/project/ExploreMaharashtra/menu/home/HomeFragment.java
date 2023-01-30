package com.project.ExploreMaharashtra.menu.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.ExploreMaharashtra.R;
import com.project.ExploreMaharashtra.menu.home.adapter.HomeAdapter;
import com.project.ExploreMaharashtra.menu.home.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private HomeAdapter homeAdapter;
    private List<HomeModel> homeModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();
    }

    private void initData() {
        homeModelList = new ArrayList<>();

        homeModelList.add(new HomeModel(R.drawable.bmcmumbai, "BMC UrbsPrima Heritage Walk", "", "Mumbai"));
        homeModelList.add(new HomeModel(R.drawable.kothaligadtrek, "Trek To Kothalgad", "", "Karjat"));
        homeModelList.add(new HomeModel(R.drawable.boatclub, "BOAT CLUB", "", "Nashik"));
        homeModelList.add(new HomeModel(R.drawable.matheran, "Matheran", "", "Raigad"));
        homeModelList.add(new HomeModel(R.drawable.caravan, "Caravan", "", "Mumbai"));
        homeModelList.add(new HomeModel(R.drawable.alibag, "Alibag", "", "Raigad"));

    }

    private void setAdapterType(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_recommended);
        layoutManager = new LinearLayoutManager(mContext);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setNestedScrollingEnabled(true);
    }

    private void setAdapter() {
        initData();

        homeAdapter = new HomeAdapter(homeModelList);
        recyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}