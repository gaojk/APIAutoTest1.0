package com.sandy.service;

import com.sandy.domain.Method;
import com.sandy.domain.Testcase;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: MethodService
 * @Author sandy.n.hao
 * @Date: 2019/01/11
 * @Version v1.0.0
 * @Description: //TODO
 */

public interface CaseService {

    Map<Long, List<Testcase>> getCaseByMethodId(List<Method> methodList);
}
