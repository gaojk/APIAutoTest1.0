package com.sandy.controller;

import com.sandy.service.CaseService;
import com.sandy.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: ResourceController
 * @Author sandy.n.hao
 * @Date: 2019/01/15
 * @Version v1.0.0
 * @Description: //TODO
 */


@Controller
@RequestMapping("/method")
public class MethodController {

    @Autowired
    private MethodService methodService;

    @Autowired
    private CaseService caseService;

    @RequestMapping(value="/excute_methods",method = RequestMethod.POST)
    public void getMethodByResourceId(@RequestParam(value = "env")Long env,
                                      @RequestParam(value = "port")Long port, ModelMap modelMap)
    {

    }

}
