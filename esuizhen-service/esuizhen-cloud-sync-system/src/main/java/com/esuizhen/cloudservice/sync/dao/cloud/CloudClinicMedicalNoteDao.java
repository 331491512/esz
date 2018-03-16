package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;

public interface CloudClinicMedicalNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:保存患者门诊信息到生产库</p>
	 * @author YYCHEN
	 * @date 2016年9月8日 上午11:16:49
	 * @param clinicMedicalInfo
	 * @return
	 */
	int insert(TClinicMedicalNoteInfo clinicMedicalInfo);

}
