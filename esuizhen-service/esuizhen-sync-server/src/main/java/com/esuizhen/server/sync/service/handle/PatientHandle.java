/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service.handle;<br/>  
 * <b>文件名：</b>PatientHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月28日下午6:20:09<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service.handle;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.dao.server.MatchPatientDao;
import com.esuizhen.server.sync.dao.server.PatientDao;
import com.esuizhen.server.sync.dao.server.RHospitalPatientDao;
import com.esuizhen.server.sync.dao.server.UserDao;
import com.esuizhen.server.sync.dao.temp.TempUserDao;
import com.esuizhen.server.sync.model.server.RHospitalPatient;
import com.esuizhen.server.sync.model.server.RMatchPatient;
import com.esuizhen.server.sync.model.server.TPatient;
import com.esuizhen.server.sync.model.server.User;
import com.esuizhen.server.sync.model.temp.SyncPatient;
import com.esuizhen.server.sync.model.temp.SyncUser;
import com.westangel.common.constant.Constant;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.JsonUtil;

/**
 * @ClassName: PatientHandle
 * @Description:
 * @author lichenghao
 * @date 2017年3月28日 下午6:20:09
 */
@Component
public class PatientHandle {

	@Autowired
	private PatientDao patientDao;
	@Autowired
	private TempUserDao tempUserDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RHospitalPatientDao rHospitalPatientDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private UserHandle userHandle;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void handlePatient(SyncPatient tempPatient) {
		SyncUser tempUser = tempUserDao.queryUser(tempPatient);
		if (tempUser == null)
			throw new EmptyObjectExcption("user not in temp");
		if (tempPatient.getPatientId() != null) {// 已同步的患者
			updatePatient(tempPatient, tempUser);
		} else if (StringUtils.isNotEmpty(tempUser.getIdentification())
				&& matchByPatientIdentification(tempPatient, tempUser)) {// 证件号匹配
		} else if (StringUtils.isNotEmpty(tempPatient.getMobile()) && matchByPatientPhone(tempPatient, tempUser)) {// 手机号匹配
		} else {
			savePatient(tempPatient, tempUser);
		}
	}

	// 正式库创建
	private void savePatient(SyncPatient tempPatient, SyncUser tempUser) {
		this.checkPatient(tempPatient, tempUser);
		// 插入用户数据
		userDao.insertUser(tempUser);
		tempPatient.setUserId(tempUser.getUserId());
		checkPatient(tempPatient, tempUser);
		// 插入患者数据
		patientDao.insert(tempPatient);
		// 创建医院患者关系
		createHospitalPatientRelation(tempPatient);

	}

	// 正式库修改
	private void updatePatient(SyncPatient tempPatient, SyncUser tempUser) {
		tempUser.setUserId(tempPatient.getUserId());// userId写入
		tempPatient.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_UPDATE);
		//考虑数据合并的问题 所以uuid为null 不修改
		tempPatient.setUuid(null);
		tempUser.setUuid(null);
		this.checkPatient(tempPatient, tempUser);
		// 修改患者信息
		patientDao.update(tempPatient);
		// 修改用户信息
		userDao.update(tempUser);
		// 创建医院患者关系
		createHospitalPatientRelation(tempPatient);
	}

	private void checkPatient(SyncPatient tempPatient, SyncUser tempUser) {
		if (StringUtils.isNotBlank(tempPatient.getSourceDiagnosis())
				&& tempPatient.getAuditState() == Constant.User.AUDITSTATE_NOT) {
			tempPatient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);
			tempUser.setInfoState(Constant.User.INFOSTATE_PRIMARY);
		}
		//患者验证
