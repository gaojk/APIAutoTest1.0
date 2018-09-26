package com.sandy.dao;

import com.sandy.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int deleteByPrimaryKey(Long sysno);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long sysno);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByNameAndPwd(@Param("loginName") String loginName, @Param("loginPassword") String loginPassword);
}