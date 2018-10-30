package com.sandy.dao;

import com.sandy.domain.Method;

import java.util.List;

public interface MethodMapper {

    int deleteByPrimaryKey(Long sysno);

    int insert(Method record);

    int insertSelective(Method record);

    Method selectByPrimaryKey(Long sysno);

    int updateByPrimaryKeySelective(Method record);

    int updateByPrimaryKey(Method record);

    List<Method> selectMethodByRoesourceId(Long resourceId);
}