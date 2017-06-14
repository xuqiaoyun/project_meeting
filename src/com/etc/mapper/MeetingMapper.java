package com.etc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.etc.entity.Meeting;
import com.etc.util.PageBean;

@Repository("meetingDao")
public interface MeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
    //∑÷“≥œ‘ æ
    List<Meeting> selectByPage(PageBean pd);
    
    int selectAccount (PageBean pd);
}