package com.etc.dao;

import com.etc.entity.Meetingtype;

public interface MeetingtypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meetingtype record);

    int insertSelective(Meetingtype record);

    Meetingtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meetingtype record);

    int updateByPrimaryKey(Meetingtype record);
}