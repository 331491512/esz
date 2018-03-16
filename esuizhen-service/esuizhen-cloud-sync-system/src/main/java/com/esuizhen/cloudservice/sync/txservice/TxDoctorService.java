package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.westangel.common.bean.User;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;

public interface TxDoctorService {
	/**
	 * <p>Title:mergeDoctor</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午5:13:40
	 * @param doctorUuid
	 * @param cloudDoctorUserId
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 */
	public User mergeDoctor(String doctorUuid, Long cloudDoctorUserId) throws EmptyParamExcption, EmptyObjectExcption;

	public boolean syncDoctor(TDoctorSyncProfile doctorSyncProfile);
}
