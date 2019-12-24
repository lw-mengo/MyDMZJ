package com.study.mydmzj.dagger;

import android.app.Application;

import com.study.mydmzj.MyApplication;
import com.study.mydmzj.repository.RecommendRepository;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * 相当于一个注射器，之前定义的Modules就是被注射的类，使用@inject注入对象的地方就是接收者类
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        NetWorkModules.class,
        RepositoryModules.class})
public interface RepositoryComponent extends AndroidInjector<MyApplication> {

    RecommendRepository recommendRepository();

    @Component.Builder
    interface Builder {
        @BindsInstance
        RepositoryComponent.Builder repository(Application application);

        RepositoryComponent build();
    }
}
