package com.etc.service;

import com.etc.entity.Meeting;
import com.etc.util.PageData;

/**
 * �Զ���ӿ�
 * 
 * @author Administrator
 * 
 */
public interface IMeetingService {

	/**
	 * 
	 * @param pb
	 * @return
	 */
	public PageData selectByPage(int page, int rows, String name);

	public boolean insertMeeting(Meeting pt);

	public boolean updateMeeting(Meeting pt);
	
	
}
