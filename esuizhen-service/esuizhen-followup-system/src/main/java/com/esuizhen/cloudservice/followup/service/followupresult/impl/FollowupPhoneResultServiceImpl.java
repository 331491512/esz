package com.esuizhen.cloudservice.followup.service.followupresult.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.followup.bean.TFollowupPhoneResultSearchInfo;
import com.esuizhen.cloudservice.followup.common.DataAccessFilter;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupPhoneResultDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupResultWayDao;
import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupTaskPatientDao;
import com.esuizhen.cloudservice.followup.dao.meta.FollowupMetaInfoDao;
import com.esuizhen.cloudservice.followup.dao.meta.PhoneHomeMetaInfoDao;
import com.esuizhen.cloudservice.followup.dao.user.PatientDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.FollowupPhonePatientPageTurnQueryReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallStatusInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupTaskPatient;
import com.esuizhen.cloudservice.followup.model.followupresult.TPatientContactInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TTreatmentInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupCallReqService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupPhoneResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.util.MyHttpUtil;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
public class FollowupPhoneResultServiceImpl implements FollowupPhoneResultService {

	@Autowired
	private FollowupPhoneResultDao followupPhoneResultDao;

	@Autowired
	private FollowupResultWayDao followupResultWayDao;

	@Autowired
	private FollowupTaskPatientDao followupTaskPatientDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private PhoneHomeMetaInfoDao phoneHomeMetaInfoDao;

	@Autowired
	private FollowupMetaInfoDao followupMetaInfoDao;

	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;

	@Autowired
	private FollowupResultService followupResultService;

	@Autowired
	private FollowupCallReqService followupCallReqService;

	@Autowired
	private MessageSource messageSource;

	private Locale locale = Locale.getDefault();

	@Value("${local.url}")
	private String localUrl;

	@Value("${smsFollowupTemplateMessageSend}")
	private String smsFollowupTemplateMessageSendUrl;

	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	
	private void setTreatmentSchemeIdArr(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo) {
		if (com.esuizhen.cloudservice.followup.util.UtilValidate.isNotEmpty(followupPhoneResultSearchInfo)) {
			if (followupPhoneResultSearchInfo.getTreatmentSchemeIds() != null) {
				followupPhoneResultSearchInfo.setTreatmentSchemeIdArr(followupPhoneResultSearchInfo.getTreatmentSchemeIds().split(","));
			}
		}
	}
	
