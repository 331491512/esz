package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.InhospitalNote;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudInhospitalNoteDao {
	
	/**
	 * 
	 * @param inhospitalNote
	 * @return
	 */
	public int insert(InhospitalNote inhospitalNote);
}
