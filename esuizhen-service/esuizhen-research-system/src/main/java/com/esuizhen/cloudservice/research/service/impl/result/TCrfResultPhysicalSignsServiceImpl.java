package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultPhysicalSignsDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalSigns;
import com.esuizhen.cloudservice.research.service.result.TCrfResultMainInfoService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultPhysicalSignsService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
public class TCrfResultPhysicalSignsServiceImpl implements TCrfResultPhysicalSignsService {
	@Autowired
	private TCrfResultPhysicalSignsDao crfResultPhysicalSignsDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultMainInfoService crfResultMainInfoService;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> queryCrfResultPhysicalSignsRecord(String projectId,
			Long patientId, Long doctorId, Integer page, Integer num) {
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
		List<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> crfResultMainInfos = this.crfResultPhysicalSignsDao.findCrfResultPhysicalSignsRecord(projectId, patientId);
		if (crfResultMainInfos != null && !crfResultMainInfos.isEmpty()) {
			for (TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> tCrfResultMainInfo : crfResultMainInfos) {
				List<TCrfResultPhysicalSigns> crfResultPhysicalSigns = this.crfResultPhysicalSignsDao.findCrfResultPhysicalSignsRecordByCheckDate(tCrfResultMainInfo.getCheckDate(), patientId);
				tCrfResultMainInfo.setCrfResult(crfResultPhysicalSigns);
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>>)crfResultMainInfos);
	}

	@Transactional
	@Override
	public TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> queryCrfResultPhysicalSigns(String crfObserveId, Long patientId,
			Long doctorId) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (StringUtils.isEmpty(crfObserveId) || patientId == null) {
			return null;
		}
		TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> crfResultMainInfo = this.crfResultPhysicalSignsDao.findCrfResultPhysicalSigns(crfObserveId, patientId);
		return crfResultMainInfo;
	}

	@Transactional
	@Override
	public boolean saveCrfResultPhysicalSigns(TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		if (crfResultMainInfo == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<TCrfResultPhysicalSigns> crfResultPhysicalSignss = crfResultMainInfo.getCrfResult();
		if (crfResultPhysicalSignss == null) {
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
		//删除之前的患者体征情况
		this.crfResultPhysicalSignsDao.deleteByCrfObserveIdAndPatientId(resultMainInfo.getCrfObserveId(), resultMainInfo.getPatientId());
		for (int i = 0; i < crfResultPhysicalSignss.size(); i++) {
			TCrfResultPhysicalSigns crfResultPhysicalSigns = crfResultPhysicalSignss.get(i);
			crfResultPhysicalSigns.setIndex(i);
			if (StringUtils.isEmpty(crfResultPhysicalSigns.getCrfPhysicalSignsResultId())) {
				crfResultPhysicalSigns.setCrfPhysicalSignsResultId(GeneralUtil.generateUniqueID("CPSR"));
			}
			if (StringUtils.isEmpty(crfResultPhysicalSigns.getCrfResultId())) {
				crfResultPhysicalSigns.setCrfResultId(resultMainInfo.getCrfResultId());
			}
		}
		//保存传入的患者体征情况
		this.crfResultPhysicalSignsDao.insertByBatch(crfResultPhysicalSignss);
		return true;
	}

}
