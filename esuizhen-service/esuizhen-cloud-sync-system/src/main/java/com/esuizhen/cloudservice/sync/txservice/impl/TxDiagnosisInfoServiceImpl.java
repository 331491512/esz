package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TDetectionReportDetailSync;
import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDepartmentDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDiagnosisInfoDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDiseaseTypeICD10Dao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudEciDetectionDetailDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudEciDetectionReportDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudEciExamReportDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDiagnosisInfoDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchEciDetectionDetailDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchEciDetectionReportDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchEciExamReportDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchMedicalRecordDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.model.Department;
import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.esuizhen.cloudservice.sync.model.DiseaseTypeICD10;
import com.esuizhen.cloudservice.sync.model.EciDetectionDetail;
import com.esuizhen.cloudservice.sync.model.EciDetectionReport;
import com.esuizhen.cloudservice.sync.model.EciExamReport;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.DiseaseTypeICD10Service;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxDiagnosisInfoService;
import com.esuizhen.cloudservice.sync.txservice.check.DiagnosisNoteCheck;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.service.PatientService;
import com.westangel.common.util.LogUtil;

@Service
public class TxDiagnosisInfoServiceImpl implements TxDiagnosisInfoService {
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private MatchDoctorDao matchDoctorDao; 
	@Autowired
	private CloudMedicalRecordDao cloudMedicalRecordDao;
	@Autowired
	private CloudEciDetectionReportDao cloudEciDetectionReportDao;
	@Autowired
	private CloudEciDetectionDetailDao cloudEciDetectionDetailDao;
	@Autowired
	private CloudEciExamReportDao cloudEciExamReportDao;
	@Autowired
	private CloudDiagnosisInfoDao cloudDiagnosisInfoDao;
	@Autowired
	private CloudDiseaseTypeICD10Dao cloudDiseaseTypeICD10Dao;
	//add by fanpanwei
	@Autowired
	private CloudDepartmentDao cloudDepartmentDao;
	
	@Autowired
	private MatchDiagnosisInfoDao matchDiagnosisInfoDao;
	@Autowired
	private MatchEciExamReportDao matchEciExamReportDao;
	@Autowired
	private MatchEciDetectionReportDao matchEciDetectionReportDao;
	@Autowired
	private MatchEciDetectionDetailDao matchEciDetectionDetailDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private MatchMedicalRecordDao matchMedicalRecordDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private DiseaseTypeICD10Service diseaseTypeICD10Service;
	@Autowired
	private DiagnosisNoteCheck diagnosisNoteCheck;
	
	@Resource(name="patientService")
	private PatientService patientService;

	@Transactional
	@Override
	public DiagnosisInfo syncDiagnosisInfo(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo) {
		diagnosisNoteDetailInfo.setPatientId(null);
		if (!diagnosisNoteCheck.checkDiagnosisInfoInMatch(diagnosisNoteDetailInfo)) {
			//保存在云端数据库
			return this.savePatientDiagnosisNoteDetailInfoToCloud(diagnosisNoteDetailInfo);
		} else {
			if(diagnosisNoteDetailInfo.getPatientId()==null){
				Patient patient = matchPatientDao.findByUuid(diagnosisNoteDetailInfo.getPatientUuid());
				if(patient==null)
					new EmptyObjectExcption("sync error patient not in clound");
			}
			//存放在匹配中间库
			return this.savePatientDiagnosisNoteDetailInfoToMatch(diagnosisNoteDetailInfo);
		}
	}
	
	/**
	 * 
	 * @param diagnosisNoteDetailInfo
	 * @return
	 */
	private DiagnosisInfo savePatientDiagnosisNoteDetailInfoToMatch(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo){
		//保存诊断信息
		DiagnosisInfo diagnosisInfo = diagnosisNoteDetailInfo.createDiagnosisInfo();
		this.matchDiagnosisInfoDao.insert(diagnosisInfo);
		LogUtil.log.debug("保存诊断信息到中间库完成（savePatientDiagnosisNoteDetailInfoToMatch()）----------<<");
		return diagnosisInfo;
	}
	
