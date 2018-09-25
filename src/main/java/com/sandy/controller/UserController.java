package com.sandy.controller;

import com.sandy.domain.User;
import com.sandy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: UserController
 * @Author sandy.n.hao
 * @Date: 2018/9/25
 * @Version v1.0.0
 * @Description: //TODO
 */

@Controller
@RequestMapping(value = "/login.jsp")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public UserLoginController(){
        if (userService.UserLogin() != null){
            //request.getSession().setAttribute("", );
            request.getRequestDispatcher("/WEB-INF/view/domain.jsp").forward(request,response);
        }else
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);

    }


}
