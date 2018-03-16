package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.MetaDataUserDefinedDao;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.westangel.common.bean.UserDefinedMetaData;

@Service
public class MetaDataUserDefinedServiceImpl implements MetaDataUserDefinedService{

	@Autowired
	private MetaDataUserDefinedDao metaDataUserDefinedDao;
	
	@Override
	public int addMetaDateInIntKey(UserDefinedMetaData metaData) {
		List<Integer> mainKeyList = this.metaDataUserDefinedDao.getMetaDataListByNameToInt(metaData);
		if(mainKeyList!=null&&mainKeyList.size()>0&&mainKeyList.get(0)!=null){
			Integer realMainKey = mainKeyList.get(0);
			metaData.setMainKey(realMainKey.toString());
			Integer useCount=this.metaDataUserDefinedDao.getUseCount(metaData);
			metaData.setUseCount(useCount+1);
			this.metaDataUserDefinedDao.updateMetaData(metaData);
			return realMainKey;
		}else{
			metaData.setMainKey(null);
			metaData.setMainKeyField(null);
			this.metaDataUserDefinedDao.insertMetaData(metaData);
			return metaData.getId();
		}
	}
	
	
	@Override
	public String addMetaDateInStrKey(UserDefinedMetaData metaData) {
		List<String> mainKeyList = this.metaDataUserDefinedDao.getMetaDataListByNameToStr(metaData);
		if(mainKeyList!=null&&mainKeyList.size()>0&&mainKeyList.get(0)!=null){
			String realMainKey = mainKeyList.get(0);
			metaData.setMainKey(realMainKey.toString());
			Integer useCount=this.metaDataUserDefinedDao.getUseCount(metaData);
			metaData.setUseCount(useCount+1);
			this.metaDataUserDefinedDao.updateMetaData(metaData);
			return realMainKey;
		}else{
			this.metaDataUserDefinedDao.insertMetaData(metaData);
			return metaData.getMainKey();
		}
	}
	
	
	public int addMetaDate(String mainKey,String metaName, String parentKey, Long creator) {
		UserDefinedMetaData metaData=new UserDefinedMetaData();
		metaData.setMainKey(mainKey);
		metaData.setMetaName(metaName);
		metaData.setCreator(creator);
		metaData.setParentKey(parentKey);
		metaData.setMetaDataTable("meta_e_detection_item");
		metaData.setMainKeyField("detectionItemId");
		metaData.setMetaNameField("detectionItemName");
		metaData.setParentKeyField("detectionTypeId");
		return this.addMetaDateInIntKey(metaData);
	}
}
