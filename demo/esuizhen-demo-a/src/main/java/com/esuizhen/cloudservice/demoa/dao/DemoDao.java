package com.esuizhen.cloudservice.demoa.dao;

import java.util.List;

import com.esuizhen.cloudservice.demoa.bean.User;
import com.esuizhen.cloudservice.demoa.model.UpdateBean;

public interface DemoDao
{
	 public List<User> selectUser(); 
	 
	 public void addUpdate(UpdateBean bean); 
	 
	 public void addUpdateList(List<UpdateBean> list); 
}
