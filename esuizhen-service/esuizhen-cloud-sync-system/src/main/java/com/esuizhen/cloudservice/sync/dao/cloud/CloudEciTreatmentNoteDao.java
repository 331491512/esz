package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;

/**
 * <p>Title:CloudEciTreatmentNoteDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月19日 下午4:00:07
 */
public interface CloudEciTreatmentNoteDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增治疗记录</p>
	 * @author YYCHEN
	 * @date 2016年5月19日 下午4:00:34
	 * @param eciTreatmentNote
	 * @return
	 */
	public int insert(EciTreatmentNote eciTreatmentNote);
}
