package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentOtherInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOtherInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultTreatmentOtherInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class TCrfResultTreatmentOtherInfoServiceImpl implements TCrfResultTreatmentOtherInfoService{
	
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultTreatmentOtherInfoDao crfResultTreatmentOtherInfoDao;

	@Override
	public TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>> queryCrfResultTreatmentOther(String crfObserveId, Long patientId)
	{
		return crfResultTreatmentOtherInfoDao.queryCrfResultTreatmentOtherByCrfObserveIdPatientId(crfObserveId, patientId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCrfResultTreatmentOther(TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>> crfResultMainInfo)
	{
		//查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		
		if(mainInfo!=null)
		{//如果填写过则删除
			
			//删除其他治疗结果
			crfResultTreatmentOtherInfoDao.deleteCrfResultTreatmentOtherByCrfResultId(mainInfo.getCrfResultId());
			
			//删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
		//保存结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		
		//保存其他治疗结果信息
		List<TCrfResultTreatmentOtherInfo> crfResultTreatmentOtherInfos = crfResultMainInfo.getCrfResult();
		if (crfResultTreatmentOtherInfos != null && !crfResultTreatmentOtherInfos.isEmpty()) {
			for (TCrfResultTreatmentOtherInfo crfResultTreatmentOtherInfo : crfResultTreatmentOtherInfos) {
				String crfTreatmentOtherResultId = GeneralUtil.generateUniqueID("CRTO");
				crfResultTreatmentOtherInfo.setCrfResultId(crfResultId);
				crfResultTreatmentOtherInfo.setCrfTreatmentOtherResultId(crfTreatmentOtherResultId);
			}
			crfResultTreatmentOtherInfoDao.insertCrfResultTreatmentOtherList(crfResultTreatmentOtherInfos);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>> queryCrfResultTreatmentMedication(String projectId, Long patientId, Integer page, Integer num)
	{
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
		//获取月份
		List<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>> crfResultMainInfos = this.crfResultTreatmentOtherInfoDao.queryCrfResultTreatmentMedicationRecord(projectId, patientId);
		if (crfResultMainInfos != null && !crfResultMainInfos.isEmpty()) {
			for (TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>> tCrfResultMainInfo : crfResultMainInfos) {
				List<TCrfResultTreatmentOtherInfo> crfResultTreatmentOtherInfos = this.crfResultTreatmentOtherInfoDao.queryCrfResultTreatmentMedicationByHappenTime(projectId, patientId, tCrfResultMainInfo.getHappenTime());
				tCrfResultMainInfo.setCrfResult(crfResultTreatmentOtherInfos);
				tCrfResultMainInfo.setCommon(DateUtil.getDateOfDay(tCrfResultMainInfo.getHappenTime(), "yyyy-MM"));
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>>)crfResultMainInfos);
	}
}
