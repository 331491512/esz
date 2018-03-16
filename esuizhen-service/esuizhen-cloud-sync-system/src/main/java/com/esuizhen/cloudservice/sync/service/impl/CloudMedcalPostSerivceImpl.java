package com.esuizhen.cloudservice.sync.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.sync.bean.MedicalRecordPost;
import com.esuizhen.cloudservice.sync.bean.MedicalRecordPostReq;
import com.esuizhen.cloudservice.sync.bean.TSyncRecord;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudProductServiceApplyDao;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.CloudMedcalPostSerivceService;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CloudMedcalPostSerivceImpl implements CloudMedcalPostSerivceService {
	@Autowired
	private CloudProductServiceApplyDao cloudProductServiceApplyDao;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	/**
	 * 设置产品服务申请记录的同步标记
	 */
	@Override
	public void setMedicalPostSyncedFlag(TSyncResultNotify notify) {
		List<TSyncRecord> uuids = notify.getUuids();
		if(uuids!=null&&uuids.size()>0){
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			for (TSyncRecord tSyncRecord : uuids) {
				paramMap.clear();
				paramMap.put("productApplyId",tSyncRecord.getProductApplyId());
				paramMap.put("syncFlag", 1);
				this.cloudProductServiceApplyDao.setServiceApplySyncedFlag(paramMap);
			}
		}
	}
	
	/**
	 * 获取服务申请列表
	 * @throws ParseException 
	 * @throws HospitalWithoutRightExcption 
	 */
	@Override
	public List<MedicalRecordPost> getMedicalPostList(MedicalRecordPostReq medicalRecordPostReq) throws ParseException, HospitalWithoutRightExcption {
		if(medicalRecordPostReq==null||!checkBeforeSyncService.checkHospitalId(medicalRecordPostReq.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		
		List<MedicalRecordPost> resultList = new ArrayList<MedicalRecordPost>();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hospitalId", medicalRecordPostReq.getHospitalId());
		//paramMap.put("productType", 9);
		paramMap.put("syncFlag", 0);
		paramMap.put("pageSize", medicalRecordPostReq.getNum());
		List<MedicalRecordPost> medicalRecordPostList = this.cloudProductServiceApplyDao.getSeviceApplyList(paramMap);
		if(medicalRecordPostList!=null&&medicalRecordPostList.size()>0){
			for (MedicalRecordPost medicalRecordPost : medicalRecordPostList) {
				JSONObject desMap = (JSONObject) JSONObject.parse(medicalRecordPost.getDescription());
				medicalRecordPost.setPatientNo((String)desMap.get("patientNo"));
				medicalRecordPost.setRelatedPatientNos((String)desMap.get("relatedPatientNos"));
				medicalRecordPost.setRecipientName(desMap.getString("recipientName"));
				medicalRecordPost.setRecipientMobile(desMap.getString("recipientMobile"));
				medicalRecordPost.setPostCode(desMap.getString("postCode"));
				medicalRecordPost.setCity(desMap.getString("city"));
				medicalRecordPost.setAddress(desMap.getString("address"));
				medicalRecordPost.setDescription(null);//提高接口返回数据安全性
				//medicalRecordPost.setProductSubType(desMap.getInteger("productSubType"));
				//medicalRecordPost.setServiceCode(desMap.getString("serviceCode"));
				//medicalRecordPost.setProgressState(desMap.getInteger("progressState"));
				resultList.add(medicalRecordPost);
				paramMap.clear();
				paramMap.put("productApplyId",medicalRecordPost.getProductApplyId());
				paramMap.put("syncFlag", 9);
				this.cloudProductServiceApplyDao.setServiceApplySyncedFlag(paramMap);
				
			}
		}
		return resultList;
	}
}
