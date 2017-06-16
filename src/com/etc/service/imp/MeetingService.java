package com.etc.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.MeetingMapper;
import com.etc.entity.Meeting;
import com.etc.service.IMeetingService;
import com.etc.util.PageBean;
import com.etc.util.PageData;

@Service("meetingService")
public class MeetingService implements IMeetingService {

	@Resource(name = "meetingDao")
	private MeetingMapper meetingDao;

	@Override
	public PageData selectByPage(int page, int rows, String name) {
		// TODO Auto-generated method stub
		if (name == null)
			name = "";
		int start = 0;
		if (page > 1)
			start = (page - 1) * rows;

		// 此时需要根据page rows构建一个pageBean对象
		PageBean pb = new PageBean();
		pb.setRows(rows);
		pb.setPage(start);
		pb.setStr(name);
		List<Meeting> data = meetingDao.selectMeetingByPage(pb);
		int total = meetingDao.selectMeetingCount(pb);
		// 将集合对象 totoal的值 封装成一个PageData对象

		PageData pd = new PageData(data, total, rows,
				page);
		return pd;
	}

	@Override
	public boolean insertMeeting(Meeting pt) {
		
		return meetingDao.insert(pt);
	}

	@Override
	public boolean updateMeeting(Meeting pt) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
