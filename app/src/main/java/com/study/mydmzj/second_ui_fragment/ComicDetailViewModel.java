package com.study.mydmzj.second_ui_fragment;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.study.mydmzj.beans.ComicDetailData;
import com.study.mydmzj.httpservice.DataCallback;
import com.study.mydmzj.repository.DataRepository;

import javax.inject.Inject;

public class ComicDetailViewModel extends ViewModel implements DataCallback<ComicDetailData> {
    @Inject
    DataRepository repository;

    @Inject
    public ComicDetailViewModel(DataRepository repository) {
        this.repository = repository;
    }

    private MutableLiveData<ComicDetailData> liveData;

//    private String description, author_notice, comic_notice;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getAuthor_notice() {
//        return author_notice;
//    }
//
//    public String getComic_notice() {
//        return comic_notice;
//    }

    public MutableLiveData<ComicDetailData> getLiveData(int obj_id) {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            repository.loadComicDetailData(this, obj_id);
        }
        return liveData;
    }

    @Override
    public void success(ComicDetailData data) {
        this.liveData.setValue(data);
//        this.comic_notice = data.getComic_notice();
//        this.author_notice = data.getAuthor_notice();
//        this.description = data.getDescription();
    }

    @Override
    public void failed(String result) {
        Log.d("error", "failed: " + result);
    }
    // TODO: Implement the ViewModel
}