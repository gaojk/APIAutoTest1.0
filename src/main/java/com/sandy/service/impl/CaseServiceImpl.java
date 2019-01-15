package com.sandy.service.impl;

import com.sandy.dao.MethodMapper;
import com.sandy.dao.TestcaseMapper;
import com.sandy.domain.Method;
import com.sandy.domain.Testcase;
import com.sandy.service.CaseService;
import com.sandy.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MethodServiceImpl
 * @Author sandy.n.hao
 * @Date: 2019/01/11
 * @Version v1.0.0
 * @Description: //TODO
 */

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private TestcaseMapper testcaseMapper;

    @Override
    public Map<Long, List<Testcase>> getCaseByMethodId(List<Method> methodList){

        Map<Long, List<Testcase>> caseList = new HashMap<>();

        for(int i=0; i<methodList.size(); i++){

            caseList.put(methodList.get(i).getSysno(), testcaseMapper.selectCaseByMethodId(methodList.get(i).getSysno()));

        }

        return caseList;
    }


}
