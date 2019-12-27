package com.study.mydmzj.recommend_fragments;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.study.mydmzj.beans.TopicData;
import com.study.mydmzj.httpservice.DataCallback;
import com.study.mydmzj.repository.RecommendRepository;
import java.util.List;
import javax.inject.Inject;

public class TopicViewModel extends ViewModel implements DataCallback<List<TopicData>> {
    private MutableLiveData<List<TopicData>> listMutableLiveData;

    @Inject
    RecommendRepository repository;

    @Inject
    public TopicViewModel(RecommendRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<TopicData>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            repository.loadTopicData(this);
        }
        return listMutableLiveData;
    }

    @Override
    public void success(List<TopicData> data) {
        this.listMutableLiveData.setValue(data);
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
}
