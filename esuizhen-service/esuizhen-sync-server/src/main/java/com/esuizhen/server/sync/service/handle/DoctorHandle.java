/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service.handle;<br/>  
 * <b>文件名：</b>DoctorHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月28日下午3:58:47<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service.handle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.server.sync.dao.server.DoctorDao;
import com.esuizhen.server.sync.dao.server.MatchDoctorDao;
import com.esuizhen.server.sync.dao.server.RHospitalDoctorDao;
import com.esuizhen.server.sync.dao.server.UserDao;
import com.esuizhen.server.sync.dao.temp.TempUserDao;
import com.esuizhen.server.sync.model.server.RHospitalDoctor;
import com.esuizhen.server.sync.model.server.RMatchDoctor;
import com.esuizhen.server.sync.model.server.TDoctor;
import com.esuizhen.server.sync.model.server.User;
import com.esuizhen.server.sync.model.temp.SyncDoctor;
import com.esuizhen.server.sync.model.temp.SyncUser;
import com.westangel.common.constant.Constant;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.JsonUtil;

/**
 * @ClassName: DoctorHandle
 * @Description:
 * @author lichenghao
 * @date 2017年3月28日 下午3:58:47
 */
@Component
public class DoctorHandle {
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private MatchDoctorDao matchDoctorDao;
	@Autowired
	private TempUserDao tempUserDao;
	@Autowired
	private RHospitalDoctorDao rHospitalDoctorDao;
	@Autowired
	private UserHandle userHandle;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void handleDoctor(SyncDoctor tempDoctor){
		SyncUser tempUser = tempUserDao.queryUser(tempDoctor);
		if (tempUser == null)
			throw new EmptyObjectExcption("user not in temp");
		if (tempDoctor.getDoctorId() != null) {// 已同步的医生
			this.updateDoctor(tempDoctor, tempUser);
		} else if (StringUtils.isNotEmpty(tempDoctor.getMobile()) && matchByDoctorPhone(tempDoctor, tempUser)) {
		} else {
			this.savaDoctor(tempDoctor, tempUser);
		}
	}
	
	
	public void savaDoctor(SyncDoctor tempDoctor, SyncUser tempUser) {
		checkDoctor(tempDoctor,tempUser);
		// 插入用户
		userDao.insertUser(tempUser);
		tempDoctor.setUserId(tempUser.getUserId());
		// 创建医生
		doctorDao.insert(tempDoctor);
		// 创建医院医生关系
		createHospitalPatientRelation(tempDoctor);
	}

	public void updateDoctor(SyncDoctor tempDoctor, SyncUser tempUser) {
		tempUser.setUserId(tempDoctor.getUserId());
		tempDoctor.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_UPDATE);
		//考虑合并的问题 所以uuid 为null 不做修改
		tempDoctor.setUuid(null);
		tempUser.setUuid(null);
		checkDoctor(tempDoctor,tempUser);
		// 修改用户信息
		userDao.update(tempUser);
		doctorDao.update(tempDoctor);
		// 创建医院医生关系
		createHospitalPatientRelation(tempDoctor);
	}

	private void checkDoctor(SyncDoctor tempDoctor, SyncUser tempUser) {
//		if(StringUtils.isNotEmpty(tempDoctor.getMobile())){
//			Map<String,Object> params = new HashMap<String, Object>();
//			params.put("mobile", tempDoctor.getMobile());
//			params.put("syncFlag", ConstantSync.SYNCFLAG.SYNC_NO);
//			if(doctorDao.queryDoctorByMobileUnique(params)!=0)
//				tempDoctor.setMobile(null);
//		}
		if(tempDoctor.getDoctorId()!=null){
			TDoctor doctor = doctorDao.queryDoctorByUserId(tempDoctor.getUserId());
			if(doctor!=null){
				userHandle.checkUpdateUser(tempUser);
				if(tempDoctor.getAuditState()==Constant.User.AUDITSTATE_NOT)
					tempDoctor.setAuditState(null);
				tempDoctor.setRecommendFlag(userHandle.validateValue(tempDoctor.getRecommendFlag(), doctor.getRecommendFlag()));
			}
		}
	}


	// 创建医院医生关系
	private void createHospitalPatientRelation(SyncDoctor tempDoctor) {
		// 插入医院患者关系
		if (tempDoctor.getHospitalId() != 0) {
			RHospitalDoctor rHospitalDoctor = RHospitalDoctor.create(tempDoctor);
			if (rHospitalDoctorDao.queryHospitalDoctorRelation(tempDoctor) == null)
				rHospitalDoctorDao.insert(rHospitalDoctor);
			else
				rHospitalDoctorDao.update(rHospitalDoctor);
		}
	}
	//医生手机号匹配
	private boolean matchByDoctorPhone(SyncDoctor tempDoctor, SyncUser tempUser) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", tempUser.getMobile());
		params.put("role", Constant.User.ROLE_DOCTOR);
		User user = userDao.queryUser(params);
		if (user == null)
			return false;
		TDoctor doctor = doctorDao.queryDoctorByUserId(user.getUserId());
		// 手机号存在 保存并插入匹配数据
		this.savaDoctor(tempDoctor, tempUser);
		// 插入匹配记录表
		createMatchHistory(JsonUtil.toObject(JsonUtil.toJson(tempDoctor), TDoctor.class), doctor,ConstantSync.MATCH_TYPE_MOBILE);
		return true;
	}
	
	// 匹配记录写入
	private void createMatchHistory(TDoctor clientDoctor, TDoctor serverDoctor,Integer matchType) {
		RMatchDoctor matchDoctor = new RMatchDoctor();
		matchDoctor.setMatchDoctorId(clientDoctor.getDoctorId());
		matchDoctor.setMatchUserId(clientDoctor.getUserId());
		matchDoctor.setMatchUuid(clientDoctor.getUuid());
		matchDoctor.setTargetDoctorId(serverDoctor.getDoctorId());
		matchDoctor.setTargetUserId(serverDoctor.getUserId());
		matchDoctor.setTargetUuid(serverDoctor.getUuid());
		matchDoctor.setMatchType(matchType);
		matchDoctorDao.insert(matchDoctor);
	}

	//合并医生
	public TDoctor mergeDoctor(TDoctor matchDoctor, TDoctor targetDoctor) {
		matchDoctor.setUserId(targetDoctor.getUserId());
		matchDoctor.setDoctorId(targetDoctor.getDoctorId());
		if(matchDoctor.getAuditState()!=null
				&&targetDoctor.getAuditState()!=null
				&&matchDoctor.getAuditState()<targetDoctor.getAuditState()){
			matchDoctor.setAuditState(null);
		}
		return matchDoctor;
	}
}
