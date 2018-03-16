package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.common.Const;
import com.esuizhen.cloudservice.research.dao.crf.ProjectCrfTemplateDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.result.PatientDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultDiagnosisInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.result.TCrfResultDiagnosisInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultDiagnosisInfoService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultDiagnosisInfoServiceImpl implements TCrfResultDiagnosisInfoService {
	@Autowired
	private TCrfResultDiagnosisInfoDao crfResultDiagnosisInfoDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	@Autowired
	private ProjectCrfTemplateDao projectCrfTemplateDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private TCrfObservationSubjectElementDao crfObservationSubjectElementDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;

	@Override
	public TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> queryCrfResultDiagnosis(String crfObserveId, Long patientId,
			Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo = this.crfResultDiagnosisInfoDao.findCrfResultDiagnosisInfoes(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Override
	public boolean saveCrfResultDiagnosis(TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<TCrfResultDiagnosisInfo> crfResultDiagnosisInfos = crfResultMainInfo.getCrfResult();
		if (crfResultDiagnosisInfos == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TCrfResultMainInfo<?> resultMainInfo = this.crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		if (resultMainInfo == null) {
			//还未录入信息，则创建Result-main主表信息
			resultMainInfo = this.crfResultMainInfoService.createTCrfResultMainInfo(crfResultMainInfo);
		}
		//处理录入人
		if (resultMainInfo.getCreatorId() == null &&
				crfResultMainInfo.getCreatorId() != null) {
			resultMainInfo.setCreatorId(crfResultMainInfo.getCreatorId());
			this.crfResultMainInfoDao.updateCrfResultMain(resultMainInfo);
		}
		//删除之前的基本信息-人口学信息结果
		this.crfResultDiagnosisInfoDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		for (int i = 0; i < crfResultDiagnosisInfos.size(); i++) {
			TCrfResultDiagnosisInfo crfResultBasicAllergies = crfResultDiagnosisInfos.get(i);
			
			crfResultBasicAllergies.setIndex(i);
			if (StringUtils.isEmpty(crfResultBasicAllergies.getCrfDiagnosisResultId())) {
				crfResultBasicAllergies.setCrfDiagnosisResultId(GeneralUtil.generateUniqueID("CDRI"));
			}
			if (StringUtils.isEmpty(crfResultBasicAllergies.getCrfResultId())) {
				crfResultBasicAllergies.setCrfResultId(resultMainInfo.getCrfResultId());
			}
			//保存传入的基本信息-人口学信息结果
			this.crfResultDiagnosisInfoDao.insert(crfResultBasicAllergies);
		}
		return true;
	}

	@Override
	public boolean autoSupplement(TCrfResultMainInfo<List<PatientSimpleInfo>> info) throws ParameterCannotBeNullException, ObjectNotAvailableExcption{
		TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<TCrfResultDiagnosisInfo>>();
		crfResultMainInfo.setProjectId(info.getProjectId());
		crfResultMainInfo.setCreatorId(info.getCreatorId());
		//获取患者诊断信息CRF观察项设置
		TCrfObservationSubjectElement crfObservationSubjectElement = this.crfObservationSubjectElementDao.findCrfObservationSubjectElementBySubjectElementId(info.getProjectId(), Const.META_CRF_SUBJECT_ELEMENT_ZDXX);
		crfResultMainInfo.setCrfObserveId(crfObservationSubjectElement.getCrfObserveId());
		//模板简要信息
		//TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(info.getProjectId());
		TProjectTemplateSimpleInfo projectTemplateSimpleInfo = this.projectCrfTemplateDao.findByProjectId(info.getProjectId());
		List<PatientSimpleInfo> patientSimpleInfos = info.getCrfResult();
		List<TCrfResultDiagnosisInfo> crfResultDiagnosisInfos = new ArrayList<TCrfResultDiagnosisInfo>(1);
		for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
			//获取患者诊断信息
			PageHelper.startPage(1, 2);
			List<TCrfResultDiagnosisInfo> crfResultDiagnosisInfoes = this.patientDao.findDiagosisInfo(patientSimpleInfo.getPatientId(), patientSimpleInfo.getSourceDiseaseTypeId());
			//患者无诊断信息，不处理
			if (crfResultDiagnosisInfoes == null || crfResultDiagnosisInfoes.isEmpty()) {
				continue;
			}
			TCrfResultDiagnosisInfo crfResultDiagnosisInfo = crfResultDiagnosisInfoes.get(0);
			crfResultMainInfo.setPatientId(patientSimpleInfo.getPatientId());
			if (projectTemplateSimpleInfo.getFollowupStartMark() == 1) {//随访周期起始标识：患者入组日期
				crfResultMainInfo.setCrfCourseItemTime(new Date());
			} else {//首次确诊日期
				crfResultMainInfo.setCrfCourseItemTime(crfResultDiagnosisInfo.getDiagnosisDate());
			}
			//保存
			crfResultDiagnosisInfos.clear();
			crfResultDiagnosisInfos.add(crfResultDiagnosisInfo);
			crfResultMainInfo.setCrfResult(crfResultDiagnosisInfos);
			this.saveCrfResultDiagnosis(crfResultMainInfo);
		}
		return true;
	}
}
