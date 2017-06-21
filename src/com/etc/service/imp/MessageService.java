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
	 * ��������
	 */
	@Transactional
	public boolean addMessage(List<Message> list) {
		//�������
		boolean flag = messageMapper.addMessage(list) > 0;
		//ˢ���Ķ���¼
		int meetingId=list.get(0).getMeetingid();
		String sendId=list.get(0).getSendid().toString();
		MessageStatus ms=new MessageStatus();
		ms.setId(meetingId);
		ms.setReadid(sendId);
		messageStatusMapper.updateByPrimaryKey(ms);
		return flag;
	}

	/**
	 * �޸�����
	 */
	@Transactional
	public boolean updateMessage(Message message) {
		boolean flag = messageMapper.updateByPrimaryKey(message) > 0;
		return flag;

	}

	/**
	 * ɾ������
	 */
	@Transactional
	public boolean deleteMessageById(List<String> list) {
		boolean flag = messageMapper.deleteMessageById(list) > 0;
		return flag;
	}

	/**
	 * ��ѯ��������
	 */
	@Transactional
	public Map selectMessageByAll(Map map) {
		// ҳ��
		int page = Integer.parseInt(map.get("page").toString());
		// ÿҳ��¼��
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		// ��ȡ�û�id�����ж��Ƿ��Ѿ�������Ϣ
		String sendId = map.get("employeeId").toString();
		// �ж��Ƿ���bigҳ
		if (map.get("big") != null) {
			// ��ʼ��¼��
			int start = (page - 1) * pageSize;
			// ��ѯ���л��������¼
			List<MessageStatus> list = messageStatusMapper
					.selectMessageStatus();
			// δ������Ϣ��
			List<Message> list0 = new ArrayList<Message>();
			// �Ѷ���Ϣ��
			List<Message> list1 = new ArrayList<Message>();
			map.put("collectionid", sendId);
			map.put("start", 0);
			map.put("pageSize", 99999);
			// ��ѯ���л�������һ����Ϣ
			List<Message> list_message = messageMapper.selectMessageByAll(map);
			for (Message message : list_message) {

				int meetingid = message.getMeetingid();
				// ��ѯ�û�����Ϣ�Ƿ��Ѿ��Ķ�
				String str[] = messageStatusMapper
						.selectByPrimaryKey(meetingid).getReadid().split(",");
				// ��¼�Ƿ���Ա��
				boolean iId = false;
				// �ж��Ƿ��Ѿ������û���

				for (String string : str) {
					if (string.equals(sendId)) {
						// ���iIdΪtrue��˵���Ѿ�����ѯ
						iId = true;
					}
				}

				if (iId) {
					// �Ѷ���Ϣ
					list1.add(message);
				} else {
					// δ����Ϣ
					list0.add(message);
				}
			}
			// ������Ϣ
			List<Message> listRe = new ArrayList<Message>();
			// �ж���ʾ����
			// ��δ������������ʾ��ʱ
			if (list0.size() >= (start + pageSize)) {
				for (int i = start; i < pageSize; i++) {
					listRe.add(list0.get(i));
				}
			} else if (start < list0.size()
					&& list0.size() < (start + pageSize)) {
				// ��δ����������ʾ��δ��ʾ�м�ʱ
				for (int i = start; i < list0.size(); i++) {
					listRe.add(list0.get(i));
				}
				for (int i = 0; i < (start + pageSize - list0.size()); i++) {
					listRe.add(list1.get(i));
				}

			} else if (start >= list0.size()) {
				// ��δ������С��δ��ʾ��
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
			// ���û��������鿴��ϸ�����¼��ʱ��
			// ��ȡ����id
			int meetingId = Integer.parseInt(map.get("meetingId").toString());
			// ��ȡ��ʼ��Ϣ
			int start = (page - 1) * pageSize;
			map.put("start", start);
			map.put("pageSize", pageSize);
			List<Message> list = messageMapper.selectMessageByAll(map);
			// ��ѯ��Ϣ����
			map.put("start", 0);
			map.put("pageSize", 99999);
			List<Message> listAll = messageMapper.selectMessageByAll(map);
			//�޸ļ�¼��ȡ״̬
			//��ȡ��¼���¼����
			MessageStatus messageStatus=messageStatusMapper.selectByPrimaryKey(meetingId);
			//�������
			String str=messageStatus.getReadid();	
			//�洢��ѯ����
			if(str.equals("")){
				str=sendId.toString();
			}else{
				//�ж��Ƿ��Ѿ�����
				String string[]=str.split(",");
				//��¼�ж�
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
			//�޸�messageStatus����
			messageStatus.setReadid(str);
			//�޸����ݿ�messageStatus����
			messageStatusMapper.updateByPrimaryKey(messageStatus);
			Map reMap = new HashMap();
			reMap.put("total", listAll.size());
			reMap.put("data", list);
			return reMap;
		}

	}
}
