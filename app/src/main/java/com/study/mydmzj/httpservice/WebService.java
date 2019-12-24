package com.study.mydmzj.httpservice;

import com.study.mydmzj.beans.RecommendData;

import java.util.List;

import retrofit2.http.GET;

public interface WebService {

    @GET(value = "recommend_new_game.json")
    List<RecommendData> getRecommendData();
}
