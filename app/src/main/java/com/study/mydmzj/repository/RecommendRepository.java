package com.study.mydmzj.repository;

import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.httpservice.DataCallback;
import com.study.mydmzj.httpservice.WebService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 数据仓库，为view model提供数据来源
 */
public class RecommendRepository {

    private final WebService mwebService;
    @Inject
    public RecommendRepository(WebService mwebService) {
        this.mwebService = mwebService;

    }
    public void loadData(DataCallback<List<RecommendData>> dataCallback) {
        mwebService.getRecommendData().enqueue(new Callback<List<RecommendData>>() {
            @Override
            public void onResponse(Call<List<RecommendData>> call, Response<List<RecommendData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<RecommendData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

}
