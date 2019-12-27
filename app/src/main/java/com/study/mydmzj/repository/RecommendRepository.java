package com.study.mydmzj.repository;

import com.study.mydmzj.beans.ClassifyData;
import com.study.mydmzj.beans.LatestData;
import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.beans.TopicData;
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

    /**
     * 获取推荐页的数据
     *
     * @param dataCallback 通用回调接口
     */
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

    /**
     * 获取更新页的数据
     */
    public void loadLatestData(DataCallback<List<LatestData>> dataCallback) {
        mwebService.getLatestData().enqueue(new Callback<List<LatestData>>() {
            @Override
            public void onResponse(Call<List<LatestData>> call, Response<List<LatestData>> response) {
                dataCallback.success(response.body());

            }

            @Override
            public void onFailure(Call<List<LatestData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 获取分类页的数据
     */
    public void loadClassifyData(DataCallback<List<ClassifyData>> dataCallback) {
        mwebService.getClassifyData().enqueue(new Callback<List<ClassifyData>>() {
            @Override
            public void onResponse(Call<List<ClassifyData>> call, Response<List<ClassifyData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<ClassifyData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }

    /**
     * 获取专题页的数据
     */
    public void loadTopicData(DataCallback<List<TopicData>> dataCallback) {
        mwebService.getTopicData().enqueue(new Callback<List<TopicData>>() {
            @Override
            public void onResponse(Call<List<TopicData>> call, Response<List<TopicData>> response) {
                dataCallback.success(response.body());
            }

            @Override
            public void onFailure(Call<List<TopicData>> call, Throwable t) {
                dataCallback.failed(t.toString());
            }
        });
    }


}
