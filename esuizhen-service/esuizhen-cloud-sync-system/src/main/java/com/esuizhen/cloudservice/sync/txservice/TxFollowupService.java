package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.westangel.common.excption.DuplicateRecordExcption;

public interface TxFollowupService {

	String syncB2CFollowupResultRecord(TPatientFollowupResultDetailInfo detail)throws DuplicateRecordExcption;

	boolean mergeFollowup(String patientFinalUuid, Long patientId);

}
