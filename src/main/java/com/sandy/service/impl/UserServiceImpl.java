package com.sandy.service.impl;

import com.sandy.dao.ResourceMapper;
import com.sandy.dao.UserMapper;
import com.sandy.domain.Resource;
import com.sandy.domain.User;
import com.sandy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public User UserLogin(String loginName, String loginPassword) {

        User user =  userMapper.selectByNameAndPwd(loginName, loginPassword);
        if (user != null){
            Long userId = user.getSysno();
            List<Resource> resourceList = resourceMapper.selectResourceByUserId(userId);
            user.setResourceList(resourceList);
        }
        return user;
    }
}
