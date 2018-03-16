package com.esuizhen.cloudservice.research.service.impl.result;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.bean.PatientsAdvancedSearchReq;
import com.esuizhen.cloudservice.research.bean.PatientsInProjectSearchReq;
import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.bean.TCrfCourseInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.common.Const;
import com.esuizhen.cloudservice.research.dao.crf.CrfCourseDao;
import com.esuizhen.cloudservice.research.dao.crf.ProjectCrfTemplateDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.dao.pro.RCrftemplateProjectDao;
import com.esuizhen.cloudservice.research.dao.result.PatientDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectInvitationPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterPatientDao;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.model.result.TCrfResultBasicDemography;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectInvitationPatient;
import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterPatient;
import com.esuizhen.cloudservice.research.service.crf.CrfCourseService;
import com.esuizhen.cloudservice.research.service.result.PatientManageService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultBasicDemographyService;
import com.esuizhen.cloudservice.research.service.result.TCrfResultDiagnosisInfoService;
import com.esuizhen.cloudservice.research.service.result.TProjectSubcenterService;
import com.esuizhen.cloudservice.research.service.result.TRSubcenterPatientService;
import com.esuizhen.cloudservice.research.util.CrfCourseUtil;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.DisableExcption;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.TimeTooShortException;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.search.RetrievalParamentUtil;

@Service
public class PatientManageServiceImpl implements PatientManageService {
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectCrfTemplateDao projectCrfTemplateDao;
	@Autowired
	private CrfCourseDao crfCourseDao;
	@Autowired
	private TRSubcenterPatientDao rSubcenterPatientDao;
	@Autowired
	private TProjectInvitationPatientDao projectInvitationPatientDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	@Autowired
	private TCrfObservationSubjectElementDao crfObservationSubjectElementDao;
	@Autowired
	private RCrftemplateProjectDao rCrftemplateProjectDao;
	
	@Autowired
	private TRSubcenterPatientService rSubcenterPatientService;
	@Autowired
	private TCrfResultBasicDemographyService crfResultBasicDemographyService;
	@Autowired
	private TCrfResultDiagnosisInfoService crfResultDiagnosisInfoService;
	@Autowired
	private CrfCourseService crfCourseService;
	@Autowired
	private PushInnerService pushService;
	@Autowired
	private SmsInnerService smsInnerService;
	@Autowired
	private TProjectSubcenterService projectSubcenterService;

