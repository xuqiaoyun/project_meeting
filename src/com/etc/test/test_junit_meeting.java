package com.etc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.entity.Employee;
import com.etc.entity.Meeting;
import com.etc.service.IEmployeeaService;
import com.etc.service.IMeetingService;

public class test_junit_meeting {

	IMeetingService ies = null;

	@Before
	public void before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ies = (IMeetingService) context.getBean("meetingService");
	}

	@Test
	public void test() {

		Meeting record = new Meeting();
		int n = ies.insert(record);
		System.out.println(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
