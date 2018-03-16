package com.esuizhen.cloudservice.demob.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.demoa.bean.User;
import com.esuizhen.cloudservice.demoa.service.UserService;
import com.esuizhen.cloudservice.demob.service.FollowupService;

@Service
public class FollowupServiceImpl implements FollowupService
{

	@Autowired
	private UserService userService;
	
	@Override
	public User getPatient()
	{
		return userService.queryUser();
	}

}
