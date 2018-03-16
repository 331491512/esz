package com.esuizhen.cloudservice.demoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.esuizhen.cloudservice.demoa.bean.User;
import com.esuizhen.cloudservice.demoa.dao.DemoDao;
import com.esuizhen.cloudservice.demoa.model.UpdateBean;
import com.esuizhen.cloudservice.demoa.service.UserService;


public class UserServiceImpl implements UserService
{

	@Autowired
	private DemoDao dao;
	

	
	public User queryUser()
	{
		return dao.selectUser().get(0);
	}

	@Override
	public void addUpdate(UpdateBean bean)
	{
		dao.addUpdate(bean);
	}

	@Override
	public void addUpdateList(List<UpdateBean> addList)
	{
		dao.addUpdateList(addList);
	}

	@Override
	public String getName()
	{
		return "李四";
	}

	

}
