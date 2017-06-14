package com.etc.dao;

import com.etc.entity.Dinnertype;

public interface DinnertypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dinnertype record);

    int insertSelective(Dinnertype record);

    Dinnertype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dinnertype record);

    int updateByPrimaryKey(Dinnertype record);
}