package com.study.mydmzj.recommend_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.mydmzj.R;
import com.study.mydmzj.adapters.UpdateRecycleViewAdapter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class UpdateFragment extends DaggerFragment {

    @Inject
    UpdateViewModel mViewModel;

    private boolean rvTypeSwitch = false;
    private RecyclerView recyclerView;
    private ImageView imageView_rvSwitch;

    public static UpdateFragment newInstance() {
        return new UpdateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update_fragment, container, false);
        recyclerView = view.findViewById(R.id.comicList_rv);
        imageView_rvSwitch = view.findViewById(R.id.rv_switch_image);

        imageView_rvSwitch.setOnClickListener(v -> {
            if (v == imageView_rvSwitch) {
                if (rvTypeSwitch == false) {
                    rvTypeSwitch = true;
                    changeLayout(true);
                } else {
                    rvTypeSwitch = false;
                    changeLayout(false);
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(UpdateViewModel.class);
        UpdateRecycleViewAdapter adapter = new UpdateRecycleViewAdapter(requireContext(),1);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        mViewModel.getListMutableLiveData().observe(this, latestData -> {
            adapter.setLatestData(latestData);
            adapter.notifyDataSetChanged();
        });
    }


    private void changeLayout(boolean isChange) {
        if (isChange) {
            UpdateRecycleViewAdapter adapter2 = new UpdateRecycleViewAdapter(requireContext(),2);
            imageView_rvSwitch.setImageResource(R.drawable.rv_switch_two);
            recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
            recyclerView.setAdapter(adapter2);
            mViewModel.getListMutableLiveData().observe(this, latestData -> {
                adapter2.setLatestData(latestData);
                adapter2.notifyDataSetChanged();
            });
        } else {
            imageView_rvSwitch.setImageResource(R.drawable.rv_switch_one);
            UpdateRecycleViewAdapter adapter3 = new UpdateRecycleViewAdapter(requireContext(),1);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
            recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(adapter3);
            mViewModel.getListMutableLiveData().observe(this, latestData -> {
                adapter3.setLatestData(latestData);
                adapter3.notifyDataSetChanged();
            });

        }
    }

}