//		if(StringUtils.isNotBlank(tempPatient.getMobile())){
//			Map<String,Object> params = new HashMap<String, Object>();
//			params.put("mobile", tempPatient.getMobile());
//			params.put("relation", tempPatient.getPatientRelation());
//			params.put("syncFlag", ConstantSync.SYNCFLAG.SYNC_NO);
//			if(patientDao.queryPatientUnique(params)!=0){
//				tempPatient.setMobile(null);
//			}
//		}
		if(tempPatient.getPatientId()!=null){
			userHandle.checkUpdateUser(tempUser);
			TPatient patient = patientDao.queryPatientByUserId(tempPatient.getUserId());
			if(patient==null)
				return;
			if(tempPatient.getAuditState()==null)
				tempPatient.setAuditState(Constant.User.AUDITSTATE_NOT);
			if(tempPatient.getAuditState()<patient.getAuditState()){
				tempPatient.setAuditState(null);
				tempUser.setInfoState(null);
			}
		}
	}

	// 手机号查找
	private boolean matchByPatientPhone(SyncPatient tempPatient, SyncUser tempUser) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", tempPatient.getMobile());
		params.put("role", Constant.User.ROLE_PATIENT);
		params.put("accountTypeFlag", true);
		User user = userDao.queryUser(params);
		if (user == null)
			return false;
		TPatient patient = patientDao.queryPatientByUserId(user.getUserId());
		// 手机号存在 保存并插入匹配数据
		savePatient(tempPatient, tempUser);
		// 插入匹配记录表
		createMatchHistory(JsonUtil.toObject(JsonUtil.toJson(tempPatient), TPatient.class), patient,ConstantSync.MATCH_TYPE_MOBILE);
		return true;
	}

	// 证件号查找
	private boolean matchByPatientIdentification(SyncPatient tempPatient, SyncUser tempUser) {
		if (tempUser.getIdType() == null)
			tempUser.setIdType(Constant.IDTYPE_ID);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idType", tempUser.getIdType());
		params.put("identification", tempUser.getIdentification());
		params.put("role", Constant.User.ROLE_PATIENT);
		params.put("auditState", Constant.User.AUDITSTATE_ADVANCEDPASS);
		params.put("accountTypeFlag", true);
		User user = userDao.queryUser(params);
		if (user == null)// 如果证件号不存在
			return false;
		TPatient patient = patientDao.queryPatientByUserId(user.getUserId());
		// 证件号存在 保存并插入匹配数据
		savePatient(tempPatient, tempUser);
		// 插入匹配记录表
		createMatchHistory(JsonUtil.toObject(JsonUtil.toJson(tempPatient), TPatient.class), patient,ConstantSync.MATCH_TYPE_IDENTIFICATION);
		return true;
	}

	// 匹配记录写入
	private void createMatchHistory(TPatient clientPatient, TPatient serverPatient,Integer matchType) {
		RMatchPatient matchPatient = new RMatchPatient();
		matchPatient.setMatchPatientId(clientPatient.getPatientId());
		matchPatient.setMatchUserId(clientPatient.getUserId());
		matchPatient.setMatchUuid(clientPatient.getUuid());
		matchPatient.setTargetPatientId(serverPatient.getPatientId());
		matchPatient.setTargetUserId(serverPatient.getUserId());
		matchPatient.setTargetUuid(serverPatient.getUuid());
		matchPatient.setMatchType(matchType);
		matchPatientDao.insert(matchPatient);
	}

	// 创建医院关系
	private void createHospitalPatientRelation(SyncPatient tempPatient) {
		// 插入医院患者关系
		if (tempPatient.getHospitalId() != 0) {
			RHospitalPatient rHospitalPatient = RHospitalPatient.create(tempPatient);
			if (rHospitalPatientDao.queryHospitalPatientRelation(tempPatient) == null)
				rHospitalPatientDao.insert(rHospitalPatient);
			else
				rHospitalPatientDao.update(rHospitalPatient);
		}
	}

	public TPatient mergePatient(TPatient matchPatient, TPatient targetPatient) {
		//前期判断
		if(StringUtils.isBlank(matchPatient.getMobile())){
			matchPatient.setMobile(null);
		}
		//userId  和 patientId 赋值
		matchPatient.setUserId(targetPatient.getUserId());
		matchPatient.setPatientId(targetPatient.getPatientId());
		matchPatient.setHasVisibleMedicalRecord(null);
		//如果患者状态为null
		if(StringUtils.isNotBlank(matchPatient.getSourceDiagnosis())&&matchPatient.getAuditState()!=null&&matchPatient.getAuditState()<Constant.User.AUDITSTATE_PRIMARYPASS){
			matchPatient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);
		}
		//如果匹配状态 小于目标状态 合并信息
		if(matchPatient.getAuditState()!=null
				&&targetPatient.getAuditState()!=null
				&&matchPatient.getAuditState()<targetPatient.getAuditState()){
			matchPatient.setAuditState(targetPatient.getAuditState());
		}
		return matchPatient;
	}
}
