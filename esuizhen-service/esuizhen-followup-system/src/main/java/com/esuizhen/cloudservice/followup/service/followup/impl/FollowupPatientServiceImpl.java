/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.followup.impl;<br/>  
 * <b>文件名：</b>FollowupPatientServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午10:32:29<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.followup.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskSeniorScreenPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupPatientStatisInfo;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.common.DataAccessFilter;
import com.esuizhen.cloudservice.followup.dao.followup.FollowupPatientDao;
import com.esuizhen.cloudservice.followup.service.followup.FollowupPatientService;
import com.westangel.common.bean.search.ConfGlobal;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.dao.search.ConfGlobalDao;
import com.westangel.common.dao.search.SearchDao;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PatientNoUtil;
import com.westangel.common.util.search.RetrievalParamentUtil;

/**
 * @ClassName: FollowupPatientServiceImpl
 * @Description:
 * @author lichenghao
 * @date 2016年8月8日 上午10:32:29
 */
@Service
@Transactional
public class FollowupPatientServiceImpl implements FollowupPatientService {

	@Autowired
	private SearchDao searchDao;
	//@Autowired
	//private ConfGlobalDao confGlobalDao;
//	@Autowired
//	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	@Autowired
	private ConfGlobalDao confGlobalDao;
	@Autowired
	private FollowupPatientDao followupPatientDao;
	
	@Autowired
	private DataAccessFilter dataAccessFilter;
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	@Override
	@Transactional
	public TFollowupPatientStatisInfo getFollowupTaskPatientList(FollowupTaskPatientReq req) {
		if (req.getOperator() == null)
			throw new EmptyParamExcption("param error operator is null");
		FollowupTaskPatientReq info = new FollowupTaskPatientReq();
		initFollowupTaskPatientInfo(req, info);
		// 插入查询患者数据
		saveSearchInfo(info);
		// 返回最终结果
		TFollowupPatientStatisInfo followupPatientStatisInfo = followupPatientDao.queryFollowupPatientStatis(info);
		if(followupPatientStatisInfo == null) {//如果查询结果为空，返回searchid给前端，供叠加筛选使用。
			followupPatientStatisInfo = new TFollowupPatientStatisInfo();
			followupPatientStatisInfo.setSearchId(info.getSearchId());
		}
		return followupPatientStatisInfo;
	}
	
	@Override
	@Transactional
	public TFollowupPatientStatisInfo getFollowupTaskPatientList(FollowupTaskScreenPatientReq req) {
		if (req.getOperator() == null)
			throw new EmptyParamExcption("param error operator is null");
		// 查询search数据
		FollowupTaskPatientReq info = new FollowupTaskPatientReq();
		SearchInfo searchInfo = searchDao.querySearchById(req.getSearchId());
		
		//初始化宽表列
		searchDao.initNullSearchWidePatientColumn(searchInfo);

		//将符合条件的患者标记
		String param = searchInfo.getReq();
		Map<String,Object> paramsMap = JSON.parseObject(param);
		paramsMap.put("searchId", searchInfo.getSearchId());
		paramsMap.put("searchColumn", searchInfo.getSearchColumn());
		paramsMap.put("searchTableName", searchInfo.getSearchTableName());
		paramsMap.put("searchNarrowTableName", searchDao.queryVarFollowupPatientTableName());
		paramsMap.put("needContactFlag", req.getNeedContactFlag());
		dataAccessFilter.decorteDataAccessParams(paramsMap, req.getOperator());
		followupPatientDao.updateSearchFollowupPatient(paramsMap);
		
		// 返回最终结果
		info.setSearchId(searchInfo.getSearchId());
		info.setSearchColumn(searchInfo.getSearchColumn());
		info.setSearchTableName(searchInfo.getSearchTableName());
		return followupPatientDao.queryFollowupPatientStatis(info);
	}