	@Value("${server.api.url.root}")
	private String urlRoot;
	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;

	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> searchInProjectPatients(PatientsInProjectSearchReq patientsInProjectSearchReq) throws ParseException {
		if (StringUtils.isEmpty(patientsInProjectSearchReq.getProjectId())){
			return null;
		}
		PageHelper.startPage(patientsInProjectSearchReq.getPage() + 1, patientsInProjectSearchReq.getNum());
		List<PatientSimpleInfo> patientSimpleInfos = this.projectInvitationPatientDao.searchInProjectPatients(patientsInProjectSearchReq);
		//处理患者应随访时间和逾期情况
		if (patientSimpleInfos != null && !patientSimpleInfos.isEmpty()) {
			Calendar calendar = Calendar.getInstance(), lastCalendar = Calendar.getInstance();
			Date currentDate = calendar.getTime();
			String pattern = "yyyy-MM-dd";
			RCrftemplateProject crftemplateProject = this.rCrftemplateProjectDao.findByProjectId(patientsInProjectSearchReq.getProjectId());
			for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
				//该患者在专题中为正常随访患者
				patientSimpleInfo.setProjectState(1);
				patientSimpleInfo.setFollowupState(1);
				String currentCrfCourseItemId = null;
				//当期随访阶段
				TCrfCourseDetailInfo currentCrfCourseDetailInfo = this.crfCourseService.getCurrentCourseDetailInfo(patientsInProjectSearchReq.getProjectId(), patientSimpleInfo.getPatientId());
				TCrfCourseInfo currentCrfCourseInfo = null;
				if (currentCrfCourseDetailInfo != null) {
					currentCrfCourseItemId = currentCrfCourseDetailInfo.getCrfCourseItemId();
					currentCrfCourseInfo = this.crfCourseDao.findByCrfCourseItemId(currentCrfCourseDetailInfo.getCrfCourseItemId());
				}
				//该患者在专题中随访最后阶段
				TCrfCourseDetailInfo lastTCrfCourseDetailInfo = this.crfCourseService.getLastTCrfCourseDetailInfo(patientsInProjectSearchReq.getProjectId(), patientSimpleInfo.getPatientId());
				if (currentCrfCourseDetailInfo != null) {
					//采集结果的个数
					int gatherFlag = this.crfResultMainInfoDao.gatherFlag(currentCrfCourseDetailInfo.getCrfCourseItemId(), patientSimpleInfo.getPatientId());
					int days = 0;
					List<TCrfCourseInfo> courseConfs = this.crfCourseDao.findProjectCourseItems(patientsInProjectSearchReq.getProjectId(), patientSimpleInfo.getPatientId(), currentCrfCourseItemId);
					if (gatherFlag > 0) {//已采集患者的数据
						/*
						if (null != currentCrfCourseDetailInfo && null != currentCrfCourseDetailInfo.getCrfObserveList() && !currentCrfCourseDetailInfo.getCrfObserveList().isEmpty()) {//未采集完成
							patientSimpleInfo.setFollowupDate(currentCrfCourseDetailInfo.getCrfCourseItemTime());
						} else if(StringUtils.isNotEmpty(currentCrfCourseItemId)) {//采集完成，应随访时间展示下一周期的随访时间；如果是最后一个随访周期，则应该是随访完成
						}
						*/
						//最后一个随访阶段
						if (currentCrfCourseItemId.equals(lastTCrfCourseDetailInfo.getCrfCourseItemId())) {
							days = this.crfCourseService.getFollowupDays(crftemplateProject.getCrfTemplateId(), currentCrfCourseItemId);
							currentCrfCourseDetailInfo = this.crfObservationSubjectElementDao.findFollowupTimeAxis(crftemplateProject.getProjectId(), currentCrfCourseItemId,
									currentCrfCourseItemId, patientSimpleInfo.getPatientId(), days, Const.COLLECTFLAG_NOT, null);
							//已采集完成
							if (currentCrfCourseDetailInfo == null) {
								patientSimpleInfo.setProjectState(0);//该患者在专题中结束
								courseConfs = null;
							}
						}else{
							//显示下一随访周期
							if (courseConfs != null && !courseConfs.isEmpty()) {
								TCrfCourseDetailInfo nextTCrfCourseDetailInfo = this.getNextTCrfCourseDetailInfo(courseConfs, crftemplateProject.getProjectId(),
										crftemplateProject.getCrfTemplateId(), patientSimpleInfo.getPatientId(), currentCrfCourseItemId);
								if (nextTCrfCourseDetailInfo != null) {
									patientSimpleInfo.setFollowupDate(nextTCrfCourseDetailInfo.getCrfCourseItemTime());
									continue;
								}
							}
						}
					} else {//未采集患者数据
						//随访频率不足三天
						if (currentCrfCourseInfo.getFollowupFrequency() < 3 && CrfCourseUtil.unitConversionDaies(currentCrfCourseInfo.getFollowupFrequencyUnit()) == 1) {
							//已不是当天
							if (currentDate.compareTo(currentCrfCourseDetailInfo.getFollowupDate()) > 0) {
								patientSimpleInfo.setFollowupState(0);
								
								//当期不是最后一个随访阶段,三天未采集，则为逾期，展示下一随访日期
								//最后一个随访阶段
								if (!currentCrfCourseItemId.equals(lastTCrfCourseDetailInfo.getCrfCourseItemId())) {
									//patientSimpleInfo.setFollowupOverdue(days);
									TCrfCourseDetailInfo nextTCrfCourseDetailInfo = this.getNextTCrfCourseDetailInfo(crftemplateProject.getProjectId(),
											crftemplateProject.getCrfTemplateId(), patientSimpleInfo.getPatientId(), currentCrfCourseItemId);
									if (nextTCrfCourseDetailInfo != null) {
										patientSimpleInfo.setFollowupDate(nextTCrfCourseDetailInfo.getCrfCourseItemTime());
									}
								}
							}else{
								patientSimpleInfo.setFollowupDate(currentCrfCourseDetailInfo.getFollowupDate());
							}
						} else {//随访频率大于三天时
							days = DateUtil.daysBetween(currentCrfCourseDetailInfo.getFollowupDate(), calendar.getTime());
							//未逾期三天
							patientSimpleInfo.setFollowupState(0);
							if (days < 4) {
								patientSimpleInfo.setFollowupOverdue(days);
							}else{
								//当期不是最后一个随访阶段,三天未采集，则为逾期，展示下一随访日期
								//最后一个随访阶段
								if (!currentCrfCourseItemId.equals(lastTCrfCourseDetailInfo.getCrfCourseItemId())) {
									patientSimpleInfo.setFollowupOverdue(days);
									TCrfCourseDetailInfo nextTCrfCourseDetailInfo = this.getNextTCrfCourseDetailInfo(crftemplateProject.getProjectId(),
											crftemplateProject.getCrfTemplateId(), patientSimpleInfo.getPatientId(), currentCrfCourseItemId);
									if (nextTCrfCourseDetailInfo != null) {
										patientSimpleInfo.setFollowupDate(nextTCrfCourseDetailInfo.getCrfCourseItemTime());
									}
								}
							}
						}
					}
				} else {
					//未获取到随访阶段
					patientSimpleInfo.setFollowupState(0);
				}
				Date endTime = lastTCrfCourseDetailInfo.getCrfCourseItemTime();
				endTime = DateUtil.stringToDate(DateUtil.getDateOfDay(endTime, pattern), pattern);
				if (currentCrfCourseItemId == null) {
					patientSimpleInfo.setProjectState(0);
				}else if (currentCrfCourseItemId.equals(lastTCrfCourseDetailInfo.getCrfCourseItemId())) {
					lastCalendar.setTime(endTime);
					lastCalendar.add(Calendar.DAY_OF_MONTH, 7);
					if (currentDate.compareTo(lastCalendar.getTime()) >= 0) {//已经逾期7天
						patientSimpleInfo.setProjectState(0);
					}else{//未逾期，是否采集完成
						int days = this.crfCourseService.getFollowupDays(crftemplateProject.getCrfTemplateId(), lastTCrfCourseDetailInfo.getCrfCourseItemId());
						TCrfCourseDetailInfo crfCourseDetailInfo = this.crfObservationSubjectElementDao.findFollowupTimeAxis(crftemplateProject.getProjectId(),
								lastTCrfCourseDetailInfo.getCrfCourseItemId(), lastTCrfCourseDetailInfo.getCrfCourseItemId(), patientSimpleInfo.getPatientId(), days, Const.COLLECTFLAG_NOT, null);
						if (crfCourseDetailInfo == null || crfCourseDetailInfo.getCrfObserveList() == null || crfCourseDetailInfo.getCrfObserveList().isEmpty()) {
							patientSimpleInfo.setProjectState(0);
						}else{
							patientSimpleInfo.setProjectState(1);
							patientSimpleInfo.setFollowupDate(crfCourseDetailInfo.getCrfCourseItemTime());
						}
					}
				}
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<PatientSimpleInfo>)patientSimpleInfos);
	}
	
	/**
	 * <p>Title:getNextTCrfCourseDetailInfo</p>
	 * <p>Description:获取下一随访周期</p>
	 * @author YYCHEN
	 * @date 2016年7月15日 上午10:12:16
	 * @param projectId
	 * @param crfTemplateId
	 * @param patientId
	 * @param currentCrfCourseItemId
	 * @return
	 */
	private TCrfCourseDetailInfo getNextTCrfCourseDetailInfo(String projectId, String crfTemplateId, Long patientId, String currentCrfCourseItemId){
		List<TCrfCourseInfo> courseConfs = this.crfCourseDao.findProjectCourseItems(projectId, patientId, currentCrfCourseItemId);//所有随访周期
		return this.getNextTCrfCourseDetailInfo(courseConfs, projectId, crfTemplateId, patientId, currentCrfCourseItemId);
	}
	private TCrfCourseDetailInfo getNextTCrfCourseDetailInfo(List<TCrfCourseInfo> courseConfs, String projectId, String crfTemplateId, Long patientId, String currentCrfCourseItemId){
		boolean currentFlag = false;
		for (int i = 0, size = courseConfs.size(); i < size; i++) {
			TCrfCourseInfo tCrfCourseInfo = courseConfs.get(i);
			List<TCrfCourseDetailInfo> crfCourseDetailInfos = tCrfCourseInfo.getCrfCourseItemList();//随访明细
			for (int j = 0, count = crfCourseDetailInfos.size(); j < count; j++) {
				TCrfCourseDetailInfo tCrfCourseDetailInfo = crfCourseDetailInfos.get(j);
				if (currentFlag) {
					int days = this.crfCourseService.getFollowupDays(crfTemplateId, tCrfCourseDetailInfo.getCrfCourseItemId());
					TCrfCourseDetailInfo crfCourseDetailInfo = this.crfObservationSubjectElementDao.findFollowupTimeAxis(projectId, tCrfCourseDetailInfo.getCrfCourseItemId(), currentCrfCourseItemId,
							patientId, days, Const.COLLECTFLAG_PROHIBIT, null);
					return crfCourseDetailInfo;//下一周期随访明细
				}
				if (currentCrfCourseItemId.equals(tCrfCourseDetailInfo.getCrfCourseItemId())) {
					currentFlag  = true;
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> searchUnselectedPatients(PatientsAdvancedSearchReq patientsAdvancedSearchReq) {
		if (StringUtils.isEmpty(patientsAdvancedSearchReq.getProjectId()) ||
				patientsAdvancedSearchReq.getDoctorId() == null) {
			return null;
		}
		patientsAdvancedSearchReq.setFollowupStartMark(this.projectCrfTemplateDao.findByProjectId(patientsAdvancedSearchReq.getProjectId()).getFollowupStartMark());
		
		PageHelper.startPage(patientsAdvancedSearchReq.getPage() + 1, patientsAdvancedSearchReq.getNum());
		String sqlStr = RetrievalParamentUtil.loadingParaments(patientsAdvancedSearchReq.getParaments());
		List<PatientSimpleInfo> patientSimpleInfos = this.patientDao.selectUnselectedPatients(patientsAdvancedSearchReq, sqlStr);
		return PageUtil.returnPage((com.github.pagehelper.Page<PatientSimpleInfo>) patientSimpleInfos);
	}

	@Transactional
	@Override
	public boolean addPendingPatientsToProject(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption, TimeTooShortException {
		List<PatientSimpleInfo> patientSimpleInfos = crfResultMainInfo.getCrfResult();
		if (patientSimpleInfos == null || patientSimpleInfos.isEmpty()) {
			return true;
		}
		if (StringUtils.isEmpty(crfResultMainInfo.getProjectId()) ||
				crfResultMainInfo.getDoctorId() == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(crfResultMainInfo.getProjectId());
		if (projectSimpleInfo == null) {
			throw new ObjectNotAvailableExcption("object not found!");
		}
		//如果专题患者入组截止时间已到，拒绝请求
		if (projectSimpleInfo.getInGroupEndDate() != null) {
			String pattern = "yyyy-MM-dd";
			Calendar calendar = Calendar.getInstance();
			Date inGroupEndDate = projectSimpleInfo.getInGroupEndDate(), currentDate = calendar.getTime();
			currentDate = DateUtil.stringToDate(DateUtil.getDateOfDay(currentDate, pattern), pattern);
			if (inGroupEndDate.compareTo(currentDate) < 0) {
				throw new TimeTooShortException("Patients in group time has been cut off!");
			}
		}
		//如果专题结束时间已到，拒绝请求
		if (projectSimpleInfo.getProjectEndTime() != null) {
			String pattern = "yyyy-MM-dd";
			Calendar calendar = Calendar.getInstance();
			Date projectEndTime = projectSimpleInfo.getProjectEndTime(), currentDate = calendar.getTime();
			//projectEndTime = DateUtil.stringToDate(DateUtil.getDateOfDay(projectEndTime, pattern + " HH:mm:ss") + " 23:59:59", pattern + " HH:mm:ss");
			currentDate = DateUtil.stringToDate(DateUtil.getDateOfDay(currentDate, pattern), pattern);
			if (projectEndTime.compareTo(currentDate) < 0) {
				throw new RejectRequestExcption("Special end time has arrived, can not add patients!");
			}
		}
		/*
		for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
			if (patientSimpleInfo.getPatientId() == null) {
				throw new ParameterCannotBeNullException("Parameter patientId cannot be empty!");
			}
		}
		*/
		TProjectSubcenter projectSubcenter = this.projectSubcenterService.getCreatorProjectSubCenter(crfResultMainInfo);
		TProjectInvitationPatient projectInvitationPatient = new TProjectInvitationPatient();
		if (projectSubcenter != null) {
			projectInvitationPatient.setSubcenterId(projectSubcenter.getSubcenterId());
		}
		crfResultMainInfo.setSubcenterId(projectInvitationPatient.getSubcenterId());
		projectInvitationPatient.setProjectId(crfResultMainInfo.getProjectId());
		projectInvitationPatient.setGroupId(crfResultMainInfo.getGroupId());
		projectInvitationPatient.setInviter(crfResultMainInfo.getDoctorId());
		//处理被邀请患者的状态
		switch (projectSimpleInfo.getIcfConfirmWay()) {
		case Constant.Research.ICFCONFIRMWAY_UNWANTED://无需确认
			/*
			//验证专题患者组是否已经满员
			if (crfResultMainInfo.getGroupId() != null) {
				TProjectGroupInfo projectGroupInfo = this.projectGroupDao.findByGroupId(crfResultMainInfo.getGroupId());
				if (projectGroupInfo != null && projectGroupInfo.getGroupNum() != null) {
					int count = this.rSubcenterPatientDao.findGroupCount(projectGroupInfo.getProjectId(), projectGroupInfo.getGroupId());
					if (count + patientSimpleInfos.size() > projectGroupInfo.getGroupNum()) {
						throw new DisableExcption("The number of patients in the group has reached the ceiling.");
					}
				}
			}else if(projectSimpleInfo.getPlanInGroupSum() != null){
				int count = this.rSubcenterPatientDao.findGroupCount(crfResultMainInfo.getProjectId(), null);
				if (count + patientSimpleInfos.size() > projectSimpleInfo.getPlanInGroupSum()) {
					throw new DisableExcption("The number of patients in the group has reached the ceiling.");
				}
			}
			*/
			projectInvitationPatient.setState(Constant.Research.PROJECTINVITATIONPATIENT_STATE_AGREE);
			//添加分中心和患者关系
			this.rSubcenterPatientService.addByBatch(crfResultMainInfo);
			//填充人口学信息
			this.crfResultBasicDemographyService.autoSupplement(crfResultMainInfo);
			//填充诊断信息
			this.crfResultDiagnosisInfoService.autoSupplement(crfResultMainInfo);
			break;
		case Constant.Research.ICFCONFIRMWAY_ONLINE://线上确认
		case Constant.Research.ICFCONFIRMWAY_NEGOTIABLE://面签确认
			projectInvitationPatient.setState(Constant.Research.PROJECTINVITATIONPATIENT_STATE_SMS_SENDING);
			break;
		}
		//更新专题状态（进行中）
		if (projectSimpleInfo.getState() != Const.PROJECT_STATE_CARRIEDOUT) {
			this.projectDao.updateProjectState(projectSimpleInfo.getProjectId(), Const.PROJECT_STATE_CARRIEDOUT);
			//如果专题有结束时间，启用定时，时间到将专题修改为结束状态
			if (projectSimpleInfo.getProjectEndTime() != null) {
				//this.projectService.timedUpdateProjectState(projectSimpleInfo);
			}
		}
		//批量保存专题与被邀请患者关系
		this.projectInvitationPatientDao.insertByBatch(projectInvitationPatient, patientSimpleInfos);
		if (crfResultMainInfo.getCommon() != null && StringUtils.isNotEmpty(crfResultMainInfo.getCommon().toString())) {
			List<String> mobiles = new ArrayList<String>();
			List<String> values = new ArrayList<String>();
			Integer state = null;
			for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
				//获取患者基本信息
				TCrfResultBasicDemography basicDemography = this.patientDao.findDemography(patientSimpleInfo.getPatientId());
				if (basicDemography == null) {
					continue;
				}
				
				String description = null;
				String url = null;
				switch (projectSimpleInfo.getIcfConfirmWay()) {
				case Constant.Research.ICFCONFIRMWAY_UNWANTED://无需确认
//					description = crfResultMainInfo.getCommon().toString().replace("{0}", basicDemography.getTrueName());
					break;
				case Constant.Research.ICFCONFIRMWAY_ONLINE://线上确认
				case Constant.Research.ICFCONFIRMWAY_NEGOTIABLE://面签确认
					url = crfResultMainInfo.getUrl().replace("{0}", basicDemography.getPatientId().toString());
					description = crfResultMainInfo.getCommon().toString().replace("{0}", basicDemography.getTrueName());
					break;
				}

				if (projectSimpleInfo.getIcfConfirmWay() != Constant.Research.ICFCONFIRMWAY_UNWANTED) {//无需确认，不发送消息
					//发送微信通知
					if (basicDemography.getWeixinFlag() == 1) {
						values.clear();
						values.add("医生已邀请您加入专题随访计划！");
						values.add(basicDemography.getTrueName());
						values.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
						values.add("专题随访入组邀请");
						values.add(description);
						
						state = Constant.Research.PROJECTINVITATIONPATIENT_STATE_PENDING;
						this.sendWeixinContent(basicDemography.getUserId(), values, url);
					} else if(StringUtils.isNotEmpty(basicDemography.getMobile())){//发送短信通知
						mobiles.clear();
						mobiles.add(basicDemography.getMobile());
						
						state = Constant.Research.PROJECTINVITATIONPATIENT_STATE_SMS_SENDING;
						if (url != null) {
							if(!this.sendSmsContent(mobiles, description + "详情请点击：" + url, projectSimpleInfo.getIcfConfirmWay())){
								state = Constant.Research.PROJECTINVITATIONPATIENT_STATE_FAIL;
							}
						} else {
							if(!this.sendSmsContent(mobiles, description, projectSimpleInfo.getIcfConfirmWay())){
								state = Constant.Research.PROJECTINVITATIONPATIENT_STATE_FAIL;
							}
						}
					}else{
						state = Constant.Research.PROJECTINVITATIONPATIENT_STATE_FAIL;
					}
				}
				//记录发送的邀请内容
				this.projectInvitationPatientDao.recordInvitationContent(crfResultMainInfo.getProjectId(), crfResultMainInfo.getSubcenterId(), crfResultMainInfo.getGroupId(),
						crfResultMainInfo.getDoctorId(), basicDemography.getPatientId(), state, description);
				state = null;
			}
		}
		return true;
	}
	
	/**
	 * <p>Title:sendSmsContent</p>
	 * <p>Description:给指定的手机号发送短信</p>
	 * @author YYCHEN
	 * @date 2016年10月31日 下午3:16:31
	 * @param mobiles
	 * @param content
	 * @return
	 */
	private boolean sendSmsContent(List<String> mobiles, String content, int icfConfirmWay) {
		if (mobiles == null || mobiles.isEmpty() || StringUtils.isEmpty(content)) {
			return false;
		}
		SmsContentSendReq paramMap = new SmsContentSendReq();
		paramMap.setBusinessId(1);
		paramMap.setProductId(1);
		paramMap.setMobiles(mobiles);
		paramMap.setContent(content);
		if (icfConfirmWay != 0) {
			paramMap.setSendBackUrl(urlRoot + "/project/invitation/patient/sms/send/state/receipt");
		}
		try {
			this.smsInnerService.sendContent(paramMap);
			return true;
		} catch (Exception e) {
			LogUtil.log.error("发送短信出错！" + e.getMessage());
		}
		return false;
	}
	
	/**
	 * <p>Title:sendWeixinContent</p>
	 * <p>Description:推送微信消息</p>
	 * @author YYCHEN
	 * @date 2016年10月31日 下午3:19:07
	 * @param userId
	 * @param values
	 * @param url
	 */
	private void sendWeixinContent(Long userId, List<String> values, String url) {
		try {
			if (userId != null && userId > 0) {
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(followuWxTtemplateName, url, values);
				notify.setUserId(userId);
				this.pushService.push(notify);
			}
		} catch (Exception e) {
			LogUtil.logError.error("sendWeixinContent() failed:" + e.getMessage());
		}
	}

	@Transactional
	@Override
	public boolean joinPatientsToProject(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption {
		List<PatientSimpleInfo> patientSimpleInfos = crfResultMainInfo.getCrfResult();
		if (patientSimpleInfos == null || patientSimpleInfos.isEmpty()) {
			return true;
		}
		if (StringUtils.isEmpty(crfResultMainInfo.getProjectId()) ||
				crfResultMainInfo.getDoctorId() == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(crfResultMainInfo.getProjectId());
		if (projectSimpleInfo == null) {
			throw new ObjectNotAvailableExcption("object not found!");
		}
		//如果专题结束时间已到，拒绝请求
		if (projectSimpleInfo.getProjectEndTime() != null) {
			String pattern = "yyyy-MM-dd";
			Calendar calendar = Calendar.getInstance();
			Date projectEndTime = projectSimpleInfo.getProjectEndTime(), currentDate = calendar.getTime();
			projectEndTime = DateUtil.stringToDate(DateUtil.getDateOfDay(projectEndTime, pattern + " HH:mm:ss") + " 23:59:59", pattern + " HH:mm:ss");
			currentDate = DateUtil.stringToDate(DateUtil.getDateOfDay(currentDate, pattern), pattern);
			if (projectEndTime.compareTo(currentDate) < 0) {
				throw new RejectRequestExcption("Special end time has arrived, can not add patients!");
			}
		}
		
		/*
		//验证专题患者组是否已经满员
		for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
			if (patientSimpleInfo.getGroupId() != null) {
				TProjectGroupInfo projectGroupInfo = this.projectGroupDao.findByGroupId(patientSimpleInfo.getGroupId());
				if (projectGroupInfo != null && projectGroupInfo.getGroupNum() != null) {
					int count = this.rSubcenterPatientDao.findGroupCount(projectGroupInfo.getProjectId(), projectGroupInfo.getGroupId());
					if (count + patientSimpleInfos.size() > projectGroupInfo.getGroupNum()) {
						throw new DisableExcption("The number of patients in the group has reached the ceiling.");
					}
				}
			}
		}
		if(projectSimpleInfo.getPlanInGroupSum() != null){
			int count = this.rSubcenterPatientDao.findGroupCount(crfResultMainInfo.getProjectId(), null);
			if (count + patientSimpleInfos.size() > projectSimpleInfo.getPlanInGroupSum()) {
				throw new DisableExcption("The number of patients in the group has reached the ceiling.");
			}
		}
		*/
		
		TProjectSubcenter projectSubcenter = this.projectSubcenterService.getCreatorProjectSubCenter(crfResultMainInfo);
		if (projectSubcenter != null) {
			crfResultMainInfo.setSubcenterId(projectSubcenter.getSubcenterId());
		}
		TProjectInvitationPatient projectInvitationPatient = new TProjectInvitationPatient();
		projectInvitationPatient.setProjectId(crfResultMainInfo.getProjectId());
		projectInvitationPatient.setState(Constant.Research.PROJECTINVITATIONPATIENT_STATE_AGREE);
		//修改为已同意邀请
		this.projectInvitationPatientDao.updatePatientsState(projectInvitationPatient, patientSimpleInfos);
		//添加分中心和患者关系
		TRSubcenterPatient rSubcenterPatient = new TRSubcenterPatient();
		rSubcenterPatient.setProjectId(crfResultMainInfo.getProjectId());
		for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
			if(this.rSubcenterPatientDao.findPatientCount(crfResultMainInfo.getProjectId(), patientSimpleInfo.getPatientId()) < 1){
				TProjectInvitationPatient invitationPatient = this.projectInvitationPatientDao.findById(patientSimpleInfo.getId());
				if (invitationPatient != null) {
					rSubcenterPatient.setSubcenterId(invitationPatient.getSubcenterId());
					rSubcenterPatient.setGroupId(invitationPatient.getGroupId());
					rSubcenterPatient.setPatientId(invitationPatient.getInvitee());
					
					this.rSubcenterPatientDao.insert(rSubcenterPatient);
				}
				//this.rSubcenterPatientDao.superinduceByInvitation(crfResultMainInfo);
			}
		}
		//填充人口学信息
		this.crfResultBasicDemographyService.autoSupplement(crfResultMainInfo);
		//填充诊断信息
		this.crfResultDiagnosisInfoService.autoSupplement(crfResultMainInfo);
		//更新专题状态（进行中）
		if (projectSimpleInfo.getState() != Const.PROJECT_STATE_CARRIEDOUT) {
			this.projectDao.updateProjectState(projectSimpleInfo.getProjectId(), Const.PROJECT_STATE_CARRIEDOUT);
		}
		return true;
	}

	@Override
	public boolean deletePendingPatients(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo)
			throws ParameterCannotBeNullException, ObjectNotAvailableExcption {
		List<PatientSimpleInfo> patientSimpleInfos = crfResultMainInfo.getCrfResult();
		if (patientSimpleInfos == null || patientSimpleInfos.isEmpty()) {
			return false;
		}
		if (StringUtils.isEmpty(crfResultMainInfo.getProjectId()) ||
				crfResultMainInfo.getDoctorId() == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TProjectInvitationPatient projectInvitationPatient = new TProjectInvitationPatient();
		projectInvitationPatient.setProjectId(crfResultMainInfo.getProjectId());
		projectInvitationPatient.setState(Constant.Research.PROJECTINVITATIONPATIENT_STATE_PENDING);
		this.projectInvitationPatientDao.deletePendingPatients(projectInvitationPatient, patientSimpleInfos);
		//this.rSubcenterPatientDao.deleteProjectPatients(crfResultMainInfo.getProjectId(), patientSimpleInfos);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteProjectPatients(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) throws ParameterCannotBeNullException {
		if (StringUtils.isEmpty(crfResultMainInfo.getProjectId()) ||
				crfResultMainInfo.getDoctorId() == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<PatientSimpleInfo> patientSimpleInfos = crfResultMainInfo.getCrfResult();
		if (patientSimpleInfos == null || patientSimpleInfos.isEmpty()) {
			return false;
		}
		//删除专题分中心患者关系
		this.rSubcenterPatientDao.deleteProjectPatients(crfResultMainInfo.getProjectId(), patientSimpleInfos);
		//删除专题患者邀请关系
		this.projectInvitationPatientDao.deleteProjectPatients(crfResultMainInfo.getProjectId(), patientSimpleInfos);
		return true;
	}

	@Override
	public PatientSimpleInfo getPatientInfo(String projectId, Long patientId) {
		return patientDao.findPatientInfo(projectId, patientId);
	}

	@Override
	public boolean confirmJoinProjectOfPatient(String projectId, Long subcenterId, String groupId, Long doctorId, Long patientId, Integer state,
			Integer confirmSource) throws ParameterCannotBeNullException, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption {
		if (StringUtils.isEmpty(projectId) ||
				doctorId == null ||
				patientId == null ||
				state == null ||
				confirmSource == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(projectId);
		if (projectSimpleInfo == null) {
			throw new EmptyObjectExcption("Special topic does not exist!");
		}
		if (state == 1 && projectSimpleInfo.getIcfConfirmWay() == 1) {
			this.projectInvitationPatientDao.confirmJoinProjectInvitation(projectId, doctorId, patientId, 2, confirmSource);
			if (this.rSubcenterPatientDao.findPatientCount(projectId, patientId) < 1) {
				TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo = new TCrfResultMainInfo<List<PatientSimpleInfo>>();
				crfResultMainInfo.setProjectId(projectId);
				crfResultMainInfo.setDoctorId(doctorId);
				
				TProjectInvitationPatient invitationPatient = this.projectInvitationPatientDao.findInvitaionInfo(projectId, subcenterId, groupId, doctorId, patientId);
				PatientSimpleInfo patientSimpleInfo = new PatientSimpleInfo();
				patientSimpleInfo.setId(invitationPatient.getId());
				patientSimpleInfo.setPatientId(patientId);
				patientSimpleInfo.setGroupId(groupId);
				
				List<PatientSimpleInfo> patientSimpleInfos = new ArrayList<PatientSimpleInfo>();
				patientSimpleInfos.add(patientSimpleInfo);
				
				crfResultMainInfo.setCrfResult(patientSimpleInfos);
				this.joinPatientsToProject(crfResultMainInfo);
			}
		}else{
			this.projectInvitationPatientDao.confirmJoinProjectInvitation(projectId, doctorId, patientId, state, confirmSource);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> searchStayPatientList(String projectId, Long subcenterId, Integer state, Long doctorId, Integer page,
			Integer num) throws ParameterCannotBeNullException {
		if (StringUtils.isEmpty(projectId)) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<PatientSimpleInfo> patientSimpleInfos = this.patientDao.findStayPatientList(projectId, subcenterId, state, doctorId);
		if (patientSimpleInfos != null && !patientSimpleInfos.isEmpty()) {
			for (PatientSimpleInfo patientSimpleInfo : patientSimpleInfos) {
				if (patientSimpleInfo.getSourceDiseaseTypeId() == null) {
					PatientSimpleInfo diseaseType = this.patientDao.findDiseaseType(patientSimpleInfo.getPatientId());
					if (diseaseType != null) {
						patientSimpleInfo.setSourceDiseaseTypeId(diseaseType.getSourceDiseaseTypeId());
						patientSimpleInfo.setSourceDiseaseTypeName(diseaseType.getSourceDiseaseTypeName());
					}
				}
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<PatientSimpleInfo>) patientSimpleInfos);
	}

	@Override
	public TProjectInvitationPatient getInvitationContent(String projectId, Long subcenterId, String groupId, Long doctorId,
			Long patientId) {
		return this.projectInvitationPatientDao.findInvitaionInfo(projectId, subcenterId, groupId, doctorId, patientId);
	}

	@Override
	public boolean receiptInvitaionPatientSmsState(Map<String, List<SmsSendReportInfo>> data) {
		if (data == null) {
			return false;
		}
		List<SmsSendReportInfo> smsSendReportInfoes = data.get("data");
		if (smsSendReportInfoes == null || smsSendReportInfoes.isEmpty()) {
			return false;
		}
		for (SmsSendReportInfo smsSendReportInfo : smsSendReportInfoes) {
			if (smsSendReportInfo.getStatus() != null
					&& smsSendReportInfo.getStatus() == 0) {
				//信息发送成功
				this.projectInvitationPatientDao.updateInvitationPatientState(smsSendReportInfo.getMobile(),
						Constant.Research.PROJECTINVITATIONPATIENT_STATE_SMS_SENDING, Constant.Research.PROJECTINVITATIONPATIENT_STATE_PENDING);
			}else{
				//信息发送失败
				this.projectInvitationPatientDao.updateInvitationPatientState(smsSendReportInfo.getMobile(),
						Constant.Research.PROJECTINVITATIONPATIENT_STATE_SMS_SENDING, Constant.Research.PROJECTINVITATIONPATIENT_STATE_FAIL);
			}
		}
		return true;
	}
}
