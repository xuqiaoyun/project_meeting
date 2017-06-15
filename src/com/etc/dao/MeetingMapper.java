package com.etc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.etc.entity.Meeting;
import com.etc.util.PageBean;

@Repository("meetingDao")
public interface MeetingMapper {
    int deleteByPrimaryKey(Integer id);

    boolean insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
    
    List<Meeting> selectMeetingByPage(PageBean pb);
    
    int selectMeetingCount(PageBean pb);
    
}