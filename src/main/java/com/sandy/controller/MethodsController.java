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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liwy (lwy@hz.cn)
 * @description TODO
 * @date 2018/10/23 15:09
 * @since 1.0.0
 */
@Controller
@RequestMapping("/methods")
public class MethodsController {

    @RequestMapping(value ="/excute_methods", method = RequestMethod.POST)
    public String getMethodsByResourceId(HttpServletRequest request, ModelMap modelMap)
    {

        System.out.println(request.getParameter("port"));
        System.out.println(request.getParameter("environment"));
        String[] choices = request.getParameterValues("choicemethod");
        for(String value :choices){
            System.out.println(value);

       }
        return "caseresults" ;
    }

}
