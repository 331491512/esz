/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.check;<br/>  
 * <b>文件名：</b>SurgeryNoteCheck.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月24日下午3:24:24<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.excption.EmptyParamExcption;

/** 
* @ClassName: SurgeryNoteCheck
* @Description: 
* @author lichenghao
* @date 2016年12月24日 下午3:24:24  
*/
@Component
public class SurgeryNoteCheck {
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	//检查数据是否进入云端
	public boolean checkSurgerNoteNoteInMatch(TPatientSurgeryNoteDetailInfo surgeryInfo){
		String uuid=null;
		Long doctorId = null;
		Long patientId = null;
		Integer deptId = null;
		//确定患者uuid
		uuid = surgeryInfo.getPatientUuid();
		if (StringUtils.isNotEmpty(uuid)&&surgeryInfo.getPatientId()==null) {
			patientId = uuidRelationshipService.getPatientId(uuid);
			if(patientId==null)
				return true;
			surgeryInfo.setPatientId(patientId);
		}else{
			if(surgeryInfo.getPatientId()==null)
				throw new EmptyParamExcption("param error patientUuid is null");
		}
		// 确定麻醉医师uuid值
		uuid = surgeryInfo.getAnesthesiaDoctorUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				return true;
			surgeryInfo.setAnesthesiaDoctor(doctorId);
		}
		// 确定主刀医师uuid值
		uuid = surgeryInfo.getSurgeryDoctorUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				return true;
			surgeryInfo.setSurgeryDoctor(doctorId);
		}
		// 确定一助uuid值
		uuid = surgeryInfo.getSurgeryAssistant1Uuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				return true;
			surgeryInfo.setSurgeryAssistant1(doctorId);
		}
		// 确定二助uuid值
		uuid = surgeryInfo.getSurgeryAssistant2Uuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				return true;
			surgeryInfo.setSurgeryAssistant2(doctorId);
		}
		// 科室
		uuid = surgeryInfo.getDeptUuid();
		if(StringUtils.isNotEmpty(uuid)){
			deptId = uuidRelationshipService.getDeptId(uuid);
			if(deptId==null)
				return true;
			surgeryInfo.setDeptId(deptId);
		}
		return false;
	}
}
