package com.esuizhen.server.sync.dao.server;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.bean.PatientMergeInfoSyncReq;
import com.esuizhen.server.sync.model.server.TPatient;

import java.util.Date;

/**
 * Created by Nidan on 2017年03月21 上午 11:45
 */
public interface PatientDao {
	public TPatient queryPatientByUserId(@Param("userId")Long userId);
	
	public TPatient queryPatientByUuid(@Param("uuid")String uuid);
	
	public int insert(Object obj);

	public int update(Object object);
	
	public Integer queryPatientUnique(Object obj);

	public void updatePatientMergeUuid(PatientMergeInfoSyncReq req);

	TPatient findPatientByUuid(String mergeFromUuid);

	public int delete(Long patientId);

	void mergePatientInfoDeleteProce(@Param("mergeFrom") Long mergeFrom, @Param("mergeFromUuid") String mergeFromUuid, @Param("mergeTargetUuid") String mergeTargetUuid, @Param("mergeTime") Date mergeTime);
}