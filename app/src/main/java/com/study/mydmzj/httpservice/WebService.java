package com.study.mydmzj.httpservice;

import com.study.mydmzj.beans.LatestData;
import com.study.mydmzj.beans.RecommendData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET(value = "recommend_new_game.json")
    Call<List<RecommendData>> getRecommendData();

    @GET(value = "latest/100/0.json?timestamp=1577337349&channel=Android&_debug=0&version=2.7.023")
    Call<List<LatestData>> getLatestData();

}
