package com.esuizhen.cloudservice.research.service.impl.result;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.pro.RCrftemplateProjectDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;

@Service
public class TCrfResultMainInfoServiceImpl implements TCrfResultMainInfoService {
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	@Autowired
	private RCrftemplateProjectDao rCrftemplateProjectDao;
	@Autowired
	private TCrfObservationSubjectElementDao crfObservationSubjectElementDao;

	@Transactional
	@Override
	public TCrfResultMainInfo<?> createTCrfResultMainInfo(TCrfResultMainInfo<?> casing) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(casing.getCrfObserveId()) || casing.getPatientId() == null) {
			throw new ParameterCannotBeNullException("crfObserveId=" + casing.getCrfObserveId() + ", patientId=" + casing.getPatientId() + ", Parameters cannot be empty!");
		}
		//判断数据库中是否有该记录
		TCrfResultMainInfo<?> crfResultMainInfo = this.crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(casing.getCrfObserveId(), casing.getPatientId());
		if (crfResultMainInfo != null) {
			//有该记录直接返回
			return crfResultMainInfo;
		}
		//获取CRF观察项设置信息
		TCrfObservationSubjectElement crfObservationSubjectElement = this.crfObservationSubjectElementDao.queryCrfObservationSubjectElement(casing.getCrfObserveId());
		if (crfObservationSubjectElement == null) {
			throw new ObjectNotAvailableExcption("object not found!");
		}
		//获取专题信息
		RCrftemplateProject rCrftemplateProject = this.rCrftemplateProjectDao.findByCrfObserveId(casing.getCrfObserveId());
		crfResultMainInfo = new TCrfResultMainInfo<Object>();
		crfResultMainInfo.setCrfResultId(GeneralUtil.generateUniqueID("CRRI"));
		crfResultMainInfo.setCrfObserveId(casing.getCrfObserveId());
		crfResultMainInfo.setSubjectElementId(crfObservationSubjectElement.getSubjectElementId());
		crfResultMainInfo.setProjectId(rCrftemplateProject.getProjectId());
		crfResultMainInfo.setPatientId(casing.getPatientId());
		crfResultMainInfo.setCreatorId(casing.getCreatorId());
		crfResultMainInfo.setCrfCourseItemTime(casing.getCrfCourseItemTime());
		//保存
		LogUtil.log.debug("创建CRF观察项结果主表信息......");
		this.crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		return crfResultMainInfo;
	}
}
