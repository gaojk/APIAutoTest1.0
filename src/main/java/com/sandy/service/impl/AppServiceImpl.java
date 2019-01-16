package com.sandy.service.impl;

import com.sandy.dao.AppMapper;
import com.sandy.domain.App;
import com.sandy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public App getAppByUserId(Long userId){

        App app = appMapper.selectByUserId(userId);

        return app;
    }
}
