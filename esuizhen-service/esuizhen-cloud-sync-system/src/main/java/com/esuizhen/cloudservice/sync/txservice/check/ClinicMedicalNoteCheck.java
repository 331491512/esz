/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.check;<br/>  
 * <b>文件名：</b>ClinicMedicalNoteCheck.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月25日下午5:16:14<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.excption.EmptyParamExcption;

/** 
* @ClassName: ClinicMedicalNoteCheck
* @Description: 
* @author lichenghao
* @date 2016年12月25日 下午5:16:14  
*/
@Component
public class ClinicMedicalNoteCheck {
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	public boolean checkClinicMedicalNoteInMatch(TClinicMedicalNoteInfo clinicMedicalNoteInfo){
		String uuid=null;
		Long doctorId = null;
		Long patientId = null;
		//确定患者uuid
		uuid = clinicMedicalNoteInfo.getPatientUuid();
		if (StringUtils.isNotEmpty(uuid)&&clinicMedicalNoteInfo.getPatientId()==null) {
			patientId = uuidRelationshipService.getPatientId(uuid);
			if(patientId==null)
				return true;
			clinicMedicalNoteInfo.setPatientId(patientId);
		}else{
			if(clinicMedicalNoteInfo.getPatientId()==null)
				throw new EmptyParamExcption("param error patientUuid is null");
		}
		//门诊医生
		uuid = clinicMedicalNoteInfo.getClinicDoctorUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				return true;
			clinicMedicalNoteInfo.setClinicDoctor(doctorId);
		}
		//主治医生
		uuid = clinicMedicalNoteInfo.getAttendingDoctoruuId();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				return true;
			clinicMedicalNoteInfo.setAttendingDoctorId(doctorId);
		}
		//k科室
		uuid = clinicMedicalNoteInfo.getDeptUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			Integer deptId = uuidRelationshipService.getDeptId(uuid);
			if(deptId==null)
				return true;
			clinicMedicalNoteInfo.setDeptId(deptId);
		}
		return false;
	}
}
