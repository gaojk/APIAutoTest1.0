package com.sandy.service;

import com.sandy.domain.Method;

import java.util.List;

/**
 * @ClassName: MethodService
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */

public interface MethodService {

    List<Method> getMethodsByResourceId(Long resourceId);

}
