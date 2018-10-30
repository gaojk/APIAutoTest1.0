package com.sandy.dao;

import com.sandy.domain.Role;

public interface RoleMapper {

    int deleteByPrimaryKey(Long sysno);


    int insert(Role record);


    int insertSelective(Role record);


    Role selectByPrimaryKey(Long sysno);


    int updateByPrimaryKeySelective(Role record);


    int updateByPrimaryKey(Role record);
}