package com.study.mydmzj.recommend_fragments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.httpservice.DataCallback;
import com.study.mydmzj.repository.DataRepository;

import java.util.List;

import javax.inject.Inject;

public class RecommendViewModel extends ViewModel implements DataCallback<List<RecommendData>> {

    private MutableLiveData<List<RecommendData>> liveData;

    
    DataRepository repository;

    @Inject
    public RecommendViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<RecommendData>> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            repository.loadData(this);
        }
        return liveData;
    }

    @Override
    public void success(List<RecommendData> data) {
        this.liveData.setValue(data);

    }

    @Override
    public void failed(String result) {

    }
}
