package com.sandy.service.impl;

import com.sandy.dao.DomainMapper;
import com.sandy.dao.UserMapper;
import com.sandy.domain.Domain;
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
    private DomainMapper domainMapper;

    @Override
    public User UserLogin(String loginName, String loginPassword) {

        User user =  userMapper.selectByNameAndPwd(loginName, loginPassword);
        if (user != null){
            Long userId = user.getSysno();
            List<Domain> domainList = domainMapper.selectDomainByUserId(userId);
            user.setDomainList(domainList);
        }
        return user;
    }
}
