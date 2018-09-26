package com.sandy.controller;

import com.sandy.service.UserService;
import com.sandy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void UserLoginController(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String login_username = request.getParameter("login_username");
        String login_pwd = request.getParameter("login_pwd");
        if (userService.UserLogin(login_username, login_pwd) != null){
            //request.getSession().setAttribute("", );
            request.getRequestDispatcher("/WEB-INF/views/domain.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("/WEB-INF/views/domain.jsp").forward(request, response);

    }


}
