package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultBasicAllergiesDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicAllergies;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicAllergiesService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultBasicAllergiesServiceImpl implements TCrfResultBasicAllergiesService {
	@Autowired
	private TCrfResultBasicAllergiesDao crfResultBasicAllergiesDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	
	@Override
	public TCrfResultMainInfo<List<TCrfResultBasicAllergies>> queryCrfResultAllergy(String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<List<TCrfResultBasicAllergies>> crfResultMainInfo = this.crfResultBasicAllergiesDao.findCrfResultBasicAllergies(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveCrfResultAllergy(TCrfResultMainInfo<List<TCrfResultBasicAllergies>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<TCrfResultBasicAllergies> crfResultBasicAllergieses = crfResultMainInfo.getCrfResult();
		TCrfResultMainInfo<?> resultMainInfo = this.crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		if (resultMainInfo == null) {
			//无（状态）
			if (crfResultBasicAllergieses == null) {
				return true;
			}
			//还未录入信息，则创建Result-main主表信息
			resultMainInfo = this.crfResultMainInfoService.createTCrfResultMainInfo(crfResultMainInfo);
		}
		//无（状态）
		if (crfResultBasicAllergieses == null) {
			this.crfResultMainInfoDao.deleteCrfResultMain(resultMainInfo.getCrfResultId());
			return true;
		}
		//删除之前的基本信息-过敏史信息结果
		this.crfResultBasicAllergiesDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		//未说明(状态)
		if (crfResultBasicAllergieses.isEmpty()) {
			return true;
		}
		//处理录入人
		if (resultMainInfo.getCreatorId() == null &&
				crfResultMainInfo.getCreatorId() != null) {
			resultMainInfo.setCreatorId(crfResultMainInfo.getCreatorId());
			this.crfResultMainInfoDao.updateCrfResultMain(resultMainInfo);
		}
		for (int i = 0; i < crfResultBasicAllergieses.size(); i++) {
			TCrfResultBasicAllergies crfResultBasicAllergies = crfResultBasicAllergieses.get(i);
			crfResultBasicAllergies.setIndex(i);
			if (StringUtils.isEmpty(crfResultBasicAllergies.getCrfAllergyResultId())) {
				crfResultBasicAllergies.setCrfAllergyResultId(GeneralUtil.generateUniqueID("CRBD"));
			}
			if (StringUtils.isEmpty(crfResultBasicAllergies.getCrfResultId())) {
				crfResultBasicAllergies.setCrfResultId(resultMainInfo.getCrfResultId());
			}
		}
		//保存传入的基本信息-过敏史信息结果
		this.crfResultBasicAllergiesDao.insertByBatch(crfResultBasicAllergieses);
		return true;
	}

}
