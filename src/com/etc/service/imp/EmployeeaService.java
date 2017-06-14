package com.etc.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etc.entity.Employee;
import com.etc.mapper.EmployeeMapper;
import com.etc.service.IEmployeeaService;

@Service("empService")
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
