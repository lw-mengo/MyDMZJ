package com.study.mydmzj.httpservice;

import com.study.mydmzj.beans.ClassifyData;
import com.study.mydmzj.beans.LatestData;
import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.beans.TopicData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    /**
     * @return获取推荐首页的数据
     */
    @GET(value = "recommend_new_game.json")
    Call<List<RecommendData>> getRecommendData();

    /**
     * 获取最新页面的数据（是一个漫画更新的列表）
     */
    @GET(value = "latest/100/0.json?timestamp=1577337349&channel=Android&_debug=0&version=2.7.023")
    Call<List<LatestData>> getLatestData();

    /**
     * 获取一个分类页面的数据（是一个索引/搜索的功能）
     */
    @GET(value = "http://v3api.dmzj.com/0/category.json?timestamp=1577337597&channel=Android&_debug=0&version=2.7.023")
    Call<List<ClassifyData>> getClassifyData();

    /**
     * 专题页面的数据（新闻类汇总）
     */
    @GET(value = "http://v3api.dmzj.com/subject/0/0.json?timestamp=1577337789&channel=Android&_debug=0&version=2.7.023")
    Call<List<TopicData>> getTopicData();

}
