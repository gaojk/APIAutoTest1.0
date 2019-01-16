package com.sandy.service;

import com.sandy.domain.App;
import com.sandy.domain.Method;

import java.util.List;

/**
 * @ClassName: MethodService
 * @Author sandy.n.hao
 * @Date: 2019/01/16
 * @Version v1.0.0
 * @Description: //TODO
 */

public interface AppService {

     App getAppByUserId(Long userId);
}
