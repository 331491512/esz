package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoICDODao;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoICDO;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoICDOService;


@Service("metaInfoICDOService")
public class TMetaInfoICDOServiceImpl implements TMetaInfoICDOService<TMetaInfoICDO> {
	
	@Autowired
	private TMetaInfoICDODao<TMetaInfoICDO> MetaInfoICDODao;

	@Override
	public List<TMetaInfoICDO> queryListLike(String searchItem) {
		StringBuffer sb = new StringBuffer(); 
		String[] items = searchItem.split(" ");
		for(String item : items) {
			if(!item.trim().equals("")){
				sb.append("%").append(item).append("%");
			}
		}
		Map<String,String> searchItemMap = new HashMap<String,String>();
		searchItemMap.put("searchItem", sb.toString());
		return MetaInfoICDODao.queryListLike(searchItemMap);
	}

}
