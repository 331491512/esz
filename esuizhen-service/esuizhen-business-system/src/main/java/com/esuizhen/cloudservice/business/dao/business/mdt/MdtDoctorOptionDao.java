package com.esuizhen.cloudservice.business.dao.business.mdt;

import com.esuizhen.cloudservice.business.bean.MdtDoctorOptionInfo;

/** 
 * @ClassName: PatientActivityDao.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public interface MdtDoctorOptionDao {
	
	
	void updateMdtapplyInfo(MdtDoctorOptionInfo mdtOption);
	void updateDoctorOption(MdtDoctorOptionInfo mdtOption);
	void insertDoctorOption(MdtDoctorOptionInfo mdtOption);
	MdtDoctorOptionInfo getOpinionInfoById(String productApplyId);
}
