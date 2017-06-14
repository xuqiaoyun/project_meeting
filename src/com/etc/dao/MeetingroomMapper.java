package com.etc.dao;

import com.etc.entity.Meetingroom;

public interface MeetingroomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meetingroom record);

    int insertSelective(Meetingroom record);

    Meetingroom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meetingroom record);

    int updateByPrimaryKey(Meetingroom record);
}