/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.followup;<br/>  
 * <b>文件名：</b>FollowupPatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午10:31:48<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.FollowupRecords.impl;

import java.util.HashMap;
import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired; 

import com.alibaba.dubbo.config.annotation.Service;
import com.esuizhen.cloudservice.followup.bean.FamilyHistoriesReq;
import com.esuizhen.cloudservice.followup.bean.FollowupConvMainQuestionItemReq;
import com.esuizhen.cloudservice.followup.bean.FollowupConvQuestionReq;
import com.esuizhen.cloudservice.followup.bean.SymptomsReq;
import com.esuizhen.cloudservice.followup.bean.TreatmentDetailReq;
import com.esuizhen.cloudservice.followup.bean.TreatmentTypeReq;
import com.esuizhen.cloudservice.followup.bean.VerifiesReq;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupConvQuestionSymptomDao;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupConvQuestionTreatmentDao;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupConvQuestionTreatmentDetailDao;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupConvQuestionVerifyDao;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupConvMainQuestionItemDao;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupConventionRecordsDao;
import com.esuizhen.cloudservice.followup.dao.followupRecords.FollowupTumourFamilyHistoryDao;
import com.esuizhen.cloudservice.followup.service.FollowupRecords.FollowupRecordService;

/** 
* @ClassName: FollowupRecordServiceImpl
* @Description: 
* @author fanpanwei
* @date 2017年01月18日 上午10:31:48  
*/
@org.springframework.stereotype.Service
public class FollowupRecordServiceImpl  implements FollowupRecordService{
	
	@Autowired
	private FollowupConventionRecordsDao followupConventionRecordsDao;
	@Autowired
	private FollowupConvMainQuestionItemDao followupConvMainQuestionItemDao;

	@Autowired
	private FollowupConvQuestionTreatmentDao followupConvQuestionTreatmentDao;
	@Autowired
	private FollowupConvQuestionTreatmentDetailDao followupConvQuestionTreatmentDetailDao;
	@Autowired
	private FollowupConvQuestionVerifyDao followupConvQuestionVerifyDao;
	@Autowired
	private FollowupConvQuestionSymptomDao followupConvQuestionSymptomDao;
	@Autowired
	private FollowupTumourFamilyHistoryDao followupTumourFamilyHistoryDao;
	/**
	 * @author fanpanwei
	 * @title :getConventionFollowupRecords
	 * @Description:常规随访记录查询
	 * @return TFollowupPatientStatisInfo
	 * @date 2017年01月18日 上午10:42:42
	 */
	@Override
	public FollowupConvQuestionReq getConventionFollowupRecords(Integer patientId){
		Long followupConvQuestionId = this.followupConventionRecordsDao.getFCQIdBypatientId(patientId);
		
		FollowupConvQuestionReq followupConvQuestionResp = new FollowupConvQuestionReq();
		
		List<TreatmentTypeReq> treatmentTypes = this.followupConvQuestionTreatmentDao.getTreatmentTypes(followupConvQuestionId);
		List<TreatmentDetailReq> treatmentTypeDetails = this.followupConvQuestionTreatmentDetailDao.getTreatmentTypeDetails(followupConvQuestionId);
		List<VerifiesReq> verifies = this.followupConvQuestionVerifyDao.getVerifies(followupConvQuestionId);
		List<SymptomsReq> symptoms = this.followupConvQuestionSymptomDao.getsymptoms(followupConvQuestionId);
		List<FamilyHistoriesReq> familyHistories = this.followupTumourFamilyHistoryDao.getFamilyHistories(followupConvQuestionId);
		
		followupConvQuestionResp.setFollowupConvQuestionId(followupConvQuestionId);
		followupConvQuestionResp.setTreatmentType(treatmentTypes);
		followupConvQuestionResp.setTreatmentDetail(treatmentTypeDetails);
		followupConvQuestionResp.setVerifies(verifies);
		followupConvQuestionResp.setSymptoms(symptoms);
		followupConvQuestionResp.setFamilyHistories(familyHistories);
		return followupConvQuestionResp;
	};
	
