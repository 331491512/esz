package com.esuizhen.cloudservice.sync.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.bean.PacAndLisResp;
import com.esuizhen.cloudservice.sync.bean.TDetectionReportDetailSync;
import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMetaEIcd10Dao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudUserDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreDiagnosisInfoDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreEciDetectionDetailDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreEciDetectionReportDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreEciExamReportDao;
import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.esuizhen.cloudservice.sync.model.EciDetectionDetail;
import com.esuizhen.cloudservice.sync.model.EciDetectionReport;
import com.esuizhen.cloudservice.sync.model.EciExamReport;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.DiagnosisInfoService;
import com.esuizhen.cloudservice.sync.txservice.TxDiagnosisInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.User;
import com.westangel.common.bean.ehr.MetaEicd10;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.service.PatientService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;

/**
 * 
 * @author YYCHEN
 *
 */
@Service
public class DiagnosisInfoServiceImpl implements DiagnosisInfoService {
	@Autowired
	private IncreDiagnosisInfoDao increDiagnosisInfoDao;
	@Autowired
	private IncreEciDetectionReportDao increEciDetectionReportDao;
	@Autowired
	private IncreEciDetectionDetailDao increEciDetectionDetailDao;
	@Autowired
	private IncreEciExamReportDao increEciExamReportDao;
	
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudMetaEIcd10Dao cloudMetaEIcd10Dao;
	@Autowired
	private CloudUserDao cloudUserDao;
	@Autowired
	private TxDiagnosisInfoService txDiagnosisInfoService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	@Resource(name="patientService")
	private PatientService patientService;
	
	
	/**
	 * { 
			"emrNo":"8768 ", //TOB生成的电子病历住院登记编号，唯一标识一次住院
			"patientUuid":"sdfsfd4646156501254852 ",
			"diseaseTypeId":12, 
			"diagnosis ":"肺癌",
			"diseaseCode ":"c34",
			"pathologyDiagnosis":"800000/0"，
			"pathologyDiagnosisCode":"良性肿瘤"，
			"isSourceDiagnosis ":1，
			"confirmedDate": "2015-1-6 12:34:00", 
			" hospitalId ":15
		}
	 * @throws HospitalWithoutRightExcption 
	 * 
	 */
	@Override
	public MedicalRecord syncDiagnosisInfo(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo) throws HospitalWithoutRightExcption {
		if(!checkBeforeSyncService.checkHospitalId(diagnosisNoteDetailInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		
		//将数据保存到增量数据库
		this.savePatientDiagnosisNoteDetailInfoToIncre(diagnosisNoteDetailInfo);
		this.txDiagnosisInfoService.syncDiagnosisInfo(diagnosisNoteDetailInfo);
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setEmrId(diagnosisNoteDetailInfo.getEmrId());
		return medicalRecord;
	}
	
	/**
	 * 
	 * @param diagnosisNoteDetailInfo
	 * @return
	 */
	private boolean savePatientDiagnosisNoteDetailInfoToIncre(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo){
		LogUtil.log.debug("保存诊断信息到增量库（savePatientDiagnosisNoteDetailInfoToIncre()）---------->>");
		Date nowTime = new Date();
		if(diagnosisNoteDetailInfo.getCreateTime()==null)
			diagnosisNoteDetailInfo.setCreateTime(nowTime);
		if(diagnosisNoteDetailInfo.getRawCreateTime()==null)
			diagnosisNoteDetailInfo.setRawCreateTime(diagnosisNoteDetailInfo.getCreateTime());
		if(diagnosisNoteDetailInfo.getUpdateTime()==null)
			diagnosisNoteDetailInfo.setUpdateTime(nowTime);
		diagnosisNoteDetailInfo.setSyncTime(nowTime);
		//保存电子病历信息
		if(StringUtils.isEmpty(diagnosisNoteDetailInfo.getEmrId()))
			diagnosisNoteDetailInfo.setEmrId(GeneralUtil.generatorUUID("EMRI"));
		
		/*MedicalRecord medicalRecord = diagnosisNoteDetailInfo.createMedicalRecord();
		this.increMedicalRecordDao.insert(medicalRecord);*/
		//保存诊断信息
		if(StringUtils.isNotEmpty(diagnosisNoteDetailInfo.getUuid()))
			diagnosisNoteDetailInfo.setDiagnosisId(diagnosisNoteDetailInfo.getUuid());
		if(StringUtils.isEmpty(diagnosisNoteDetailInfo.getDiagnosisId()))
			diagnosisNoteDetailInfo.setDiagnosisId(GeneralUtil.generatorUUID("ED"));
		
		DiagnosisInfo diagnosisInfo = diagnosisNoteDetailInfo.createDiagnosisInfo();
		this.increDiagnosisInfoDao.insert(diagnosisInfo);
		LogUtil.log.debug("保存诊断信息到增量库完成,savePatientDiagnosisNoteDetailInfoToIncre()----------<<");
		return true;
	}
	
	private boolean setPatientSourceDiagnosis(DiagnosisInfo diagnosisInfo, Patient patient){
		LogUtil.log.debug("给患者添加原发诊断...");
		String sourceDiagnosis = diagnosisInfo.getDiagnosis();
		if (StringUtils.isEmpty(sourceDiagnosis)) {
			PageHelper.startPage(1, 1);
			List<MetaEicd10> metaEicd10s = this.cloudMetaEIcd10Dao.findByDiseaseTypeId(diagnosisInfo.getDiagnosisTypeId());
			if (metaEicd10s == null || metaEicd10s.isEmpty()) {
				LogUtil.log.debug("通过病种Id=" + diagnosisInfo.getDiagnosisTypeId() + "没查询到诊断内容。");
				return false;
			}
			sourceDiagnosis = metaEicd10s.get(0).getDiseaseName();
		}
		boolean flag = false;
		patient.setSyncFlag(Constant.SYNC_OK);
		//判断患者基本信息里是否有原发诊断信息
		if (StringUtils.isEmpty(patient.getSourceDiagnosis()) ||
				StringUtils.isEmpty(patient.getSourceDiseaseCode()) ||
				patient.getConfirmedDate() == null ||
				patient.getSourceDiseaseTypeId() == null) {
			patient.setSourceDiagnosis(sourceDiagnosis);
			patient.setSourceDiseaseCode(diagnosisInfo.getDiseaseCode());
			patient.setSourceDiseaseTypeId(diagnosisInfo.getDiseaseTypeId());
			patient.setConfirmedDate(diagnosisInfo.getVisitTime());
			//给患者开启随访计划
			this.patientService.enableFollowupPlan(patient);
		}else if (StringUtils.isEmpty(patient.getSourceDiagnosis2()) ||
				StringUtils.isEmpty(patient.getSourceDiseaseCode2()) ||
				patient.getConfirmedDate2() == null ||
				patient.getSourceDiseaseTypeId2() == null) {
			patient.setSourceDiagnosis2(sourceDiagnosis);
			patient.setSourceDiseaseCode2(diagnosisInfo.getDiseaseCode());
			patient.setSourceDiseaseTypeId2(diagnosisInfo.getDiseaseTypeId());
			patient.setConfirmedDate2(diagnosisInfo.getVisitTime());
			flag = true;
		}else if (StringUtils.isEmpty(sourceDiagnosis) ||
				StringUtils.isEmpty(patient.getSourceDiseaseCode3()) ||
				patient.getConfirmedDate3() == null &&
				patient.getSourceDiseaseTypeId3() == null) {
			patient.setSourceDiagnosis3(diagnosisInfo.getDiagnosis());
			patient.setSourceDiseaseCode3(diagnosisInfo.getDiseaseCode());
			patient.setSourceDiseaseTypeId3(diagnosisInfo.getDiseaseTypeId());
			patient.setConfirmedDate3(diagnosisInfo.getVisitTime());
			flag = true;
		}
		if (patient.getAuditState() == null ||
				patient.getAuditState() < Constant.User.AUDITSTATE_PRIMARYPASS) {
			patient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);
			flag = true;
		}
		if (flag) {
			this.cloudPatientDao.update(patient);
		}
		User cloudUser = this.cloudUserDao.findByUserId(patient.getUserId(), Constant.User.ROLE_PATIENT);
		if (cloudUser != null &&
				(cloudUser.getInfoState() == null ||
				cloudUser.getInfoState() < Constant.User.INFOSTATE_PRIMARY)) {
			cloudUser.setInfoState(Constant.User.INFOSTATE_PRIMARY);
			this.cloudUserDao.update(cloudUser);
		}
		return true;
	}

	@Override
	public PacAndLisResp examReportCoudSync(List<TExamReportSync> examReportList) throws HospitalWithoutRightExcption{
		if(!checkBeforeSyncService.checkHospitalId(examReportList.get(0).getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		
		//保存到增量库
		this.increExamReportCloudSync(examReportList);
		List<Object> fails = new ArrayList<Object>();

		PacAndLisResp pacAndLisResp = new PacAndLisResp();
		for (int i = 0, size = examReportList.size(); i < size; i++) {
			TExamReportSync tExamReportSync = examReportList.get(i);

			LogUtil.log.debug("检查报告同步保存到生产库,implementExamReportCoudSync()---------->>");
			if (StringUtils.isEmpty(tExamReportSync.getPatientUuid())) {
				fails.add(tExamReportSync.getExamReportId());
				LogUtil.log.debug("检查报告同步保存到生产库,由于patientUuid为空，拒绝处理！----------<<");
				continue;
			}
			try {
				this.txDiagnosisInfoService.implementExamReportCoudSync(tExamReportSync);
			} catch(RejectRequestExcption e){
				pacAndLisResp.setCode(1404);
				LogUtil.log.error("同步检查报告同步出错，" + e.getMessage());
				fails.add(tExamReportSync.getExamReportId());
			} catch (Exception e) {
				LogUtil.log.error("同步检查报告同步出错，" + e.getMessage());
				fails.add(tExamReportSync.getExamReportId());
			}
		}
		pacAndLisResp.setFaildList(fails);
		LogUtil.log.debug("There are " + (examReportList.size() - fails.size()) + " successful processing, Check the report did not handle the synchronization of " + fails.size() + "!");
		return pacAndLisResp;
	}
	
	/**
	 * <p>Title:increExamReportCloudSync</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月6日 下午5:52:12
	 * @param examReportList
	 */
	private void increExamReportCloudSync(List<TExamReportSync> examReportList) {
		LogUtil.log.debug("检查报告同步保存到增量库,increExamReportCloudSync()---------->>");
		for (int i = 0, size = examReportList.size(); i < size; i++) {
			TExamReportSync tExamReportSync = examReportList.get(i);

			MedicalRecord medicalRecord = new MedicalRecord();
			medicalRecord.setEmrId(tExamReportSync.getEmrId());
			medicalRecord.setEmrNo(tExamReportSync.getEmrNo());
			medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_LEGALMEDICAL);
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_CHECK);
			medicalRecord.setPatientUuid(tExamReportSync.getPatientUuid());
			medicalRecord.setPatientNo(tExamReportSync.getPatientNo());
			medicalRecord.setHospitalId(tExamReportSync.getHospitalId());
			medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
			medicalRecord.setVisitTime(tExamReportSync.getCreateTime());
			
			EciExamReport eciExamReport = new EciExamReport();
			eciExamReport.setExamReportId(tExamReportSync.getExamReportId());
			eciExamReport.setEmrId(tExamReportSync.getEmrId());
			eciExamReport.setPatientId(tExamReportSync.getPatientId());
			eciExamReport.setPatientUuid(tExamReportSync.getPatientUuid());
			eciExamReport.setPatientName(tExamReportSync.getPatientName());
			eciExamReport.setPatientNo(tExamReportSync.getPatientNo());
			eciExamReport.setOutPatientFlag(tExamReportSync.getOutPatientFlag());
			eciExamReport.setHospitalId(tExamReportSync.getHospitalId());
			eciExamReport.setExamTypeId(tExamReportSync.getExamTypeId());
			eciExamReport.setExamChildTypeId(tExamReportSync.getExamChildTypeId());
			eciExamReport.setExamTypeName(tExamReportSync.getExamTypeName());
			eciExamReport.setDeptId(tExamReportSync.getDeptId());
			eciExamReport.setDeptName(tExamReportSync.getDeptName());
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
			eciExamReport.setApplyDoctorUuid(tExamReportSync.getApplyDoctorUuid());
			eciExamReport.setApplyDoctorNo(tExamReportSync.getApplyDoctorNo());
			eciExamReport.setApplyDoctorName(tExamReportSync.getApplyDoctorName());
			eciExamReport.setReportDoctorId(tExamReportSync.getReportDoctorId());
			eciExamReport.setReportDoctorNo(tExamReportSync.getReportDoctorNo());
			eciExamReport.setReportDoctorName(tExamReportSync.getReportDoctorName());
			eciExamReport.setState(tExamReportSync.getState());
			eciExamReport.setReadFlag(Constant.User.READFLAG_NO);
			eciExamReport.setApplyTime(tExamReportSync.getApplyTime());
			eciExamReport.setExcuteTime(tExamReportSync.getExcuteTime());
			eciExamReport.setReportTime(tExamReportSync.getReportTime());
			eciExamReport.setCreateTime(tExamReportSync.getCreateTime());
			eciExamReport.setUpdateTime(tExamReportSync.getUpdateTime());
			// start by fanpanwei
			eciExamReport.setReportDoctorUuid(tExamReportSync.getReportDoctorUuid());
			eciExamReport.setRawCreateTime(tExamReportSync.getRawCreateTime());
			eciExamReport.setInhospitaltimes(tExamReportSync.getInhospitaltimes());
			// end by fanpanwei
			
			//this.increMedicalRecordDao.insert(medicalRecord);
			this.increEciExamReportDao.insert(eciExamReport);
		}
		LogUtil.log.debug("检查报告同步保存到增量库,increExamReportCloudSync()----------<<");
	}

	@Override
	public PacAndLisResp detectionReportCloudSync(List<TDetectionReportSync> detectionReportSyncList) throws HospitalWithoutRightExcption{
		if(!checkBeforeSyncService.checkHospitalId(detectionReportSyncList.get(0).getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		
		//保存到增量库
		this.increDetectionReportCloudSync(detectionReportSyncList);

		PacAndLisResp pacAndLisResp = new PacAndLisResp();
		List<Object> fails = new ArrayList<Object>();
		for (int i = 0, size = detectionReportSyncList.size(); i < size; i++) {
			TDetectionReportSync detectionReportSync = detectionReportSyncList.get(i);
			
			LogUtil.log.debug("检验单同步保存到生产库,detectionReportCloudSync()---------->>");
			if (StringUtils.isEmpty(detectionReportSync.getPatientUuid())) {
				pacAndLisResp.setCode(1404);
				fails.add(detectionReportSync.getMainID());
				LogUtil.log.debug("检验单同步保存到生产库,detectionReportCloudSync(),由于patientUuid为空，拒绝处理！----------<<");
				continue;
			}
			try {
				this.txDiagnosisInfoService.implementDetectionReportCloudSync(detectionReportSync, fails);
			} catch(RejectRequestExcption e){
				pacAndLisResp.setCode(1404);
				LogUtil.log.error("检验单同步出错，" + e.getMessage());
				this.addFaildItem(fails, detectionReportSync);
			} catch (Exception e) {
				LogUtil.log.error("检验单同步出错，" + e.getMessage());
				this.addFaildItem(fails, detectionReportSync);
			}
		}
		pacAndLisResp.setFaildList(fails);
		LogUtil.log.debug("Check the report did not handle the synchronization of " + fails.size() + ", There are " + (detectionReportSyncList.size() - fails.size()) + " successful processing");
		return pacAndLisResp;
	}
	
	/**
	 * <p>Title:addFaildItem</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月18日 下午4:16:59
	 * @param fails
	 * @param detectionReportSync
	 */
	private void addFaildItem(List<Object> fails, TDetectionReportSync detectionReportSync){
		if (detectionReportSync == null ||
				detectionReportSync.getDetectionReportDetailList() == null ||
				detectionReportSync.getDetectionReportDetailList().isEmpty()) {
			return;
		}
		for (TDetectionReportDetailSync tDetectionReportDetailSync : detectionReportSync.getDetectionReportDetailList()) {
			fails.add(tDetectionReportDetailSync.getDetailID());
		}
	}
	
	private void increDetectionReportCloudSync(List<TDetectionReportSync> detectionReportSyncList) {
		LogUtil.log.debug("检验单同步信息保存到增量库,increDetectionReportCloudSync()---------->>");
		for (int i = 0, size = detectionReportSyncList.size(); i < size; i++) {
			TDetectionReportSync detectionReportSync = detectionReportSyncList.get(i);

			/*MedicalRecord medicalRecord = new MedicalRecord();
			medicalRecord.setEmrId(detectionReportSync.getEmrId());
			medicalRecord.setEmrNo(detectionReportSync.getEmrNo());
			medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_LEGALMEDICAL);
			medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_CHECK);
			medicalRecord.setPatientUuid(detectionReportSync.getPatientUuid());
			medicalRecord.setPatientNo(detectionReportSync.getPatientNo());
			medicalRecord.setHospitalId(detectionReportSync.getHospitalId());
			medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
			medicalRecord.setVisitTime(detectionReportSync.getCreateTime());
			this.increMedicalRecordDao.insert(medicalRecord);*/
			
			EciDetectionReport eciDetectionReport = new EciDetectionReport();
			eciDetectionReport.setEmrId(detectionReportSync.getEmrId());
			eciDetectionReport.setDetectionReportId(detectionReportSync.getDetectionReportId());
			eciDetectionReport.setPatientId(detectionReportSync.getPatientId());
			eciDetectionReport.setPatientName(detectionReportSync.getPatientName());
			eciDetectionReport.setPatientNo(detectionReportSync.getPatientNo());
			eciDetectionReport.setPatientIdno(detectionReportSync.getPatientIdno());
			eciDetectionReport.setPatientUuid(detectionReportSync.getPatientUuid());
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
			eciDetectionReport.setDiagnosis(detectionReportSync.getDiagnosis());
			eciDetectionReport.setSampleNo(detectionReportSync.getSampleNo());
			eciDetectionReport.setSampleName(detectionReportSync.getSampleName());
			eciDetectionReport.setSampleType(detectionReportSync.getSampleType());
			eciDetectionReport.setSampleState(detectionReportSync.getSampleState());
			eciDetectionReport.setApplyDoctorId(detectionReportSync.getApplyDoctorId());
			eciDetectionReport.setApplyDoctorUuid(detectionReportSync.getApplyDoctorUuid());
			eciDetectionReport.setApplyDoctorNo(detectionReportSync.getApplyDoctorNo());
			eciDetectionReport.setApplyDoctorName(detectionReportSync.getApplyDoctorName());
			eciDetectionReport.setOperateDoctorId(detectionReportSync.getOperateDoctorId());
			eciDetectionReport.setOperateDoctorNo(detectionReportSync.getOperateDoctorNo());
			eciDetectionReport.setOperateDoctorName(detectionReportSync.getOperateDoctorName());
			eciDetectionReport.setReportDoctorId(detectionReportSync.getReportDoctorId());
			eciDetectionReport.setReportDoctorNo(detectionReportSync.getReportDoctorNo());
			eciDetectionReport.setReportDoctorName(detectionReportSync.getReportDoctorName());
			eciDetectionReport.setAuditDoctorId(detectionReportSync.getAuditDoctorId());
			eciDetectionReport.setAuditDoctorNo(detectionReportSync.getAuditDoctorNo());
			eciDetectionReport.setAuditDoctorName(detectionReportSync.getAuditDoctorName());
			eciDetectionReport.setRemark(detectionReportSync.getRemark());
			eciDetectionReport.setApplyTime(detectionReportSync.getApplyTime());
			eciDetectionReport.setSampleTime(detectionReportSync.getSampleTime());
			eciDetectionReport.setAcceptTime(detectionReportSync.getAcceptTime());
			eciDetectionReport.setReportTime(detectionReportSync.getReportTime());
			eciDetectionReport.setState(detectionReportSync.getState());
			eciDetectionReport.setReadFlag(Constant.User.READFLAG_NO);
			eciDetectionReport.setCreateTime(detectionReportSync.getCreateTime());
			eciDetectionReport.setUpdateTime(detectionReportSync.getUpdateTime());
			eciDetectionReport.setRawDetectionTypeId(detectionReportSync.getRawDetectionTypeId());
			eciDetectionReport.setRawDetectionChildTypeId(detectionReportSync.getRawDetectionChildTypeId());
			eciDetectionReport.setInstrument(detectionReportSync.getInstrument());
			eciDetectionReport.setMainID(detectionReportSync.getMainID());
			//Start by fanpanwei
			/*deptUuid 
			operateDoctorUuid
			reportDoctorUuid
			auditDoctorUuid*/
			eciDetectionReport.setDeptUuid(detectionReportSync.getDeptUuid());
			eciDetectionReport.setOperateDoctorUuid(detectionReportSync.getOperateDoctorUuid());
			eciDetectionReport.setReportDoctorUuid(detectionReportSync.getReportDoctorUuid());
			eciDetectionReport.setAuditDoctorUuid(detectionReportSync.getAuditDoctorUuid());
			eciDetectionReport.setRawCreateTime(detectionReportSync.getRawCreateTime());
			eciDetectionReport.setInhospitaltimes(detectionReportSync.getInhospitaltimes());
			// end by fanpanwei
			this.increEciDetectionReportDao.insert(eciDetectionReport);
			
			List<TDetectionReportDetailSync> detectionReportDetailSyncs = detectionReportSync.getDetectionReportDetailList();
			if (detectionReportDetailSyncs != null && !detectionReportDetailSyncs.isEmpty()) {
				
				for (int j = 0, count = detectionReportDetailSyncs.size(); j < count; j++) {
					TDetectionReportDetailSync detectionReportDetailSync = detectionReportDetailSyncs.get(j);
					
					EciDetectionDetail eciDetectionDetail = new EciDetectionDetail();
					eciDetectionDetail.setDetectionDetailId(GeneralUtil.generatorUUID("EDETD"));
					eciDetectionDetail.setDetectionReportId(detectionReportSync.getDetectionReportId());
					eciDetectionDetail.setPatientId(detectionReportDetailSync.getPatientId());
					eciDetectionDetail.setPatientUuid(detectionReportSync.getPatientUuid());
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
					eciDetectionDetail.setCreateTime(detectionReportDetailSync.getCreateTime());
					eciDetectionDetail.setUpdateTime(detectionReportDetailSync.getUpdateTime());
					eciDetectionDetail.setDetectionTypeName(detectionReportDetailSync.getDetectionTypeName());
					eciDetectionDetail.setRawDetectionItemCode(detectionReportDetailSync.getRawDetectionItemCode());
					eciDetectionDetail.setDetectionItemName(detectionReportDetailSync.getDetectionItemName());
					eciDetectionDetail.setDetectionItemEnglishName(detectionReportDetailSync.getDetectionItemEnglishName());
					eciDetectionDetail.setRefrenceRange(detectionReportDetailSync.getRefrenceRange());
					eciDetectionDetail.setDetailID(detectionReportDetailSync.getDetailID());
					eciDetectionDetail.setMainID(detectionReportDetailSync.getMainID());
					//add by fanpanwei
					/*promptType*/
					eciDetectionDetail.setPromptType(detectionReportDetailSync.getPromptType());
					eciDetectionDetail.setRawCreateTime(detectionReportDetailSync.getRawCreateTime());
					this.increEciDetectionDetailDao.insert(eciDetectionDetail);
				}
			}
		}
		LogUtil.log.debug("检验单同步信息保存到增量库完成,increDetectionReportCloudSync()----------<<");
	}
}
