package com.etc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.etc.entity.Message;
@Repository(value="messageMapper")
public interface MessageMapper {
    int addMessage(List<Message> list);

    List<Message> selectMessageByAll(Map map);

    int updateByPrimaryKey(Message record);
    
    int deleteMessageById(List<String> list);
}