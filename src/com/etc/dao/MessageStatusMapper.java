package com.etc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.etc.entity.MessageStatus;
@Repository(value="messageStatusMapper")
public interface MessageStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageStatus record);

    int insertSelective(MessageStatus record);

    MessageStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageStatus record);

    int updateByPrimaryKey(MessageStatus record);
    
    List<MessageStatus> selectMessageStatus();
}