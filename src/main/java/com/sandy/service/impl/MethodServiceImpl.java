package com.sandy.service.impl;

import com.sandy.dao.MethodMapper;
import com.sandy.domain.Method;
import com.sandy.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MethodServiceImpl
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */

@Service
public class MethodServiceImpl implements MethodService {

    @Autowired
    private MethodMapper methodMapper;

    @Override
    public List<Method> getMethodsByResourceId(Long resourceId){
         List<Method> methodList = methodMapper.selectMethodByRoesourceId(resourceId);
         return methodList;
    }

}
