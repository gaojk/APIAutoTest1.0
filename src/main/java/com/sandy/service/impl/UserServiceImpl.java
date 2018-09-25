package com.sandy.service.impl;

import com.sandy.dao.UserMapper;
import com.sandy.domain.User;
import com.sandy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Author sandy.n.hao
 * @Date: 2018/9/25
 * @Version v1.0.0
 * @Description: //TODO
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User UserLogin(String loginname, String loginpassword) {
        User user = new User();
        user = userMapper.selectByNameAndPwd(loginname, loginpassword);
        return user;
    }
}
