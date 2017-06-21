package com.etc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.service.IMessageService;
import com.etc.service.imp.MessageService;
@Controller
@RequestMapping(value="message")
public class messageController {
	@Resource(name = "messageService")
	private IMessageService messageService;

	public IMessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	@RequestMapping(value = "selectBig", method = RequestMethod.POST)
	@ResponseBody
	public Map selectByLike(@RequestBody Integer sendId,@RequestBody Integer pageSize,@RequestBody Integer page) {
		/*Employee emp=(Employee)request.getSession().getAttribute("emp");*/
		Map map=new HashMap();
		/*map.put("sendId", emp.getId());*/
		map.put("sendId", sendId);
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("big", 1);
		Map reMap=messageService.selectMessageByAll(map);
		return reMap;
	}

	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public boolean selectByEmailAndPassword(String username, String password,
			HttpServletRequest request) {
		Map map = employeeservice.selectByEmailAndPassword(username, password);
		boolean flag = false;
		if (map.get("flag").equals("true")) {
			request.getSession().setAttribute("emp", map.get("emp"));
			flag = true;
		}
		return flag;
	}

	@RequestMapping(value = "selectone", method = RequestMethod.POST)
	@ResponseBody
	public Employee selectOne(Integer id) {
		return employeeservice.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "selectemail", method = RequestMethod.POST)
	@ResponseBody
	public boolean selectByEmail(String email) {
		return employeeservice.selectByEmail(email);
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertMeeting(String email,String password) {
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setPassword(password);
		return employeeservice.insertSelective(emp);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteMeeting(String ids) {
		return employeeservice.deleteByPrimaryKey(ids);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateMeeting(Employee emp) {
		return employeeservice.updateByPrimaryKeySelective(emp);
	}
*/
}
