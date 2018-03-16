package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.westangel.common.bean.User;
import com.westangel.common.excption.EmptyObjectExcption;

public interface TxPatientService {
	/**
	 * <p>Title:mergePatient</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午5:23:36
	 * @param patientUuid
	 * @param cloudPatientUserId
	 * @param transferFlag 是否迁移数据到云端
	 * @return
	 */
	public User mergePatient(String patientUuid, Long cloudPatientUserId, boolean transferFlag);

	public boolean syncPatientInfo(TPatientSyncProfile patientSyncProfile);
	
	public void syncPatientContactInfo(TPatientContactInfo tPatientContactInfo) throws EmptyObjectExcption;
}
