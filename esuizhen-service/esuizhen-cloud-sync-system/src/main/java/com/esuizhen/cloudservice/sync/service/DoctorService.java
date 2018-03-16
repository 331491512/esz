package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.ParamMismatchExcption;

/**
 * 
 * @author YYCHEN
 *
 */
public interface DoctorService {
	/**
	 * 
	 * @param doctorSyncProfile
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	public boolean synchDoctor(TDoctorSyncProfile doctorSyncProfile) throws HospitalWithoutRightExcption;

	/**
	 * @throws ParamMismatchExcption 
	 * 
	* @Title: confirmDoctor 
	* @Description: 确认是否是医生本人 
	* @param @param confirmInfo
	* @param @return    设定文件 
	* @return TUserSyncConfirmResp    返回类型 
	* @throws
	 */
	public TConfirmUserResp confirmDoctor(TConfirmUserReq confirmReq) throws EmptyParamExcption, ParamMismatchExcption;
}
