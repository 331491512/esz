package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoDiagnosisBasisDao;
import com.esuizhen.cloudservice.ehr.model.meta.SpecialDiseaseDiagnosisMeta;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDiagnosisBasis;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoDiagnosisBasisService;


@Service("metaInfoDiagnosisBasisService")
public class TMetaInfoDiagnosisBasisServiceImpl implements
		TMetaInfoDiagnosisBasisService<TMetaInfoDiagnosisBasis> {
	
	@Autowired
	private TMetaInfoDiagnosisBasisDao<TMetaInfoDiagnosisBasis> metaInfoDiagnosisBasisDao;

	@Override
	public List<SpecialDiseaseDiagnosisMeta> getSpecialDiseaseDiagnosisMeta(
			String searchItem) {
		StringBuffer sb = new StringBuffer(); 
		String[] items = searchItem.split(" ");
		for(String item : items) {
			if(!item.trim().equals("")){
				sb.append("%").append(item).append("%");
			}
		}
		Map<String,String> searchItemMap = new HashMap<String,String>();
		searchItemMap.put("searchItem", sb.toString());
		List<SpecialDiseaseDiagnosisMeta> list = metaInfoDiagnosisBasisDao.getSpecialDiseaseDiagnosisMeta(searchItemMap);
		return list;
	}

}
