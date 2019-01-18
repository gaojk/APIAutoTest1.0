package com.sandy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: CategoryController
 * @Author sandy.n.hao
 * @Date: 2019-01-18
 * @Version v1.0.0
 * @Description: //TODO
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String getMethodByResourceId(@RequestParam(value = "url") String url, ModelMap modelMap) {

        switch (url) {

            case "OpenAPI":
                return "domainlist";

            case "Waiting":
                return "category";

            default:
                return "category";
        }

    }
}
