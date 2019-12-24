package com.study.mydmzj.recommend_fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.mydmzj.R;
import com.study.mydmzj.adapters.RecommendRecycleViewAdapter;
import com.study.mydmzj.beans.RecommendData;

import java.util.List;

public class RecommendFragment extends Fragment {

    private RecommendViewModel mViewModel;

    private RecyclerView recyclerView;

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
        mViewModel = ViewModelProviders.of(this).get(RecommendViewModel.class);
        RecommendRecycleViewAdapter adapter = new RecommendRecycleViewAdapter(requireActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        mViewModel.getLiveData().observe(this, recommendData -> {
            adapter.setRecommendData(recommendData);
            adapter.notifyDataSetChanged();

        });
    }

}
