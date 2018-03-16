package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultQualityoflifeInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultQualityoflifeInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultQualityoflifeInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class TCrfResultQualityoflifeInfoServiceImpl implements TCrfResultQualityoflifeInfoService{
	
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	
	@Autowired
	private TCrfResultQualityoflifeInfoDao crfResultQualityoflifeInfoDao;

	@Override
	public TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>> queryCrfResultQualityoflife(String crfObserveId, Long patientId)
	{
		return crfResultQualityoflifeInfoDao.queryCrfResultQualityoflifeByCrfObserveIdAndPatientId(crfObserveId, patientId);
	}

	@Transactional
	@Override
	public void saveCrfResultQualityoflife(TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>> crfResultMainInfo) throws ParameterCannotBeNullException
	{
		//查询是否填写过
		TCrfResultMainInfo<?> mainInfo = crfResultMainInfoDao.queryCrfResultMainByCrfObserveIdAndPatientId(crfResultMainInfo.getCrfObserveId(), crfResultMainInfo.getPatientId());
		
		if(mainInfo!=null)
		{//如果填写过则删除
			
			//删除生存质量结果
			crfResultQualityoflifeInfoDao.deleteCrfResultQualityoflifeByCrfResultId(mainInfo.getCrfResultId());
			
			//删除结果主信息
			crfResultMainInfoDao.deleteCrfResultMain(mainInfo.getCrfResultId());
		}
				
		//保存结果主表信息
		String crfResultId = GeneralUtil.generateUniqueID("CRRI");
		crfResultMainInfo.setCrfResultId(crfResultId);
		crfResultMainInfoDao.insertCrfResultMain(crfResultMainInfo);
		
		//保存生成质量结果信息
		List<TCrfResultQualityoflifeInfo> crfResultQualityoflifeInfos = crfResultMainInfo.getCrfResult();
		if (crfResultQualityoflifeInfos == null || crfResultQualityoflifeInfos.isEmpty()) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		for(TCrfResultQualityoflifeInfo crfResultQualityoflifeInfo : crfResultQualityoflifeInfos)
		{
			String crfSymptomResultId = GeneralUtil.generateUniqueID("CRQR");
			crfResultQualityoflifeInfo.setCrfResultId(crfResultId);
			crfResultQualityoflifeInfo.setCrfQolResultId(crfSymptomResultId);;
		}
		
		crfResultQualityoflifeInfoDao.insertCrfResultQualityoflifeList(crfResultMainInfo.getCrfResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TCrfResultQualityoflifeInfo> queryCrfResultQualityoflifeRecord(String projectId, Long patientId, Integer page, Integer num)
	{
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<TCrfResultQualityoflifeInfo> crfResultMainInfos = crfResultQualityoflifeInfoDao.queryTCrfResultQualityoflifeInfoRecord(projectId, patientId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TCrfResultQualityoflifeInfo>)crfResultMainInfos);
	}
	
	
}
