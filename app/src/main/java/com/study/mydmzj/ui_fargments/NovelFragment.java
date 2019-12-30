package com.study.mydmzj.ui_fargments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.mydmzj.R;
import com.study.mydmzj.adapters.NovelRecycleViewAdapter;
import com.study.mydmzj.beans.NovelData;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class NovelFragment extends DaggerFragment {
    @Inject
    NovelViewModel mViewModel;

    private RecyclerView recyclerView;

    public static NovelFragment newInstance() {
        return new NovelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.novel_fragment, container, false);
        recyclerView = view.findViewById(R.id.novel_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(NovelViewModel.class);
        NovelRecycleViewAdapter recycleViewAdapter = new NovelRecycleViewAdapter(requireContext());
        mViewModel.getMutableLiveData().observe(this, novelData -> {
            recycleViewAdapter.setDataList(novelData);
            recyclerView.setAdapter(recycleViewAdapter);
        });

    }

}
