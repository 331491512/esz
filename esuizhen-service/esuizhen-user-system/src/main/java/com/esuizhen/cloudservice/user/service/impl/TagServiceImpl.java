package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.bean.Tag;
import com.esuizhen.cloudservice.user.dao.TagDao;
import com.esuizhen.cloudservice.user.service.TagService;


@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao dao;
	
	@Override
	public List<Tag> findmenuTagList(Map<String, Object> searchParams) {
		List<Tag> diseaseTagList = this.dao.findmenuTagList(searchParams);
		return diseaseTagList;
	}
}
