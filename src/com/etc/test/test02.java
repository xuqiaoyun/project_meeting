package com.etc.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.dao.MessageMapper;
import com.etc.entity.Message;

public class test02 {
	MessageMapper dm;

	@Before
	public void before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dm = (MessageMapper) context.getBean("messageMapper");
	}

	@Test
	public void test() {
		Message m=new Message();
		m.setContentfact("45454");	
		m.setMeetingid(1);
		m.setCollectionid(1);	
		m.setSendid(2);
		m.setStatus(0);
        dm.insert(m);    
	}
	@After
	public void after() {
		System.out.println("Ω· ¯¡À");
	}
}
