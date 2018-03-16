package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultClinicalSymptomsDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultClinicalSymptomsInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTcmSymptomsDetailDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTcmSymptomsDetail;
import com.esuizhen.cloudservice.research.service.result.TCrfResultClinicalSymptomsInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class TCrfResultClinicalSymptomsInfoServiceImpl implements TCrfResultClinicalSymptomsInfoService {

	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;

	@Autowired
	private TCrfResultClinicalSymptomsInfoDao crfResultClinicalSymptomsInfoDao;

	@Autowired
	private TCrfResultClinicalSymptomsDetailDao crfResultClinicalSymptomsDetailDao;

	@Autowired
	private TCrfResultTcmSymptomsDetailDao crfResultTcmSymptomsDetailDao;

	@Override
	public TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> queryResultClinicalSymptoms(String crfObserveId,
			Long patientId) {
		return crfResultClinicalSymptomsInfoDao.queryCrfResultClinicalSymptomsByPatientIdAndCrfObserveId(crfObserveId,
				patientId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfResultClinicalSymptoms(
			TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> crfResultMainInfo)
			throws ParameterCannotBeNullException {
		// 查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(
				crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());

		if (mainInfo != null) {// 如果填写过则删除
			// 删除症状结果明细
			crfResultClinicalSymptomsDetailDao
					.deleteCrfResultClinicalSymptomsDetailByCrfResultId(mainInfo.getCrfResultId());
			// 删除症状结果
			crfResultClinicalSymptomsInfoDao.deleteCrfResultClinicalSymptomsByCrfResultId(mainInfo.getCrfResultId());
			// 删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}

		// 保存结果主表信息
		crfResultMainInfo.setCrfResultId(GeneralUtil.generateUniqueID("CRRI"));
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);

		// 保存症状结果信息
		for (TCrfResultClinicalSymptomsInfo crfResultClinicalSymptomsInfo : crfResultMainInfo.getCrfResult()) {
			crfResultClinicalSymptomsInfo.setCrfResultId(crfResultMainInfo.getCrfResultId());
			crfResultClinicalSymptomsInfo.setCrfSymptomResultId(GeneralUtil.generateUniqueID("CRSY"));
			if (crfResultClinicalSymptomsInfo.getCreateTime() == null) {// 如果为空则为当前日期
				crfResultClinicalSymptomsInfo.setCreateTime(new Date());
			}
			crfResultClinicalSymptomsInfoDao.insertCrfResultClinicalSymptoms(crfResultClinicalSymptomsInfo);
			List<TCrfResultClinicalSymptomsDetailInfo> clinicalSymptomsDetailInfos = crfResultClinicalSymptomsInfo
					.getCrfResultClinicalSymptomsDetailList();
			if (clinicalSymptomsDetailInfos == null || clinicalSymptomsDetailInfos.isEmpty()) {
				throw new ParameterCannotBeNullException("Parameters cannot be empty!");
			}
			// 保存症状结果明细
			for (int i = 0; i < clinicalSymptomsDetailInfos.size(); i++) {
				TCrfResultClinicalSymptomsDetailInfo crfResultClinicalSymptomsDetail = crfResultClinicalSymptomsInfo
						.getCrfResultClinicalSymptomsDetailList().get(i);
				String crfSymptomResultDetailId = GeneralUtil.generateUniqueID("CRSD");
				crfResultClinicalSymptomsDetail.setCrfSymptomResultDetailId(crfSymptomResultDetailId);
				crfResultClinicalSymptomsDetail
						.setCrfSymptomResultId(crfResultClinicalSymptomsInfo.getCrfSymptomResultId());
				crfResultClinicalSymptomsDetail.setIndex(i);
			}
			crfResultClinicalSymptomsDetailDao.insertCrfResultClinicalSymptomsDetailList(clinicalSymptomsDetailInfos);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultClinicalSymptomsInfo> queryCrfResultClinicalSymptomsRecord(String projectId, Long patientId,
			Integer page, Integer num) {
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
		List<TCrfResultClinicalSymptomsInfo> clinicalSymptomsInfos = crfResultClinicalSymptomsInfoDao
				.queryCrfResultClinicalSymptomsByPatientIdAndProjectId(projectId, patientId);
		if (clinicalSymptomsInfos != null && !clinicalSymptomsInfos.isEmpty()) {
			for (TCrfResultClinicalSymptomsInfo tCrfResultClinicalSymptomsInfo : clinicalSymptomsInfos) {
				tCrfResultClinicalSymptomsInfo
						.setCrfResultClinicalSymptomsDetailList(this.crfResultClinicalSymptomsDetailDao
								.queryByCrfSymptomResultId(tCrfResultClinicalSymptomsInfo.getCrfSymptomResultId()));
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TCrfResultClinicalSymptomsInfo>) clinicalSymptomsInfos);
	}

	@Override
	public TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> queryCrfResultTcmSymptoms(String crfObserveId,
			Long patientId) {
		return crfResultClinicalSymptomsInfoDao.queryCrfResultTcmSymptomsByPatientIdAndCrfObserveId(crfObserveId,
				patientId);
	}

	@Transactional
	@Override
	public void saveCrfResultTcmSymptoms(TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> crfResultMainInfo)
			throws ParameterCannotBeNullException {
		// 查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(
				crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());

		if (mainInfo != null) {// 如果填写过则删除

			// 删除症状中医结果明细
			crfResultTcmSymptomsDetailDao.deleteCrfResultTcmSymptomsByCrfResultId(mainInfo.getCrfResultId());

			// 删除症状结果
			crfResultClinicalSymptomsInfoDao.deleteCrfResultClinicalSymptomsByCrfResultId(mainInfo.getCrfResultId());

			// 删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}

		// 保存结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);

		// 保存中医症状结果信息
		for (TCrfResultClinicalSymptomsInfo crfResultClinicalSymptomsInfo : crfResultMainInfo.getCrfResult()) {
			String crfSymptomResultId = GeneralUtil.generateUniqueID("CRSY");
			crfResultClinicalSymptomsInfo.setCrfResultId(crfResultId);
			crfResultClinicalSymptomsInfo.setCrfSymptomResultId(crfSymptomResultId);
			crfResultClinicalSymptomsInfoDao.insertCrfResultClinicalSymptoms(crfResultClinicalSymptomsInfo);
			// 保存中医症状结果明细
			List<TCrfResultTcmSymptomsDetail> crfResultTcmSymptomsDetails = crfResultClinicalSymptomsInfo
					.getCrfResultTcmSymptomsDetailList();
			if (crfResultTcmSymptomsDetails == null || crfResultTcmSymptomsDetails.isEmpty()) {
				throw new ParameterCannotBeNullException("Parameters cannot be empty!");
			}
			for (TCrfResultTcmSymptomsDetail crfResultTcmSymptomsDetail : crfResultTcmSymptomsDetails) {
				String crfSymptomResultDetailId = GeneralUtil.generateUniqueID("CRSD");
				crfResultTcmSymptomsDetail.setCrfSymptomResultDetailId(crfSymptomResultDetailId);
				crfResultTcmSymptomsDetail.setCrfSymptomResultId(crfSymptomResultId);
			}
			crfResultTcmSymptomsDetailDao
					.insertCrfResultTcmSymptomsList(crfResultClinicalSymptomsInfo.getCrfResultTcmSymptomsDetailList());
		}
	}

}
