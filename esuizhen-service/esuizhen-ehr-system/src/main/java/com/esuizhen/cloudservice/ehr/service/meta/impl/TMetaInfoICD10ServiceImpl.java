package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoICD10Dao;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoICD10;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoICD10Service;


@Service("metaInfoICD10Service")
public class TMetaInfoICD10ServiceImpl implements TMetaInfoICD10Service<TMetaInfoICD10> {

	@Autowired
	private TMetaInfoICD10Dao<TMetaInfoICD10> metaInfoICD10Dao;
	
	@Override
	public List<TMetaInfoICD10> queryListLike(String searchItem) {
		StringBuffer sb = new StringBuffer(); 
		String[] items = searchItem.split(" ");
		for(String item : items) {
			if(!item.trim().equals("")){
				sb.append("%").append(item).append("%");
			}
		}
		Map<String,String> searchItemMap = new HashMap<String,String>();
		searchItemMap.put("searchItem", sb.toString());
		return metaInfoICD10Dao.queryTumorListLike(searchItemMap);
		// return
		// metaInfoICD10Dao.queryListLike(searchItemMap);
	}

}
