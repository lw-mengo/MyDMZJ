package com.study.mydmzj.recommend_fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.mydmzj.R;
import com.study.mydmzj.adapters.RecommendRecycleViewAdapter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class RecommendFragment extends DaggerFragment {


    private RecyclerView recyclerView;

    @Inject
    RecommendViewModel viewModel;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_list_data_recommend);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecommendRecycleViewAdapter adapter = new RecommendRecycleViewAdapter(requireActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        viewModel.getLiveData().observe(this, recommendData -> {
            adapter.setRecommendData(recommendData);
            adapter.notifyDataSetChanged();
        });
    }

}
