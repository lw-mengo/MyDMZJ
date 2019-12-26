package com.study.mydmzj.recommend_fragments;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.study.mydmzj.beans.LatestData;
import com.study.mydmzj.httpservice.DataCallback;
import com.study.mydmzj.repository.RecommendRepository;

import java.util.List;

import javax.inject.Inject;

public class UpdateViewModel extends ViewModel implements DataCallback<List<LatestData>> {
    private MutableLiveData<List<LatestData>> listMutableLiveData;

    @Inject
    RecommendRepository repository;

    @Inject
    public UpdateViewModel(RecommendRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<LatestData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadLatestData(this);
        }
        return listMutableLiveData;
    }

    @Override
    public void success(List<LatestData> data) {
        this.listMutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
}
