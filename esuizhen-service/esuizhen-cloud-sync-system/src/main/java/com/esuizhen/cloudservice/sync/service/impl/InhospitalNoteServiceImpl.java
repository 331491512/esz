package com.esuizhen.cloudservice.sync.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.esuizhen.cloudservice.sync.dao.incre.IncreInhospitalNoteDao;
import com.esuizhen.cloudservice.sync.model.InhospitalNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.InhospitalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxInhospitalNoteService;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.GeneralUtil;

/**
 * 
 * @author YYCHEN
 *
 */
@Service
public class InhospitalNoteServiceImpl implements InhospitalNoteService {
	@Autowired
	private IncreInhospitalNoteDao increInhospitalNoteDao;

	@Autowired
	private TxInhospitalNoteService txInhospitalNote;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	/**
	 	{ 
			"patientUuid":"asdfweskpko145645454545ga",
			"patientNo":"01254852",
			"emrNo":"0131101000987698",//TOB生成的电子病历住院登记编号，唯一标识一次住院
			"inhospitalWay”:1,
			“inhospitalDate”: "2015-10-9 10:02:00”,
			“inhospitalDeptUuid”: "uuid541541515”,
			“inhospitalWard”: "vip 1病室”，
			“inhospitalTimes”:3,
			“medicalPayType”:4，
			“healthCardNo”:"N012544444"，
			“turnDeptUuid”:”uuid”，
			“turnDeptDate”:"2015-09-08 09:06:06"，
			“outhospitalDeptUuid”:”uuid”，
			“outhospitalDate”:"2015-09-08 09:06:06"，
			“outhospitalWard”:3，
			“inhospitalDays”:7，
			“diagnose”:"肿瘤"，
			“diseaseCode”:"c34"，
			“deptDoctorUuid”: “11111asdfasdf”
			“directorDoctorUuid”: “fasfegege15545feefe”，
			“inchargeDoctorUuid”: “fasfegege15545feefe”，
			“inhospitalDoctorUuid”: “fasfegege15545feefe”，
			“attendingDoctorUuid”: “fasfegege15545feefe”，
			“dutyNurseUuid”: “fasfegege15545feefe”，
			“postgraduateDoctorUuid”: vfasfegege15545feefe”，
			“internshipDoctorUuid”: “fasfegege15545feefe”，
			“codePersonUuid”: “fasfegege15545feefe”，
			“medicalRecordsQuality”:1，
			“qualityControlDoctorUuid”:”asdfasdf545454”，
			“qualityControlNurseUuid”:”asdf545454”，
			“qualityControlDate”:15632，
			“mainDiagnosis”:"肺癌"，
			“mainDiagnosisCode”:"c34"，
			“inhospitalCondition”:1，
			“sourceflag”:3，
			“historyCuration”:13，
			“sourceCancerNum”:1， 
			" hospitalId ":15,
		}
	 * @throws HospitalWithoutRightExcption 
	 */
	@Transactional
	@Override
	public MedicalRecord syncInhospitalNote(TPatientInHospitalNoteDetailInfo inHospitalNoteDetailInfo) throws HospitalWithoutRightExcption {
		if(inHospitalNoteDetailInfo==null||!checkBeforeSyncService.checkHospitalId(inHospitalNoteDetailInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		//将数据保存到增量数据库
		this.savePatientInHospitalNoteDetailInfoToIncre(inHospitalNoteDetailInfo);
		
		return this.txInhospitalNote.syncInhospitalNote(inHospitalNoteDetailInfo);
	}
	
	/**
	 * 
	 * @param inHospitalNoteDetailInfo
	 * @return
	 */
	private boolean savePatientInHospitalNoteDetailInfoToIncre(TPatientInHospitalNoteDetailInfo inHospitalNoteDetailInfo){
		Date nowTime = new Date();
		if(inHospitalNoteDetailInfo.getCreateTime()==null)
			inHospitalNoteDetailInfo.setCreateTime(nowTime);
		inHospitalNoteDetailInfo.setUpdateTime(nowTime);
		inHospitalNoteDetailInfo.setSyncTime(nowTime);
		//电子病历
		if(StringUtils.isEmpty(inHospitalNoteDetailInfo.getEmrId()))
			inHospitalNoteDetailInfo.setEmrId(GeneralUtil.generatorUUID("EMRI"));
//		MedicalRecord medicalRecord = inHospitalNoteDetailInfo.createMedicalRecord();
//		this.increMedicalRecordDao.insert(medicalRecord);
		
		//住院信息
		if(!StringUtils.isEmpty(inHospitalNoteDetailInfo.getUuid()))
			inHospitalNoteDetailInfo.setInhospitalId(inHospitalNoteDetailInfo.getUuid());
		if(StringUtils.isEmpty(inHospitalNoteDetailInfo.getInhospitalId()))
			inHospitalNoteDetailInfo.setInhospitalId(GeneralUtil.generatorUUID("EINH"));
		InhospitalNote inhospitalNote = inHospitalNoteDetailInfo.createInhospitalNote();
		this.increInhospitalNoteDao.insert(inhospitalNote);
		return true;
	}

}
