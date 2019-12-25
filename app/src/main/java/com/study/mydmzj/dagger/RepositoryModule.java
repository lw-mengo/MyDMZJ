package com.study.mydmzj.dagger;

import com.study.mydmzj.MainActivity;
import com.study.mydmzj.recommend_fragments.RecommendFragment;
import com.study.mydmzj.recommend_fragments.RecommendViewModel;

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

}