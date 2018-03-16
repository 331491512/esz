package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultBasicPastmedicalHistoryDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicPastmedicalHistory;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicPastmedicalHistoryService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultBasicPastmedicalHistoryServiceImpl implements TCrfResultBasicPastmedicalHistoryService {
	@Autowired
	private TCrfResultBasicPastmedicalHistoryDao crfResultBasicPastmedicalHistoryDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;

	@Override
	public TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> queryCrfResultPastmedicalHistory(
			String crfObserveId, Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> crfResultMainInfo = this.crfResultBasicPastmedicalHistoryDao.findCrfResultBasicPastmedicalHistory(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Override
	public boolean saveCrfResultPastmedicalHistory(TCrfResultMainInfo<List<TCrfResultBasicPastmedicalHistory>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<TCrfResultBasicPastmedicalHistory> crfResultBasicPastmedicalHistories = crfResultMainInfo.getCrfResult();
		TCrfResultMainInfo<?> resultMainInfo = this.crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		if (resultMainInfo == null) {
			if (crfResultBasicPastmedicalHistories == null) {
				//无(状态)
				return true;
			}
			//还未录入信息，则创建Result-main主表信息
			resultMainInfo = this.crfResultMainInfoService.createTCrfResultMainInfo(crfResultMainInfo);
		}
		if (crfResultBasicPastmedicalHistories == null) {
			//无(状态)
			this.crfResultMainInfoDao.deleteCrfResultMain(resultMainInfo.getCrfResultId());
			return true;
		}
		//删除之前的基本信息-既往病史结果
		this.crfResultBasicPastmedicalHistoryDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		//未说明(状态)
		if(crfResultBasicPastmedicalHistories.isEmpty()){
			return true;
		}
		//处理录入人
		if (resultMainInfo.getCreatorId() == null &&
				crfResultMainInfo.getCreatorId() != null) {
			resultMainInfo.setCreatorId(crfResultMainInfo.getCreatorId());
			this.crfResultMainInfoDao.updateCrfResultMain(resultMainInfo);
		}
		for (int i = 0; i < crfResultBasicPastmedicalHistories.size(); i++) {
			TCrfResultBasicPastmedicalHistory crfResultBasicAllergies = crfResultBasicPastmedicalHistories.get(i);
			crfResultBasicAllergies.setIndex(i);
			if (StringUtils.isEmpty(crfResultBasicAllergies.getCrfPastmedicalResultId())) {
				crfResultBasicAllergies.setCrfPastmedicalResultId(GeneralUtil.generateUniqueID("CRBD"));
			}
			if (StringUtils.isEmpty(crfResultBasicAllergies.getCrfResultId())) {
				crfResultBasicAllergies.setCrfResultId(resultMainInfo.getCrfResultId());
			}
		}
		//保存传入的基本信息-既往病史结果
		this.crfResultBasicPastmedicalHistoryDao.insertByBatch(crfResultBasicPastmedicalHistories);
		return true;
	}

}
