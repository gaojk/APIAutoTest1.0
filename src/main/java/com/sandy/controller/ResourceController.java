/*
 * 四川恒智科技有限公司
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */
package com.sandy.controller;

import com.sandy.domain.Method;
import com.sandy.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author liwy (lwy@hz.cn)
 * @description TODO
 * @date 2018/10/23 15:09
 * @since 1.0.0
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {


    @Autowired
    private MethodService methodService ;
    /**
     * 根据产品线列表查询所有的用例方法
     * @param resourceId
     * @return
     */
    @RequestMapping(value ="/get_methods_by_id", method = RequestMethod.GET)
    public String getMethodsByResourceId(@RequestParam(value = "resourceId")Long resourceId ,ModelMap modelMap)
    {
       List<Method> methodList = methodService.getMethodsByResourceId(resourceId);
       modelMap.addAttribute("methods", methodList);
       return "methods" ;
    }
}
