package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.common.Const;
import com.esuizhen.cloudservice.research.dao.crf.ProjectCrfTemplateDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.result.PatientDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultBasicDemographyDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterPatientDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicDemographyService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultBasicDemographyServiceImpl implements TCrfResultBasicDemographyService {
	@Autowired
	private TCrfResultBasicDemographyDao crfResultBasicDemographyDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	@Autowired
	private ProjectCrfTemplateDao projectCrfTemplateDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private TCrfObservationSubjectElementDao crfObservationSubjectElementDao;
	@Autowired
	private TRSubcenterPatientDao subcenterPatientDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	
	@Override
	public TCrfResultMainInfo<TCrfResultBasicDemography> queryCrfResultDemography(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo = this.crfResultBasicDemographyDao.findCrfResultDemography(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveCrfResultDemography(TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TCrfResultBasicDemography crfResultBasicDemography = crfResultMainInfo.getCrfResult();
		if (crfResultBasicDemography == null) {
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
		this.crfResultBasicDemographyDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		if (StringUtils.isEmpty(crfResultBasicDemography.getCrfDemographyResultId())) {
			crfResultBasicDemography.setCrfDemographyResultId(GeneralUtil.generateUniqueID("CDRI"));
		}
		if (StringUtils.isEmpty(crfResultBasicDemography.getCrfResultId())) {
			crfResultBasicDemography.setCrfResultId(resultMainInfo.getCrfResultId());
		}
		if (crfResultBasicDemography.getPatientId() == null) {
			crfResultBasicDemography.setPatientId(crfResultMainInfo.getPatientId());
		}
		//保存传入的基本信息-人口学信息结果
		this.crfResultBasicDemographyDao.insert(crfResultBasicDemography);
		return true;
	}
	
	@Override
	public boolean autoSupplement(TCrfResultMainInfo<List<PatientSimpleInfo>> info) throws ParameterCannotBeNullException, ObjectNotAvailableExcption{
		TCrfResultMainInfo<TCrfResultBasicDemography> crfResultMainInfo = new TCrfResultMainInfo<TCrfResultBasicDemography>();
		crfResultMainInfo.setProjectId(info.getProjectId());
		crfResultMainInfo.setCreatorId(info.getCreatorId());
		//获取患者人口学CRF观察项设置
		TCrfObservationSubjectElement crfObservationSubjectElement = this.crfObservationSubjectElementDao.findCrfObservationSubjectElementBySubjectElementId(info.getProjectId(), Const.META_CRF_SUBJECT_ELEMENT_RKXXX);
		crfResultMainInfo.setCrfObserveId(crfObservationSubjectElement.getCrfObserveId());
		//模板简要信息
		TProjectTemplateSimpleInfo projectTemplateSimpleInfo = this.projectCrfTemplateDao.findByProjectId(info.getProjectId());
		List<PatientSimpleInfo> patientSimpleInfos = info.getCrfResult();
		//获取上次患者流水号
		int invitationCount = this.subcenterPatientDao.findInvitationCount(info.getProjectId(), info.getCreatorId());
		for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
			//获取患者基本信息
			TCrfResultBasicDemography basicDemography = this.patientDao.findDemography(patientSimpleInfo.getPatientId());
			//患者无基本信息，不处理
			if (basicDemography == null) {
				continue;
			}
			crfResultMainInfo.setPatientId(patientSimpleInfo.getPatientId());
			if (projectTemplateSimpleInfo.getFollowupStartMark() == 1) {//随访周期起始标识：患者入组日期
				crfResultMainInfo.setCrfCourseItemTime(new Date());
			} else {//首次确诊日期
				crfResultMainInfo.setCrfCourseItemTime(basicDemography.getConfirmedDate());
			}
			//患者标识号
			basicDemography.setPatientNo(this.getPatientNo(++invitationCount));
			crfResultMainInfo.setCrfResult(basicDemography);
			//保存
			this.saveCrfResultDemography(crfResultMainInfo);
		}
		return true;
	}
	
	/**
	 * <p>Title:getPatientNo</p>
	 * <p>Description:获取患者标识号</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 上午10:47:40
	 * @param invitationCount
	 * @return
	 */
	private String getPatientNo(Integer invitationCount){
		StringBuilder builder = new StringBuilder();
		String patientNo = DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMdd");
		builder.append(invitationCount);
		for (int j = builder.length(); j < 4; j++) {
			builder.insert(0, 0);
		}
		builder.insert(0, patientNo);
		return builder.toString();
	}
}
