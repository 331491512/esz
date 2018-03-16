package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.HospitalDao;
import com.esuizhen.cloudservice.user.service.UuidRelationshipService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.User;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;

@Service
public class UuidRelationshipServiceImpl implements UuidRelationshipService {
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private com.westangel.common.service.UuidRelationshipService uuidRelationshipService;

	/**
	 * 保存uuid映射关系
	 * @param user
	 * @return
	 */
	public boolean saveUuidMapper(User user, String uuid){
		UuidRelationship uuidRelationship = new UuidRelationship();
		uuidRelationship.setUuidFinal(user.getUuid());
		uuidRelationship.setUuid(uuid);
		uuidRelationship.setUserId(user.getUserId());
		List<HospitalProfile> hospitalProfiles = null;
		if (Constant.User.ROLE_PATIENT == user.getRole()) {
			PageHelper.startPage(1, 1);
			hospitalProfiles = this.hospitalDao.findHospitalUuidByPatientUserId(user.getUserId());
		}else if(Constant.User.ROLE_DOCTOR == user.getRole()){
			PageHelper.startPage(1, 1);
			hospitalProfiles = this.hospitalDao.findHospitalUuidByDoctorUserId(user.getUserId());
		}
		if (hospitalProfiles != null && !hospitalProfiles.isEmpty()) {
			uuidRelationship.setHospitalId(hospitalProfiles.get(0).getHospitalId());
		}
		try {
			LogUtil.log.info("save the UUID mapping eelationship: user id " + user.getUserId());
			this.uuidRelationshipService.save(uuidRelationship);
			return true;
		} catch (Exception ex) {
			LogUtil.log.error("save the UUID mapping error: user id " + user.getUserId() + "," + ex.getCause() + "\t" + ex.getMessage());
		}
		return false;
	}
}
