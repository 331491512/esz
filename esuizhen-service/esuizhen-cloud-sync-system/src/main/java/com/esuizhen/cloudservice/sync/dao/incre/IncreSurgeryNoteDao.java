package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.SurgeryNote;

/**
 * 
 * @author YYCHEN
 *
 */
public interface IncreSurgeryNoteDao {
	
	/**
	 * 
	 * @param surgeryNote
	 * @return
	 */
	public int insert(SurgeryNote surgeryNote);
}
