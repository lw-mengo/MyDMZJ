package com.study.mydmzj.dagger;

import com.study.mydmzj.httpservice.RetrofitUtil;
import com.study.mydmzj.httpservice.WebService;
import com.study.mydmzj.repository.RecommendRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * dagger的modules
 * 通过provider注解提供给目标对象需要的数据
 */
@Module
public class NetWorkModule {
    private WebService webService = new RetrofitUtil().create(WebService.class);

    /**
     * @return 返回了一个Webservice的实列
     */
    @Singleton
    @Provides
    public WebService providerWebService() {
        return webService;
    }


    @Singleton
    @Provides
    public RecommendRepository providerRepository() {
        return new RecommendRepository(webService);
    }

}
