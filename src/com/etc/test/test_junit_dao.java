package com.etc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.dao.MeetingMapper;
import com.etc.entity.Meeting;
import com.etc.service.IMeetingService;
import com.etc.util.PageBean;
import com.etc.util.PageData;


public class test_junit_dao {

		MeetingMapper bs = null;

		@Before
		public void before() {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			bs = (MeetingMapper) context.getBean("meetingDao");
		}

		@Test
		public void test() {
			PageBean pb=new PageBean(1, 2, "");
			List<Meeting> list=bs.selectMeetingByPage(pb);
			System.out.println(list.size());
			for (Meeting user : list) {
				System.out.println(user);
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	
	
}
