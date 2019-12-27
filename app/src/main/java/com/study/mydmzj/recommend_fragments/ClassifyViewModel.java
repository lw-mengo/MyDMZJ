package com.study.mydmzj.recommend_fragments;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.study.mydmzj.beans.ClassifyData;
import com.study.mydmzj.httpservice.DataCallback;
import com.study.mydmzj.repository.RecommendRepository;

import java.util.List;

import javax.inject.Inject;

public class ClassifyViewModel extends ViewModel implements DataCallback<List<ClassifyData>> {
    private MutableLiveData<List<ClassifyData>> listMutableLiveData;


    public MutableLiveData<List<ClassifyData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadClassifyData(this);
        }
        return listMutableLiveData;
    }

    @Inject
    RecommendRepository repository;

    @Inject
    public ClassifyViewModel(RecommendRepository repository) {
        this.repository = repository;
    }

    @Override
    public void success(List<ClassifyData> data) {
        this.listMutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }

}
