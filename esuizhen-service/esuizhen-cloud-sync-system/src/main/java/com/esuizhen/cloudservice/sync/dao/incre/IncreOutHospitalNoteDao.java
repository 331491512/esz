package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;

public interface IncreOutHospitalNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:将出院小结保存到增量库</p>
	 * @author fanpanwei
	 * @date 2016年9月7日 下午5:49:39
	 * @param clinicMedicalNoteInfo
	 * @return
	 */
	int savecOutHospitalInfo(TOutHospitalNoteInfo outHospitalNoteInfo);
	
}
