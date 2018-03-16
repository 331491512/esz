package com.esuizhen.cloudservice.research.service.impl.result;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultPainScaleDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultPainScaleInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultPainScaleService;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultPainScaleServiceImpl implements TCrfResultPainScaleService {
	@Autowired
	private TCrfResultPainScaleDao crfResultPainScaleDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;

	@Override
	public TCrfResultMainInfo<TCrfResultPainScaleInfo> queryCrfResultPainScaleInfo(String crfObserveId, Long patientId) {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<TCrfResultPainScaleInfo> crfResultMainInfo = this.crfResultPainScaleDao.findCrfResultPainScaleInfo(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveGenenalPhysicalExam(TCrfResultMainInfo<TCrfResultPainScaleInfo> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TCrfResultPainScaleInfo crfResultPainScaleInfo = crfResultMainInfo.getCrfResult();
		if (crfResultPainScaleInfo == null) {
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
		//删除之前的临床症状-疼痛指数结果数据
		this.crfResultPainScaleDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		if (StringUtils.isEmpty(crfResultPainScaleInfo.getCrfPainScaleResultId())) {
			crfResultPainScaleInfo.setCrfPainScaleResultId(GeneralUtil.generateUniqueID("CSPR"));
		}
		if (StringUtils.isEmpty(crfResultPainScaleInfo.getCrfResultId())) {
			crfResultPainScaleInfo.setCrfResultId(resultMainInfo.getCrfResultId());
		}
		//保存传入的临床症状-疼痛指数结果数据
		this.crfResultPainScaleDao.insert(crfResultPainScaleInfo);
		return true;
	}

}
