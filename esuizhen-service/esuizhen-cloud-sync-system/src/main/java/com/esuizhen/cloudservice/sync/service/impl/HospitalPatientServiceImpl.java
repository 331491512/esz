package com.esuizhen.cloudservice.sync.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalPatientDao;
import com.esuizhen.cloudservice.sync.model.HospitalPatient;
import com.esuizhen.cloudservice.sync.service.HospitalPatientService;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:HospitalPatientServiceImpl</p>
 * <p>Description:医院、患者关系业务层实现</p>
 * @author YYCHEN
 * @date 2016年5月11日 上午11:37:22
 */
@Service
public class HospitalPatientServiceImpl implements HospitalPatientService {
	@Autowired
	private CloudHospitalPatientDao cloudHospitalPatientDao;

	@Transactional
	@Override
	public boolean saveHospitalPatient(HospitalPatient hospitalPatient) {
		LogUtil.log.debug("新增或更新医院、患者关系数据----------->>");
		if (hospitalPatient == null ||
				hospitalPatient.getHospitalId() == null ||
				hospitalPatient.getPatientId() == null) {
			LogUtil.log.debug("新增或更新医院、患者关系数据，由于参数不足拒绝处理-----------<<<, 参数：" + JsonUtil.toJson(hospitalPatient));
			return false;
		}
		HospitalPatient oldHospitalPatient = this.cloudHospitalPatientDao.find(hospitalPatient);
		if (oldHospitalPatient == null) {
			if (hospitalPatient.getSourceFlag() == null) {
				hospitalPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			}
			this.cloudHospitalPatientDao.insert(hospitalPatient);
		} else {
			boolean setFlag = false;
			if (oldHospitalPatient.getSourceFlag() == null) {
				oldHospitalPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
				setFlag = true;
			}
			if (StringUtils.isNotEmpty(hospitalPatient.getPatientNo())) {
				if (StringUtils.isEmpty(oldHospitalPatient.getPatientNo()) ||
						(StringUtils.isNotEmpty(oldHospitalPatient.getPatientNo()) && 
						!oldHospitalPatient.getPatientNo().equals(hospitalPatient.getPatientNo()))) {
					oldHospitalPatient.setPatientNo(hospitalPatient.getPatientNo());
					setFlag = true;
				}
			}
			if (setFlag) {
				this.cloudHospitalPatientDao.update(oldHospitalPatient);
			}
		}
		LogUtil.log.debug("新增或更新医院、患者关系数据完成-----------<<");
		return true;
	}
	
}
