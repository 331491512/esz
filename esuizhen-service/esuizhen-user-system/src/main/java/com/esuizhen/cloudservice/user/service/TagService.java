package com.esuizhen.cloudservice.user.service;

import java.util.List; 
import java.util.Map;



import com.esuizhen.cloudservice.user.bean.Tag;

public interface TagService {

	List<Tag> findmenuTagList(Map<String, Object> searchParams);

	
}