	@Override
	public TFollowupPatientStatisInfo getFollowupTaskSeniorScreenPatientList(FollowupTaskSeniorScreenPatientReq req) {
		if (req.getOperator() == null)
			throw new EmptyParamExcption("param error operator is null");
		if (req.getParaments() == null)
			throw new EmptyParamExcption("param error paraments is null");
		FollowupTaskPatientReq info=new FollowupTaskPatientReq();
		info.setSql(RetrievalParamentUtil.loadingParaments(req.getParaments()));
		initFollowupTaskPatientInfo(req,info);
		// 插入查询患者数据
		saveSearchInfo(info);
		// 返回最终结果
		return followupPatientDao.queryFollowupPatientStatis(info);
	}

	// 初始化查询
	private void initFollowupTaskPatientInfo(Object req, FollowupTaskPatientReq info) {
		if (info == null){
			info = new FollowupTaskPatientReq();
		}
		// 转为查询bean
		BeanUtils.copyProperties(req, info);
		if(info.getSex()!=null&&info.getSex().size()==0) {
			info.setSex(null);
		}
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		// 如果随访周期为null 使用系统默认随访周期
		if (info.getFollowupCycle() == null){
			info.setFollowupCycle(conf.getFollowupCycle());
		}
		//按肿瘤性质处理
		info.setFollowupRangeFlag(conf.getFollowupRangeFlag());
		if(conf.getFollowupRangeFlag()==1){
			info.setSourceTumorFlags(conf.getNotMalignantTumorFlag());
		}
		//长度判断
		List<String> list = info.getPatientNos();
		if(list!=null&&list.size()>Constant.BATCH_PATIENTNO){
			info.setPatientNos(null);
		}
		// 如果存在导入病案号，进行补齐
		if ( info.getPatientNos()!=null && info.getPatientNos().size()>0) {
			info.setOriginalPatientNos(info.getPatientNos());
			if (conf.getAutoPatientNoPaddingFlag() != 0 && conf.getAutoPatientNoPaddingDigits() != null)
			{
				info.setPatientNos(PatientNoUtil.loadPatientNo(info.getPatientNos(),conf.getAutoPatientNoPaddingDigits()));
			}
		}
		boolean isFollowupRole = organizationDoctorService.queryDoctorRoleById(info.getOperator(), null);
		if(isFollowupRole){
			String privilegeSql = organizationDoctorService.getPatientSql(info.getOperator(), null);
			info.setPrivilegeSql(privilegeSql);
		}
	}

	@Override
	public TFollowupPatientStatisInfo getFollowupTaskPatientListWithOverlap(
			FollowupTaskPatientReq req) {
		if (req.getOperator() == null)
			throw new EmptyParamExcption("param error operator is null");
		if (req.getSearchId() == null)
			throw new EmptyParamExcption("param error searchId is null");
		FollowupTaskPatientReq info = new FollowupTaskPatientReq();
		initFollowupTaskPatientInfo(req,info);
		// 插入查询患者数据
		getSearchInfo(info);
		followupPatientDao.insertSearchFollowupPatient(info);
		// 返回最终结果
		return followupPatientDao.queryFollowupPatientStatis(info);
	}
	
	/**
	 * 创建查询类
	 * @param info
	 */
	private void saveSearchInfo(FollowupTaskPatientReq info) {
		// 创建查询类
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SearchInfo searchInfo = new SearchInfo(methodName,JsonUtil.toJson(info), info.getOperator());
		Integer searchId = searchDao.createSearchInfo(searchInfo);
		info.setSearchId(searchId);
		SearchInfo search = getSearchInfo(info);
		// 插入查询患者数据
		int totalNum = followupPatientDao.insertSearchFollowupPatient(info);
		search.setTotalNum(totalNum);
		searchDao.update(search);
	}
	
	/**
	 * 查询search数据
	 * @param req
	 * @param info
	 * @param conf
	 * @return
	 */
	private SearchInfo getSearchInfo(FollowupTaskPatientReq info) {
		// 查询search数据
		SearchInfo searchInfo = searchDao.querySearchById(info.getSearchId());
		info.setSearchTableName(searchInfo.getSearchTableName());
		info.setSearchColumn(searchInfo.getSearchColumn());
		return searchInfo;
	}
}
