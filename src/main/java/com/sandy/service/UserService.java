package com.sandy.service;

import com.sandy.domain.User;

/**
 * @ClassName: UserService
 * @Author sandy.n.hao
 * @Date: 2018/9/25
 * @Version v1.0.0
 * @Description: //TODO
 */

public interface UserService {

    public User UserLogin(String loginName, String loginPassword);

}
