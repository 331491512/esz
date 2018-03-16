/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service.impl<br/>  
 * <b>文件名：</b>PatientServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:46:24<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.user.bean.PatientExportReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.PatientConfirmedDateReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.common.followuppatient.BeanUtils;
import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.esuizhen.cloudservice.user.dao.MetaDao;
import com.esuizhen.cloudservice.user.dao.OperationHistoryDao;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.dao.PatientFamilyDao;
import com.esuizhen.cloudservice.user.dao.TPatientWideDao;
import com.esuizhen.cloudservice.user.dao.UserDao;
import com.esuizhen.cloudservice.user.dao.followuppatient.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.user.dao.followuppatient.FollowupPatientDao;
import com.esuizhen.cloudservice.user.dao.followuppatient.TPatientExportTemplateInfoDao;
import com.esuizhen.cloudservice.user.followuppatient.util.FileSuffixEnum;
import com.esuizhen.cloudservice.user.followuppatient.util.FileUtil;
import com.esuizhen.cloudservice.user.followuppatient.util.UtilValidate;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.model.TMetaInfoRelatives;
import com.esuizhen.cloudservice.user.model.TPatientWide;
import com.esuizhen.cloudservice.user.model.followuppatient.FollowupPatientProfile;
import com.esuizhen.cloudservice.user.model.followuppatient.PatientCallBackInfo;
import com.esuizhen.cloudservice.user.model.followuppatient.TFaultSimilarPatientSpread;
import com.esuizhen.cloudservice.user.model.followuppatient.TPatientExportTemplateInfo;
import com.esuizhen.cloudservice.user.model.followuppatient.TPatientSpreadItem;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.esuizhen.cloudservice.user.service.UserRoleService;
import com.esuizhen.cloudservice.user.service.followuppatient.ExportBigData;
import com.esuizhen.cloudservice.user.service.followuppatient.FollowupPatientService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.User;
import com.westangel.common.bean.search.ConfGlobal;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.bean.user.RConfDataPrivilege;
import com.westangel.common.bean.user.TRDoctor;
import com.westangel.common.dao.search.ConfGlobalDao;
import com.westangel.common.dao.search.SearchDao;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.AuthorizationService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PatientNoUtil;

/** 
* @ClassName: PatientFollowupServiceImpl 
* @Description: 
* @author yuan_wm
*/
@Service(value = "patientFollowupService")
public class FollowupPatientServiceImpl implements FollowupPatientService{
	
	@Autowired
	private FollowupPatientDao followupPatientDao;
	
	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PatientFamilyDao patientFamilyDao;
	
	@Autowired
	private TPatientExportTemplateInfoDao templateDao;
	
	@Autowired
	private ExportBigData exportBigData;
	
	@Autowired
	private ConfGlobalDao globalConfigInfoDao;
	
	@Autowired
	private OperationHistoryDao operationHistoryDao;
	@Autowired
	private ConfGlobalDao confGlobalDao;
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private TPatientWideDao patientWideDao;
	
	@Autowired
	private MetaDao metaDao;
	
	/** 院际医生工作站  add by yuan_wm 20170217 start */
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private DoctorService doctorService;
	/** 院际医生工作站  add by yuan_wm 20170217 end */
	@Autowired
	private UserRoleService userRoleService;
	
	// add by zhuguo
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	// end
	
	@Override
	public int saveMiddlePatientSimpleInfo(TPatientSearchInfo patientSearchInfo)
			throws EmptyParamExcption {
		fillPatientSearch(patientSearchInfo);
		SearchInfo search = saveSearchInfo(patientSearchInfo);
		AsyncSearchServiceImpl asyncSearch = new AsyncSearchServiceImpl();
		asyncSearch.setSearch(search);
		asyncSearch.setSearchDao(searchDao);
		new Thread(asyncSearch).start();
		return search.getSearchId();
	}
	
