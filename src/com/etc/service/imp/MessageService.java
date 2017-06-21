package com.etc.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.MessageMapper;
import com.etc.dao.MessageStatusMapper;
import com.etc.entity.Message;
import com.etc.entity.MessageStatus;
import com.etc.service.IMessageService;

@Service(value = "messageService")
public class MessageService implements IMessageService {
	@Resource(name = "messageMapper")
	private MessageMapper messageMapper;

	public MessageMapper getMessageMapper() {
		return messageMapper;
	}

	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	@Resource(name = "messageStatusMapper")
	private MessageStatusMapper messageStatusMapper;

	public MessageStatusMapper getMessageStatusMapper() {
		return messageStatusMapper;
	}

	public void setMessageStatusMapper(MessageStatusMapper messageStatusMapper) {
		this.messageStatusMapper = messageStatusMapper;
	}

	/**
	 * 增加留言
	 */
	@Transactional
	public boolean addMessage(List<Message> list) {
		//添加数据
		boolean flag = messageMapper.addMessage(list) > 0;
		//刷新阅读记录
		int meetingId=list.get(0).getMeetingid();
		String sendId=list.get(0).getSendid().toString();
		MessageStatus ms=new MessageStatus();
		ms.setId(meetingId);
		ms.setReadid(sendId);
		messageStatusMapper.updateByPrimaryKey(ms);
		return flag;
	}

	/**
	 * 修改留言
	 */
	@Transactional
	public boolean updateMessage(Message message) {
		boolean flag = messageMapper.updateByPrimaryKey(message) > 0;
		return flag;

	}

	/**
	 * 删除留言
	 */
	@Transactional
	public boolean deleteMessageById(List<String> list) {
		boolean flag = messageMapper.deleteMessageById(list) > 0;
		return flag;
	}

	/**
	 * 查询会议留言
	 */
	@Transactional
	public Map selectMessageByAll(Map map) {
		// 页数
		int page = Integer.parseInt(map.get("page").toString());
		// 每页记录数
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		// 获取用户id用来判断是否已经读过信息
		String sendId = map.get("employeeId").toString();
		// 判断是否是big页
		if (map.get("big") != null) {
			// 开始记录数
			int start = (page - 1) * pageSize;
			// 查询所有会议聊天记录
			List<MessageStatus> list = messageStatusMapper
					.selectMessageStatus();
			// 未读新信息数
			List<Message> list0 = new ArrayList<Message>();
			// 已读信息数
			List<Message> list1 = new ArrayList<Message>();
			map.put("collectionid", sendId);
			map.put("start", 0);
			map.put("pageSize", 99999);
			// 查询所有会议的最后一条信息
			List<Message> list_message = messageMapper.selectMessageByAll(map);
			for (Message message : list_message) {

				int meetingid = message.getMeetingid();
				// 查询该会议信息是否已经阅读
				String str[] = messageStatusMapper
						.selectByPrimaryKey(meetingid).getReadid().split(",");
				// 记录是否有员工
				boolean iId = false;
				// 判断是否已经读过该会议

				for (String string : str) {
					if (string.equals(sendId)) {
						// 如果iId为true则说明已经被查询
						iId = true;
					}
				}

				if (iId) {
					// 已读信息
					list1.add(message);
				} else {
					// 未读信息
					list0.add(message);
				}
			}
			// 返回信息
			List<Message> listRe = new ArrayList<Message>();
			// 判断显示类型
			// 当未读条数大于显示数时
			if (list0.size() >= (start + pageSize)) {
				for (int i = start; i < pageSize; i++) {
					listRe.add(list0.get(i));
				}
			} else if (start < list0.size()
					&& list0.size() < (start + pageSize)) {
				// 当未读条数在显示和未显示中间时
				for (int i = start; i < list0.size(); i++) {
					listRe.add(list0.get(i));
				}
				for (int i = 0; i < (start + pageSize - list0.size()); i++) {
					listRe.add(list1.get(i));
				}

			} else if (start >= list0.size()) {
				// 当未读条数小于未显示数
				for (int i = start - list0.size(); i < pageSize; i++) {
					listRe.add(list1.get(i));
				}
			}
			Map mapRe = new HashMap();
			mapRe.put("total", list_message.size());
			mapRe.put("data", listRe);
			return mapRe;
		} else {
			System.out.println(0);
			// 当用户点进会议查看详细聊天记录的时候
			// 获取会议id
			int meetingId = Integer.parseInt(map.get("meetingId").toString());
			// 获取开始信息
			int start = (page - 1) * pageSize;
			map.put("start", start);
			map.put("pageSize", pageSize);
			List<Message> list = messageMapper.selectMessageByAll(map);
			// 查询消息总数
			map.put("start", 0);
			map.put("pageSize", 99999);
			List<Message> listAll = messageMapper.selectMessageByAll(map);
			//修改记录读取状态
			//获取记录表记录数据
			MessageStatus messageStatus=messageStatusMapper.selectByPrimaryKey(meetingId);
			//拆分数据
			String str=messageStatus.getReadid();	
			//存储查询对象
			if(str.equals("")){
				str=sendId.toString();
			}else{
				//判断是否已经读过
				String string[]=str.split(",");
				//记录判断
				boolean flag=false;
				for (String string2 : string) {
					if(string2.equals(sendId.toString())){
						flag=true;
						break;
					}
				}
				if(!flag){
					str=str+","+sendId.toString();
				}				
			}		
			//修改messageStatus对象
			messageStatus.setReadid(str);
			//修改数据库messageStatus对象
			messageStatusMapper.updateByPrimaryKey(messageStatus);
			Map reMap = new HashMap();
			reMap.put("total", listAll.size());
			reMap.put("data", list);
			return reMap;
		}

	}
}
