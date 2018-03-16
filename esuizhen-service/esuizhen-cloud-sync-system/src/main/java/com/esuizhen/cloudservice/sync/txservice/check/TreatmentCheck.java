/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.check;<br/>  
 * <b>文件名：</b>TreatmentCheck.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月24日下午5:24:19<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.excption.EmptyParamExcption;

/** 
* @ClassName: TreatmentCheck
* @Description: 
* @author lichenghao
* @date 2016年12月24日 下午5:24:19  
*/
@Component
public class TreatmentCheck {
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	//检查数据是否进入云端
		public boolean checkTreatmentNoteInMatch(EciTreatmentNote treatmentNoteInfo){
			String uuid=null;
			Long doctorId = null;
			Long patientId = null;
			Integer deptId = null;
			//确定患者uuid
			uuid = treatmentNoteInfo.getPatientUuid();
			if (StringUtils.isNotEmpty(uuid)&&treatmentNoteInfo.getPatientId()==null) {
				patientId = uuidRelationshipService.getPatientId(uuid);
				if(patientId==null)
					return true;
				treatmentNoteInfo.setPatientId(patientId);
			}else{
				if(treatmentNoteInfo.getPatientId()==null)
					throw new EmptyParamExcption("param error patientUuid is null");
			}
			//操作人
			uuid = treatmentNoteInfo.getOperationDoctorUuid();
			if(StringUtils.isNotEmpty(uuid)){
				doctorId = uuidRelationshipService.getDoctorId(uuid);
				if(doctorId==null)
					return true;
				treatmentNoteInfo.setOperationDoctor(doctorId);
			}
			return false;
		}
}
