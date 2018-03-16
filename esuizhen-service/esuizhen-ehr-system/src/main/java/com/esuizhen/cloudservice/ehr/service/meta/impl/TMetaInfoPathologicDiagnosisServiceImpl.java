package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoPathologicDiagnosisDao;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoPathologicDiagnosis;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoPathologicDiagnosisService;


@Service("metaInfoPathologicDiagnosisService")
public class TMetaInfoPathologicDiagnosisServiceImpl implements
		TMetaInfoPathologicDiagnosisService<TMetaInfoPathologicDiagnosis> {
	
	@Autowired
	private TMetaInfoPathologicDiagnosisDao<TMetaInfoPathologicDiagnosis> metaInfoPathologicDiagnosisDao;

	@Override
	public List<TMetaInfoPathologicDiagnosis> queryListLike(String searchItem) {
		StringBuffer sb = new StringBuffer(); 
		String[] items = searchItem.split(" ");
		for(String item : items) {
			if(!item.trim().equals("")){
				sb.append("%").append(item).append("%");
			}
		}
		Map<String,String> searchItemMap = new HashMap<String,String>();
		searchItemMap.put("searchItem", sb.toString());
		return metaInfoPathologicDiagnosisDao.queryListLike(searchItemMap);
	}

}
