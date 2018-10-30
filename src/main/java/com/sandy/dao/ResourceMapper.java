package com.sandy.dao;

import com.sandy.domain.Resource;

import java.util.List;

public interface ResourceMapper {

    int deleteByPrimaryKey(Long sysno);


    int insert(Resource record);


    int insertSelective(Resource record);


    Resource selectByPrimaryKey(Long sysno);


    int updateByPrimaryKeySelective(Resource record);


    int updateByPrimaryKey(Resource record);

    List<Resource> selectResourceByUserId(Long userId);
}