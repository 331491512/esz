/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.check;<br/>  
 * <b>文件名：</b>InhospitalNoteCheck.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月14日下午4:57:05<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.check;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.esuizhen.cloudservice.sync.common.Const;
import com.esuizhen.cloudservice.sync.model.InhospitalNote;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.constant.Constant;

/** 
* @ClassName: InhospitalNoteCheck
* @Description: 
* @author lichenghao
* @date 2016年12月14日 下午4:57:05  
*/
@Component
public class InhospitalNoteCheck {
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	
	public boolean checkMatchToCloud(InhospitalNote inhospitalNote){
		Integer deptId;
		Long doctorId;
		String uuid;
		//inhospitalDeptUuid
		uuid = inhospitalNote.getInhospitalDeptUuid();
		if (checkUuid(uuid)) {
			deptId = this.uuidRelationshipService.getDeptId(uuid);
			if(deptId==null)
				return false;
			inhospitalNote.setInhospitalDeptId(deptId);
		}
		//turnDeptUuid
		uuid = inhospitalNote.getTurnDeptUuid();
		if (checkUuid(uuid)) {
			deptId = this.uuidRelationshipService.getDeptId(uuid);
			//部门不存在，这次不合并
			if(deptId==null)
				return false;
			inhospitalNote.setTurnDeptId(deptId);
		}
		//outhospitalDeptUuid
		uuid = inhospitalNote.getOuthospitalDeptUuid();
		if (checkUuid(uuid)) {
			deptId = this.uuidRelationshipService.getDeptId(uuid);
			//部门不存在
			if(deptId==null)
				return false;
			inhospitalNote.setOuthospitalDeptId(deptId);
		}
		//deptDoctorUuid
		uuid = inhospitalNote.getDeptDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setDeptDoctor(doctorId);
		}
		//directorDoctorUuid
		uuid = inhospitalNote.getDirectorDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setDirectorDoctor(doctorId);
		}
		//inchargeDoctorUuid
		uuid = inhospitalNote.getInchargeDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setInchargeDoctor(doctorId);
		}
		//inhospitalDoctorUuid
		uuid = inhospitalNote.getInhospitalDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setInhospitalDoctor(doctorId);
		}
		//attendingDoctorUuid
		uuid = inhospitalNote.getAttendingDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setAttendingDoctor(doctorId);
		}
		//dutyNurseUuid
		uuid = inhospitalNote.getDutyNurseUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setDutyNurse(doctorId);
		}
		//postgraduateDoctorUuid
		uuid = inhospitalNote.getPostgraduateDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setPostgraduateDoctor(doctorId);
		}
		//internshipDoctorUuid
		uuid = inhospitalNote.getInternshipDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setInternshipDoctor(doctorId);
		}
		//codePersonUuid
		uuid = inhospitalNote.getCodePersonUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setCodePerson(doctorId);
		}
		//qualityControlDoctorUuid
		uuid = inhospitalNote.getQualityControlDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setQualityControlDoctor(doctorId);
		}
		//qualityControlNurseUuid
		uuid = inhospitalNote.getQualityControlNurseUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			//医生不存在，这次不合并
			if (doctorId == null)
				return false;
			inhospitalNote.setQualityControlNurse(doctorId);
		}
		//住院次数
		if (inhospitalNote.getInhospitalTimes() == null) {
			inhospitalNote.setInhospitalTimes(Const.INHOSPITALTIMES_FIRST);//默认第一次住院
		}
		//syncflag
		if (inhospitalNote.getSyncFlag() == null) {
			inhospitalNote.setSyncFlag(Constant.SYNC_OK);
		}
		//sourceflag
		if (inhospitalNote.getSourceFlag() == null) {
			inhospitalNote.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		return true;
	}
	
	//住院病案首页患者医生检查
	public boolean checkInhospitalNoteInMatch(TPatientInHospitalNoteDetailInfo inHospitalNoteDetailInfo) {
		Long doctorId = null;
		Long patientId = null;
		Integer deptId = null;
		// 患者确定
		String uuid = inHospitalNoteDetailInfo.getPatientUuid();
		if (checkUuid(uuid)) {
			patientId = this.uuidRelationshipService.getPatientId(uuid);
			if (patientId == null)
				return true;
			inHospitalNoteDetailInfo.setPatientId(patientId);
		} else {
			return true;
		}
		// 确定入院科别
		uuid = inHospitalNoteDetailInfo.getInhospitalDeptUuid();
		if (checkUuid(uuid)) {
			deptId = this.uuidRelationshipService.getDeptId(uuid);
			if (deptId == null)
				return true;
			inHospitalNoteDetailInfo.setInhospitalDeptId(deptId);
		}
		// 确定转科科别
		uuid = inHospitalNoteDetailInfo.getTurnDeptUuid();
		if (checkUuid(uuid)) {
			deptId = this.uuidRelationshipService.getDeptId(uuid);
			if (deptId == null)
				return true;
			inHospitalNoteDetailInfo.setTurnDeptId(deptId);
		}
		// 确定出院科别
		uuid = inHospitalNoteDetailInfo.getOuthospitalDeptUuid();
		if (checkUuid(uuid)) {
			deptId = this.uuidRelationshipService.getDeptId(uuid);
			if (deptId == null)
				return true;
			inHospitalNoteDetailInfo.setOuthospitalDeptId(deptId);
		}
		// 科室医生uuid
		uuid = inHospitalNoteDetailInfo.getDeptDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setDeptDoctor(doctorId);
		}
		// 主任医师uuid
		uuid = inHospitalNoteDetailInfo.getDirectorDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setDirectorDoctor(doctorId);
		}
		// 主治医师uuid
		uuid = inHospitalNoteDetailInfo.getInchargeDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setInchargeDoctor(doctorId);
		}
		// 住院医师uuid
		uuid = inHospitalNoteDetailInfo.getInhospitalDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setInhospitalDoctor(doctorId);
		}
		// 主诊医师uuid
		uuid = inHospitalNoteDetailInfo.getAttendingDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setAttendingDoctor(doctorId);
		}
		// 责任护士uuid
		uuid = inHospitalNoteDetailInfo.getDutyNurseUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setDutyNurse(doctorId);
		}
		// 确定进修医师uuid
		uuid = inHospitalNoteDetailInfo.getPostgraduateDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setPostgraduateDoctor(doctorId);
		}
		// 确定实习医师uuid
		uuid = inHospitalNoteDetailInfo.getInternshipDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setInternshipDoctor(doctorId);
		}
		// 确定编码员uuid
		uuid = inHospitalNoteDetailInfo.getCodePersonUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setCodePerson(doctorId);
		}
		// 确定质控医师uuid
		uuid = inHospitalNoteDetailInfo.getQualityControlDoctorUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setQualityControlDoctor(doctorId);
		}
		// 确定质控护士uuid
		uuid = inHospitalNoteDetailInfo.getQualityControlNurseUuid();
		if (checkUuid(uuid)) {
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if (doctorId == null)
				return true;
			inHospitalNoteDetailInfo.setQualityControlNurse(doctorId);
		}
		return false;
	}

	private boolean checkUuid(String uuid) {
		return StringUtils.isNotEmpty(uuid);
	}
}
