package com.esuizhen.cloudservice.demoa.service;

import java.util.List;

import com.esuizhen.cloudservice.demoa.bean.User;
import com.esuizhen.cloudservice.demoa.model.UpdateBean;


public interface UserService
{
	
	public String getName();
	
	public User queryUser(); 
	
	public void addUpdate(UpdateBean bean); 

	public void addUpdateList(List<UpdateBean> addList); 
}
