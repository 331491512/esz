package com.esuizhen.cloudservice.ehr.service.meta.userdefined.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.userdefined.MetaDataDao;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.westangel.common.bean.UserDefinedMetaData;

@Service
public class MetaDataServiceImpl implements MetaDataService{

	@Autowired
	private MetaDataDao metaDataDao;
	
	@Override
	public int addMetaDate(UserDefinedMetaData metaData) {
		List<Integer> mainKeyList = this.metaDataDao.getMetaDataCountByName(metaData);
		if(mainKeyList!=null&&mainKeyList.size()>0&&mainKeyList.get(0)!=null){
			Integer realMainKey = mainKeyList.get(0);
			metaData.setMainKey(realMainKey.toString());
			Integer useCount=this.metaDataDao.getUseCount(metaData);
			metaData.setUseCount(useCount+1);
			this.metaDataDao.updateMetaData(metaData);
			return realMainKey;
		}else{
			metaData.setMainKey(null);
			metaData.setMainKeyField(null);
			this.metaDataDao.insertMetaData(metaData);
			return metaData.getId();
		}
	}
	
}
