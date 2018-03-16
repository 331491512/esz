package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;

public interface IncreClinicMedicalNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:将患者门诊信息保存到增量库</p>
	 * @author YYCHEN
	 * @date 2016年9月7日 下午5:49:39
	 * @param clinicMedicalNoteInfo
	 * @return
	 */
	int insert(TClinicMedicalNoteInfo clinicMedicalNoteInfo);
	
}
