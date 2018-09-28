package com.sandy.controller;

import com.sandy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: UserController
 * @Author sandy.n.hao
 * @Date: 2018/9/25
 * @Version v1.0.0
 * @Description: //TODO
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String UserLoginController(@RequestParam(value = "login_username")String login_username, @RequestParam(value = "login_pwd")String login_pwd, ModelMap modelMap)
    {
        if (userService.UserLogin(login_username, login_pwd) != null){
            modelMap.addAttribute("domain","集采，商城，收验货");
            return "domain";
        }else
            return "login";

    }

}
