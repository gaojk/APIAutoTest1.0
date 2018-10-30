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
 * @ClassName: ResourceController
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */


@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private MethodService methodService;

    @RequestMapping(value="/get_methods_by_id",method = RequestMethod.GET)
    public String getMethodByResourceId(@RequestParam(value = "resourceId")Long resourceId, ModelMap modelMap){
        List<Method> methodList = methodService.getMethodsByResourceId(resourceId);
        modelMap.addAttribute("methods",methodList);
        return "methods";
    }

}
