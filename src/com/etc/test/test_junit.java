package com.etc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.entity.Meeting;
import com.etc.service.IMeetingService;
import com.etc.util.PageData;


public class test_junit {

		IMeetingService bs = null;

		@Before
		public void before() {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			bs = (IMeetingService) context.getBean("meetingService");
		}

		@Test
		public void test() {
			PageData pd = bs.selectByPage(0, 3, "");
			List<Meeting> list = pd.getData();
			for (Meeting user : list) {
				
				System.out.println(user);
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	
	
}