	@Override
	public Page<TFollowupResultDetailInfo> queryFollowupPhoneResult(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo) {
		setTreatmentSchemeIdArr(followupPhoneResultSearchInfo);
		// 数据筛选
		followupPhoneResultSearchInfo.setOperator(DataAccessFilter.getOperator(followupPhoneResultSearchInfo.getUserRole(), followupPhoneResultSearchInfo.getOperator()));
		String sql = organizationDoctorService.getDoctorIdSql(followupPhoneResultSearchInfo.getOperator(), null);
		followupPhoneResultSearchInfo.setSql(sql);
		PageHelper.startPage(followupPhoneResultSearchInfo.getPage() + 1, followupPhoneResultSearchInfo.getNum());
		List<TFollowupResultDetailInfo> list = followupPhoneResultDao.queryFollowupPhoneResult(followupPhoneResultSearchInfo);

		Page myPage = PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultDetailInfo>) list);
		List<TFollowupResultDetailInfo> dataList = myPage.getDataList();
		if (UtilValidate.isNotEmpty(dataList)) {
			List<TFollowupResultDetailInfo> resultList = new ArrayList<TFollowupResultDetailInfo>();
			for (TFollowupResultDetailInfo data : dataList) {
				data.setTreatmentList(this.queryTreatmentNameByPatientId(data.getPatientId()));
				resultList.add(data);
			}
			myPage.setDataList(resultList);
		}

		return myPage;
	}

	@Override
	public List<TFollowupResultValueInfo> statisFollowupPhoneResult(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo) {
		setTreatmentSchemeIdArr(followupPhoneResultSearchInfo);
		// 数据筛选
		followupPhoneResultSearchInfo.setOperator(DataAccessFilter.getOperator(followupPhoneResultSearchInfo.getUserRole(), followupPhoneResultSearchInfo.getOperator()));
		return this.followupPhoneResultDao.statisFollowupPhoneResult(followupPhoneResultSearchInfo);
	}

	@Override
	public Long statisFollowupPhoneResultTotal(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo) {
		setTreatmentSchemeIdArr(followupPhoneResultSearchInfo);
		// 数据筛选
		followupPhoneResultSearchInfo.setOperator(DataAccessFilter.getOperator(followupPhoneResultSearchInfo.getUserRole(), followupPhoneResultSearchInfo.getOperator()));
		return this.followupPhoneResultDao.statisFollowupPhoneResultTotal(followupPhoneResultSearchInfo);
	}

	@Override
	public Integer statisFollowupOperatorTotal(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo) {
		setTreatmentSchemeIdArr(followupPhoneResultSearchInfo);
		return this.followupPhoneResultDao.statisFollowupOperatorTotal(followupPhoneResultSearchInfo);
	}

	@Override
	public TFollowupResultDetailInfo queryFollowupPhonePatientPageTurn(FollowupPhonePatientPageTurnQueryReq followupPhonePatientPageTurnQueryReq) {
		// 随访结果详细信息
		TFollowupResultDetailInfo followupResultDetailInfo = new TFollowupResultDetailInfo();
		// 随访分配任务患者信息
		TFollowupTaskPatient followupTaskPatient = null;
		String followupTaskId = followupPhonePatientPageTurnQueryReq.getFollowupTaskId();
		String followupAssignId = followupPhonePatientPageTurnQueryReq.getFollowupAssignId();
		Long patientId = followupPhonePatientPageTurnQueryReq.getPatientId();
		Integer userRole = followupPhonePatientPageTurnQueryReq.getUserRole();
		Integer pageTurn = followupPhonePatientPageTurnQueryReq.getPageTurn();
		// 是否翻页
		if (UtilValidate.isNotEmpty(pageTurn)) {
			followupTaskPatient = this.pageTurn(followupPhonePatientPageTurnQueryReq);
		} else {
			Map<String, Object> searchInfo = new HashMap<String, Object>();
			searchInfo.put("followupTaskId", followupTaskId);
			searchInfo.put("followupAssignId", followupAssignId);
			searchInfo.put("patientId", patientId);
			followupTaskPatient = followupPhoneResultDao.queryFollowupTaskPatient(searchInfo);
		}
		if (UtilValidate.isEmpty(followupTaskPatient)) {
			return null;
		}

		// 查询随访结果参数
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("followupTaskId", followupTaskId);
//		searchParams.put("followupAssignId", followupAssignId);//2017-07-13注掉该语句，通过followupTaskId和patientId即能确定唯一随访结果
		searchParams.put("patientId", patientId);
		if (UtilValidate.isEmpty(patientId)) {
			searchParams.put("patientId", followupTaskPatient.getPatientId());
		}

		// 查询随访结果
		List<TFollowupResultDetailInfo> followupResultDetailList = followupResultWayDao.queryFollowupResult(searchParams);
		if (UtilValidate.isNotEmpty(followupResultDetailList)) {
			followupResultDetailInfo = followupResultDetailList.get(0);
		} else {
			// 查询随访暂存结果
			followupResultDetailList = followupResultWayDao.queryFollowupResultBuff(searchParams);
			if (UtilValidate.isNotEmpty(followupResultDetailList)) {
				followupResultDetailInfo = followupResultDetailList.get(0);
				followupResultDetailInfo.setFollowupResultState(1);// 暂存状态
			}
		}
		List<TPatientContactInfo> patientContactList = patientDao.getPatientContactList(patientId);
		followupResultDetailInfo.setFollowupTaskId(followupTaskId);
		followupResultDetailInfo.setFollowupAssignId(followupAssignId);
		followupResultDetailInfo.setPatientId(patientId);
		followupResultDetailInfo.setOperator(followupTaskPatient.getOperator());
		followupResultDetailInfo.setPatient(followupTaskPatient.getPatient());
		followupResultDetailInfo.setPatientContactList(processPatientContactPhoneHome(patientContactList));

		// 随访全局配置
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		// 如果云端则身份证加密
		if (2 == globalConfig.getDeployLocation()) {
			if (UtilValidate.isNotEmpty(followupResultDetailInfo.getPatient()) && UtilValidate.isNotEmpty(followupResultDetailInfo.getPatient().getIdentification())) {
				String ident = followupResultDetailInfo.getPatient().getIdentification();
				followupResultDetailInfo.getPatient().setIdentification(ident.substring(0, ident.length() - 4) + "****");
			}
		}
		return followupResultDetailInfo;
	}

	@Override
	@Transactional
	public void saveFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo) {
		// 暂存只插入不更新
		followupResultDetailInfo.setSyncFlag(0);
		followupResultDetailInfo.setSourceFlag(1);// 数据来源标识B端填写
		if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime())) {
			followupResultDetailInfo.setFollowupTime(new Date());
		}
		followupResultService.insertFollowupResultBuff(followupResultDetailInfo);

		// add by fanpanwei
		TFollowupTaskPatient fTPatientInfo = followupTaskPatientDao.queryFollowupTaskByPatientId(followupResultDetailInfo.getFollowupTaskId(),
				followupResultDetailInfo.getFollowupAssignId(), followupResultDetailInfo.getPatientId());
		if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupResultId()) && (fTPatientInfo == null || 2 != fTPatientInfo.getState())) {
			// 更新随访结果患者表状态
			TFollowupTaskPatient followupTaskPatient = new TFollowupTaskPatient();
			followupTaskPatient.setFollowupTaskId(followupResultDetailInfo.getFollowupTaskId());
			followupTaskPatient.setFollowupAssignId(followupResultDetailInfo.getFollowupAssignId());
			followupTaskPatient.setPatientId(followupResultDetailInfo.getPatientId());
			followupTaskPatient.setState(1);// 暂存
			followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);
		}

		// 更新随访电话下发信息
		TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo = new TFollowupPhoneCallStatusInfo();
		followupPhoneCallStatusInfo.setFollowupTaskId(followupResultDetailInfo.getFollowupTaskId());
		followupPhoneCallStatusInfo.setFollowupAssignId(followupResultDetailInfo.getFollowupAssignId());
		followupPhoneCallStatusInfo.setPatientId(followupResultDetailInfo.getPatientId());
		followupPhoneCallStatusInfo.setResultProcessState(2);
		followupPhoneCallStatusInfo.setFollowupResultBuffId(followupResultDetailInfo.getFollowupResultBuffId());
		this.followupCallReqService.updateFollowupCallReq(followupPhoneCallStatusInfo);

		// 如果电话随访结果为无效时，将该状态保存
		TPatientContactInfo patientContactInfo = new TPatientContactInfo();
		patientContactInfo.setId(followupResultDetailInfo.getPatientFamilyId());
		
		switch (followupResultDetailInfo.getFollowupResultValue()) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			// 获取患者id和家庭电话-add by zhuguo
			TPatientContactInfo tpInfo = patientDao.findPatientInfoById(patientContactInfo);
			
			// 根据患者id和家庭电话修改电话状态-add by zhuguo
			patientDao.updatePatientFamilyPhoneStatusToOther(tpInfo);
			break;
		case 7:
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
			// 保存正式结果的时候，才修改手机状态
			if (null != followupResultDetailInfo.getFollowupResultState()) {
				if (2 == followupResultDetailInfo.getFollowupResultState()) {
					patientContactInfo.setIsValid(1);
					patientContactInfo.setPhoneStatus(followupResultDetailInfo.getFollowupResultValue());
					patientDao.updatePatientContactInfo(patientContactInfo);
				}
			}
			
			// 获取患者id和家庭电话-add by zhuguo
			TPatientContactInfo tpInfo0 = patientDao.findPatientInfoById(patientContactInfo);
			
			// 根据患者id和家庭电话修改电话状态-add by zhuguo
			patientDao.updatePatientFamilyPhoneStatus(tpInfo0);
			break;
		case 8:
		case 9:
			// 保存正式结果的时候，才修改手机状态
			if (null != followupResultDetailInfo.getFollowupResultState()) {
				if (2 == followupResultDetailInfo.getFollowupResultState()) {
					patientContactInfo.setIsValid(0);
					patientContactInfo.setPhoneStatus(followupResultDetailInfo.getFollowupResultValue());
					patientDao.updatePatientContactInfo(patientContactInfo);
				}
			}
			
			// 获取患者id和家庭电话-add by zhuguo
			TPatientContactInfo tpInfo1 = patientDao.findPatientInfoById(patientContactInfo);

			// 根据患者id和家庭电话修改电话状态-add by zhuguo
			patientDao.updatePatientFamilyPhoneStatus(tpInfo1);
			break;
		default:
			FollowupResultValue followupResultValue = followupMetaInfoDao.getMetaInfoFollowupResultValueById(followupResultDetailInfo.getFollowupResultValue());
			if (followupResultValue.getType() == 1) {// 有效结果
				patientContactInfo.setIsValid(1);
				patientContactInfo.setPhoneStatus(null);
				patientDao.updatePatientFamilyStatusIsValueOrNull(patientContactInfo);
				// 获取患者id和家庭电话-add by zhuguo
				TPatientContactInfo tpInfo2 = patientDao.findPatientInfoById(patientContactInfo);
				
				// 根据患者id和家庭电话修改电话状态-add by zhuguo
				patientDao.updatePatientFamilyPhoneStatus(tpInfo2);
			}
		}
	}

	@Override
	@Transactional
	public void saveFollowupPhoneResultTemp(TFollowupResultDetailInfo followupResultDetailInfo) {
		String followupResultId = followupResultDetailInfo.getFollowupResultId();
		if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime())) {
			followupResultDetailInfo.setFollowupTime(new Date());
		}

		if (UtilValidate.isEmpty(followupResultId)) {
			// 保存随访结果
			followupResultDetailInfo.setSyncFlag(0);
			followupResultDetailInfo.setFollowupResultState(1);// 暂存状态
			if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime())) {
				followupResultDetailInfo.setFollowupTime(new Date());
			}
			followupResultDetailInfo.setSourceFlag(1);// 数据来源标识B端填写
			TFollowupGlobalConfigInfo globalConfigInfo = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			if (globalConfigInfo != null) {
				if (globalConfigInfo.getDeployLocation() != null) {
					if (globalConfigInfo.getDeployLocation() == 2) {
						followupResultDetailInfo.setSourceFlag(7);// 数据来源标识医生工作站
					}
				}
			}
			followupResultService.insertFollowupResult(followupResultDetailInfo);

			// 保存随访缓存结果
			saveFollowupResultBuff(followupResultDetailInfo);
			// 更新随访结果患者表状态
			TFollowupTaskPatient followupTaskPatient = new TFollowupTaskPatient();
			followupTaskPatient.setFollowupTaskId(followupResultDetailInfo.getFollowupTaskId());
			followupTaskPatient.setFollowupAssignId(followupResultDetailInfo.getFollowupAssignId());
			followupTaskPatient.setPatientId(followupResultDetailInfo.getPatientId());
			followupTaskPatient.setState(1);// 暂存
			followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);
		} else {
			// 查询随访结果参数
			Map<String, Object> searchParams = new HashMap<String, Object>();
			searchParams.put("followupResultId", followupResultId);
			searchParams.put("followupResultState", 1);// 暂存
			// 查询随访结果
			List<TFollowupResultDetailInfo> followupResultDetailList = followupResultWayDao.queryFollowupResult(searchParams);
			if (UtilValidate.isNotEmpty(followupResultDetailList)) {
				followupResultDetailInfo.setFollowupResultState(1);// 暂存
				followupResultService.updateFollowupResult(followupResultDetailInfo);
				;

				// 保存随访缓存结果
				saveFollowupResultBuff(followupResultDetailInfo);
			} else {
				// 只暂存，不与resultId关联
				followupResultDetailInfo.setFollowupResultId(null);
				// 保存随访缓存结果
				saveFollowupResultBuff(followupResultDetailInfo);
			}
			// 20170418注释：在保存暂存时并不能将状态置为2.
			/*
			 * // 查询随访结果
			 * searchParams.put
			 * ("followupResultState",
			 * 2);//正式
			 * followupResultDetailList
			 * = followupResultWayDao.
			 * queryFollowupResult
			 * (searchParams); if
			 * (UtilValidate.isNotEmpty(
			 * followupResultDetailList
			 * )) { // 更新随访结果患者表状态
			 * followupTaskPatient
			 * .setState(2);// 正式
			 * followupTaskPatientDao
			 * .updateFollowupTaskPatient
			 * (followupTaskPatient); }
			 */
		}
	}

	@Override
	@Transactional
	public void saveFollowupPhone(TFollowupResultDetailInfo followupResultDetailInfo) {
		Long patientId = followupResultDetailInfo.getPatientId();
		String followupTaskId = followupResultDetailInfo.getFollowupTaskId();
		String followupAssignId = followupResultDetailInfo.getFollowupAssignId();

		// 更新随访结果患者表状态
		TFollowupTaskPatient followupTaskPatient = new TFollowupTaskPatient();
		followupTaskPatient.setFollowupTaskId(followupTaskId);
		followupTaskPatient.setFollowupAssignId(followupAssignId);
		followupTaskPatient.setPatientId(patientId);
		followupTaskPatient.setState(2);// 已完成
		followupTaskPatientDao.updateFollowupTaskPatient(followupTaskPatient);

		// 更新随访电话下发信息
		TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo = new TFollowupPhoneCallStatusInfo();
		followupPhoneCallStatusInfo.setFollowupTaskId(followupTaskId);
		followupPhoneCallStatusInfo.setFollowupAssignId(followupAssignId);
		followupPhoneCallStatusInfo.setPatientId(patientId);
		followupPhoneCallStatusInfo.setResultProcessState(2);
		followupPhoneCallStatusInfo.setFollowupResultId(followupResultDetailInfo.getFollowupResultId());
		this.followupCallReqService.updateFollowupCallReq(followupPhoneCallStatusInfo);

		// 保存随访结果
		followupResultDetailInfo.setSyncFlag(0);
		followupResultDetailInfo.setFollowupResultState(2);// 正式结果
		if (UtilValidate.isEmpty(followupResultDetailInfo.getFollowupTime())) {
			followupResultDetailInfo.setFollowupTime(new Date());
		}
		followupResultDetailInfo.setSourceFlag(1);// 数据来源标识B端填写
		TFollowupGlobalConfigInfo globalConfigInfo = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		if (globalConfigInfo != null) {
			if (globalConfigInfo.getDeployLocation() != null) {
				if (globalConfigInfo.getDeployLocation() == 2) {
					followupResultDetailInfo.setSourceFlag(7);// 数据来源标识医生工作站
				}
			}
		}
		if (UtilValidate.isNotEmpty(followupResultDetailInfo.getFollowupResultId())) {
			// followupResultDetailInfo.setSourceFlag(1);//数据来源标识B端填写
			followupResultService.updateFollowupResult(followupResultDetailInfo);
		} else {
			// followupResultDetailInfo.setSourceFlag(1);//数据来源标识B端填写
			followupResultService.insertFollowupResult(followupResultDetailInfo);
		}

		// 保存随访缓存结果
		saveFollowupResultBuff(followupResultDetailInfo);

		// 根据规则发送激活短信
		try {
			if (1 == globalConfigInfo.getFollowupActivateSmsFlag() && followupResultDetailInfo.getFollowupResultPhone().startsWith("1")) {
				this.sendActivateSmsByFollowupResult(patientId, followupResultDetailInfo.getFollowupResultPhone(), followupResultDetailInfo.getFollowupResultValue());
			}
		} catch (Exception e) {
			LogUtil.log.error("发送激活短信失败" + e.getMessage());
		}
	}

	/**
	 * 循环翻页
	 */
	public TFollowupTaskPatient pageTurn(FollowupPhonePatientPageTurnQueryReq followupPhonePatientPageTurnQueryReq) {
		// 随访全局配置
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		Integer followupResultFlag = globalConfig.getFollowupResultFlag();
		Integer validResultControlFlag = globalConfig.getValidResultControlFlag();
		Integer pageTurn = followupPhonePatientPageTurnQueryReq.getPageTurn();
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("followupResultFlag", followupResultFlag);
		searchInfo.put("validResultControlFlag", validResultControlFlag);
		searchInfo.put("followupTaskId", followupPhonePatientPageTurnQueryReq.getFollowupTaskId());
		searchInfo.put("followupAssignId", followupPhonePatientPageTurnQueryReq.getFollowupAssignId());
		searchInfo.put("patientId", followupPhonePatientPageTurnQueryReq.getPatientId());
		searchInfo.put("pageTurn", pageTurn);
		searchInfo.put("userRole", followupPhonePatientPageTurnQueryReq.getUserRole());

		// add 2017.7.3
		searchInfo.put("patientNo", followupPhonePatientPageTurnQueryReq.getPatientNo());
		searchInfo.put("patientTrueName", followupPhonePatientPageTurnQueryReq.getPatientTrueName());
		searchInfo.put("sourceDiagnosis", followupPhonePatientPageTurnQueryReq.getSourceDiagnosis());
		searchInfo.put("phone", followupPhonePatientPageTurnQueryReq.getPhone());
		searchInfo.put("followupResultValue", followupPhonePatientPageTurnQueryReq.getFollowupResultValue());
		searchInfo.put("state", followupPhonePatientPageTurnQueryReq.getState());

		TFollowupTaskPatient followupTaskPatient = followupPhoneResultDao.queryFollowupTaskPatient(searchInfo);
		if (UtilValidate.isEmpty(followupTaskPatient)) {
			if (pageTurn == 1) {
				followupTaskPatient = followupPhoneResultDao.queryLastFollowupTaskPatient(searchInfo);
			} else if (pageTurn == 2) {
				followupTaskPatient = followupPhoneResultDao.queryFirstFollowupTaskPatient(searchInfo);
			}
		}
		return followupTaskPatient;
	}

	public List<TTreatmentInfo> queryEciTreatmentNoteByPatientId(Long patientId) {
		return this.patientDao.queryEciTreatmentNoteByPatientId(patientId);
	}

	public List<TTreatmentInfo> queryTreatmentNameByPatientId(Long patientId) {
		return this.patientDao.getTreatmentNameByPatientId(patientId);
	}

	/**
	 * 根据手机号获取所在区域
	 * 
	 * @param patientContactList
	 * @return
	 */
	public List<TPatientContactInfo> processPatientContactPhoneHome(List<TPatientContactInfo> patientContactList) {
		List<TPatientContactInfo> result = null;
		Map<String, Object> phoneHome = null;
		String familyPhone = null;
		String prefix = null;
		if (UtilValidate.isNotEmpty(patientContactList)) {
			result = new ArrayList<TPatientContactInfo>();
			for (TPatientContactInfo patientContactInfo : patientContactList) {
				try {
					familyPhone = patientContactInfo.getFamilyPhone();
					if (UtilValidate.isEmpty(familyPhone)) {
						continue;
					}
					prefix = familyPhone.substring(0, 1);
					String addr = null;
					if ("0".equals(prefix)) {
						int i = familyPhone.indexOf("-");
						if (i < 0) {
							patientContactInfo.setAddress("未知");
						} else {
							prefix = familyPhone.substring(0, i);
							phoneHome = phoneHomeMetaInfoDao.queryPhoneHome(prefix, null);
							if (UtilValidate.isNotEmpty(phoneHome)) {
								addr = (String) phoneHome.get("province") + (String) phoneHome.get("city");
								patientContactInfo.setAddress(addr);
							}
						}
					} else if ("1".equals(prefix)) {
						prefix = familyPhone.substring(0, 7);
						phoneHome = phoneHomeMetaInfoDao.queryPhoneHome(null, prefix);
						if (UtilValidate.isNotEmpty(phoneHome)) {
							String province = (String) phoneHome.get("province");
							String city = (String) phoneHome.get("city");
							if (province.equals(city)) {
								addr = city;
							} else {
								addr = province + city;

							}
							patientContactInfo.setAddress(addr);
						}
					} else {
						addr = "本地";
						patientContactInfo.setAddress(addr);
					}
					result.add(patientContactInfo);
				} catch (Exception e) {
					LogUtil.log.error("患者patientId：" + patientContactInfo.getPatientId() + ",联系电话" + patientContactInfo.getFamilyPhone() + ",错误信息：" + e.getMessage());
				}
			}

		}
		return result;
	}

	public boolean sendActivateSmsByFollowupResult(Long patientId, String mobile, Integer followupResultValue) {
		boolean result = false;
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		String hospitalName = "易随诊";
		if (UtilValidate.isNotEmpty(globalConfig.getHospitalName())) {
			hospitalName = globalConfig.getHospitalName();
		}
		String content = messageSource.getMessage("followup.result.activate.sms", new Object[] { hospitalName }, locale);
		switch (followupResultValue) {// 判断随访结果是否为稳定、复发、转移
		case 1:
		case 2:
		case 3:
			Patient patient = patientDao.queryPatientByPrimaryKey(patientId);
			if (patient.getFollowupFlag() != 2) {// 不能为失访
				String url = localUrl + smsFollowupTemplateMessageSendUrl;
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("businessId", 1);
				paramMap.put("productId", 1);
				paramMap.put("mobiles", mobile.split(","));
				paramMap.put("content", content);

				TMsgResponse<Object> tMsgResponse = MyHttpUtil.postJson(url, paramMap);
				if (tMsgResponse.getRespCode() == 0) {
					result = true;
				}
			}
		}
		return result;
	}
}
