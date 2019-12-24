package com.study.mydmzj.dagger;

import com.study.mydmzj.repository.RecommendRepository;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 通过@contributesAndroidInjector注解来标记哪个类需要使用依赖注入功能
 */
@Module
abstract class RepositoryModules {
    @ContributesAndroidInjector
    abstract RecommendRepository recommendRepository();
}
