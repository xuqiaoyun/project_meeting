package com.etc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.dao.EmployeeMapper;
import com.etc.entity.Employee;

@Service(value="empService")
public class EmployeeaService implements IEmployeeaService{
	
	@Resource(name="empDao")
	private EmployeeMapper empDao;
	

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Employee record) {
		// TODO Auto-generated method stub
		return empDao.insert(record);
	}

	@Override
	public int insertSelective(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
