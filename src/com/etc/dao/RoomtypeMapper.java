package com.etc.dao;

import com.etc.entity.Roomtype;

public interface RoomtypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Roomtype record);

    int insertSelective(Roomtype record);

    Roomtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roomtype record);

    int updateByPrimaryKey(Roomtype record);
}