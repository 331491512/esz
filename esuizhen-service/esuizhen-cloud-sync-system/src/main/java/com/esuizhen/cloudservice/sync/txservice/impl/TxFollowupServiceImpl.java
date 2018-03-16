package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudFlowupDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudVarPatientFollowupDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchFlowupDao;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxFollowupService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.DuplicateRecordExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;


@Service
public class TxFollowupServiceImpl implements TxFollowupService {
	@Autowired
	private MatchFlowupDao matchFlowupDao;

	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	@Autowired
	private CloudFlowupDao cloudFlowupDao;
	@Autowired
	private CloudVarPatientFollowupDao cloudVarPatientFollowupDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private PatientService patientService;
	
	@Value("${server.api.url.root}")
	private String apiUrl;

	@Transactional
	@Override
	public String syncB2CFollowupResultRecord(TPatientFollowupResultDetailInfo detail)throws DuplicateRecordExcption {
		//处理创建时间
		if (detail.getCreateTime() == null) {
			detail.setCreateTime(detail.getFollowupTime());
		}

		// 根据patientUuid反查patientId
		Patient patient = this.cloudPatientDao.findByUuid(this.uuidRelationshipService.getFinalUuidByUuid(detail.getPatientUuid()));
		Doctor operator = null; 
		detail.setSourceFlag(3);
		if(!StringUtils.isEmpty(detail.getOperatorUuid()))		
			operator = this.cloudDoctorDao.findByUuid(this.uuidRelationshipService.getFinalUuidByUuid(detail.getOperatorUuid()));
		// 如果没有操作者也插入数据
		if (patient != null && (StringUtils.isEmpty(detail.getOperatorUuid()) || operator != null)) {
			detail.setPatientId(patient.getPatientId());
			detail.setOperator(operator==null?9:operator.getDoctorId());
			// 插入到生产库
			this.syncFollowup2Cloud(detail);
		} else {
			//add by fanpanwei  已存在的随访结果不再插入
			Integer existsMatch = this.matchFlowupDao.isExistsResult(detail);
			if(existsMatch!=null&&existsMatch==1)throw new DuplicateRecordExcption("followUPReslt is exists in cloud_sync_match_db!!!");
			// 插入到匹配库
			this.matchFlowupDao.addResultRecord2Match(detail);
		}
		return detail.getFollowupResultId();
	}
	
	
	//随访记录数据处理
	private void syncFollowup2Cloud(TPatientFollowupResultDetailInfo detail) throws DuplicateRecordExcption{
		// 判断随访方式
		if (detail.getFollowUpWay() == null) {
			detail.setFollowUpWay(Constant.Ehr.FOLLOWUPWAY_TELEPHONE);
		}
		
		//判断患者已死亡 将患者设成死亡
		if (detail.getFollowupResultValue() != null &&
				detail.getFollowupResultValue() == 4) {
			this.cloudVarPatientFollowupDao.setPatientDeathStatus(detail.getPatientId(), 2);
			if (detail.getDeathDate() == null) {
				detail.setDeathDate(detail.getFollowupTime());
			}
			this.patientService.setPatientDeathState(detail.getPatientId(), 
					detail.getDeathDate(),detail.getDeathCause(), 
					detail.getIsInHospitalDeath(), detail.getIsTumourDeath());
		}
		
		//判断患者生存状态
		/*if (detail.getFollowupResultId() != null &&
				"4".equals(detail.getFollowupResultId())) {
			if (detail.getDeathDate() == null) {
				detail.setDeathDate(detail.getFollowupTime());
			}
			this.patientService.setPatientDeathState(detail.getPatientId(), detail.getDeathDate());
		}*/
		//add by fanpanwei  已存在的随访结果不再插入
		Integer existsResult = this.cloudFlowupDao.isExistsResult(detail);
		if(existsResult!=null&&existsResult==1)throw new DuplicateRecordExcption("followUPReslt is exists in followUp_db!!!");
		//插入生产库数据result_buff表
		this.cloudFlowupDao.addResultBuffRecord2Cloud(detail);
		//插入生产库result表
		this.cloudFlowupDao.addResultRecord2Cloud(detail);
		//更新患者和随访结果动态表
		setVarPatientFollowup(detail);
	}
	
	//设值患者动态表记录
	private void setVarPatientFollowup(TPatientFollowupResultDetailInfo detail){
		String url = apiUrl+"/followup/result/var/patient/followup/update/toc";
        Map<String, String> hMap = new HashMap<String, String>();
        hMap.put("Content-Type", "application/json;charset=UTF-8");
        try{
        	detail.setFollowupWay(detail.getFollowUpWay());
        	String result = HttpUtil.postString(url, JsonUtil.toJson(detail), "utf-8", hMap);
        	LogUtil.log.debug("setVarPatientFollowup result=   "+result);
        	TMsgResponse<Object> obj = JsonUtil.toObject(result, TMsgResponse.class);
        	if(obj!=null&&obj.getRespCode()!=0){
        		throw new Exception(obj.getRespMsg());
        	}else{
        		LogUtil.log.debug("setVarPatientFollowup success");
        	}
        }catch(Exception e){
        	LogUtil.logError.error("setVarPatientFollowup error: "+e.getMessage());
        }
	}
	
	@Override
	public boolean mergeFollowup(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Data on the outcome of the combined follow-up---------->>");
		//将患者诊断信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchFlowupDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TPatientFollowupResultDetailInfo> followupResultDetailInfos = this.matchFlowupDao.findByPatientUuid(patientFinalUuid);
		if (followupResultDetailInfos == null || followupResultDetailInfos.isEmpty()) {
			return true;
		}
		for (int i = followupResultDetailInfos.size() - 1; i >= 0; i--) {
			TPatientFollowupResultDetailInfo followupResultDetailInfo = followupResultDetailInfos.get(i);
			followupResultDetailInfo.setPatientId(patientId);
			//operatorUuid 随访人员
			if (followupResultDetailInfo.getOperator() == null) {
				String doctorFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(followupResultDetailInfo.getOperatorUuid());
				Doctor doctor = this.cloudDoctorDao.findByUuid(doctorFinalUuid);
				if (doctor == null) {
					continue;
				}
				followupResultDetailInfo.setOperator(doctor.getDoctorId());
			}
			if (followupResultDetailInfo.getFollowUpWay() == null) {
				followupResultDetailInfo.setFollowUpWay(Constant.Ehr.FOLLOWUPWAY_TELEPHONE);
			}
			//将随访结果保存到云端数据库
			followupResultDetailInfo.setSyncFlag(Constant.SYNC_OK);
			try {
				this.syncFollowup2Cloud(followupResultDetailInfo);
			} catch (DuplicateRecordExcption e) {
				// TODO Auto-generated catch block
				//若是随访结果已存在， 程序正常执行
				LogUtil.log.debug(e.getMessage());
			}
			//将匹配中间库的数据删除
			this.matchFlowupDao.delete(followupResultDetailInfo.getFollowupResultBuffId());
		}
		LogUtil.log.debug("Data of the combined follow-up data were completed----------<<");
		return true;
	}

}