	/**
	 * 把查询条件插入中间表var_search
	 */
	@Transactional
	private SearchInfo saveSearchInfo(TPatientSearchInfo patientSearch) {
		String jsonParams = JsonUtil.toJson(patientSearch);
		SearchInfo search = new SearchInfo();
		search.setInterfaceName(patientSearch.getInterfaceName());
		if(jsonParams==null)
			jsonParams = JSON.toJSONString(patientSearch);
		search.setReq(jsonParams);
		search.setOperator(patientSearch.getOperator());
		long start = System.currentTimeMillis();
		search.setSearchTableName(searchDao.queryVarFollowupPatientTableName());
		search.setSearchId(searchDao.createSearchInfo(search));
		//编目角色ID为55不执行该语句
//		if(patientSearch.getDeployLocation() != null && patientSearch.getDeployLocation() == 2 && patientSearch.getUserRole()!=55) {
//			//插入查询中间表 院际医生工作站  add by yuan_wm 20170217 start
//			Map<String,Object> beanMap = BeanUtils.toMap(patientSearch);
//			beanMap.put("searchId", search.getSearchId());
//			beanMap.put("searchTableName", search.getSearchTableName());
//			beanMap.put("searchColumn", search.getSearchColumn());
//			int totalNum = 0;
//			totalNum = patientFollowupDao.insertSearchPatient(beanMap);
//			search.setTotalNum(totalNum);
//			searchDao.update(search);
//			//插入查询中间表 院际医生工作站  add by yuan_wm 20170217 end
//		}
		long end = System.currentTimeMillis();
		long diff = (end - start) /1000l;
		LogUtil.log.info("把查询条件插入到var_search表中==》" + diff + "秒");
		return search;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> searchPatientSimpleInfoList(
			TwiceSearchReq twiceSearchReq)
			throws EmptyParamExcption {
		TwiceSearchReq localReq = twiceSearchReq;
		Integer num = localReq.getNum();
		Integer page = localReq.getPage();
		Integer searchId = localReq.getSearchId();
		Integer conditionId = localReq.getConditionId();
		SearchInfo search = searchDao.querySearchById(searchId);
		if(search == null) {
			throw new EmptyParamExcption("searchId 为空");
		}
		twiceSearchReq = null;
		if(search == null || StringUtils.isEmpty(search.getSearchTableName()) || StringUtils.isEmpty(search.getSearchColumn())) {
			throw new EmptyParamExcption("宽表==》表名或者列名为空!");
		}
		String tableName = search.getSearchTableName();//表名
		String searchColumn = search.getSearchColumn();//列名
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("tableName", tableName);
		paramsMap.put("searchColumn", searchColumn);
		paramsMap.put("conditionId", conditionId);
		
		// add by zhuguo 判断项目位置
		LinkedHashMap<String,Integer> lmap = followupGlobalConfigInfoDao.queryFollowupGlobalConfigInfo();
		Integer deployLocation = lmap.get("deployLocation");
		paramsMap.put("deployLocation", deployLocation);
		// end
		
		PageHelper.startPage(page+1, num);
		List<PatientSimpleInfo> list = followupPatientDao.queryPagePatientSimpleList(paramsMap);
		return PageUtil.returnPage((com.github.pagehelper.Page<?>) list);
	}
	
	@Override
	public int updatePatientProfileSeletive(PatientProfile patientProfile)
			throws EmptyParamExcption {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLostFollowupPatientState(Long patientId)
			throws EmptyParamExcption {
		return followupPatientDao.updateLostFollowupPatientState(patientId);
	}

	@Override
	public FollowupPatientProfile getPatientProfileAndFimilyById(Long patientId,Integer dataId) {
		ConfGlobal conf = globalConfigInfoDao.queryConfGlobal();
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientId", patientId);
		if(conf != null && conf.getDeployLocation() != null && conf.getDeployLocation() == 2) {
			paramsMap.put("dataId", conf.getDeployLocation());
		}
		return followupPatientDao.getPatientProfileAndFimilyById(paramsMap);
	}
	
	@Override
	public int savePatientAndFamily(FollowupPatientProfile patientProfile) throws Exception{
		int res = 0;
		res = savePatientAndFamily(patientProfile,null);
		if(res > 0) {
//			AsyncFreshPatientWideTableServiceImpl patientWideTable = new AsyncFreshPatientWideTableServiceImpl();
//			patientWideTable.setPatientId(patientProfile.getPatientId());
//			patientWideTable.setPatientFollowupDao(patientFollowupDao);
//			new Thread(patientWideTable).start();
			savePatientWideByFamily(patientProfile.getPatientId(),patientProfile.getLatestClinicDate(),patientProfile.getPatientFamilyList());
		}
		return res;
	}
	
	private void savePatientWideByFamily(Long patientId,Date latestClinicDate,List<PatientFamily> patientFamilyList){
		boolean isUpdate=false;
		TPatientWide patientWide=patientWideDao.queryPatientWideByPatientId(patientId);;
		if(UtilValidate.isEmpty(patientWide)){
			patientWide=new TPatientWide();
		}else{
			isUpdate=true;
		}
		patientWide.setPatientId(patientId);
		patientWide.setLatestClinicDate(latestClinicDate);
		
		if(UtilValidate.isNotEmpty(patientFamilyList)){
			for(PatientFamily patientFamily:patientFamilyList){
				if(patientFamily.getIsDefault()==1){
					patientWide.setFamilyName1(patientFamily.getFamilyName());
					patientWide.setFamilyPhone1(patientFamily.getFamilyPhone());
					patientWide.setPatientRelationId1(patientFamily.getPatientRelation());
					patientWide.setAddress1(patientFamily.getAddress());
					patientWide.setIsValid1(patientFamily.getIsValid());
					TMetaInfoRelatives meta1=metaDao.queryMetaInfoRelatives(patientFamily.getPatientRelation());
					patientWide.setPatientRelation2(meta1.getRelationName());
					if(UtilValidate.isEmpty(patientFamily.getCreateTime())){
						patientWide.setFamilyCreateTime1(new Date());
					}else{
						patientWide.setFamilyCreateTime1(patientFamily.getCreateTime());
					}
					patientFamilyList.remove(patientFamily);
					break;
				}
			}
		}
		if(UtilValidate.isNotEmpty(patientFamilyList)){
			Iterator<PatientFamily> it=patientFamilyList.iterator();
			PatientFamily patientFamily2= it.next();
			patientWide.setFamilyName2(patientFamily2.getFamilyName());
			patientWide.setFamilyPhone2(patientFamily2.getFamilyPhone());
			patientWide.setPatientRelationId2(patientFamily2.getPatientRelation());
			patientWide.setAddress2(patientFamily2.getAddress());
			patientWide.setIsValid2(patientFamily2.getIsValid());
			TMetaInfoRelatives meta2=metaDao.queryMetaInfoRelatives(patientFamily2.getPatientRelation());
			patientWide.setPatientRelation2(meta2.getRelationName());
			if(UtilValidate.isEmpty(patientFamily2.getCreateTime())){
				patientWide.setFamilyCreateTime2(new Date());
			}else{
				patientWide.setFamilyCreateTime2(patientFamily2.getCreateTime());
			}
			patientFamilyList.remove(patientFamily2);
		}else{
			patientWide.setFamilyName2(null);
			patientWide.setFamilyPhone2(null);
			patientWide.setPatientRelationId2(null);
			patientWide.setAddress2(null);
			patientWide.setIsValid2(null);
			patientWide.setPatientRelation2(null);
			patientWide.setFamilyCreateTime2(null);
		}
			
		if(UtilValidate.isNotEmpty(patientFamilyList)){
			Iterator<PatientFamily> it=patientFamilyList.iterator();
			PatientFamily patientFamily3=it.next();
			patientWide.setFamilyName3(patientFamily3.getFamilyName());
			patientWide.setFamilyPhone3(patientFamily3.getFamilyPhone());
			patientWide.setPatientRelationId3(patientFamily3.getPatientRelation());
			patientWide.setAddress3(patientFamily3.getAddress());
			patientWide.setIsValid3(patientFamily3.getIsValid());
			TMetaInfoRelatives meta3=metaDao.queryMetaInfoRelatives(patientFamily3.getPatientRelation());
			patientWide.setPatientRelation3(meta3.getRelationName());
			if(UtilValidate.isEmpty(patientFamily3.getCreateTime())){
				patientWide.setFamilyCreateTime3(new Date());
			}else{
				patientWide.setFamilyCreateTime3(patientFamily3.getCreateTime());
			}
		}else{
			patientWide.setFamilyName3(null);
			patientWide.setFamilyPhone3(null);
			patientWide.setPatientRelationId3(null);
			patientWide.setAddress3(null);
			patientWide.setIsValid3(null);
			patientWide.setPatientRelation3(null);
			patientWide.setFamilyCreateTime3(null);
		}
		
		if(isUpdate){
			patientWideDao.updateByPrimaryKey(patientWide);
		}else{
			patientWideDao.insertPatientWide(patientWide);
		}
	}
	
	/**
	 * 保存患者及家属联系人信息
	 * @param patientProfile
	 * @param other
	 * @return
	 */
	@Transactional
	private int savePatientAndFamily(FollowupPatientProfile patientProfile,String other) {
		LogUtil.log.info("开始执行患者及家属联系人信息更新插入操作...");
		int res = 0;
		boolean updateFlag=false;
		User userInfo = userDao.findByUserId(patientProfile.getUserId());
		String mobile = userInfo.getMobile();
		//add by fanpanwei  患者表mobile！=用户表mobile
		/*if(mobile !=null && !mobile.equals(patientProfile.getMobile())) {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("mobile", patientProfile.getMobile());
			paramMap.put("accountType", userInfo.getAccountType());
			paramMap.put("role", userInfo.getRole());
			int count = userDao.existsUser(paramMap);
			if(count > 0) {
				return -1;
			}
		}*/
		if(patientProfile.getIdentification() != null && patientProfile.getIdentification().endsWith("*")) {
			patientProfile.setIdentification(userInfo.getIdentification());
		}
		//更新患者基本信息
		User user = new User();
		user.setUserId(patientProfile.getUserId());
		user.setTrueName(patientProfile.getTrueName());
		user.setMobile(mobile);
		user.setSex(patientProfile.getSex());
		user.setBirthDate(patientProfile.getBirthDate());
		user.setNationId(patientProfile.getNationId());
		user.setNation(patientProfile.getNation());
		user.setNationalityId(patientProfile.getNationalityId());
		user.setCountry(patientProfile.getCountry());
		user.setBirthPlaceAddress(patientProfile.getBirthPlaceAddress());
		user.setBirthPlaceCode(patientProfile.getBirthPlaceCode());
		user.setNativeplace(patientProfile.getNativePlace());
		user.setOccupationId(patientProfile.getOccupationId());
		user.setProfession(patientProfile.getProfession());
		user.setIdentification(patientProfile.getIdentification());
		user.setMarriageStatus(patientProfile.getMarriageStatus());
		res += userDao.updateFollowupPatientByPrimaryKey(user);
		//更新患者信息
		PatientProfile p = new PatientProfile();
		p.setPatientId(patientProfile.getPatientId());
		p.setAuditRemark(patientProfile.getAuditRemark());
		p.setWholeProcessFlag(patientProfile.getWholeProcessFlag());
		p.setBirthDate(patientProfile.getBirthDate());
		p.setCauseOfDeath(patientProfile.getCauseOfDeath());
		p.setDeathDate(patientProfile.getDeathDate());
		p.setLiveStatus(patientProfile.getLiveStatus());
		if(StringUtils.isNotEmpty(patientProfile.getMobile())){
			//患者表不用改成user表手机号
			p.setMobile(patientProfile.getMobile());
		}
		p.setSex(patientProfile.getSex());
		p.setTrueName(patientProfile.getTrueName());
		
		//最近门诊时间
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientId", p.getPatientId());
		paramsMap.put("latestClinicDate", patientProfile.getLatestClinicDate());
		res += followupPatientDao.updateLatestClinicDate(paramsMap);
		
		List<PatientFamily> updateFamilyList = new ArrayList<PatientFamily>();
		List<PatientFamily> insertFamilyList = new ArrayList<PatientFamily>();
		//添加患者家属信息
		List<Long> noDelIdList = null;
		List<PatientFamily> patientFamilyList = patientProfile.getPatientFamilyList();
		if(patientFamilyList != null && patientFamilyList.size() > 0) {
			noDelIdList = new ArrayList<Long>();
			boolean flag = true;
			//patientFamilyDao.deleteByPatientId(p.getPatientId());
			for(PatientFamily patientFamily : patientFamilyList) {
				List<PatientFamily> existsPhone = patientFamilyDao.find(p.getPatientId(), patientFamily.getFamilyPhone());
				if(patientFamily.getIsDefault() != null && patientFamily.getIsDefault()==1 && flag) {
					p.setPatientRelation(patientFamily.getPatientRelation());
					p.setFamilyName(patientFamily.getFamilyName());
					p.setFamilyPhone(patientFamily.getFamilyPhone());
					
					// 电话状态，随访时修改，add by zhuguo
					p.setPhoneStatus(patientFamily.getPhoneStatus());
					flag = false;
				}
				patientFamily.setPatientId(p.getPatientId());
				if(patientFamily.getId()!=null){
					updateFamilyList.add(patientFamily);
					noDelIdList.add(patientFamily.getId());
					//patientFamilyDao.update(patientFamily);
					if(!existsPhone.contains(patientFamily.getFamilyPhone())) {
						updateFlag = true;
					}
				}else{
					insertFamilyList.add(patientFamily);
					//noDelIdList.add(patientFamilyDao.insert(patientFamily));
					if(!existsPhone.contains(patientFamily.getFamilyPhone())) {
						updateFlag = true;
					}
				}
			}
		}
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("noDelIdList", noDelIdList);
		hm.put("patientId", p.getPatientId());
		patientFamilyDao.delByPatientIdAndId(hm);//add by fanpanwei
		if(updateFamilyList!=null){
			for (int i = 0; i < updateFamilyList.size(); i++) {
				patientFamilyDao.updatePatientFamily(updateFamilyList.get(i));
			}
		}
		if(insertFamilyList!=null){
			for (int i = 0; i < insertFamilyList.size(); i++) {
				PatientFamily patientFamily = insertFamilyList.get(i);
				if(StringUtils.isBlank(patientFamily.getContactId()))
					patientFamily.setContactId(GeneralUtil.generateUniqueID("CONT"));
				patientFamilyDao.insert(insertFamilyList.get(i));
			}
		}
		res += followupPatientDao.updateByPrimaryKey(p);
		if(updateFlag) {
			LogUtil.log.info("##########var_patient_follow(newContactFlag)置为空...##########");
			followupPatientDao.updateContactFlag(p.getPatientId());
			LogUtil.log.info("##########var_patient_follow(newContactFlag)置空结束!##########");
		}
		LogUtil.log.info("执行患者及家属联系人信息更新插入操作结束！");
		return res;
	}
	@Override
	public TPatientSpreadItem countFollowupStatusNum(Integer type,Integer userRole,Integer operator) {
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("countType", type);
		paramsMap.put("userRole", userRole);
		paramsMap.put("operator", operator);
		paramsMap.put("followupCycle", conf.getFollowupCycle());
		paramsMap.put("cancerFilterFlag", conf.getCancerFilterFlag());
		return followupPatientDao.countFollowupStatusNum(paramsMap);
	}

	@Override
	public TFaultSimilarPatientSpread statisticsFaultPatient(Integer searchId) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		return followupPatientDao.statisticsFaultPatient(paramsMap);
	}

	@Override
	public int getGroupsOfPatientByName(TwiceSearchReq twiceSearchReq)
			throws EmptyParamExcption{
		if(twiceSearchReq!=null){
			SearchInfo search = searchDao.querySearchById(twiceSearchReq.getSearchId());
			if(search == null) {
				throw new EmptyParamExcption("searchId 为空");
			}
			String req = search.getReq();
			Map<String,Object> paramsMap = JSON.parseObject(req);
			paramsMap.put("clickType", twiceSearchReq.getClickType());
			
			// add by zhuguo
			if (search.getOperator() != null) {
				boolean result = organizationDoctorService.queryDoctorRoleById(search.getOperator(), null);
				if (result) {
					String powerSql = organizationDoctorService.getPatientSql(search.getOperator(), null);
					if (powerSql == null || "".equals(powerSql)) {
						LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
					} else {
						paramsMap.put("powerSql", powerSql);
					}
				}
			}
			// end
			
			return followupPatientDao.getGroupsOfPatientByName(paramsMap);
		}else{
			//查询疑似总组数
			return followupPatientDao.getGroupsOfPatientByName(null);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> searchSimilarPatientSimpleInfoList(
			TwiceSearchReq twiceSearchReq) throws Exception {
		Integer searchId = twiceSearchReq.getSearchId();
		SearchInfo search = searchDao.querySearchById(searchId);
		if(search == null) {
			throw new EmptyParamExcption("searchId 为空");
		}
		String req = search.getReq();
		Map<String,Object> paramsMap = JSON.parseObject(req);
		//paramsMap.put("clickType", twiceSearchReq.getClickType());
		List<PatientSimpleInfo> list = null;
		if(twiceSearchReq.getClickType().equals(5)){
			paramsMap.put("startRow", twiceSearchReq.getPage()*twiceSearchReq.getNum());
			paramsMap.put("num", twiceSearchReq.getNum());
			list = followupPatientDao.queryPageSimilarPatientSimpleList(paramsMap);
			List<PatientProfile> otherPatients=null;
			for (PatientSimpleInfo patientSimpleInfo1 : list) {
				otherPatients=new ArrayList<PatientProfile>();
				PatientProfile pat=null;
				for (PatientSimpleInfo patientSimpleInfo2 : list) {
					if(patientSimpleInfo1.getGoalpatientid().equals(patientSimpleInfo2.getGoalpatientid())
							&&!patientSimpleInfo1.getPatientId().equals(patientSimpleInfo2.getPatientId())){
						pat=new PatientProfile();
						pat.setPatientId(patientSimpleInfo2.getPatientId());
						pat.setPatientNo(patientSimpleInfo2.getPatientNo());
						otherPatients.add(pat);
					}
				}
				patientSimpleInfo1.setOtherPatients(otherPatients);
			}
			Page<PatientSimpleInfo> pages=new Page<PatientSimpleInfo>();
			pages.setDataList(list);
			pages.setCurrPage(twiceSearchReq.getPage());
			int groupNum = getGroupsOfPatientByName(twiceSearchReq);
			pages.setTotalNum(groupNum);
			pages.setTotalPage(groupNum/twiceSearchReq.getNum()+((groupNum%twiceSearchReq.getNum())>0?1:0));
			if(pages.getTotalPage()>(pages.getCurrPage()+1)){
				pages.setCurrSize(twiceSearchReq.getNum());
			}else{
				pages.setCurrSize(groupNum-(pages.getTotalPage()-1)*twiceSearchReq.getNum());
			}
			return pages;
		}else if(twiceSearchReq.getClickType().equals(6)){
			PageHelper.startPage(twiceSearchReq.getPage()+1, twiceSearchReq.getNum());
			list = followupPatientDao.queryPageMergePatientSimpleList(paramsMap);
			for (PatientSimpleInfo patientSimpleInfo : list) {
				List<PatientProfile> patients=patientDao.findOtherMergePatient(patientSimpleInfo.getPatientId());
				patientSimpleInfo.setOtherPatients(patients);
				StringBuilder sf=new StringBuilder();
				sf.append(patientSimpleInfo.getPatientNo());
				sf.append(",");
				for (PatientProfile patientProfile : patients) {
					sf.append(patientProfile.getPatientNo());
					sf.append(",");
				}
				sf.append("合并原因：");
				if(!StringUtils.isBlank(patientSimpleInfo.getAuditRemark()))
					sf.append(patientSimpleInfo.getAuditRemark());
				patientSimpleInfo.setAuditRemark(sf.toString());
			}
			return PageUtil.returnPage((com.github.pagehelper.Page<PatientSimpleInfo>)list);
		}else{
			throw new EmptyParamExcption("clickType is not 5/6");
		}
	}

	@Override
	public void mergeSimilarPatient(List<Long> ids) throws Exception {
		doMerge(ids);
		List<Long> patientList = followupPatientDao.reversePatientByPatientId(ids.get(0));
		if(patientList != null && patientList.size()==1) {
			revokeSimilarPatient(patientList.get(0));
		}
	}
	
	@Transactional
	private void doMerge(List<Long> ids) {
		int len = ids.size();
		int subLen = len - 1;
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < len;i++) {
			if(i == subLen) {
				sb.append("'").append(ids.get(i)).append("'");
			}else {
				sb.append("'").append(ids.get(i)).append("'").append(",");
			}
		}
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientIds", sb.toString());
		paramsMap.put("goalpatientid", ids.get(0));
		int res = followupPatientDao.updateMergeflag(paramsMap);
		if(res > 0) {
			LogUtil.log.info("################## 调用存储过程合并疑似重复患者 start ##################");
			paramsMap.clear();
			followupPatientDao.mergePatientWithProcedure(paramsMap);
			LogUtil.log.info("################## 调用存储过程合并疑似重复患者 end! ##################");
			AsyncOperationHistoryServiceImpl asyncOperationHistory = new AsyncOperationHistoryServiceImpl();
			asyncOperationHistory.setIds(ids);
			asyncOperationHistory.setOperationHistoryDao(operationHistoryDao);
			new Thread(asyncOperationHistory).start();
		}
	}
	@Override
	public Integer countPatientSimpleNum(TwiceSearchReq twiceSearchReq) {
		SearchInfo search = searchDao.querySearchById(twiceSearchReq.getSearchId());
		if(search == null || StringUtils.isEmpty(search.getSearchTableName()) || StringUtils.isEmpty(search.getSearchColumn())) {
			throw new EmptyParamExcption("宽表==》表名或者列名为空!");
		}
		Map<String,Object> paramsMap = BeanUtils.toMap(twiceSearchReq);
		paramsMap.put("tableName", search.getSearchTableName());
		paramsMap.put("searchColumn", search.getSearchColumn());
		return followupPatientDao.countPatientSimpleNum(paramsMap);
	}

	@Override
	@Transactional
	public String exportPatient(PatientExportReq req) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(req.getExportTemplateId()))
			throw new EmptyParamExcption("error param templateId is null");
		TPatientExportTemplateInfo template = templateDao.getPatientExportTemplateById(req.getExportTemplateId());
		if(template==null)
			throw new EmptyObjectExcption("template is null  templateId:"+req.getExportTemplateId());
		String[] heads = null;
		String[] columns = null;
		heads = template.getHeads().split(",");
		columns = template.getFields().split(",");
		//对模版顺序进行判断
		if(StringUtils.isNotEmpty(template.getExportSort())){
			//对表头和列进行排序
			String[] sorts = template.getExportSort().split(",");
			String[] fheads = new String[sorts.length];
			String[] fcolumns = new String[sorts.length];
			for(int i=0;i<sorts.length;i++){
				Integer index = Integer.parseInt(sorts[i]);
				fheads[i] = heads[index];
				fcolumns[i] = columns[index];
			}
			heads = fheads;
			columns = fcolumns;
		}
		//判断是否有中间表查询 并 生成查询语句
		if(req.getSearchId()!=null){
			SearchInfo searchInfo = searchDao.querySearchById(req.getSearchId());
			/**
			 * 注意   u_patient 表定义别名为 t1
			 */
			
			// add by zhuguo
			String sql = "";
			if (searchInfo.getOperator() != null) {
				boolean result = organizationDoctorService.queryDoctorRoleById(searchInfo.getOperator(), null);
				if (result) {
					String powerSql = organizationDoctorService.getPatientSql(searchInfo.getOperator(), null);
					if (powerSql == null || "".equals(powerSql)) {
						LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
					} else {
						sql = " JOIN (" + powerSql + ") a ON a.patientId = t1.patientId ";
					}
				}
			}
			// end			
			
			//如果有查询语句 按照查询语句查询
			if(StringUtils.isNotEmpty(searchInfo.getSqlContent())){
				sql += " JOIN ("+ searchInfo.getSqlContent() + ") search ON search.patientId = t1.patientId AND t1.outPatientFlag=2 AND t1.patientType=1 AND t1.mergeFlag!=2 ";
				if(!StringUtils.isBlank(searchInfo.getInterfaceName())&&searchInfo.getInterfaceName().equals("/user/similar/patient/list"))
					sql =sql+ " left join uuid_patient_merge m1 on t1.patientId=m1.patientId ";
			}else{// 否则按照中间表进行查询
				sql += " JOIN "+ searchInfo.getSearchTableName() + " search ON search.patientId = t1.patientId AND t1.outPatientFlag=2 AND t1.patientType=1 AND t1.mergeFlag!=2 AND "+searchInfo.getSearchColumn();
				if(req.getReqFlag()!=null&&req.getReqFlag()==1)
					sql+=" = 1";
				else
					sql+=" IS NOT NULL";
			} 
			// {0} 关联查询字段    {1}{2}缺省可扩展
			template.setSqlContent(MessageFormat.format(template.getSqlContent(), sql,"",""));
			if(!StringUtils.isBlank(searchInfo.getInterfaceName())&&searchInfo.getInterfaceName().equals("/user/similar/patient/list"))
				template.setSqlContent(template.getSqlContent()+" Order by m1.goalpatientid ");
		}
		return exportFile(template.getSqlContent(),req.outFilePath,heads,columns);
	}
	
