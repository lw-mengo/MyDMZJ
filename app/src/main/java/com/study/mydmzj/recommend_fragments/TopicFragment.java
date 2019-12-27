package com.study.mydmzj.recommend_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.mydmzj.R;
import com.study.mydmzj.adapters.TopicRecycleViewAdapter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class TopicFragment extends DaggerFragment {
    @Inject
    TopicViewModel mViewModel;
    private RecyclerView topic_rv;

    public static TopicFragment newInstance() {
        return new TopicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topic_fragment, container, false);
        topic_rv = view.findViewById(R.id.topic_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        topic_rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        topic_rv.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        TopicRecycleViewAdapter adapter = new TopicRecycleViewAdapter(requireContext());
        mViewModel.getListMutableLiveData().observe(this, (dataList) -> {
            adapter.setDataList(dataList);
            topic_rv.setAdapter(adapter);
        });
    }

}
