/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service.impl;<br/>  
 * <b>文件名：</b>MatchServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月6日上午10:20:31<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.server.sync.dao.server.*;
import com.esuizhen.server.sync.model.server.TDoctor;
import com.esuizhen.server.sync.model.server.TPatient;
import com.esuizhen.server.sync.model.server.User;
import com.esuizhen.server.sync.service.MatchService;
import com.esuizhen.server.sync.service.handle.DoctorHandle;
import com.esuizhen.server.sync.service.handle.PatientHandle;
import com.esuizhen.server.sync.service.handle.UserHandle;
import com.westangel.common.bean.sync.MatchUserMergeReq;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/** 
* @ClassName: MatchServiceImpl
* @Description: 
* @author lichenghao
* @date 2017年4月6日 上午10:20:31  
*/
@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private ProcedureDao procedureDao;
	@Autowired
	private UserHandle userHandle;
	@Autowired
	private PatientHandle patientHandle;
	@Autowired
	private DoctorHandle doctorHandle;
	@Autowired
	private OperatorHistoryDao operatorHistoryDao;
	
	@Override
	@Transactional
	public void matchUserMerge(MatchUserMergeReq req) {
		//参数判断
		if(StringUtils.isBlank(req.getMatchUuid())||StringUtils.isBlank(req.getTargetUuid())||req.getRole()==null){
			throw new EmptyParamExcption("params error,params:"+JsonUtil.toJson(req));
		}
		if(req.getMatchUuid().equals(req.getTargetUuid()))
			throw new EmptyParamExcption("params error,matchUuid="+req.getMatchUuid()+",targetUuid="+req.getTargetUuid());
		//用户确认
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("uuid", req.getMatchUuid());
		User matchUser = userDao.queryUser(params);
		if(matchUser==null)
			throw new EmptyObjectExcption("match user is null , uuid="+req.getMatchUuid());
		params.put("uuid", req.getTargetUuid());
		User targetUser = userDao.queryUser(params);
		if(targetUser==null)
			throw new EmptyObjectExcption("target user is null , uuid="+req.getMatchUuid());
		if(req.getRole()==Constant.User.ROLE_PATIENT){//合并患者
			this.matchPatientMerger(matchUser,targetUser);
		}else if(req.getRole()==Constant.User.ROLE_DOCTOR){//合并医生
			this.matchDoctorMerger(matchUser,targetUser);
		}else{
			throw new EmptyParamExcption("params error,role error,role="+req.getRole());
		}
	}
	//匹配医生合并
	private void matchDoctorMerger(User matchUser, User targetUser) {
		TDoctor matchDoctor = doctorDao.queryDoctorByUserId(matchUser.getUserId());
		TDoctor targetDoctor = doctorDao.queryDoctorByUserId(targetUser.getUserId());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("matchDoctorId", matchDoctor.getDoctorId());
		params.put("targetDoctorId", targetDoctor.getDoctorId());
		procedureDao.mergeDoctorInfo(params);
		Integer mergeState = (Integer)params.get("mergeState");
		if(mergeState==null||mergeState==0){
			throw new RuntimeException("merge doctor info error,matchDoctorId="+matchDoctor.getDoctorId()+",targetDoctorId="+targetDoctor.getDoctorId());
		}
		//删除匹配医生信息
		doctorDao.delete(matchDoctor.getDoctorId());
		//删除匹配用户信息
		userDao.delete(matchUser.getUserId());
		//合并医生信息并修改
		targetDoctor = doctorHandle.mergeDoctor(matchDoctor,targetDoctor);
		doctorDao.update(JsonUtil.toObject(JsonUtil.toJson(targetDoctor), Map.class));
		//合并用户信息并修改
		targetUser = userHandle.mergeUser(matchUser,targetUser);
		userDao.update(JsonUtil.toObject(JsonUtil.toJson(targetUser), Map.class));
		
		Map<String, Object> operator = new HashMap<String, Object>();
		operator.put("operationName", "matchDoctorMerger");
		operator.put("description", "matchDoctorMerger matchDoctorId="+matchDoctor.getDoctorId()+",targetDoctorId="+targetDoctor.getDoctorId());
		operator.put("actionType", 5);
		operator.put("operatorId", targetUser.getUserId());
		operatorHistoryDao.insert(operator);
	}
	//匹配患者合并
	private void matchPatientMerger(User matchUser, User targetUser) {
		TPatient matchPatient = patientDao.queryPatientByUserId(matchUser.getUserId());
		TPatient targetPatient = patientDao.queryPatientByUserId(targetUser.getUserId());
		if(matchPatient==null){
			throw new EmptyObjectExcption("matchPatient is null,matchUserId="+matchUser.getUserId());
		}
		if(targetPatient==null){
			throw new EmptyObjectExcption("targetPatient is null,targetUserId="+targetUser.getUserId());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("matchPatientId", matchPatient.getPatientId());
		params.put("targetPatientId", targetPatient.getPatientId());
		procedureDao.mergePatientInfo(params);
		Integer mergeState = (Integer)params.get("mergeState");//获取执行结果 0 执行失败
		if(mergeState==null||mergeState==0){
			throw new RuntimeException("merge patient info error,matchPatientId="+matchPatient.getPatientId()+",targetPatientId="+targetPatient.getPatientId());
		}
		//删除匹配患者信息
		patientDao.delete(matchPatient.getPatientId());
		//删除匹配患者信息
		userDao.delete(matchUser.getUserId());
		//合并患者信息
		targetPatient = patientHandle.mergePatient(matchPatient,targetPatient);
		patientDao.update(JsonUtil.toObject(JsonUtil.toJson(targetPatient), Map.class));
		if(targetPatient.getAuditState()!=null){
			if(targetPatient.getAuditState()==Constant.User.AUDITSTATE_PRIMARYPASS)
				matchUser.setInfoState(Constant.User.INFOSTATE_PRIMARY);
			if(targetPatient.getAuditState()==Constant.User.AUDITSTATE_ADVANCEDPASS)
				matchUser.setInfoState(Constant.User.INFOSTATE_REALNAME);
		}
		//合并用户信息
		targetUser = userHandle.mergeUser(matchUser, targetUser);
		//userDao.update(JsonUtil.toObject(JsonUtil.toJson(targetUser), Map.class));
		userDao.update(targetUser);
		Map<String, Object> operator = new HashMap<String, Object>();
		operator.put("operationName", "matchPatientMerger");
		operator.put("description", "matchPatientMerger matchPatientId="+matchPatient.getPatientId()+",targetPatientId="+targetPatient.getPatientId());
		operator.put("actionType", 5);
		operator.put("operatorId", targetUser.getUserId());
		operatorHistoryDao.insert(operator);
	}
	

}
