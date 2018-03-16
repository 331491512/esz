package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;


public interface IncreEciTreatmentNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:将治疗表信息保存到增量库</p>
	 * @author fanpanwei
	 * @date 2016年9月7日 下午5:49:39
	 * @param clinicMedicalNoteInfo
	 * @return
	 */
	int saveTreatmentNote(EciTreatmentNote treatmentNote);
	
}
