/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.check;<br/>  
 * <b>文件名：</b>PatientCheck.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月15日上午10:49:10<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.User;
import com.westangel.common.constant.Constant;

/** 
* @ClassName: PatientCheck
* @Description: 
* @author lichenghao
* @date 2016年12月15日 上午10:49:10  
*/
@Component
public class PatientCheck {
	@Autowired
	private CloudPatientDao cloudPatientDao;
	/**
	 * 对比
	 * @param user
	 * @param patientSyncProfile
	 * @return  true 属性匹配 false 属性不完全匹配
	 */
	public boolean comparisonPatientFullProperty(User user, Patient patient, TPatientSyncProfile patientSyncProfile){
		//如果为更新患者 信息 直接返回
		if (patientSyncProfile.getSyncFlag() != null
				&& (patientSyncProfile.getSyncFlag() == Constant.User.SYNCFLAG_MERGER
						|| patientSyncProfile.getSyncFlag() == Constant.User.SYNCFLAG_NO||patientSyncProfile.getSyncFlag() == Constant.User.SYNCFLAG_UPDATE))
			return false;
		
		//对比国籍
		if (StringUtils.isNotEmpty(patientSyncProfile.getCountry()) &&
				!patientSyncProfile.getCountry().equals(user.getCountry())) {
			return false;
		}
		//对比城市
		if (StringUtils.isNotEmpty(patientSyncProfile.getCity()) &&
				!patientSyncProfile.getCity().equals(user.getCity())) {
			return false;
		}
		//对比籍贯
		if (StringUtils.isNotEmpty(patientSyncProfile.getNativePlace()) &&
				!patientSyncProfile.getNativePlace().equals(user.getNativePlace())) {
			return false;
		}
		//对比民族
		if (StringUtils.isNotEmpty(patientSyncProfile.getNation()) &&
				!patientSyncProfile.getNation().equals(user.getNation())) {
			return false;
		}
		//证件类型
		if (patientSyncProfile.getIdType() != user.getIdType()) {
			return false;
		}
		//对比证件
		if (StringUtils.isNotEmpty(user.getIdentification()) &&
				!patientSyncProfile.getIdentification().equals(user.getIdentification())) {
			return false;
		}
		//对比职业
		if (StringUtils.isNotEmpty(patientSyncProfile.getProfession()) &&
				!patientSyncProfile.getProfession().equals(user.getProfession())) {
			return false;
		}
		//对比婚姻状况
		if (patientSyncProfile.getMarriageStatus() != null &&
				patientSyncProfile.getMarriageStatus() != user.getMarriageStatus()) {
			return false;
		}
		if (patient == null) {
			patient = this.cloudPatientDao.findByUserId(user.getUserId());
		}
		//对比电话
		if (StringUtils.isNotEmpty(patientSyncProfile.getMobile()) &&
				!patientSyncProfile.getMobile().equals(patient.getMobile())) {
			TPatientContactInfo patientContactInfo = new TPatientContactInfo();
			patientContactInfo.setFamilyName(patientSyncProfile.getTrueName());
			patientContactInfo.setFamilyPhone(patientSyncProfile.getMobile());
			patientContactInfo.setPatientRelation(Constant.User.PATIENTRELATION_RELATIVE);
			patientContactInfo.setAddress(patientSyncProfile.getNativePlace());
			patientSyncProfile.getPatientContactList().add(patientContactInfo);
			patientSyncProfile.setMobile(null);
		}
		//对比出生日期
		if (patientSyncProfile.getBirthDate() != null &&
				(patient.getBirthDate() == null ||
				patientSyncProfile.getBirthDate().compareTo(patient.getBirthDate()) != 0)) {
			return false;
		}
		//对比性别
		if (patientSyncProfile.getSex() != null &&
				patientSyncProfile.getSex() != patient.getSex()) {
			return false;
		}
		//对比真实姓名
		if (StringUtils.isNotEmpty(patientSyncProfile.getTrueName()) &&
				!patientSyncProfile.getTrueName().equals(patient.getTrueName())) {
			return false;
		}
		//对比生存状况
		if (patientSyncProfile.getLiveStatus() != null &&
				patientSyncProfile.getLiveStatus() != patient.getLiveStatus()) {
			return false;
		}
		//对比死亡日期
		if (patientSyncProfile.getDeathDate() != null &&
				(patient.getDeathDate() == null ||
				patientSyncProfile.getDeathDate().compareTo(patient.getDeathDate()) != 0)) {
			return false;
		}
		//对比死亡原因
		if (StringUtils.isNotEmpty(patientSyncProfile.getCauseOfDeath()) &&
				!patientSyncProfile.getDeathDate().equals(patient.getCauseOfDeath())) {
			return false;
		}
		return true;
	}
}
