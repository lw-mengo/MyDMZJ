package com.study.mydmzj.utils;

import android.util.Log;

import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.httpservice.WebService;
import com.study.mydmzj.repository.RecommendRepository;

import java.util.List;

import javax.inject.Inject;

public class DataManager {
    private final WebService service;

    @Inject
    public DataManager(RecommendRepository repository) {
        this.service = repository.getWebService();
    }

    public List<RecommendData> getRecentData() {
        String TAG = "log";
        Log.d(TAG, "getRecentData: this method is executed");
        List<RecommendData> dataBeans = service.getRecommendData();
        if (dataBeans == null||dataBeans.size()==0){
            Log.d(TAG, "getRecentData: the databeans have no data!");
        }
        return dataBeans;
    }


}
