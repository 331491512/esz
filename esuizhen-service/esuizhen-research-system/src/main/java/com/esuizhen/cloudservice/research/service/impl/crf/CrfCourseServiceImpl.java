package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.bean.TCrfCourseConf;
import com.esuizhen.cloudservice.research.bean.TCrfCourseConfInfo;
import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.bean.TCrfCourseInfo;
import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.common.Const;
import com.esuizhen.cloudservice.research.dao.crf.CrfCourseDao;
import com.esuizhen.cloudservice.research.dao.crf.CrfCourseDetailDao;
import com.esuizhen.cloudservice.research.dao.crf.ProjectCrfTemplateDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.dao.pro.RCrftemplateProjectDao;
import com.esuizhen.cloudservice.research.dao.result.PatientDao;
import com.esuizhen.cloudservice.research.model.crf.CrfCourseDetail;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.service.crf.CrfCourseService;
import com.esuizhen.cloudservice.research.util.CrfCourseUtil;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title: CrfCourseServiceImpl</p>
 * <p>Description: </p>
 * @author YYCHEN
 * @date 2016年4月7日 上午11:13:58
 */
@Service
public class CrfCourseServiceImpl implements CrfCourseService {
	@Autowired
	private ProjectCrfTemplateDao projectCrfTemplateDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private CrfCourseDao crfCourseDao;
	@Autowired
	private CrfCourseDetailDao crfCourseDetailDao;
	@Autowired
	private RCrftemplateProjectDao rCrftemplateProjectDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private TCrfObservationSubjectElementDao tCrfObservationSubjectElementDao;

