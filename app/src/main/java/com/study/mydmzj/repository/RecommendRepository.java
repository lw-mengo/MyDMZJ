package com.study.mydmzj.repository;

import com.study.mydmzj.httpservice.WebService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 数据仓库，为view model提供数据来源
 */
@Singleton
public class RecommendRepository {
    private final WebService webService;

    public WebService getWebService() {
        return webService;
    }

    @Inject
    public RecommendRepository(WebService webService) {
        this.webService = webService;
    }
}
