package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.SurgeryNote;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudSurgeryNoteDao {
	
	/**
	 * 
	 * @param surgeryNote
	 * @return
	 */
	public int insert(SurgeryNote surgeryNote);
}
