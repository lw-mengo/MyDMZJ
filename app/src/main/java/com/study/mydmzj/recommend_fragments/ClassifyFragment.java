package com.study.mydmzj.recommend_fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.mydmzj.R;
import com.study.mydmzj.adapters.ClassifyRecyclerViewAdapter;
import com.study.mydmzj.beans.ClassifyData;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ClassifyFragment extends DaggerFragment {

    @Inject
    ClassifyViewModel mViewModel;

    private RecyclerView rv_classify;

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classify_fragment, container, false);
        rv_classify = view.findViewById(R.id.classify_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(ClassifyViewModel.class);
        rv_classify.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        ClassifyRecyclerViewAdapter adapter = new ClassifyRecyclerViewAdapter(requireContext());
        rv_classify.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        mViewModel.getListMutableLiveData().observe(this, classifyData -> {
            adapter.setList(classifyData);
            rv_classify.setAdapter(adapter);
        });
    }

}