	/**
	 * @author fanpanwei
	 * @title :getFollowupTaskSeniorScreenPatientList
	 * @Description:常规随访记录保存
	 * @return TFollowupPatientStatisInfo
	 * @date 2017年01月18日 上午8:10:37
	 */
	@Override
	public void saveConventionFollowupRecords(FollowupConvQuestionReq followupConvQuestionReq){
		if(followupConvQuestionReq!=null){
			Long followupConvQuestionId = followupConvQuestionReq.getFollowupConvQuestionId();
			
			if(followupConvQuestionId==null){
				followupConvQuestionId = this.followupConventionRecordsDao.getFCQIdBypatientId(followupConvQuestionReq.getPatientId());
				if(followupConvQuestionId==null){
					this.followupConventionRecordsDao.insert(followupConvQuestionReq);
					followupConvQuestionId = followupConvQuestionReq.getFollowupConvQuestionId();
				}
			}
			
			FollowupConvMainQuestionItemReq req = null;
			Long mainQuestionItemId = null;
			List<TreatmentTypeReq> treatmentType = followupConvQuestionReq.getTreatmentType();
			if(treatmentType!=null&&treatmentType.size()>0){
				for (TreatmentTypeReq treatmentTypeReq : treatmentType) {
					mainQuestionItemId = treatmentTypeReq.getMainQuestionItemId();
					if(mainQuestionItemId==null){
						treatmentTypeReq.setFollowupConvQuestionId(followupConvQuestionId);
						Integer judgeTreatmentTypes = followupConvQuestionTreatmentDao.judgeTreatmentTypes(treatmentTypeReq);
						if(judgeTreatmentTypes!=null)continue;
						req = new FollowupConvMainQuestionItemReq();
						req.setFollowupConvQuestionId(followupConvQuestionId);
						req.setQuestionType(1);
						this.followupConvMainQuestionItemDao.insert(req);
						mainQuestionItemId = req.getMainQuestionItemId();
						
						treatmentTypeReq.setMainQuestionItemId(mainQuestionItemId);
						this.followupConvQuestionTreatmentDao.insert(treatmentTypeReq);
					}else{
						if(treatmentTypeReq.getIsDel()!=null&&1==treatmentTypeReq.getIsDel()){
							this.followupConvQuestionTreatmentDao.deleteByMQIId(mainQuestionItemId);
							this.followupConvMainQuestionItemDao.deleteByMQIId(mainQuestionItemId);
						}
					}
				}
			}
			List<TreatmentDetailReq> treatmentDetail = followupConvQuestionReq.getTreatmentDetail();
			if(treatmentDetail!=null&&treatmentDetail.size()>0){
				for (TreatmentDetailReq treatmentDetailReq : treatmentDetail) {
					mainQuestionItemId = treatmentDetailReq.getMainQuestionItemId();
					if(mainQuestionItemId==null){
						req = new FollowupConvMainQuestionItemReq();
						req.setFollowupConvQuestionId(followupConvQuestionId);
						req.setQuestionType(5);
						this.followupConvMainQuestionItemDao.insert(req);
						mainQuestionItemId = req.getMainQuestionItemId();
						
						treatmentDetailReq.setMainQuestionItemId(mainQuestionItemId);
						treatmentDetailReq.setFollowupConvQuestionId(followupConvQuestionId);
						this.followupConvQuestionTreatmentDetailDao.insert(treatmentDetailReq);
					}else{
						this.followupConvQuestionTreatmentDetailDao.deleteByMQIId(mainQuestionItemId);
						if(treatmentDetailReq.getIsDel()!=null&&1==treatmentDetailReq.getIsDel()){
							this.followupConvMainQuestionItemDao.deleteByMQIId(mainQuestionItemId);
						}else{
							treatmentDetailReq.setMainQuestionItemId(mainQuestionItemId);
							treatmentDetailReq.setFollowupConvQuestionId(followupConvQuestionId);
							this.followupConvQuestionTreatmentDetailDao.insert(treatmentDetailReq);
						}
					}
				}
			}
			//检验检查
			List<VerifiesReq> verifies = followupConvQuestionReq.getVerifies();
			if(verifies!=null&&verifies.size()>0){
				for (VerifiesReq verifiesReq : verifies) {
					mainQuestionItemId = verifiesReq.getMainQuestionItemId();
					if(mainQuestionItemId==null){
						req = new FollowupConvMainQuestionItemReq();
						req.setFollowupConvQuestionId(followupConvQuestionId);
						req.setQuestionType(2);
						this.followupConvMainQuestionItemDao.insert(req);
						mainQuestionItemId = req.getMainQuestionItemId();
						
						verifiesReq.setMainQuestionItemId(mainQuestionItemId);
						verifiesReq.setFollowupConvQuestionId(followupConvQuestionId);
						this.followupConvQuestionVerifyDao.insert(verifiesReq);
					}else{
						this.followupConvQuestionVerifyDao.deleteByMQIId(mainQuestionItemId);
						if(verifiesReq.getIsDel()!=null&&1==verifiesReq.getIsDel()){
							this.followupConvMainQuestionItemDao.deleteByMQIId(mainQuestionItemId);
						}else{
							verifiesReq.setMainQuestionItemId(mainQuestionItemId);
							verifiesReq.setFollowupConvQuestionId(followupConvQuestionId);
							this.followupConvQuestionVerifyDao.insert(verifiesReq);
						}
					}
				}
			}
			//症状表现
			List<SymptomsReq> symptoms = followupConvQuestionReq.getSymptoms();
			if(symptoms!=null&&symptoms.size()>0){
				for (SymptomsReq symptomsReq : symptoms) {
					mainQuestionItemId = symptomsReq.getMainQuestionItemId();
					if(mainQuestionItemId==null){
						req = new FollowupConvMainQuestionItemReq();
						req.setFollowupConvQuestionId(followupConvQuestionId);
						req.setQuestionType(3);
						this.followupConvMainQuestionItemDao.insert(req);
						mainQuestionItemId = req.getMainQuestionItemId();
						
						symptomsReq.setMainQuestionItemId(mainQuestionItemId);
						symptomsReq.setFollowupConvQuestionId(followupConvQuestionId);
						this.followupConvQuestionSymptomDao.insert(symptomsReq);
					}else{
						this.followupConvQuestionSymptomDao.deleteByMQIId(mainQuestionItemId);
						if(symptomsReq.getIsDel()!=null&&1==symptomsReq.getIsDel()){
							this.followupConvMainQuestionItemDao.deleteByMQIId(mainQuestionItemId);
						}else{
							symptomsReq.setMainQuestionItemId(mainQuestionItemId);
							symptomsReq.setFollowupConvQuestionId(followupConvQuestionId);
							this.followupConvQuestionSymptomDao.insert(symptomsReq);
						}
					}
				}
			}
			List<FamilyHistoriesReq> familyHistories = followupConvQuestionReq.getFamilyHistories();
			if(familyHistories!=null&&familyHistories.size()>0){
				for (FamilyHistoriesReq familyHistoriesReq : familyHistories) {
					mainQuestionItemId = familyHistoriesReq.getMainQuestionItemId();
					if(mainQuestionItemId==null){
						req = new FollowupConvMainQuestionItemReq();
						req.setFollowupConvQuestionId(followupConvQuestionId);
						req.setQuestionType(4);
						this.followupConvMainQuestionItemDao.insert(req);
						mainQuestionItemId = req.getMainQuestionItemId();
						
						familyHistoriesReq.setMainQuestionItemId(mainQuestionItemId);
						familyHistoriesReq.setFollowupConvQuestionId(followupConvQuestionId);
						this.followupTumourFamilyHistoryDao.insert(familyHistoriesReq);
					}else{
						this.followupTumourFamilyHistoryDao.deleteByMQIId(mainQuestionItemId);
						if(familyHistoriesReq.getIsDel()!=null&&1==familyHistoriesReq.getIsDel()){
							this.followupConvMainQuestionItemDao.deleteByMQIId(mainQuestionItemId);
						}else{
							familyHistoriesReq.setMainQuestionItemId(mainQuestionItemId);
							familyHistoriesReq.setFollowupConvQuestionId(followupConvQuestionId);
							this.followupTumourFamilyHistoryDao.insert(familyHistoriesReq);
						}
					}
					
				}
			}
			//boolean delRecordsTab = true;// 删除常规随访总表的标识
			List<Long> mqiIdBypatientId = this.followupConvMainQuestionItemDao.getMQIIdBypatientId(followupConvQuestionReq.getPatientId());
			if(mqiIdBypatientId==null||mqiIdBypatientId.size()==0)
				this.followupConventionRecordsDao.deleteByPatientId(followupConvQuestionReq.getPatientId());
		}
	}
	

}
