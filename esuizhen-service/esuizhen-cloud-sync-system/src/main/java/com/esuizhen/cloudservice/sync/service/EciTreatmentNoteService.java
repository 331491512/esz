package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.model.SurgeryNote;

public interface EciTreatmentNoteService {
	/**
	 * <p>Title:saveByDiagnosisInfo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月19日 下午4:11:47
	 * @param surgeryNote
	 * @return
	 */
	public boolean saveByDiagnosisInfo(SurgeryNote surgeryNote);
}
