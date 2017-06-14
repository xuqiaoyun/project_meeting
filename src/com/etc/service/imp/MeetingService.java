package com.etc.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.entity.Employee;
import com.etc.entity.Meeting;
import com.etc.mapper.MeetingMapper;
import com.etc.service.IMeetingService;

@Service("meetingService")
public class MeetingService implements IMeetingService{

	@Resource(name="meetingDao")
	private MeetingMapper mdao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Meeting record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Meeting record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Meeting selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Meeting record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Meeting record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
