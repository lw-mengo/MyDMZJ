package com.study.mydmzj.httpservice;

import com.study.mydmzj.beans.ClassifyData;
import com.study.mydmzj.beans.ComicDetailData;
import com.study.mydmzj.beans.LatestData;
import com.study.mydmzj.beans.NewsBannerData;
import com.study.mydmzj.beans.NewsData;
import com.study.mydmzj.beans.NovelData;
import com.study.mydmzj.beans.RecommendData;
import com.study.mydmzj.beans.TopicData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
    @GET(value = "0/category.json?timestamp=1577337597&channel=Android&_debug=0&version=2.7.023")
    Call<List<ClassifyData>> getClassifyData();

    /**
     * 专题页面的数据（新闻类汇总）
     */
    @GET(value = "subject/0/0.json?timestamp=1577337789&channel=Android&_debug=0&version=2.7.023")
    Call<List<TopicData>> getTopicData();

    /**
     * 新闻页面的数据
     * 第一个是banner的数据，第二个是新闻列表
     */
    @GET(value = "v3/article/recommend/header.json?timestamp=1576929059&channel=Android&_debug=0&version=2.7.023")
    Call<NewsBannerData> getNewsBannerData();

    @GET(value = "v3/article/list/0/2/0.json?timestamp=1576929059&channel=Android&_debug=0&version=2.7.023")
    Call<List<NewsData>> getNewsData();

    /**
     * 小说页面数据
     */

    @GET(value = "novel/recommend.json?timestamp=1576929340&channel=Android&_debug=0&version=2.7.023")
    Call<List<NovelData>> getNovelData();

    /**
     * 二级目录，国产漫画的详情页面
     */
    @GET(value = "comic/comic_{obj_id}.json?timestamp=1577857740&channel=Android&_debug=0&version=2.7.023")
    Call<ComicDetailData> getComicDetailData(@Path("obj_id") int obj_id);

}