	@Transactional
	@Override
	public int pojectTemplateCrfCourseModify(TCrfCourseConf crfCourseConf) throws EmptyParamExcption {
		//Crf模板Id
		if (StringUtils.isEmpty(crfCourseConf.getCrfTemplateId())) {
			throw new EmptyParamExcption("crfTemplateId is empty!");
		}
		//随访周期起始时间开关
		if (crfCourseConf.getFollowupStartMark() == null) {
			throw new EmptyParamExcption("followupStartMark is empty!");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", crfCourseConf.getCrfTemplateId());
		params.put("state", -1);
		
		LogUtil.log.debug("开始删除之前的随访周期（proCrfTemplateDetailDelete）:" + JsonUtil.toJson(params));
		this.projectCrfTemplateDao.proCrfTemplateDetailDelete(params);
		LogUtil.log.debug("删除之前的随访周期完成（proCrfTemplateDetailDelete）:" + JsonUtil.toJson(params));
		
		//添加随访周期
		this.addTemplateCrfCourse(crfCourseConf);
		//修改专题模板随访周期起始时间
		this.projectCrfTemplateDao.updateCrfTemplateIdcrfTemplateId(crfCourseConf.getCrfTemplateId(), crfCourseConf.getFollowupStartMark());

		LogUtil.log.debug("开始添加专题观察项（proCrfTemplateModify）:" + JsonUtil.toJson(params));
		this.projectCrfTemplateDao.proCrfTemplateModify(params);
		LogUtil.log.debug("添加专题观察项完成（proCrfTemplateModify）:" + JsonUtil.toJson(params));
		return 0;
	}

	/**
	 * <p>Title: addTemplateCrfCourse</p>
	 * <p>Description: 添加随访周期</p>
	 * @date 2016年4月7日 下午12:03:33
	 * @param crfCourseConf
	 */
	private boolean addTemplateCrfCourse(TCrfCourseConf crfCourseConf) {
		List<TCrfCourseConfInfo> courseConfInfos = crfCourseConf.getCrfCourseList();
		if (courseConfInfos == null || courseConfInfos.isEmpty()) {
			throw new EmptyParamExcption("The follow-up period was empty!");
		}
		/*
		//添加入组基线
		TCrfCourseConfInfo baselineCourseConfInfo = new TCrfCourseConfInfo();
		baselineCourseConfInfo.setCrfCourseIndex(0);
		baselineCourseConfInfo.setCrfTemplateId(crfCourseConf.getCrfTemplateId());
		baselineCourseConfInfo.setCrfCourseId(GeneralUtil.generateUniqueID("COUR"));
		baselineCourseConfInfo.setCrfCourseItemName("入组基线");
		baselineCourseConfInfo.setFollowupPeriod(0);
		baselineCourseConfInfo.setFollowupPeriodUnit("D");
		baselineCourseConfInfo.setFollowupFrequency(0);
		baselineCourseConfInfo.setFollowupFrequencyUnit("D");
		baselineCourseConfInfo.setFollowupCount(0);
		this.crfCourseDao.insert(baselineCourseConfInfo);
		//添加入组基线随访明细
		this.addBaselineCourseDetail(baselineCourseConfInfo);
		*/
		Integer countDay = 0;
		for (int i = 0, size = courseConfInfos.size(); i < size; i++) {
			TCrfCourseConfInfo tCrfCourseConfInfo = courseConfInfos.get(i);
			//周期名
			if (StringUtils.isEmpty(tCrfCourseConfInfo.getCrfCourseItemName())) {
				throw new EmptyParamExcption("crfCourseItemName is empty!");
			}
			//周期序号
			if (tCrfCourseConfInfo.getCrfCourseIndex() == null) {
				throw new EmptyParamExcption("crfCourseIndex is empty!");
			}
			//随访周期值
			if (tCrfCourseConfInfo.getFollowupPeriod() == null) {
				throw new EmptyParamExcption("followupPeriod is empty!");
			}
			//随访周期单位
			if (StringUtils.isEmpty(tCrfCourseConfInfo.getFollowupPeriodUnit())) {
				throw new EmptyParamExcption("followupPeriodUnit is empty!");
			}
			//随访频率
			if (tCrfCourseConfInfo.getFollowupFrequency() == null) {
				throw new EmptyParamExcption("followupFrequency is empty!");
			}
			//随访频率单位
			if (StringUtils.isEmpty(tCrfCourseConfInfo.getFollowupFrequencyUnit())) {
				throw new EmptyParamExcption("followupFrequencyUnit is empty!");
			}
			//随访次数
			if (tCrfCourseConfInfo.getFollowupCount() == null) {
				throw new EmptyParamExcption("followupCount is empty!");
			}
			//Crf模板Id
			if (StringUtils.isEmpty(tCrfCourseConfInfo.getCrfTemplateId())) {
				tCrfCourseConfInfo.setCrfTemplateId(crfCourseConf.getCrfTemplateId());
			}
			//CRF随访周期ID
			tCrfCourseConfInfo.setCrfCourseId(GeneralUtil.generateUniqueID("COUR"));
			//保存随访周期
			LogUtil.log.debug("开始添加专题模板随访周期:" + JsonUtil.toJson(tCrfCourseConfInfo));
			this.crfCourseDao.insert(tCrfCourseConfInfo);
			LogUtil.log.debug("添加专题模板随访周期完成:" + JsonUtil.toJson(tCrfCourseConfInfo));
			
			//添加随访明细
			LogUtil.log.debug("添加专题模板随访周期的随访明细...");
			this.addTemplateCrfCourseDetails(crfCourseConf, tCrfCourseConfInfo, countDay);
			countDay += CrfCourseUtil.unitConversionDaies(tCrfCourseConfInfo.getFollowupFrequencyUnit()) * tCrfCourseConfInfo.getFollowupFrequency() * tCrfCourseConfInfo.getFollowupCount();
		}
		return true;
	}

	/**
	 * 添加随访明细
	 * <p>Title: addTemplateCrfCourseDetails</p>
	 * <p>Description: </p>
	 * @date 2016年4月7日 下午1:59:09
	 * @param tCrfCourseConfInfo
	 * @param countDay
	 * @param index
	 * @return
	 */
	private boolean addTemplateCrfCourseDetails(TCrfCourseConf crfCourseConf, TCrfCourseConfInfo tCrfCourseConfInfo, Integer countDay) {
		int distanceTime = countDay;
		for (int i = 0, size = tCrfCourseConfInfo.getFollowupCount(); i < size; i++) {
			crfCourseConf.setCourseDetailCount(crfCourseConf.getCourseDetailCount() + 1);
			CrfCourseDetail crfCourseDetail = new CrfCourseDetail();
			crfCourseDetail.setIndex(i);
			//随访周期明细名
			Integer proUnit = countDay / CrfCourseUtil.unitConversionDaies(tCrfCourseConfInfo.getFollowupFrequencyUnit());
			if (countDay % CrfCourseUtil.unitConversionDaies(tCrfCourseConfInfo.getFollowupFrequencyUnit()) != 0) {
				proUnit++;
			}
			proUnit += tCrfCourseConfInfo.getFollowupFrequency() * (i + 1);
			crfCourseDetail.setCrfCourseItemName(CrfCourseUtil.unitConversion(tCrfCourseConfInfo.getFollowupFrequencyUnit(),  proUnit));
			//随访周期明细序号
			crfCourseDetail.setCrfCourseItemIndex(crfCourseConf.getCourseDetailCount());
			//距离本周期起始时间的间隔
			distanceTime += CrfCourseUtil.unitConversionDaies(tCrfCourseConfInfo.getFollowupFrequencyUnit()) * tCrfCourseConfInfo.getFollowupFrequency();
			crfCourseDetail.setDistanceTime(distanceTime);
			//随访周期明细(观察时点)ID
			crfCourseDetail.setCrfCourseItemId(GeneralUtil.generateUniqueID("CITEM"));
			//随访周期ID
			crfCourseDetail.setCrfCourseId(tCrfCourseConfInfo.getCrfCourseId());
			
			//保存
			LogUtil.log.debug("开始添加专题模板随访周期明细:" + JsonUtil.toJson(crfCourseDetail));
			this.crfCourseDetailDao.insert(crfCourseDetail);
			LogUtil.log.debug("添加专题模板随访周期明细完成:" + JsonUtil.toJson(crfCourseDetail));
		}
		return true;
	}

	@Override
	public TCrfCourseConf projectTemplateCrfCourseQuery(String crfTemplateId, Long doctorId) {
		return this.crfCourseDao.findByCrfTemplateId(crfTemplateId);
	}

	@Override
	public List<TCrfCourseInfo> queryCrfObserve(String crfTemplateId) {
		return this.crfCourseDao.queryByCrfTemplateId(crfTemplateId);
	}

	@Transactional
	@Override
	public boolean projectTemplateCrfCopyBaseItems(String crfTemplateId) {
		//Crf模板Id
		if (StringUtils.isEmpty(crfTemplateId)) {
			throw new EmptyParamExcption("crfTemplateId is empty!");
		}
		RCrftemplateProject rCrftemplateProject = this.rCrftemplateProjectDao.findByTemplateId(crfTemplateId);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", crfTemplateId);
		params.put("state", -1);
		
		LogUtil.log.debug("开始删除之前的随访周期（proCrfTemplateDetailDelete）:" + JsonUtil.toJson(params));
		this.projectCrfTemplateDao.proCrfTemplateCopyDelete(params);
		LogUtil.log.debug("删除之前的随访周期完成（proCrfTemplateDetailDelete）:" + JsonUtil.toJson(params));
		LogUtil.log.debug("开始添加专题观察项（proCrfTemplateModify）:" + JsonUtil.toJson(params));
		this.projectCrfTemplateDao.proCrfTemplateModify(params);
		this.projectDao.updateProjectState(rCrftemplateProject.getProjectId(), Const.PROJECT_STATE_NOTSCREENEDPATIENTS);
		LogUtil.log.debug("添加专题观察项完成（proCrfTemplateModify）");
		this.projectCrfTemplateDao.setIsBaselineCopied(crfTemplateId);
		return true;
	}

	@Override
	public List<TCrfCourseInfo> queryProjectCrfResultOutlineFirst(String projectId, Long patientId, Long doctorId) {
		TCrfCourseDetailInfo crfCourseDetailInfo = this.getCurrentCourseDetailInfo(projectId, patientId);
		String crfCourseItemId = null;
		if (crfCourseDetailInfo != null) {
			crfCourseItemId = crfCourseDetailInfo.getCrfCourseItemId();
		}
		return this.crfCourseDao.findProjectCourseItems(projectId, patientId, crfCourseItemId);
	}
	
	@Override
	public int getFollowupDays(String crfTemplateId, String crfCourseItemId){
		int days = 0;
		List<TCrfCourseInfo> courseConfInfos = this.crfCourseDao.queryByCrfTemplateId(crfTemplateId);
		for (TCrfCourseInfo tCrfCourseConfInfo : courseConfInfos) {
			List<TCrfCourseDetailInfo> courseDetailInfos = tCrfCourseConfInfo.getCrfCourseItemList();
			for (TCrfCourseDetailInfo tCrfCourseDetailInfo : courseDetailInfos) {
				days += CrfCourseUtil.unitConversionDaies(tCrfCourseConfInfo.getFollowupFrequencyUnit()) * tCrfCourseConfInfo.getFollowupFrequency();
				if (tCrfCourseDetailInfo.getCrfCourseItemId().equals(crfCourseItemId)) {
					return days;
				}
			}
		}
		return -1;
	}
	
	@Override
	public TCrfCourseDetailInfo getCurrentCourseDetailInfo(String projectId, Long patientId){
		String pattern = "yyyy-MM-dd";
		Calendar calendar = Calendar.getInstance();
		Date baseDate = this.patientDao.findBaseDate(projectId, patientId), currentDate = calendar.getTime();
		baseDate = DateUtil.stringToDate(DateUtil.getDateOfDay(baseDate, pattern), pattern);
		currentDate = DateUtil.stringToDate(DateUtil.getDateOfDay(currentDate, pattern), pattern);
		calendar.setTime(baseDate);
		TProjectTemplateSimpleInfo projectTemplateSimpleInfo = this.projectCrfTemplateDao.findByProjectId(projectId);
		List<TCrfCourseInfo> courseConfInfos = this.crfCourseDao.queryByCrfTemplateId(projectTemplateSimpleInfo.getCrfTemplateId());
		int days = 0;
		for (int i = 0; i < courseConfInfos.size(); i++) {
			TCrfCourseInfo crfCourseInfo = courseConfInfos.get(i);
			for (int j = 0, size = crfCourseInfo.getCrfCourseItemList().size(); j < size; j++) {
				TCrfCourseDetailInfo tCrfCourseDetailInfo = crfCourseInfo.getCrfCourseItemList().get(j);
				if (i == 0 && j == 0) {//入组基线的随访时间
					tCrfCourseDetailInfo.setFollowupDate(currentDate);
				}
				days = CrfCourseUtil.unitConversionDaies(crfCourseInfo.getFollowupFrequencyUnit()) * crfCourseInfo.getFollowupFrequency(); 
				calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + days);//日期加days天
				//当期日期小于或等于随访周期的日期，就是当期随访的周期
				if (currentDate.compareTo(calendar.getTime()) == 0) {
					tCrfCourseDetailInfo.setFollowupDate(currentDate);
					return tCrfCourseDetailInfo;
				}else if (currentDate.compareTo(calendar.getTime()) < 0) {//采集时间未到
					TCrfCourseDetailInfo nextCrfCourseDetailInfo = null;
					boolean nextAvailable = false;
					//如果下一个阶段已到提前3天
					if (!(crfCourseInfo.getFollowupFrequency() < 3 &&
							crfCourseInfo.getFollowupFrequencyUnit().equalsIgnoreCase("d"))) {
						Calendar nextCourseDate = Calendar.getInstance();
						nextCourseDate.setTime(calendar.getTime());
						nextCourseDate.set(Calendar.DAY_OF_YEAR, nextCourseDate.get(Calendar.DAY_OF_YEAR) - 3);
						if (currentDate.compareTo(nextCourseDate.getTime()) >= 0) {
							nextCourseDate.set(Calendar.DAY_OF_YEAR, nextCourseDate.get(Calendar.DAY_OF_YEAR) + 3);
							if (currentDate.compareTo(nextCourseDate.getTime()) <= 0) {
								nextAvailable = true;
							}
						}
					}
					calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - days);//日期减days天
					if (j > 0) {
						TCrfCourseDetailInfo currentTCrfCourseDetailInfo = crfCourseInfo.getCrfCourseItemList().get(j - 1);//当期是下一个阶段
						currentTCrfCourseDetailInfo.setFollowupDate(calendar.getTime());
						nextCrfCourseDetailInfo = currentTCrfCourseDetailInfo;
					}else{
						if (i > 0) {
							//当期是上一个周期的最后一个阶段
							TCrfCourseInfo currentTCrfCourseInfo = courseConfInfos.get(i - 1);
							List<TCrfCourseDetailInfo> courseDetailInfos = currentTCrfCourseInfo.getCrfCourseItemList();
							TCrfCourseDetailInfo currentTCrfCourseDetailInfo = courseDetailInfos.get(courseDetailInfos.size() - 1);
							currentTCrfCourseDetailInfo.setFollowupDate(calendar.getTime());
							nextCrfCourseDetailInfo = currentTCrfCourseDetailInfo;
						}else{
							nextCrfCourseDetailInfo = courseConfInfos.get(0).getCrfCourseItemList().get(0);
						}
					}
					if (nextAvailable) {
						nextCrfCourseDetailInfo.setAvailable(1);
					}
					return nextCrfCourseDetailInfo;
				}
			}
		}
		List<TCrfCourseDetailInfo> courseDetailInfos = courseConfInfos.get(courseConfInfos.size() - 1).getCrfCourseItemList();
		TCrfCourseDetailInfo courseDetailInfo = courseDetailInfos.get(courseDetailInfos.size() - 1);
		courseDetailInfo.setFollowupDate(calendar.getTime());
		return courseDetailInfo;
	}

	//获取最后一个阶段的随访阶段
	@Override
	public TCrfCourseDetailInfo getLastTCrfCourseDetailInfo(String projectId, Long patientId){
		TProjectTemplateSimpleInfo projectTemplateSimpleInfo = this.projectCrfTemplateDao.findByProjectId(projectId);
		List<TCrfCourseInfo> courseConfInfos = this.crfCourseDao.queryByCrfTemplateId(projectTemplateSimpleInfo.getCrfTemplateId());
		TCrfCourseInfo lastTCrfCourseInfo = courseConfInfos.get(courseConfInfos.size() - 1);
		TCrfCourseDetailInfo lastTCrfCourseDetailInfo = lastTCrfCourseInfo.getCrfCourseItemList().get(lastTCrfCourseInfo.getCrfCourseItemList().size() - 1);
		
		TCrfCourseDetailInfo crfCourseDetailInfo = this.getCurrentCourseDetailInfo(projectId, patientId);
		String currentCrfCourseItemId = null;
		if (crfCourseDetailInfo != null) {
			currentCrfCourseItemId = crfCourseDetailInfo.getCrfCourseItemId();
		}
		int days = this.getFollowupDays(projectTemplateSimpleInfo.getCrfTemplateId(), lastTCrfCourseDetailInfo.getCrfCourseItemId());
		RCrftemplateProject crftemplateProject =  rCrftemplateProjectDao.findByTemplateId(projectTemplateSimpleInfo.getCrfTemplateId());
		return this.tCrfObservationSubjectElementDao.findFollowupTimeAxis(crftemplateProject.getProjectId(),
				lastTCrfCourseDetailInfo.getCrfCourseItemId(), currentCrfCourseItemId, patientId, days, null, null);
	}
}
