package com.esuizhen.cloudservice.research.service.impl.result;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentResultDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreantmentResultInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentResultService;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;

@Service
public class TCrfResultTreatmentResultServiceImpl implements TCrfResultTreatmentResultService {
	@Autowired
	private TCrfResultTreatmentResultDao crfResultTreatmentResultDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	@Value("${server.api.url.root}")
	private String urlRoot;

	@Override
	public TCrfResultMainInfo<TCrfResultTreantmentResultInfo> queryCrfResultTreatmentResultInfo(String crfObserveId,
			Long patientId) {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<TCrfResultTreantmentResultInfo> crfResultMainInfo = this.crfResultTreatmentResultDao.findCrfResultTreatmentResultInfo(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveCrfResultTreatmentResultInfo(
			TCrfResultMainInfo<TCrfResultTreantmentResultInfo> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TCrfResultTreantmentResultInfo crfResultTreantmentResultInfo = crfResultMainInfo.getCrfResult();
		if (crfResultTreantmentResultInfo == null) {
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
		//删除之前的CRF治疗效果结果数据
		this.crfResultTreatmentResultDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
		if (StringUtils.isEmpty(crfResultTreantmentResultInfo.getCrfTreantmentResultId())) {
			crfResultTreantmentResultInfo.setCrfTreantmentResultId(GeneralUtil.generateUniqueID("CTTR"));
		}
		if (StringUtils.isEmpty(crfResultTreantmentResultInfo.getCrfResultId())) {
			crfResultTreantmentResultInfo.setCrfResultId(resultMainInfo.getCrfResultId());
		}
		//保存传入的CRF治疗效果结果数据
		this.crfResultTreatmentResultDao.insert(crfResultTreantmentResultInfo);
		
		crfResultTreantmentResultInfo.setFollowupTime(crfResultTreantmentResultInfo.getFillDate());
		crfResultTreantmentResultInfo.setFollowupWay(3);
		crfResultTreantmentResultInfo.setPatientId(crfResultMainInfo.getPatientId());
		crfResultTreantmentResultInfo.setOperator(crfResultMainInfo.getDoctorId());
		crfResultTreantmentResultInfo.setFollowupResultValue(crfResultTreantmentResultInfo.getEffectType());
		crfResultTreantmentResultInfo.setRelapseDate(crfResultTreantmentResultInfo.getHappenDate());
		crfResultTreantmentResultInfo.setTransferParts(crfResultTreantmentResultInfo.getBodyPartName());
		crfResultTreantmentResultInfo.setHospitalId(crfResultMainInfo.getHospitalId());
		crfResultTreantmentResultInfo.setSourceFlag(4);
		
		HttpUtil.postWithJSON(urlRoot + "/followup/result/submit", JsonUtil.toJson(crfResultTreantmentResultInfo));
		return true;
	}

}
