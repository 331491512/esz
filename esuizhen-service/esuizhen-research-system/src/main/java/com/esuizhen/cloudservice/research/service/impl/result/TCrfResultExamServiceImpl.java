package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultExamDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultExamDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultExam;
import com.esuizhen.cloudservice.research.model.result.TCrfResultExamDetail;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultExamService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultExamServiceImpl implements TCrfResultExamService {
	@Autowired
	private TCrfResultExamDao crfResultExamDao;
	@Autowired
	private TCrfResultExamDetailDao crfResultExamDetailDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	
	@Override
	public List<TCrfResultMainInfo<List<TCrfResultExam>>> queryCrfResultExamRecord(String projectId, Long patientId,
			Long doctorId, String examParentTypeId, String orderBy, String orderType) {
		if (StringUtils.isEmpty(projectId) || patientId == null) {
			return null;
		}
		//检查日期
		List<TCrfResultExam> crfResultExams = this.crfResultExamDao.findCrfResultExamExcuteDatesRecord(projectId, patientId, examParentTypeId, orderBy, orderType);
		List<TCrfResultMainInfo<List<TCrfResultExam>>> crfResultMainInfos = null;
		if (crfResultExams != null && !crfResultExams.isEmpty()) {
			crfResultMainInfos = new ArrayList<TCrfResultMainInfo<List<TCrfResultExam>>>(crfResultExams.size());
			for (TCrfResultExam crfResultExam : crfResultExams) {
				List<TCrfResultMainInfo<List<TCrfResultExam>>> resultMainInfos = this.crfResultExamDao.findCrfResultExamsRecord(projectId, patientId,
						examParentTypeId, crfResultExam.getExamTypeId(), crfResultExam.getCrfExamResultId(), crfResultExam.getExcuteDate());
				crfResultMainInfos.addAll(resultMainInfos);
			}
		}
		return crfResultMainInfos;
	}

	@Transactional
	@Override
	public TCrfResultMainInfo<List<TCrfResultExam>> crfResultExamQuery(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<List<TCrfResultExam>> crfResultMainInfo = this.crfResultExamDao.findCrfResultExams(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveCrfResultExam(TCrfResultMainInfo<List<TCrfResultExam>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<TCrfResultExam> crfResultExams = crfResultMainInfo.getCrfResult();
		if (crfResultExams == null) {
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
		//删除之前的检修详情信息
		this.crfResultExamDetailDao.deleteByCrfObserveId(resultMainInfo.getCrfObserveId());
		//删除之前的检查信息
		this.crfResultExamDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		for (int i = 0; i < crfResultExams.size(); i++) {
			TCrfResultExam crfResultExam = crfResultExams.get(i);
			//crfExamResultId
			crfResultExam.setCrfExamResultId(GeneralUtil.generateUniqueID("CERI"));
			//crfResultId
			if (StringUtils.isEmpty(crfResultExam.getCrfResultId())) {
				crfResultExam.setCrfResultId(resultMainInfo.getCrfResultId());
			}
			//examParentTypeId
			/*
			if (StringUtils.isEmpty(crfResultExam.getExamParentTypeId())) {
				crfResultExam.setExamParentTypeId(crfResultMainInfo.getSubjectElementId());
			}
			*/
			//保存检查信息
			this.crfResultExamDao.insert(crfResultExam);
			//处理检查详情信息
			List<TCrfResultExamDetail> crfResultExamDetails = crfResultExam.getExamResultDetailList();
			if (crfResultExamDetails != null && !crfResultExamDetails.isEmpty()) {
				for (TCrfResultExamDetail crfResultExamDetail : crfResultExamDetails) {
					crfResultExamDetail.setCrfExamResultDetailId(GeneralUtil.generateUniqueID("CEDD"));
					crfResultExamDetail.setCrfExamResultId(crfResultExam.getCrfExamResultId());
				}
				//保存检查详情信息
				this.crfResultExamDetailDao.insertByBatch(crfResultExamDetails);
			}
		}
		return true;
	}

}