	/**
	 * 
	 * @param diagnosisNoteDetailInfo
	 * @return
	 */
	private DiagnosisInfo savePatientDiagnosisNoteDetailInfoToCloud(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo){
		LogUtil.log.debug("保存诊断信息到云端库（savePatientDiagnosisNoteDetailInfoToCloud()）---------->>>");
		//保存电子病历信息
		MedicalRecord medicalRecord = diagnosisNoteDetailInfo.createMedicalRecord();
		medicalRecord.setCreateTime(diagnosisNoteDetailInfo.getCreateTime());
		this.cloudMedicalRecordDao.insert(medicalRecord);
		//保存诊断信息
		DiagnosisInfo diagnosisInfo = diagnosisNoteDetailInfo.createDiagnosisInfo();
		//诊断类型
		if (diagnosisInfo.getDiagnosisTypeId() == null) {
			diagnosisInfo.setDiagnosisTypeId(2);
		}
		this.cloudDiagnosisInfoDao.insert(diagnosisInfo);
		LogUtil.log.debug("保存诊断信息到云端库完成（savePatientDiagnosisNoteDetailInfoToCloud()）---------->>>");
		diagnosisInfo.setFormalFlag(1);
		return diagnosisInfo;
	}
	
	@Transactional
	@Override
	public void implementExamReportCoudSync(TExamReportSync tExamReportSync) throws RejectRequestExcption {
		boolean toMDBFlag = false;//进匹配库的标识，默认是false不进。
		String finalPatientUuid = this.uuidRelationshipService.getFinalUuidByUuid(tExamReportSync.getPatientUuid());
		if (StringUtils.isEmpty(finalPatientUuid)) {
			finalPatientUuid = tExamReportSync.getPatientUuid();
		}
		Patient patient = this.cloudPatientDao.findByUuid(finalPatientUuid);
		if (patient == null) {
			patient = this.matchPatientDao.findByUuid(finalPatientUuid);
			if (patient != null) {
				toMDBFlag=true;
			}else throw new RejectRequestExcption("patient is null!");
		}
		Doctor applyDoctor = null;
		if (StringUtils.isNotEmpty(tExamReportSync.getApplyDoctorUuid())) {
			String finalAppyDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(tExamReportSync.getApplyDoctorUuid());
			if (StringUtils.isEmpty(finalAppyDoctorUuid)) {
				finalAppyDoctorUuid = tExamReportSync.getApplyDoctorUuid();
			}
			applyDoctor = this.cloudDoctorDao.findByUuid(finalAppyDoctorUuid);
		}

		//start by fanpanwei
		Doctor reportDoctor = null;
		if (StringUtils.isNotEmpty(tExamReportSync.getReportDoctorUuid())) {
			String finalReportDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(tExamReportSync.getReportDoctorUuid());
			if (StringUtils.isEmpty(finalReportDoctorUuid)) {
				finalReportDoctorUuid = tExamReportSync.getReportDoctorUuid();
			}
			reportDoctor = this.cloudDoctorDao.findByUuid(finalReportDoctorUuid);
		}
		//end by fanpanwei
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(tExamReportSync.getEmrId());
		medicalRecord.setEmrNo(tExamReportSync.getEmrNo());
		
		medicalRecord.setEmrType(tExamReportSync.getOutPatientFlag());
		if (medicalRecord.getEmrType() == null) {
			medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		}
		medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_CHECK);
		medicalRecord.setPatientNo(tExamReportSync.getPatientNo());
		medicalRecord.setHospitalId(tExamReportSync.getHospitalId());
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setStructFlag(0);
		medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
		medicalRecord.setVisitTime(tExamReportSync.getCreateTime());
		medicalRecord.setSyncFlag(Constant.User.SYNCFLAG_YES);
		medicalRecord.setCreateTime(tExamReportSync.getCreateTime());
		medicalRecord.setPatientId(patient.getPatientId());
		EciExamReport eciExamReport = new EciExamReport();
		eciExamReport.setExamReportId(tExamReportSync.getExamReportId());
		eciExamReport.setEmrId(tExamReportSync.getEmrId());
		if(!toMDBFlag){
			eciExamReport.setPatientId(patient.getPatientId());
			medicalRecord.setPatientUuid(finalPatientUuid);
			eciExamReport.setPatientName(tExamReportSync.getPatientName());
			if (StringUtils.isEmpty(eciExamReport.getPatientName())) {
				eciExamReport.setPatientName(patient.getTrueName());
			}
		}else eciExamReport.setPatientUuid(tExamReportSync.getPatientUuid());
		eciExamReport.setPatientId(patient.getPatientId());
		eciExamReport.setPatientNo(tExamReportSync.getPatientNo());
		eciExamReport.setOutPatientFlag(tExamReportSync.getOutPatientFlag());
		eciExamReport.setHospitalId(tExamReportSync.getHospitalId());
		eciExamReport.setExamTypeId(tExamReportSync.getExamTypeId());
		eciExamReport.setExamChildTypeId(tExamReportSync.getExamChildTypeId());
		eciExamReport.setExamTypeName(tExamReportSync.getExamTypeName());
		eciExamReport.setDeptId(tExamReportSync.getDeptId());
		eciExamReport.setDeptName(tExamReportSync.getDeptName());
		Department department = cloudDepartmentDao.findByUuid(tExamReportSync.getDeptUuid());
		if(department!=null){//
			eciExamReport.setDeptId(department.getDeptId());
			if(StringUtils.isBlank(eciExamReport.getDeptName())){
				eciExamReport.setDeptName(department.getDeptName());
			}
		}
		eciExamReport.setReportTitle(tExamReportSync.getReportTitle());
		eciExamReport.setScanningTechnique(tExamReportSync.getScanningTechnique());
		eciExamReport.setExamWay(tExamReportSync.getExamWay());
		eciExamReport.setObtainWay(tExamReportSync.getObtainWay());
		eciExamReport.setOrganCode(tExamReportSync.getOrganCode());
		eciExamReport.setOrgan(tExamReportSync.getOrgan());
		eciExamReport.setBodyPart(tExamReportSync.getBodyPart());
		eciExamReport.setNidusCode(tExamReportSync.getNidusCode());
		eciExamReport.setNidus(tExamReportSync.getNidus());
		eciExamReport.setNidusSourceFlag(tExamReportSync.getNidusSourceFlag());
		eciExamReport.setLongestDiameter(tExamReportSync.getLongestDiameter());
		eciExamReport.setShortestDiameter(tExamReportSync.getShortestDiameter());
		eciExamReport.setExamFinding(tExamReportSync.getExamFinding());
		eciExamReport.setExamConclusion(tExamReportSync.getExamConclusion());
		eciExamReport.setPicFileUrls(tExamReportSync.getPicFileUrls());
		eciExamReport.setImageFileFormat(tExamReportSync.getImageFileFormat());
		eciExamReport.setApplyDoctorId(tExamReportSync.getApplyDoctorId());
		//add by fanpanwei 
		eciExamReport.setApplyDoctorUuid(tExamReportSync.getApplyDoctorUuid());
		eciExamReport.setApplyDoctorName(tExamReportSync.getApplyDoctorName());
		if (applyDoctor != null) {
			eciExamReport.setApplyDoctorUuid(applyDoctor.getUuid());
			eciExamReport.setApplyDoctorId(applyDoctor.getDoctorId());
			if (StringUtils.isEmpty(eciExamReport.getApplyDoctorName())) {
				eciExamReport.setApplyDoctorName(applyDoctor.getTrueName());
			}
		}
		eciExamReport.setApplyDoctorUuid(tExamReportSync.getApplyDoctorUuid());
		eciExamReport.setApplyDoctorNo(tExamReportSync.getApplyDoctorNo());
		eciExamReport.setReportDoctorId(tExamReportSync.getReportDoctorId());
		//add by fanpanwei
		eciExamReport.setReportDoctorUuid(tExamReportSync.getReportDoctorUuid());
		eciExamReport.setReportDoctorNo(tExamReportSync.getReportDoctorNo());
		eciExamReport.setReportDoctorName(tExamReportSync.getReportDoctorName());
		//start by fanpanwei
		if(reportDoctor!=null){
			eciExamReport.setReportDoctorUuid(reportDoctor.getUuid());
			eciExamReport.setReportDoctorId(reportDoctor.getDoctorId());
			if (StringUtils.isEmpty(eciExamReport.getReportDoctorName())) {
				eciExamReport.setReportDoctorName(reportDoctor.getTrueName());
			}
		}
		//end by fanpanwei
		eciExamReport.setState(tExamReportSync.getState());
		eciExamReport.setReadFlag(Constant.User.READFLAG_NO);
		eciExamReport.setApplyTime(tExamReportSync.getApplyTime());
		eciExamReport.setExcuteTime(tExamReportSync.getExcuteTime());
		if (eciExamReport.getApplyTime() == null) {
			eciExamReport.setApplyTime(eciExamReport.getExcuteTime());
		}
		eciExamReport.setReportTime(tExamReportSync.getReportTime());
		eciExamReport.setCreateTime(tExamReportSync.getCreateTime());
		eciExamReport.setUpdateTime(tExamReportSync.getUpdateTime());
		eciExamReport.setSyncFlag(Constant.User.SYNCFLAG_YES);
		// start by fanpanwei
		eciExamReport.setRawCreateTime(tExamReportSync.getRawCreateTime());
		eciExamReport.setInhospitaltimes(tExamReportSync.getInhospitaltimes());
		//end by fanpanwei
		
