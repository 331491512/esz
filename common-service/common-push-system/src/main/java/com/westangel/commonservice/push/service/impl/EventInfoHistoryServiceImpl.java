package com.westangel.commonservice.push.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.westangel.commonservice.push.dao.EventInfoHistoryDao;
import com.westangel.commonservice.push.model.EventInfoHistory;
import com.westangel.commonservice.push.service.EventInfoHistoryService;

@Service
@Transactional
public class EventInfoHistoryServiceImpl implements EventInfoHistoryService{
	
	@Autowired
	private EventInfoHistoryDao dao;
	
	@Override
	public void insertEventInfoHistory(EventInfoHistory eventInfoHistory)
	{
		dao.insertEventInfoHistory(eventInfoHistory);
	}
	
	@Override
	public void updateEventInfoHistory(EventInfoHistory eventInfoHistory)
	{
		dao.updateEventInfoHistory(eventInfoHistory);
	}
	
	@Override
	public void deleteEventInfoHistory(Long id)
	{
		dao.deleteEventInfoHistory(id);
	}
	
	@Override
	public EventInfoHistory queryEventInfoHistory(Long id)
	{
		return dao.queryEventInfoHistory(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<EventInfoHistory> eventinfoPull(Integer businessId, Integer productId, Long userId)
	{
		//查询拉取数据
		List<EventInfoHistory> list = dao.selectEventInfoHistoryList(businessId, productId, userId);
		
		//修改标志位
		dao.updateEventInfoHistoryByPushInfo(businessId, productId, userId);
		
		return list;
	}
	
}
