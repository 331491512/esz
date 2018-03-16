package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTestDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTestInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTestDetail;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTestInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTestInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class TCrfResultTestInfoServiceImpl implements TCrfResultTestInfoService {

	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;

	@Autowired
	private TCrfResultTestInfoDao crfResultTestInfoDao;
	@Autowired
	private TCrfResultTestDetailDao crfResultTestDetailDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfResultTest(TCrfResultMainInfo<List<TCrfResultTestInfo>> crfResultMainInfo) {
		// 查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(
				crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());

		if (mainInfo != null) {// 如果填写过则删除

			// 删除检验结果明细
			crfResultTestDetailDao.deleteCrfResultTestDetailByCrfResultId(mainInfo.getCrfResultId());

			// 删除检验结果
			crfResultTestInfoDao.deleteCrfResultTestByCrfResultId(mainInfo.getCrfResultId());

			// 删除检验结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
		// 保存检验结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);

		// 保存检验结果信息
		for (TCrfResultTestInfo crfResultTestInfo : crfResultMainInfo.getCrfResult()) {
			String crfTestResultId = GeneralUtil.generateUniqueID("CRTE");
			crfResultTestInfo.setCrfResultId(crfResultId);
			crfResultTestInfo.setCrfTestResultId(crfTestResultId);
			crfResultTestInfoDao.insertCrfResultTest(crfResultTestInfo);

			// 保存检验结果明细
			for (TCrfResultTestDetail crfResultTestDetail : crfResultTestInfo.getCrfResultTestDetailList()) {
				String crfTestResultDetailId = GeneralUtil.generateUniqueID("CTDE");
				crfResultTestDetail.setCrfTestResultId(crfTestResultId);
				crfResultTestDetail.setCrfTestResultDetailId(crfTestResultDetailId);
			}

			crfResultTestDetailDao.insertCrfResultTestDetailList(crfResultTestInfo.getCrfResultTestDetailList());
		}
	}

	@Override
	public TCrfResultMainInfo<List<TCrfResultTestInfo>> queryCrfResultTest(String crfObserveId, Long patientId) {
		return crfResultTestInfoDao.queryCrfResultTestByPatientIdAndCrfObserveId(crfObserveId, patientId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultMainInfo<List<TCrfResultTestInfo>>> queryCrfResultTestRecord(String projectId, Long patientId,
			Integer page, Integer num) {
		if (StringUtils.isEmpty(projectId) || patientId == null) {
			throw new EmptyParamExcption();
		}
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<TCrfResultMainInfo<List<TCrfResultTestInfo>>> crfResultMainInfos = this.crfResultTestInfoDao
				.queryCrfResultTestRecord(projectId, patientId);
		if (crfResultMainInfos != null && !crfResultMainInfos.isEmpty()) {
			for (TCrfResultMainInfo<List<TCrfResultTestInfo>> tCrfResultMainInfo : crfResultMainInfos) {
				tCrfResultMainInfo.setCrfResult(
						this.crfResultTestInfoDao.queryBySampleTime(tCrfResultMainInfo.getHappenTime(), patientId));
			}
		}
		return PageUtil.returnPage(
				(com.github.pagehelper.Page<TCrfResultMainInfo<List<TCrfResultTestInfo>>>) crfResultMainInfos);
	}

}
