package tech.tedybear.infocovid19.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tech.tedybear.infocovid19.R;
import tech.tedybear.infocovid19.adapter.HistoryListAdapter;
import tech.tedybear.infocovid19.model.RiwayatModel;
import tech.tedybear.infocovid19.viewmodel.RiwayatViewModel;

/*
 * Created by Mochammad Tedy Fazrin on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class RiwayatFragment extends Fragment {

    private HistoryListAdapter adapter;
    private ProgressDialog mProgressApp;

    public RiwayatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riwayat, container, false);

        mProgressApp = new ProgressDialog(getActivity());
        String wait = getString(R.string.please_wait);
        String display = getString(R.string.display_data);
        mProgressApp.setTitle(wait);
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage(display);

        RecyclerView recyclerView = view.findViewById(R.id.listRecycler);
        adapter = new HistoryListAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        loadListData();
        return view;
    }

    private void loadListData() {
        RiwayatViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(RiwayatViewModel.class);
        viewModel.setTodayData();
        mProgressApp.show();
        viewModel.getTodayListData().observe(this, new Observer<ArrayList<RiwayatModel>>() {
            @Override
            public void onChanged(ArrayList<RiwayatModel> riwayatModels) {
                adapter.setRiwayatModels(riwayatModels);
                mProgressApp.dismiss();
            }
        });
    }
}
