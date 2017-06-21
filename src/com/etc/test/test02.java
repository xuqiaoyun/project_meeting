package com.etc.test;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.entity.Message;
import com.etc.service.IMessageService;

public class test02 {
	IMessageService ims;

	@Before
	public void before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ims = (IMessageService) context.getBean("messageService");
	}

	@Test
	public void test() {
		Message m = new Message();
		m.setContentfact("45454");
		m.setMeetingid(1);
		m.setCollectionid(1);
		m.setSendid(1);
		m.setMlocaltime(new Date(0).toString());
		m.setStatus(0);
		List<Message> list=new ArrayList<Message>();
		list.add(m);
		ims.addMessage(list);
/*		Map map=new HashMap();
		map.put("meetingId", 1);
		map.put("collectionid", 1);
		map.put("start", 0);
		map.put("pageSize",3);		
		System.out.println(ims.selectMessageByAll(map).get(0));	*/
/*		Map map=new HashMap();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("employeeId", 2);
		map.put("meetingId", 1);
		Map mapRe=ims.selectMessageByAll(map);
		System.out.println(((List<Message>)mapRe.get("data")).get(2).getContentfact());*/
	}
	@After
	public void after() {
		System.out.println("Ω· ¯¡À");
	}
}