		if(!toMDBFlag){
			ArrayList<String> uuIdList = new ArrayList<String>(); 
			uuIdList.add(eciExamReport.getApplyDoctorUuid());
			uuIdList.add(eciExamReport.getReportDoctorUuid());
			if(uuIdList!=null&&uuIdList.size()>0){
				Integer mdoctorTotal= null;
				for (Iterator<String> iterator = uuIdList.iterator(); iterator.hasNext();) {
					mdoctorTotal=matchDoctorDao.findDoctorByUuId(iterator.next());
					if(mdoctorTotal!=null){
						toMDBFlag=true;
						break;
					}
				}
			}
		}
		if(!toMDBFlag){//同步至云端
			this.cloudMedicalRecordDao.insert(medicalRecord);
			this.cloudEciExamReportDao.insert(eciExamReport);
		}else{//插入匹配库
			//同步至匹配库
			this.matchEciExamReportDao.insert(eciExamReport);
		}
		
		LogUtil.log.debug("检查报告同步保存到生产库完成,implementExamReportCoudSync()----------<<");
	}
	
	
	@Transactional
	@Override
	public void implementDetectionReportCloudSync(TDetectionReportSync detectionReportSync, List<Object> failds) throws RejectRequestExcption{
		boolean toMDBFlag = false;//进匹配库的标识，默认是false不进。
		String finalPatientUuid = this.uuidRelationshipService.getFinalUuidByUuid(detectionReportSync.getPatientUuid());
		if (StringUtils.isEmpty(finalPatientUuid)) {
			finalPatientUuid = detectionReportSync.getPatientUuid();
		}
		Patient patient = this.cloudPatientDao.findByUuid(finalPatientUuid);
		if (patient == null) {
			patient = this.matchPatientDao.findByUuid(finalPatientUuid);
			if (patient != null) {
				toMDBFlag=true;
			}else throw new RejectRequestExcption("patient is null!");
		}
		Doctor applyDoctor = null;
		if (StringUtils.isNotEmpty(detectionReportSync.getApplyDoctorUuid())) {
			String finalAppyDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(detectionReportSync.getApplyDoctorUuid());
			if (StringUtils.isEmpty(finalAppyDoctorUuid)) {
				finalAppyDoctorUuid = detectionReportSync.getApplyDoctorUuid();
			}
			applyDoctor = this.cloudDoctorDao.findByUuid(finalAppyDoctorUuid);
		}
		
	/*	deptUuid 
		operateDoctorUuid
		reportDoctorUuid
		auditDoctorUuid*/
		// start by fanpanwei
		Department departmentByUuid = cloudDepartmentDao.findByUuid(detectionReportSync.getDeptUuid());
		Doctor operateDoctor = null;
		if (StringUtils.isNotEmpty(detectionReportSync.getOperateDoctorUuid())) {
			String finalOperateDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(detectionReportSync.getOperateDoctorUuid());
			if (StringUtils.isEmpty(finalOperateDoctorUuid)) {
				finalOperateDoctorUuid = detectionReportSync.getOperateDoctorUuid();
			}
			operateDoctor = this.cloudDoctorDao.findByUuid(finalOperateDoctorUuid);
		}
		Doctor reportDoctor = null;
		if (StringUtils.isNotEmpty(detectionReportSync.getReportDoctorUuid())) {
			String finalReportDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(detectionReportSync.getReportDoctorUuid());
			if (StringUtils.isEmpty(finalReportDoctorUuid)) {
				finalReportDoctorUuid = detectionReportSync.getReportDoctorUuid();
			}
			reportDoctor = this.cloudDoctorDao.findByUuid(finalReportDoctorUuid);
		}
		Doctor auditDoctor = null;
		if (StringUtils.isNotEmpty(detectionReportSync.getAuditDoctorUuid())) {
			String finalAuditDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(detectionReportSync.getAuditDoctorUuid());
			if (StringUtils.isEmpty(finalAuditDoctorUuid)) {
				finalAuditDoctorUuid = detectionReportSync.getAuditDoctorUuid();
			}
			auditDoctor = this.cloudDoctorDao.findByUuid(finalAuditDoctorUuid);
		}
		//end by fanpanei
		EciDetectionReport eciDetectionReport = this.cloudEciDetectionReportDao.findByDetectionReportId(detectionReportSync.getDetectionReportId());
		if (eciDetectionReport == null) {
			MedicalRecord medicalRecord = new MedicalRecord();
			medicalRecord.setEmrId(detectionReportSync.getEmrId());
			medicalRecord.setEmrNo(detectionReportSync.getEmrNo());
			medicalRecord.setEmrType(detectionReportSync.getOutPatientFlag());
			if (medicalRecord.getEmrType() == null) {
				medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
			}
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_LABORATORY);
			if(!toMDBFlag){
				medicalRecord.setPatientId(patient.getPatientId());
				medicalRecord.setPatientUuid(finalPatientUuid);
			}else medicalRecord.setPatientUuid(detectionReportSync.getPatientUuid());
			
			medicalRecord.setPatientNo(detectionReportSync.getPatientNo());
			medicalRecord.setHospitalId(detectionReportSync.getHospitalId());
			medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
			medicalRecord.setStructFlag(0);
			medicalRecord.setVisitTime(detectionReportSync.getCreateTime());
			medicalRecord.setSyncFlag(Constant.User.SYNCFLAG_YES);
			medicalRecord.setCreateTime(detectionReportSync.getCreateTime());
			eciDetectionReport = new EciDetectionReport();
			eciDetectionReport.setEmrId(detectionReportSync.getEmrId());
			eciDetectionReport.setDetectionReportId(detectionReportSync.getDetectionReportId());
			if(!toMDBFlag){
				eciDetectionReport.setPatientId(patient.getPatientId());
				eciDetectionReport.setPatientName(detectionReportSync.getPatientName());
				eciDetectionReport.setPatientUuid(finalPatientUuid);
			}else eciDetectionReport.setPatientUuid(detectionReportSync.getPatientUuid());
			eciDetectionReport.setPatientNo(detectionReportSync.getPatientNo());
			eciDetectionReport.setPatientIdno(detectionReportSync.getPatientIdno());
			eciDetectionReport.setPatientAddress(detectionReportSync.getPatientAddress());
			eciDetectionReport.setPatientMobile(detectionReportSync.getPatientMobile());
			eciDetectionReport.setPatientSex(detectionReportSync.getPatientSex());
			eciDetectionReport.setOutPatientFlag(detectionReportSync.getOutPatientFlag());
			eciDetectionReport.setHospitalId(detectionReportSync.getHospitalId());
			eciDetectionReport.setDetectionTypeId(detectionReportSync.getDetectionTypeId());
			eciDetectionReport.setDetectionChildTypeId(detectionReportSync.getDetectionChildTypeId());
			eciDetectionReport.setDetectionTypeName(detectionReportSync.getDetectionTypeName());
			
			eciDetectionReport.setDeptId(detectionReportSync.getDeptId());
			eciDetectionReport.setDeptName(detectionReportSync.getDeptName());
			if(departmentByUuid!=null){
				eciDetectionReport.setDeptId(departmentByUuid.getDeptId());
				detectionReportSync.setDeptId(departmentByUuid.getDeptId());
				if(StringUtils.isBlank(eciDetectionReport.getDeptName())){
					eciDetectionReport.setDeptName(departmentByUuid.getDeptName());
					detectionReportSync.setDeptName(departmentByUuid.getDeptName());
				}
			}
			eciDetectionReport.setDiagnosis(detectionReportSync.getDiagnosis());
			eciDetectionReport.setSampleNo(detectionReportSync.getSampleNo());
			eciDetectionReport.setSampleName(detectionReportSync.getSampleName());
			eciDetectionReport.setSampleType(detectionReportSync.getSampleType());
			eciDetectionReport.setSampleState(detectionReportSync.getSampleState());
			eciDetectionReport.setApplyDoctorName(detectionReportSync.getApplyDoctorName());
			if (applyDoctor != null) {
				eciDetectionReport.setApplyDoctorId(applyDoctor.getDoctorId());
				if (StringUtils.isEmpty(eciDetectionReport.getApplyDoctorName())) {
					eciDetectionReport.setApplyDoctorName(applyDoctor.getTrueName());
				}
			}
			eciDetectionReport.setApplyDoctorUuid(detectionReportSync.getApplyDoctorUuid());
			eciDetectionReport.setApplyDoctorNo(detectionReportSync.getApplyDoctorNo());
			
			eciDetectionReport.setOperateDoctorId(detectionReportSync.getOperateDoctorId());
			eciDetectionReport.setOperateDoctorUuid(detectionReportSync.getOperateDoctorUuid());
			eciDetectionReport.setOperateDoctorNo(detectionReportSync.getOperateDoctorNo());
			eciDetectionReport.setOperateDoctorName(detectionReportSync.getOperateDoctorName());
			if (operateDoctor != null) {
				eciDetectionReport.setOperateDoctorId(operateDoctor.getDoctorId());
				if (StringUtils.isEmpty(eciDetectionReport.getOperateDoctorName())) {
					eciDetectionReport.setOperateDoctorName(operateDoctor.getTrueName());
				}
			}
			eciDetectionReport.setReportDoctorId(detectionReportSync.getReportDoctorId());
			eciDetectionReport.setReportDoctorUuid(detectionReportSync.getReportDoctorUuid());
			eciDetectionReport.setReportDoctorNo(detectionReportSync.getReportDoctorNo());
			eciDetectionReport.setReportDoctorName(detectionReportSync.getReportDoctorName());
			if (reportDoctor != null) {
				eciDetectionReport.setReportDoctorId(reportDoctor.getDoctorId());
				if (StringUtils.isEmpty(eciDetectionReport.getReportDoctorName())) {
					eciDetectionReport.setReportDoctorName(reportDoctor.getTrueName());
				}
			}
			eciDetectionReport.setAuditDoctorId(detectionReportSync.getAuditDoctorId());
			eciDetectionReport.setAuditDoctorUuid(detectionReportSync.getAuditDoctorUuid());
			eciDetectionReport.setAuditDoctorNo(detectionReportSync.getAuditDoctorNo());
			eciDetectionReport.setAuditDoctorName(detectionReportSync.getAuditDoctorName());
			if (auditDoctor != null) {
				eciDetectionReport.setAuditDoctorId(auditDoctor.getDoctorId());
				if (StringUtils.isEmpty(eciDetectionReport.getAuditDoctorName())) {
					eciDetectionReport.setAuditDoctorName(auditDoctor.getTrueName());
				}
			}
			eciDetectionReport.setRemark(detectionReportSync.getRemark());
			eciDetectionReport.setApplyTime(detectionReportSync.getApplyTime());
			eciDetectionReport.setSampleTime(detectionReportSync.getSampleTime());
			if (eciDetectionReport.getApplyTime() == null) {
				eciDetectionReport.setApplyTime(eciDetectionReport.getSampleTime());
			}
			eciDetectionReport.setAcceptTime(detectionReportSync.getAcceptTime());
			eciDetectionReport.setReportTime(detectionReportSync.getReportTime());
			eciDetectionReport.setState(detectionReportSync.getState());
			eciDetectionReport.setReadFlag(Constant.User.READFLAG_NO);
			eciDetectionReport.setCreateTime(detectionReportSync.getCreateTime());
			eciDetectionReport.setUpdateTime(detectionReportSync.getUpdateTime());
			eciDetectionReport.setSyncFlag(Constant.User.SYNCFLAG_YES);
			eciDetectionReport.setRawDetectionTypeId(detectionReportSync.getRawDetectionTypeId());
			eciDetectionReport.setRawDetectionChildTypeId(detectionReportSync.getRawDetectionChildTypeId());
			eciDetectionReport.setInstrument(detectionReportSync.getInstrument());
			eciDetectionReport.setMainID(detectionReportSync.getMainID());
			//Start by fanpanwei
			eciDetectionReport.setRawCreateTime(detectionReportSync.getRawCreateTime());
			eciDetectionReport.setInhospitaltimes(detectionReportSync.getInhospitaltimes());
			// end by fanpanwei
			if(!toMDBFlag){
				ArrayList<String> uuIdList = new ArrayList<String>(); 
				uuIdList.add(eciDetectionReport.getApplyDoctorUuid());
				uuIdList.add(eciDetectionReport.getReportDoctorUuid());
				uuIdList.add(eciDetectionReport.getAuditDoctorUuid());
				uuIdList.add(eciDetectionReport.getOperateDoctorUuid());
				if(uuIdList!=null&&uuIdList.size()>0){
					Integer mdoctorTotal= null;
					for (Iterator<String> iterator = uuIdList.iterator(); iterator.hasNext();) {
						mdoctorTotal=matchDoctorDao.findDoctorByUuId(iterator.next());
						if(mdoctorTotal!=null){
							toMDBFlag=true;
							break;
						}
					}
				}
				
				
			}
			if(!toMDBFlag){//进正式
				this.cloudMedicalRecordDao.insert(medicalRecord);
				this.cloudEciDetectionReportDao.insert(eciDetectionReport);
			}else{//进匹配
				this.matchEciDetectionReportDao.insert(eciDetectionReport);
			}
		}
		List<TDetectionReportDetailSync> detectionReportDetailSyncs = detectionReportSync.getDetectionReportDetailList();
		if (detectionReportDetailSyncs != null && !detectionReportDetailSyncs.isEmpty()) {
			for (int j = 0, count = detectionReportDetailSyncs.size(); j < count; j++) {
				TDetectionReportDetailSync detectionReportDetailSync = detectionReportDetailSyncs.get(j);
				
				EciDetectionDetail eciDetectionDetail = this.cloudEciDetectionDetailDao.findByDetectionDetailId(detectionReportDetailSync.getDetectionDetailId());
				if (eciDetectionDetail == null) {
					eciDetectionDetail = new EciDetectionDetail();
					eciDetectionDetail.setDetectionDetailId(detectionReportDetailSync.getDetectionDetailId());
					eciDetectionDetail.setDetectionReportId(detectionReportSync.getDetectionReportId());
					if(patient != null){
						eciDetectionDetail.setPatientId(patient.getPatientId());
						eciDetectionDetail.setPatientUuid(finalPatientUuid);
					}else eciDetectionDetail.setPatientUuid(detectionReportSync.getPatientUuid());
					
					eciDetectionDetail.setPatientNo(detectionReportDetailSync.getPatientNo());
					eciDetectionDetail.setSeqNo(detectionReportDetailSync.getSeqNo());
					eciDetectionDetail.setDetectionItemId(detectionReportDetailSync.getDetectionItemId());
					eciDetectionDetail.setDetectionItemCode(detectionReportDetailSync.getDetectionItemCode());
					eciDetectionDetail.setDetectionResult(detectionReportDetailSync.getDetectionResult());
					eciDetectionDetail.setPrompt(detectionReportDetailSync.getPrompt());
					eciDetectionDetail.setResultType(detectionReportDetailSync.getResultType());
					eciDetectionDetail.setUnit(detectionReportDetailSync.getUnit());
					eciDetectionDetail.setRefrenceRangeMin(detectionReportDetailSync.getRefrenceRangeMin());
					eciDetectionDetail.setRefrenceRangeMax(detectionReportDetailSync.getRefrenceRangeMax());
					eciDetectionDetail.setDetectionMethod(detectionReportDetailSync.getDetectionMethod());
					eciDetectionDetail.setReagentBrand(detectionReportDetailSync.getReagentBrand());
					eciDetectionDetail.setInstrument(detectionReportDetailSync.getInstrument());
					eciDetectionDetail.setCreateTime(detectionReportSync.getCreateTime());
					eciDetectionDetail.setUpdateTime(detectionReportDetailSync.getUpdateTime());
					eciDetectionDetail.setDetectionTypeName(detectionReportDetailSync.getDetectionTypeName());
					eciDetectionDetail.setRawDetectionItemCode(detectionReportDetailSync.getRawDetectionItemCode());
					eciDetectionDetail.setDetectionItemName(detectionReportDetailSync.getDetectionItemName());
					eciDetectionDetail.setDetectionItemEnglishName(detectionReportDetailSync.getDetectionItemEnglishName());
					eciDetectionDetail.setRefrenceRange(detectionReportDetailSync.getRefrenceRange());
					eciDetectionDetail.setDetailID(detectionReportDetailSync.getDetailID());
					eciDetectionDetail.setMainID(detectionReportDetailSync.getMainID());
					eciDetectionDetail.setSyncFlag(Constant.User.SYNCFLAG_YES);
					//add by fanpanwei
					eciDetectionDetail.setPromptType(detectionReportDetailSync.getPromptType());
					eciDetectionDetail.setRawCreateTime(detectionReportDetailSync.getRawCreateTime());
					try {
						if(toMDBFlag){//进匹配
							this.matchEciDetectionDetailDao.insert(eciDetectionDetail);
						}else{//进生产
							this.cloudEciDetectionDetailDao.insert(eciDetectionDetail);
						}
						
					} catch (Exception e) {
						LogUtil.logError.error("同步LIS详情出错："+e.getCause() + ";" + e.getMessage());
						failds.add(eciDetectionDetail.getDetailID());
					}
				}
			}
		}
		LogUtil.log.debug("检验单同步保存到生产库完成,implementDetectionReportCloudSync()----------<<");
	}
	@Override
	public boolean mergeDiagnosisInfo(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with diagnostic data---------->>");
		//将患者诊断信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchDiagnosisInfoDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TPatientDiagnosisNoteDetailInfo> diagnosisInfos = this.matchDiagnosisInfoDao.findByPatientUuid(patientFinalUuid);
		if (diagnosisInfos == null || diagnosisInfos.isEmpty()) {
			return true;
		}
		for (int i = diagnosisInfos.size() - 1; i >= 0; i--) {
			TPatientDiagnosisNoteDetailInfo diagnosisNote = diagnosisInfos.get(i);
			diagnosisNote.setPatientUuid(patientFinalUuid);
			diagnosisNote.setPatientId(patientId);
			if(diagnosisNoteCheck.checkDiagnosisInfoInMatch(diagnosisNote))
				continue;
			DiagnosisInfo diagnosisInfo = diagnosisNote.createDiagnosisInfo();
			MedicalRecord medicalRecord = diagnosisNote.createMedicalRecord();
			//诊断类型
			if (diagnosisInfo.getDiagnosisTypeId() == null) {
				diagnosisInfo.setDiagnosisTypeId(2);
			}
			//处理病种
			if (diagnosisInfo.getDiseaseTypeId() == null) {
				//通过ICD-10编码反查病种
				if (StringUtils.isNotEmpty(diagnosisInfo.getDiseaseCode())) {
					DiseaseTypeICD10 diseaseTypeICD10 = this.diseaseTypeICD10Service.getDiseaseTypeIdByDiseaseCode(diagnosisInfo.getDiseaseCode());
					if (diseaseTypeICD10 != null) {
						diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
						diagnosisInfo.setDiseaseBodyPartId(diagnosisInfo.getDiseaseBodyPartId());
					}else{
						//非肿瘤
						//病种9999
						diagnosisInfo.setDiseaseTypeId(9999);
						diagnosisInfo.setDiseaseBodyPartId(99);
					}
				}else if(StringUtils.isNotEmpty(diagnosisInfo.getDiagnosis())){
					PageHelper.startPage(1, 1);
					List<DiseaseTypeICD10> diseaseTypeICD10s = this.cloudDiseaseTypeICD10Dao.findByDiseaseContent(0, diagnosisInfo.getDiagnosis());
					if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
						DiseaseTypeICD10 diseaseTypeICD10 = diseaseTypeICD10s.get(0);
						
						diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
						diagnosisInfo.setDiseaseBodyPartId(diagnosisInfo.getDiseaseBodyPartId());
					}else{
						diagnosisInfo.setDiseaseTypeId(null);
						diagnosisInfo.setDiseaseBodyPartId(null);
						diagnosisInfo.setDiseaseCode(null);
					}
				}
			}
			//保存到云端数据库
			this.cloudMedicalRecordDao.insert(medicalRecord);
			this.cloudDiagnosisInfoDao.insert(diagnosisInfo);
			//将匹配中间库的数据删除
			this.matchDiagnosisInfoDao.delete(diagnosisInfo.getDiagnosisId());
			this.matchDiagnosisInfoDao.delete(medicalRecord.getEmrId());
		}
		LogUtil.log.debug("合并诊断信息完成----------<<");
		return true;
	}
}
