package com.study.mydmzj.dagger;

import com.study.mydmzj.MainActivity;
import com.study.mydmzj.recommend_fragments.ClassifyFragment;
import com.study.mydmzj.recommend_fragments.RecommendFragment;
import com.study.mydmzj.recommend_fragments.RecommendViewModel;
import com.study.mydmzj.recommend_fragments.TopicFragment;
import com.study.mydmzj.recommend_fragments.UpdateFragment;
import com.study.mydmzj.recommend_fragments.UpdateViewModel;
import com.study.mydmzj.ui_fargments.NewsFragment;
import com.study.mydmzj.ui_fargments.NovelFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 通过@contributesAndroidInjector注解来标记哪个类需要使用依赖注入功能
 */
@Module
abstract class RepositoryModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract RecommendFragment contributeRecommendFragment();

    @ContributesAndroidInjector
    abstract RecommendViewModel contributeRecommendViewModel();

    @ContributesAndroidInjector
    abstract UpdateFragment contributeUpdateFragment();

    @ContributesAndroidInjector
    abstract UpdateViewModel contributeUpdateViewModel();

    @ContributesAndroidInjector
    abstract ClassifyFragment contributeClassify();

    @ContributesAndroidInjector
    abstract TopicFragment topicFragment();

    @ContributesAndroidInjector
    abstract NewsFragment contributeNewsFragment();

    @ContributesAndroidInjector
    abstract NovelFragment contributeNovelFragment();

}
