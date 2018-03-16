package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.InhospitalNote;

/**
 * 
 * @author YYCHEN
 *
 */
public interface IncreInhospitalNoteDao {
	
	/**
	 * 
	 * @param inhospitalNote
	 * @return
	 */
	public int insert(InhospitalNote inhospitalNote);
}