	//模拟分布式导出
	private String exportFile(final String sql,String outFilePath,String[] heads,final String[] columns){
		return this.exportExcelFile(sql, outFilePath, heads, columns,Constants.FOLLOW_PATIENT_FILE_NAME);
	}
	

	@Override
	public int revokeSimilarPatient(Long patientId)
			throws Exception {
		return followupPatientDao.revokeSimilarPatient(patientId);
	}
	
	@Override
	public List<PatientCallBackInfo> queryPatientCallBackInfo(String phone) {
		// 根据手机号获取患者信息
		List<PatientCallBackInfo> result = followupPatientDao.queryPatientCallBackInfo(phone);
		
		// 如果没有查询到
		if(result.size()  == 0){
			
			// 设置手机号和归属地
			PatientCallBackInfo info = new PatientCallBackInfo();
			info.setFamilyPhone(phone);
			info.setPhoneHome(followupPatientDao.queryPhoneHomeByPhone(phone));
			
			List<PatientCallBackInfo> ls = new ArrayList<PatientCallBackInfo>();
			ls.add(info);
			
			return ls;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public int statisticsPatientByDiseaseType(
			TPatientSearchInfo patientSearchInfo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> queryDemandMightRepeatPatientList(TwiceSearchReq req) {
		SearchInfo searchInfo = this.searchDao.querySearchById(req.getSearchId());
		
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<PatientSimpleInfo> params = this.followupPatientDao.findDemandMightRepeatPatientGroupList(searchInfo);
		List<PatientSimpleInfo> patientSimpleInfos = null;
		if (params != null && !params.isEmpty()) {
			patientSimpleInfos = this.followupPatientDao.findDemandMightRepeatPatientList(searchInfo, params);
		}
		Page<PatientSimpleInfo> data = PageUtil.returnPage((com.github.pagehelper.Page<PatientSimpleInfo>)params);
		data.setDataList(patientSimpleInfos);
		return data;
	}
	@Transactional
	@Override
	public int batchRevokeLostFollowPatient(List<Long> patientIds)
			throws EmptyParamExcption {
		Map<String,List<Long>>  paramsMap = new HashMap<String,List<Long>>();
		paramsMap.put("patientIds", patientIds);
		return followupPatientDao.batchRevokeLostFollowPatient(paramsMap);
	}

	@Override
	public int getGroupsOfPatientSortCount(TwiceSearchReq twiceSearchReq) {
		Integer searchId = twiceSearchReq.getSearchId();
		SearchInfo search = searchDao.querySearchById(searchId);
		if(search == null) {
			throw new EmptyParamExcption("searchId 为空");
		}
		String req = search.getReq();
		Map<String,Object> paramsMap = JSON.parseObject(req);
		List<PatientSimpleInfo> list = null;
		paramsMap.put("startRow", 0);
		paramsMap.put("num", (twiceSearchReq.getPage())*twiceSearchReq.getNum());
		
		// add by zhuguo
		if (search.getOperator() != null) {
			boolean result = organizationDoctorService.queryDoctorRoleById(search.getOperator(), null);
			if (result) {
				String powerSql = organizationDoctorService.getPatientSql(search.getOperator(), null);
				if (powerSql == null || "".equals(powerSql)) {
					LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
				} else {
					paramsMap.put("powerSql", powerSql);
				}
			}
		}
		// end
		
		return followupPatientDao.getGroupsOfPatientSortCount(paramsMap);
	}

//	@Override
//	public Page<PatientSimpleInfo> queryPatientInfoList(
//			TwiceSearchReq twiceSearchReq) throws EmptyParamExcption {
//		TwiceSearchReq localReq = twiceSearchReq;
//		Integer num = localReq.getNum();
//		Integer page = localReq.getPage();
//		Integer searchId = localReq.getSearchId();
//		Integer clickType =localReq.getClickType();
//		SearchInfo search = searchDao.querySearchById(searchId);
//		if(search == null) {
//			throw new EmptyParamExcption("searchId 为空");
//		}
//		twiceSearchReq = null;
//		String req = search.getReq();
//		Map<String,Object> paramsMap = JSON.parseObject(req);
//		paramsMap.put("operator", search.getOperator());
//		RConfDataPrivilege rConfDataPrivilege = authorizationService.findDataPrivilegeByDoctor(search.getOperator());
//		if(rConfDataPrivilege != null) {
//			paramsMap.put("dataId", rConfDataPrivilege.getDataId());
//			localReq.setDataId(rConfDataPrivilege.getDataId());
//		}else {
//			ConfGlobal conf = confGlobalDao.queryConfGlobal();
//			if(conf != null) {
//				paramsMap.put("deployLocation", conf.getDeployLocation());
//				localReq.setDataId(conf.getDeployLocation());
//			}
//		}
//		paramsMap.put("clickType", clickType);
//		PageHelper.startPage(page+1, num);
//		List<PatientSimpleInfo> list = patientFollowupDao.queryInternalPagePatientSimpleList(paramsMap);
//		return PageUtil.returnPage((com.github.pagehelper.Page<?>) list);
//	}
	
	@Override
	public Page<PatientSimpleInfo> queryPatientInfoList(
			TwiceSearchReq twiceSearchReq) throws EmptyParamExcption {
		Page<PatientSimpleInfo> pages = new Page<PatientSimpleInfo>();
		TwiceSearchReq localReq = twiceSearchReq;
		Integer num = localReq.getNum();
		Integer page = localReq.getPage();
		Integer searchId = localReq.getSearchId();
		Integer clickType =localReq.getClickType();
		SearchInfo search = searchDao.querySearchById(searchId);
		if(search == null) {
			throw new EmptyParamExcption("searchId 为空");
		}
		twiceSearchReq = null;
		String req = search.getReq();
		Map<String,Object> paramsMap = JSON.parseObject(req);
		paramsMap.put("operator", search.getOperator());
		RConfDataPrivilege rConfDataPrivilege = authorizationService.findDataPrivilegeByDoctor(search.getOperator());
		if(rConfDataPrivilege != null) {
			paramsMap.put("dataId", rConfDataPrivilege.getDataId());
			localReq.setDataId(rConfDataPrivilege.getDataId());
		}else {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			if(conf != null) {
				paramsMap.put("deployLocation", conf.getDeployLocation());
				localReq.setDataId(conf.getDeployLocation());
			}
		}
		paramsMap.put("clickType", clickType);
		String sql = organizationDoctorService.getPatientSql(search.getOperator(), null);
		// paramsMap.put("sql", sql);
		
		// add by zhuguo
		if (search.getOperator() != null) {
			boolean result = organizationDoctorService.queryDoctorRoleById(search.getOperator(), null);
			if (result) {
				String powerSql = organizationDoctorService.getPatientSql(search.getOperator(), null);
				if (powerSql == null || "".equals(powerSql)) {
					LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
				} else {
					paramsMap.put("powerSql", powerSql);
				}
			}
		}
		// end
		
		int totalNum =  followupPatientDao.queryInternalPagePatientSimpleTotal(paramsMap);
		if(totalNum > 0) {
			int totalPage = totalNum/num;
			if(totalNum % num != 0) {
				totalPage++;
			}
			paramsMap.put("startRow", page*num);
			paramsMap.put("pageSize", num);
			List<PatientSimpleInfo> list=followupPatientDao.queryInternalPagePatientSimpleList(paramsMap);
			pages.setTotalNum(totalNum);
			pages.setTotalPage(totalPage);
			pages.setCurrPage(page);
			pages.setCurrSize(num);
			pages.setDataList(list);
		}else {
			List<PatientSimpleInfo> list = new ArrayList<PatientSimpleInfo>();
			pages.setDataList(list);
		}
		return pages;
		
//		PageHelper.startPage(page+1, num);
//		List<PatientSimpleInfo> list = patientFollowupDao.queryInternalPagePatientSimpleList(paramsMap);
//		return PageUtil.returnPage((com.github.pagehelper.Page<?>) list);
	}
	
	/**
	 * 填充患者检索信息
	 * @param patientSearchInfo
	 */
	private void fillPatientSearch(TPatientSearchInfo patientSearch) {
		ConfGlobal conf = globalConfigInfoDao.queryConfGlobal();
		boolean flag = false;//默认是B端
		RConfDataPrivilege rConfDataPrivilege = authorizationService.findDataPrivilegeByDoctor(patientSearch.getOperator());
		if(rConfDataPrivilege != null && rConfDataPrivilege.getDataId() != null) {
			patientSearch.setDataId(rConfDataPrivilege.getDataId());
		}else {
			if(conf != null) {
				if(conf.getDeployLocation() != null && conf.getDeployLocation() == 2) {
					patientSearch.setDeployLocation(conf.getDeployLocation());
					int existFlag = userRoleService.existUserRoleRelationship(patientSearch.getOperator(), patientSearch.getUserRole());
					if(existFlag > 0) {
						patientSearch.setUserRole(patientSearch.getUserRole());
					}
					flag = true;
				}
			}
		}
		if(flag) {
			TRDoctor rDoctor = doctorService.getTRDoctorByDoctorId(patientSearch.getOperator());
			if(rDoctor != null) {
				patientSearch.setDoctorLevel(rDoctor.getDoctorLevel());
			}
		}
		if(patientSearch != null && StringUtils.isNotEmpty(patientSearch.getBatchPatientNo())) {
			Integer autoPatientNoPaddingDigits = 0;
			if(conf != null) {
				Integer autoPatientNoPaddingFlag = conf.getAutoPatientNoPaddingFlag();
				if(autoPatientNoPaddingFlag != null && autoPatientNoPaddingFlag == 1) {
					autoPatientNoPaddingDigits = conf.getAutoPatientNoPaddingDigits();
				}
			}
			String[] splits = patientSearch.getBatchPatientNo().split("[ |,]");
			StringBuffer sb = new StringBuffer();
			StringBuffer sb1 = new StringBuffer();
			int len = splits.length;
			int subLen = len -1;
			for(int i = 0; i < len;i++) {
				String tmpPatientNo = PatientNoUtil.loadPatientNo(splits[i], autoPatientNoPaddingDigits);
				if(i==subLen) {
					sb.append("'").append(tmpPatientNo).append("'");
				}else {
					sb.append("'").append(tmpPatientNo).append("'").append(",");
				}
				
				if(i==subLen) {
					sb1.append("'").append(splits[i]).append("'");
				}else {
					sb1.append("'").append(splits[i]).append("'").append(",");
				}
			}
			patientSearch.setBatchPatientNo(sb.toString());
			patientSearch.setOriginalBatchPatientNo(sb1.toString());
		}
		//随访范围写入
		if(conf!=null){
			patientSearch.setFollowupRangeFlag(conf.getFollowupRangeFlag());
			patientSearch.setNotMalignantTumorFlag(conf.getNotMalignantTumorFlag());
		}
	}

	@Override
	public String exportFollowupTable(PatientExportReq req) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(req.getExportTemplateId()))
			throw new EmptyParamExcption("error param templateId is null");
		TPatientExportTemplateInfo template = templateDao.getPatientExportTemplateById(req.getExportTemplateId());
		if(template==null)
			throw new EmptyObjectExcption("template is null  templateId:"+req.getExportTemplateId());
		String[] heads = null;
		String[] columns = null;
		heads = template.getHeads().split(",");
		columns = template.getFields().split(",");
		//对模版顺序进行判断
		if(StringUtils.isNotEmpty(template.getExportSort())){
			//对表头和列进行排序
			String[] sorts = template.getExportSort().split(",");
			String[] fheads = new String[sorts.length];
			String[] fcolumns = new String[sorts.length];
			for(int i=0;i<sorts.length;i++){
				Integer index = Integer.parseInt(sorts[i]);
				fheads[i] = heads[index];
				fcolumns[i] = columns[index];
			}
			heads = fheads;
			columns = fcolumns;
		}
		//判断是否有中间表查询 并 生成查询语句
		if(req.getSearchId()!=null){
			SearchInfo searchInfo = searchDao.querySearchById(req.getSearchId());
			/**
			 * 注意   u_patient 表定义别名为 t1
			 */
			
			// add by zhuguo
			String sql = "";
			if (searchInfo.getOperator() != null) {
				boolean result = organizationDoctorService.queryDoctorRoleById(searchInfo.getOperator(), null);
				if (result) {
					String powerSql = organizationDoctorService.getPatientSql(searchInfo.getOperator(), null);
					if (powerSql == null || "".equals(powerSql)) {
						LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
					} else {
						sql = " JOIN (" + powerSql + ") a ON a.patientId = p.patientId";
					}
				}
			}
			// end
			
			//如果有查询语句 按照查询语句查询
			if(StringUtils.isNotEmpty(searchInfo.getSqlContent())){
				sql += " JOIN ("+ searchInfo.getSqlContent() + ") search ON search.patientId = p.patientId Group By p.PatientId";
			}else{// 否则按照中间表进行查询
				sql += " JOIN "+ searchInfo.getSearchTableName() + " search ON search.patientId = p.patientId AND "+searchInfo.getSearchColumn();
				if(req.getReqFlag()!=null&&req.getReqFlag()==1)
					sql+=" = 1";
				else
					sql+=" IS NOT NULL";
			} 
			// {0} 关联查询字段    {1}{2}缺省可扩展
			template.setSqlContent(template.getSqlContent()+ sql);
			/*if(!StringUtils.isBlank(searchInfo.getInterfaceName())&&searchInfo.getInterfaceName().equals("/user/similar/patient/list"))
				template.setSqlContent(template.getSqlContent()+" Order by m1.goalpatientid ");*/
		}
		return exportExcelFile(template.getSqlContent(),req.outFilePath,heads,columns,Constants.FOLLOW_TABLE_FILE_NAME);
	}
	//模拟分布式导出
		private String exportExcelFile(final String sql,String outFilePath,String[] heads,final String[] columns,String tableName){
			//查询获得总条数
			final List dataList = new ArrayList();
			//定义开关
			final Map<String,Object> switchMap = new HashMap<String,Object>();
			//创建文件
			File file = FileUtil.createFile(outFilePath,tableName,FileSuffixEnum.CSV.getValue());
			ExecutorService exec = Executors.newFixedThreadPool(3);
			PrintWriter writerT=null;
			try {
				//创建输出流
//				final PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
				final PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)),"GBK"));
				//解决输出乱码  为文件添加BOM 信息
				//writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));
				writerT = writer;
				//创建查询线程
				Runnable selectRun = new Runnable(){
	    			@Override
					public void run()
					{
	    				Integer i = 0;
	    				int maxNum = 30000;
	    				long startTime;
	    				while(true){
	    					LogUtil.log.debug("--------------select"+i+" start--------------");
	    					startTime = System.currentTimeMillis();//时间记录
	    					List list = followupPatientDao.queryPatientInfoBySql(sql+" LIMIT "+(i++*maxNum)+","+maxNum);
	    					LogUtil.log.debug("--------------select end time:"+(System.currentTimeMillis()-startTime)+" ms--------------");
	    					//查不到数据结束
	    					if(list==null||list.size()==0){
	    						switchMap.put("select",true);
	    						break;
	    					}
	    					dataList.add(list);
	    					try {
								Thread.sleep(500l);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    				}
					}
				};
				exec.execute(selectRun);
				//先进行首行写入
				int length = heads.length;
				int len=length-1;
				for(int i = 0;i < length;i++) {
					writer.print(heads[i] == null ? "" : heads[i].toString().replace("\"", "\"\""));
					if(i < len) {
						writer.print(",");
					}
				}
				writer.println("");
				writer.flush();
				//创建写入线程
				Runnable writeRun = new Runnable(){
	    			@Override
					public void run()
					{
	    				//全局取值
	    				LinkedHashMap<String, Object> map = null;
	    				long startTime = 0l;
	    				//循环调用
	    				while(true){
	    					if(dataList.size()>0){
		    					List rows = (List) dataList.get(0);
		    					if(rows!=null){
		    						LogUtil.log.debug("------write start----------");
		    						startTime = System.currentTimeMillis();
		    						int size = rows.size();
									for (Object row : rows) { //循环行
										map = (LinkedHashMap<String, Object>) row;
										//循环列
										int length = columns.length;
										int len=length-1;
										for(int i = 0;i < length;i++) {
											Object col = map.get(columns[i]);
											writer.print((col == null || col.equals("NULL")) ? "" : col.toString().replace("\"", "\"\"").replace(",", ";").replaceAll("\r|\n|\t", "")+"\t");
											if(i<len) {
												writer.print(",");
											}
										}
										writer.print("\r\n");
										writer.flush();
									}
			    					rows.clear();
			    					dataList.remove(0);
			    					LogUtil.log.debug("---------write over----size:"+size+"------times:"+(System.currentTimeMillis()-startTime)+"----------");
		    					}
	    					}else if(switchMap.get("select")!=null){
	    						switchMap.put("write", true);
	    						writer.close();
	    						break;
	    					}
	    					try {
								Thread.sleep(500l);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
	    				}
					}
				};
				exec.execute(writeRun);
				//循环等待查询/写入完成
				while(switchMap.get("write")==null){
					//等待1s
	        		Thread.sleep(1*1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
				file.delete();
				exec.shutdown();
				return null;
			}finally {
				writerT.close();
			}
			return Constants.EXCEL_EXPORT+"/"+file.getName().substring(0, file.getName().indexOf("."))+"/C";
		}

		@Override
		public Integer getFollowupTableTotal(PatientExportReq req) {
			//判断是否有中间表查询 并 生成查询语句
			Integer total=0;
			if(req.getSearchId()!=null){
				SearchInfo searchInfo = searchDao.querySearchById(req.getSearchId());
				/**
				 * 注意   u_patient 表定义别名为 t1
				 */
				
				// add by zhuguo
				String sql = "";
				if (searchInfo.getOperator() != null) {
					boolean result = organizationDoctorService.queryDoctorRoleById(searchInfo.getOperator(), null);
					if (result) {
						String powerSql = organizationDoctorService.getPatientSql(searchInfo.getOperator(), null);
						if (powerSql == null || "".equals(powerSql)) {
							LogUtil.log.info("查询权限控制sql时，结果值【powerSql】是null。");
						} else {
							sql = " JOIN (" + powerSql + ") a ON a.patientId = p.patientId";
						}
					}
				}
				// end
				
				//如果有查询语句 按照查询语句查询
				if(StringUtils.isNotEmpty(searchInfo.getSqlContent())){
					sql += " JOIN ("+ searchInfo.getSqlContent() + ") search ON search.patientId = p.patientId AND p.outPatientFlag = 2 AND p.patientType = 1 AND p.mergeFlag != 2";
				}else{// 否则按照中间表进行查询
					sql += " JOIN "+ searchInfo.getSearchTableName() + " search ON search.patientId = p.patientId AND "+searchInfo.getSearchColumn();
					if(req.getReqFlag()!=null&&req.getReqFlag()==1)
						sql+=" = 1";
					else
						sql+=" IS NOT NULL";
				} 
				total = followupPatientDao.getfollowupTabTotalBySql(sql);
			}
			return total;
		}
		
		
		@Override
		public HashMap<String,Object> dealBatchQueryDetailInfo(TwiceSearchReq twiceSearchReq) throws EmptyParamExcption {
			TwiceSearchReq localReq = twiceSearchReq;
			Integer searchId = localReq.getSearchId();
			Integer clickType =localReq.getClickType();
			//1、根据searchId获取查询条件
			SearchInfo search = searchDao.querySearchById(searchId);
			if(search == null) {
				throw new EmptyParamExcption("searchId 为空");
			}
			twiceSearchReq = null;
			String req = search.getReq();
			Map<String,Object> paramsMap = JSON.parseObject(req);
			Object patientNoObj = paramsMap.get("originalBatchPatientNo");
			if(patientNoObj==null)throw new EmptyParamExcption("originalBatchPatientNo 为空");
			String patientNoStr = patientNoObj.toString();
			//2、查的被合并的病案号集合
			List<HashMap<String,String>> mergePatientNos = followupPatientDao.getMergePatientNos(paramsMap);
			String[] allPatientNos = patientNoStr.split(",");
			if(allPatientNos==null||allPatientNos[0]==null)throw new EmptyParamExcption("originalBatchPatientNo 为空");
			//3、算出重复患者及重复次数
			List<String> tempList = new ArrayList<String>();
			//3.1、repeatMap的value存patientNo出现的次数
			HashMap<String,Integer> repeatMap = new HashMap<String, Integer>();
			String tempStr = "";
			for (int i = 0; i < allPatientNos.length; i++) {
				tempStr=allPatientNos[i]==null?"":allPatientNos[i].replace("'","");
				if(tempList.contains(tempStr)){
					if(repeatMap.containsKey(tempStr)){
						repeatMap.put(tempStr, repeatMap.get(tempStr)+1);
					}else{
						repeatMap.put(tempStr, 2);
					}
				}else{
					//3.2、此时tempList中存的是所有病案号去重后的集合（包含合并的）
					tempList.add(tempStr);
				}
			}
			//4、算的无结果病案号的集合
			paramsMap.put("operator", search.getOperator());
			RConfDataPrivilege rConfDataPrivilege = authorizationService.findDataPrivilegeByDoctor(search.getOperator());
			if(rConfDataPrivilege != null) {
				paramsMap.put("dataId", rConfDataPrivilege.getDataId());
			}else {
				ConfGlobal conf = confGlobalDao.queryConfGlobal();
				if(conf != null) {
					paramsMap.put("deployLocation", conf.getDeployLocation());
				}
			}
			paramsMap.put("clickType", clickType);
			paramsMap.put("isHadRecordFlag", 1);
			//获取有结果的病案号列表
			List<String> hadRecordlist = followupPatientDao.getHadRecordPatientNos(paramsMap);
			Integer autoPatientNoPaddingDigits = 0;
			ConfGlobal conf = globalConfigInfoDao.queryConfGlobal();
			if(conf != null) {
				Integer autoPatientNoPaddingFlag = conf.getAutoPatientNoPaddingFlag();
				if(autoPatientNoPaddingFlag != null && autoPatientNoPaddingFlag == 1) {
					autoPatientNoPaddingDigits = conf.getAutoPatientNoPaddingDigits();
				}
			}
			for (int i = 0; i < tempList.size(); i++) {
				String tmpPatientNo = PatientNoUtil.loadPatientNo(tempList.get(i), autoPatientNoPaddingDigits);
				if(hadRecordlist.contains(tempList.get(i))||hadRecordlist.contains(tmpPatientNo)){
					tempList.remove(i);
					--i;
				}
			}
			//5、将结果放入返回的map
			HashMap<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put("patientNoTotal",allPatientNos==null?0:allPatientNos.length);
			resultMap.put("repeatTotal",repeatMap==null?0:repeatMap.size());
			resultMap.put("noRecordTotal",tempList==null?0:tempList.size());
			resultMap.put("mergeTotal",mergePatientNos==null?0:mergePatientNos.size());
			resultMap.put("repeatList",repeatMap);
			resultMap.put("noRecordList",tempList);
			resultMap.put("mergeList",mergePatientNos);
			return resultMap;
		}

		/**
		 * 修改患者的确诊时间和状态
		 * @author zhuguo
		 * @date 2017-8-8 17:20:09
		 */
		@Override
	public int patientConfirmedDateModify(PatientConfirmedDateReq req) {
		// 修改确诊时间和状态
		int result = followupPatientDao.patientConfirmedDateModify(req);

		if (result > 0) {

			// 根据操作者id查询操作者姓名
			PatientConfirmedDateReq patient = followupPatientDao.queryOperatorNameByOperatorId(req);

			// 拼接内容描述
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			sb.append("'updateDate':'" + req.getUpdateDate() + "',");
			sb.append("'operatorId':'" + req.getOperatorId() + "',");
			sb.append("'operatorName':'" + patient.getOperatorName() + "',");
			sb.append("'oldConfirmedDate':'" + req.getOldConfirmedDate() + "',");
			sb.append("'confirmedDateSource':'" + req.getConfirmedDateSource() + "',");
			sb.append("'confirmedDate':'" + req.getConfirmedDate() + "'");
			sb.append("}");

			OperationHistory qHistory = new OperationHistory();
			qHistory.setDescription(sb.toString());
			qHistory.setOperatorId(req.getOperatorId());

			// 写入日志
			result += followupPatientDao.insertOperationHistory(qHistory);
		}
		return result;
	}
}
