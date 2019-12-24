package com.study.mydmzj.dagger;

import com.study.mydmzj.httpservice.RetrofitUtil;
import com.study.mydmzj.httpservice.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * dagger的modules
 * 通过provider注解提供给目标对象需要的数据
 */
@Module
public class NetWorkModules {

    @Singleton
    @Provides
    public WebService providerWebService() {
        return RetrofitUtil.getInstance().create(WebService.class);
    }
}
