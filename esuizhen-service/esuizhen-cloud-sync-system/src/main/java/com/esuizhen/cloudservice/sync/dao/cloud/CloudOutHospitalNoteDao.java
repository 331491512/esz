package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;

public interface CloudOutHospitalNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:将出院小结保存到云端库</p>
	 * @author fanpanwei
	 * @date 2016年9月7日 下午5:49:39
	 * @param clinicMedicalNoteInfo
	 * @return
	 */
	int insert(TOutHospitalNoteInfo outHospitalNoteInfo);
	
}
