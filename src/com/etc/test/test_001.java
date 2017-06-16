package com.etc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.dao.DeptMapper;
import com.etc.entity.Dept;

public class test_001 {
	DeptMapper dm;

	@Before
	public void before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		dm = (DeptMapper) context.getBean("deptMapper");
	}

	@Test
	public void test() {
		Dept d=new Dept();
		d.setName("Œ“");
		d.setRemarks("Œ“");
        dm.insert(d);
        
        
	}
}
