package com.study.mydmzj.recommend_fragments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.utils.DataManager;

import java.util.List;

import javax.inject.Inject;

public class RecommendViewModel extends ViewModel {

    private MutableLiveData<List<RecommendData>> liveData;

    @Inject
    DataManager dataManager;


    public MutableLiveData<List<RecommendData>> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            loadData();
        }
        return liveData;
    }

    private void loadData() {
        liveData.setValue(dataManager.getRecentData());

    }
}
