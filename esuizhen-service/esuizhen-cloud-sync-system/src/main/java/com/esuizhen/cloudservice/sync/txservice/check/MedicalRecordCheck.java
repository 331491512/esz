/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.handle;<br/>  
 * <b>文件名：</b>MedicalRecordHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月14日下午4:33:10<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.esuizhen.cloudservice.sync.model.InhospitalNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.constant.Constant;

/** 
* @ClassName: MedicalRecordHandle
* @Description: 
* @author lichenghao
* @date 2016年12月14日 下午4:33:10  
*/
@Component
public class MedicalRecordCheck {
	//住院病案首页合并云端检查
	public boolean checkMatchToCloudInhospitalNote(MedicalRecord medicalRecord,InhospitalNote inhospitalNote){
		//病历类型
		if (medicalRecord.getEmrType() == null) {
			medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		}
		//病历子类型
		if (medicalRecord.getEmrSubType() == null) {
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_HOSPITALIZATION);
		}
		//结构化标志
		if (medicalRecord.getStructFlag() == null) {
			medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);
		}
		//医疗记录发生时间、就诊时间（实际发生时间）。
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(new Date());
		}
		//patientUuid
		if (medicalRecord.getSyncFlag() == null) {
			medicalRecord.setSyncFlag(Constant.User.SYNCFLAG_YES);
		}
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(inhospitalNote.getInhospitalDate());
		}
		medicalRecord.setPatientId(inhospitalNote.getPatientId());
		medicalRecord.setPatientUuid(inhospitalNote.getPatientUuid());
		return true;
	}
	//诊断病案合并
	public boolean checkMatchToCloudDiagnosisInfo(MedicalRecord medicalRecord,DiagnosisInfo diagnosisInfo){
		//patientUuid
		medicalRecord.setPatientUuid(diagnosisInfo.getPatientUuid());
		//patientId
		medicalRecord.setPatientId(diagnosisInfo.getPatientId());
		//病历类型
		if (medicalRecord.getEmrType() == null) {
			medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		}
		//病历子类型
		if (medicalRecord.getEmrSubType() == null) {
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_DIAGNOSIS);
		}
		//结构化标志
		if (medicalRecord.getStructFlag() == null) {
			medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);
		}
		//医疗记录发生时间、就诊时间（实际发生时间）。
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(diagnosisInfo.getVisitTime());
		}
		if (medicalRecord.getSyncFlag() == null) {
			medicalRecord.setSyncFlag(Constant.User.SYNCFLAG_YES);
		}
		return true;
	}
}
