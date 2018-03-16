package com.esuizhen.cloudservice.sync.service;


import java.text.ParseException; 
import java.util.List;

import com.esuizhen.cloudservice.sync.bean.MedicalRecordPost;
import com.esuizhen.cloudservice.sync.bean.MedicalRecordPostReq;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.westangel.common.excption.HospitalWithoutRightExcption;

public interface CloudMedcalPostSerivceService {
	/**
	 * 
	* @Title: setServiceApplySyncedFlag
	* @Description: 设置服务申请同步标识 
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void setMedicalPostSyncedFlag(TSyncResultNotify notify);
	

	//add by fanpanwei 
	public List<MedicalRecordPost> getMedicalPostList(MedicalRecordPostReq medicalRecordPostReq) throws ParseException, HospitalWithoutRightExcption;
}
