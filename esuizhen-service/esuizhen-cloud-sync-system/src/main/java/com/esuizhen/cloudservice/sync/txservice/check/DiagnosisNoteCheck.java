/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.check;<br/>  
 * <b>文件名：</b>DiagnosisNoteCheck.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月21日上午11:51:15<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.excption.EmptyObjectExcption;

/**
 * @ClassName: DiagnosisNoteCheck
 * @Description:
 * @author lichenghao
 * @date 2016年12月21日 上午11:51:15
 */
@Component
public class DiagnosisNoteCheck {

	@Autowired
	private UuidRelationshipService uuidRelationshipService;

	// 检查是否进匹配
	public boolean checkDiagnosisInfoInMatch(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo) {
		String uuid=null;
		Long patientId=null;
		Long doctorId = null;
		/**
		 * 患者校验
		 */
		uuid = diagnosisNoteDetailInfo.getPatientUuid();
		if (StringUtils.isNotEmpty(uuid)&&diagnosisNoteDetailInfo.getPatientId()==null) {
			patientId = uuidRelationshipService.getPatientId(uuid);
			if(patientId==null)
				return true;
			diagnosisNoteDetailInfo.setPatientId(patientId);
		} else {
			if(diagnosisNoteDetailInfo.getPatientId()==null)
				throw new EmptyObjectExcption("sync diagnosis error patientuuid is null");
		}
		/**
		 * 创建人校验
		 */
		uuid = diagnosisNoteDetailInfo.getCreatorUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(diagnosisNoteDetailInfo.getCreatorUuid());
			if (doctorId == null)
				return true;
			diagnosisNoteDetailInfo.setCreator(doctorId);
		}
		/**
		 * 操作人校验
		 */
		uuid = diagnosisNoteDetailInfo.getOperatorUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(diagnosisNoteDetailInfo.getCreatorUuid());
			if (doctorId == null)
				return true;
			diagnosisNoteDetailInfo.setOperatorId(doctorId);
		}
		/**
		 * 操作人校验
		 */
		uuid = diagnosisNoteDetailInfo.getDiagnosisDoctorUuid();
		if (StringUtils.isNotEmpty(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(diagnosisNoteDetailInfo.getCreatorUuid());
			if (doctorId == null)
				return true;
			diagnosisNoteDetailInfo.setDiagnosisDoctorId(doctorId);
		}
		return false;
	}
}
