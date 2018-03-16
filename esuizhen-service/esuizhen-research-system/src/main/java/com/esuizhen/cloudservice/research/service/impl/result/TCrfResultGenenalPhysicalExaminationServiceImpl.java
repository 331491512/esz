package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultGenenalPhysicalExaminationDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultGenenalPhysicalExamination;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultGenenalPhysicalExaminationService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
public class TCrfResultGenenalPhysicalExaminationServiceImpl implements TCrfResultGenenalPhysicalExaminationService {
	@Autowired
	private TCrfResultGenenalPhysicalExaminationDao crfResultGenenalPhysicalExaminationDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	
	@Transactional
	@Override
	public TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> queryCrfResultGenenalPhysicalExam(
			String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> crfResultMainInfo = this.crfResultGenenalPhysicalExaminationDao.findCrfResultGenenalPhysicalExaminations(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveGenenalPhysicalExam(TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TCrfResultGenenalPhysicalExamination crfResultGenenalPhysicalExamination = crfResultMainInfo.getCrfResult();
		if (crfResultGenenalPhysicalExamination == null) {
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
		this.crfResultGenenalPhysicalExaminationDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		if (StringUtils.isEmpty(crfResultGenenalPhysicalExamination.getCrfPhysicalExaminationResultId())) {
			crfResultGenenalPhysicalExamination.setCrfPhysicalExaminationResultId(GeneralUtil.generateUniqueID("CPER"));
		}
		if (StringUtils.isEmpty(crfResultGenenalPhysicalExamination.getCrfResultId())) {
			crfResultGenenalPhysicalExamination.setCrfResultId(resultMainInfo.getCrfResultId());
		}
		//保存传入的基本信息-人口学信息结果
		this.crfResultGenenalPhysicalExaminationDao.insert(crfResultGenenalPhysicalExamination);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> queryCrfResultGenenaPhysicalExamRecord(String projectId, Long patientId, Long doctorId, Integer page, Integer num) {
		if (StringUtils.isEmpty(projectId) || patientId == null) {
			return null;
		}
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>> crfResultMainInfos = this.crfResultGenenalPhysicalExaminationDao.findCrfResultGenenaPhysicalExamRecord(projectId, patientId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TCrfResultMainInfo<TCrfResultGenenalPhysicalExamination>>)crfResultMainInfos);
	}

}
