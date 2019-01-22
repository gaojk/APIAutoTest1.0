package com.sandy.service.impl;

import com.sandy.dao.AppMapper;
import com.sandy.domain.App;
import com.sandy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MethodService
 * @Author sandy.n.hao
 * @Date: 2019/01/16
 * @Version v1.0.0
 * @Description: //TODO
 */

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Override
    public List<App> getAppByUserId(Long userId){

        List<App> app = appMapper.selectByUserId(userId);

        return app;
    }

    @Override
    public App getAppByAppId(Long appId) {

        App app = appMapper.selectByPrimaryKey(appId);

        return app;
    }
}
