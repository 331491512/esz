package com.esuizhen.cloudservice.sync.service;

import java.util.Date;
import java.util.Map;

import com.esuizhen.cloudservice.sync.bean.TPatientAndPatientNoRelationSync;
import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.esuizhen.cloudservice.sync.bean.TPatientWeixinOpenIdInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.excption.HospitalWithoutRightExcption;

public interface PatientService {
	/**
	 * 
	 * @param patientSyncProfile
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	public boolean syncPatientInfo(TPatientSyncProfile patientSyncProfile) throws HospitalWithoutRightExcption;
	
	/**
	 * @throws HospitalWithoutRightExcption 
	 * 
	* @Title: getIncrWeixinPatients 
	* @Description: C端到B端同步随访结果 
	* @param @param hostpitalId
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public Page<TPatientWeixinOpenIdInfo> getIncrWeixinPatients(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption;
	
	/**
	 * 
	* @Title: setWeixinSyncResult 
	* @Description: 设置微信同步结果 
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void setWeixinSyncedFlag4Uuids(TSyncResultNotify notify);
	
	/**
	 * 
	* @Title: confirmPateint 
	* @Description: 确认是否是患者本人 
	* @param @param confirmInfo
	* @param @return    设定文件 
	* @return TUserSyncConfirmResp    返回类型 
	* @throws
	 */ 
	public TConfirmUserResp confirmPateint(TConfirmUserReq confirmReq);
	
	public boolean setPatientDeathState(Long patientId, Date deathDate);
	//add by fanpanwei
	public boolean setPatientDeathState(Long patientId, Date deathDate,String deathCause,Integer isInHospitalDeath,Integer isTumourDeath);
	
	/**
	 * <p>Title:transferDataToCloud</p>
	 * <p>Description:合并未处理的患者信息</p>
	 * @author YYCHEN
	 * @date 2016年7月29日 上午10:35:21
	 * @return
	 */
	public boolean transferDataToCloud();

	public boolean saveMatchUserAndPatient(TPatientSyncProfile patientSyncProfile);
	
	public void syncPatientOfPatientNoRelation(TPatientAndPatientNoRelationSync patientOfPatientNo) throws HospitalWithoutRightExcption;

	public void syncPatientContactInfo(TPatientContactInfo tPatientContactInfo) throws HospitalWithoutRightExcption;
	
	/**
	 * 获取微信用户
	 * @param uuid 患者uuid
	 * @return
	 */
	Map<String,Object> getWxUser(String uuid);
}
