package com.esuizhen.cloudservice.followup.service.conf.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.bean.TFollowupConfigDiseaseType;
import com.esuizhen.cloudservice.followup.bean.TFollowupRangeIcdCodeText;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupRangeDiseaseTypeDao;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupRangeIcdDao;
import com.esuizhen.cloudservice.followup.service.conf.FollowupRangeService;
import com.esuizhen.cloudservice.followup.util.UtilValidate;

@Service
public class FollowupRangeServiceImpl implements FollowupRangeService {
	@Autowired
	private FollowupRangeDiseaseTypeDao followupRangeDiseaseTypeDao;
	
	@Autowired
	private FollowupRangeIcdDao followupRangeIcdDao;

	@Transactional
	@Override
	public void saveFollowupConfigDiseaseType(List<TFollowupConfigDiseaseType> followupConfigDiseaseTypeList) {
		this.followupRangeDiseaseTypeDao.deleteAllFollowupDiseaseType();
		this.followupRangeDiseaseTypeDao.batchInsertFollowupDiseaseType(followupConfigDiseaseTypeList);
		
	}

	@Override
	public List<TFollowupConfigDiseaseType> getFollowupConfigDiseaseTypeList() {
		return this.followupRangeDiseaseTypeDao.queryAllFollowupDiseaseType();
	}

	@Override
	public List<TFollowupRangeIcdCodeText> getFollowupConfigIcdCodeList() {
		return this.followupRangeIcdDao.queryAllFollowupRangeIcdCodeText();
	}

	@Transactional
	@Override
	public void saveFollowupConfigIcdCode(List<TFollowupRangeIcdCodeText> followupRangeIcdCodeTextList) {
		//删除已存在范围并保存现编码范围文本
		this.followupRangeIcdDao.deleteAllFollowupRangeIcdCodeText();
		this.followupRangeIcdDao.deleteAllFollowupRangeIcd();
		this.followupRangeIcdDao.deleteAllFollowupRangeIcdCode();
		this.followupRangeIcdDao.batchInsertFollowupRangeIcdCodeText(followupRangeIcdCodeTextList);
		
		//循环保存病种或编码范围
		boolean isIcd=false;
		for(TFollowupRangeIcdCodeText icdCode:followupRangeIcdCodeTextList){
			isIcd=this.isConfFollowupRangeIcd(icdCode.getDiseaseCodeStart(), icdCode.getDiseaseCodeEnd(), icdCode.getType());
			if(isIcd){
				this.followupRangeIcdDao.batchInsertFollowupRangeIcd(icdCode);
			}else{
				this.followupRangeIcdDao.batchInsertFollowupRangeIcdCode(icdCode);
			}
		}
	}
	
	private boolean isConfFollowupRangeIcd(String codeStart,String codeEnd,Integer type){
		boolean result=false;
		Map<String,Object> tempStart=this.followupRangeIcdDao.queryDiseaseTypeIcdByCode(codeStart);
		Map<String,Object> tempEnd=this.followupRangeIcdDao.queryDiseaseTypeIcdByCode(codeEnd);
		if(type==0 && UtilValidate.isNotEmpty(tempStart)){
			result=true;
		}else if(type==1 && UtilValidate.isNotEmpty(tempStart) && UtilValidate.isNotEmpty(tempEnd)){
			result=true;
		}else if(codeStart.length()==3 && UtilValidate.isNotEmpty(codeEnd) && codeEnd.length()==3){
			result=true;
		}
		return result;
	}
	
}
