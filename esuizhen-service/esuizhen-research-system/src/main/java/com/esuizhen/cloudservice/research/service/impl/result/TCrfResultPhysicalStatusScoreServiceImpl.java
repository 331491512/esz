package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.PatientDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultPhysicalStatusScoreDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalStatusScore;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultPhysicalStatusScoreService;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;

@Service
public class TCrfResultPhysicalStatusScoreServiceImpl implements TCrfResultPhysicalStatusScoreService {
	@Autowired
	private TCrfResultPhysicalStatusScoreDao crfResultPhysicalStatusScoreDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	
	@Override
	public List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>> queryCrfResultPhysicalStatusScoreRecord(
			String projectId, Long patientId, Long doctorId) {
		if (StringUtils.isEmpty(projectId) || patientId == null) {
			return null;
		}
		List<TCrfResultMainInfo<List<TCrfResultPhysicalStatusScore>>> crfResultMainInfos = this.crfResultPhysicalStatusScoreDao.findCrfResultPhysicalStatusScoreRecord(projectId, patientId);
		/*
		if (crfResultMainInfos != null && !crfResultMainInfos.isEmpty()) {
			for (int i = 0; i < crfResultMainInfos.size(); i++) {
				TCrfResultMainInfo<List<CrfResultPhysicalStatusScore>> crfResultMainInfo = crfResultMainInfos.get(i);
				if (crfResultMainInfo != null) {
					crfResultMainInfo.setCrfResult(this.crfResultPhysicalStatusScoreDao.findCrfResultPhysicalStatusScoreRecords(crfResultMainInfo.getCrfObserveId(), patientId));
				}
			}
		}
		*/
		return crfResultMainInfos;
	}

	@Transactional
	@Override
	public TCrfResultMainInfo<TCrfResultPhysicalStatusScore> queryCrfResultPhysicalStatusScoreI(String crfObserveId,
			Long patientId, Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<TCrfResultPhysicalStatusScore> crfResultMainInfo = this.crfResultPhysicalStatusScoreDao.findCrfResultPhysicalStatusScores(crfObserveId, patientId);
		/*
		if (crfResultMainInfo != null) {
			crfResultMainInfo.setCrfResult(this.crfResultPhysicalStatusScoreDao.findCrfResultPhysicalStatusScores(crfObserveId, patientId));
		}
		*/
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveCrfResultPhysicalStatusScore(List<TCrfResultMainInfo<TCrfResultPhysicalStatusScore>> crfResultMainInfoes) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfoes == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		for (int i = 0; i < crfResultMainInfoes.size(); i++) {
			TCrfResultMainInfo<TCrfResultPhysicalStatusScore> crfResultMainInfo = crfResultMainInfoes.get(i);
			TCrfResultPhysicalStatusScore crfResultPhysicalStatusScore = crfResultMainInfo.getCrfResult();
			if (crfResultPhysicalStatusScore == null) {
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
			//删除之前的身体状况评分信息结果
			this.crfResultPhysicalStatusScoreDao.deleteByCrfResultIdAndPatientId(resultMainInfo.getCrfResultId(), resultMainInfo.getPatientId());
			if (StringUtils.isEmpty(crfResultPhysicalStatusScore.getCrfScoreResultId())) {
				crfResultPhysicalStatusScore.setCrfScoreResultId(GeneralUtil.generateUniqueID("CSID"));
			}
			if (StringUtils.isEmpty(crfResultPhysicalStatusScore.getCrfResultId())) {
				crfResultPhysicalStatusScore.setCrfResultId(crfResultMainInfo.getCrfResultId());
			}
			//处理crfResultId
			if (StringUtils.isEmpty(crfResultPhysicalStatusScore.getCrfResultId())) {
				crfResultPhysicalStatusScore.setCrfResultId(resultMainInfo.getCrfResultId());
			}
			//观察项ID
			crfResultPhysicalStatusScore.setSubjectElementId(crfResultMainInfo.getSubjectElementId());
			//保存传入的患者身体状况评分
			this.crfResultPhysicalStatusScoreDao.insert(crfResultPhysicalStatusScore);
			//如何患者死亡，则更新到患者基本信息里
			if (crfResultPhysicalStatusScore.getDeathDate() != null) {
				PatientSimpleInfo patientSimpleInfo = new PatientSimpleInfo();
				patientSimpleInfo.setPatientId(crfResultMainInfo.getPatientId());
				patientSimpleInfo.setDeathDate(crfResultPhysicalStatusScore.getDeathDate());
				patientSimpleInfo.setIsTumourDeath(crfResultPhysicalStatusScore.getIsTumourDeath());
				
				this.patientDao.update(patientSimpleInfo);
			}
		}
		return true;
	}

}
