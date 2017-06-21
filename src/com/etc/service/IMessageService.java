package com.etc.service;

import java.util.List;
import java.util.Map;

import com.etc.entity.Message;

public interface IMessageService {
	public boolean addMessage(List<Message> list);
	public boolean updateMessage(Message message);
	public boolean deleteMessageById(List<String> array);
	public Map selectMessageByAll(Map map);
}
