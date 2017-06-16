package com.etc.dao;

import org.springframework.stereotype.Repository;

import com.etc.entity.Dept;
@Repository(value="deptMapper")
public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}