package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.dao.crf.TCrfObservationSubjectElementDao;
import com.esuizhen.cloudservice.research.dao.pro.RCrftemplateProjectDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElementSet;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.service.crf.CrfCourseService;
import com.esuizhen.cloudservice.research.service.crf.TCrfSubjectElementService;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfSubjectElementServiceImpl implements TCrfSubjectElementService {

	@Autowired
	private TCrfObservationSubjectElementDao dao;
	@Autowired
	private RCrftemplateProjectDao rCrftemplateProjectDao;

	@Autowired
	private CrfCourseService crfCourseService;

	@Override
	public List<TCrfObservationSubjectElement> queryCrfSubjectElementChild(String crfCourseItemId, String parentId) {
		return dao.queryCrfSubjectElementChild(crfCourseItemId, parentId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void removeCrfSubjectElementChild(String crfObserveId) {
		dao.deleteCrfObservationSubjectElementByIds(crfObserveId);

		dao.deleteCrfObservationSubjectElement(crfObserveId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setCrfSubjectElementChild(TCrfObservationSubjectElementSet crfObservationSubjectElementSet) {
		String crfCourseItemId = crfObservationSubjectElementSet.getCrfCourseItemId();
		String parentId = crfObservationSubjectElementSet.getParentId();

		// 目前数据库中存在的观察项目
		List<TCrfObservationSubjectElement> crfObservationSubjectElementList = dao.queryCrfSubjectElementChild(crfCourseItemId, parentId);

		// 新添加的采集项目
		List<TCrfObservationSubjectElement> insertCrfObservationSubjectElementList = new ArrayList<TCrfObservationSubjectElement>();

		// 需要删除的采集项目
		List<TCrfObservationSubjectElement> deleteCrfObservationSubjectElementList = new ArrayList<TCrfObservationSubjectElement>();

		for (int i = 0; i < crfObservationSubjectElementSet.getSubjectElemenList().size(); i++) {

			// 设置观察项目
			TCrfObservationSubjectElement crfObservationSubjectElement = crfObservationSubjectElementSet
					.getSubjectElemenList().get(i);
			crfObservationSubjectElement.setCrfObserveId(GeneralUtil.generateUniqueID("OBSE"));
			crfObservationSubjectElement.setParentId(crfObservationSubjectElementSet.getParentId());
			crfObservationSubjectElement.setCrfCourseItemId(crfObservationSubjectElementSet.getCrfCourseItemId());

			// 判断观察项目是否已经存在如果存在则不在新添加
			boolean isExist = false;
			for (TCrfObservationSubjectElement subjectElement : crfObservationSubjectElementList) {
				if (crfObservationSubjectElement.getSubjectElementId().equals(subjectElement.getSubjectElementId())) {
					isExist = true;
					break;
				}
			}

			if (!isExist) {// 如果不存在则新添加采集项目
				insertCrfObservationSubjectElementList.add(crfObservationSubjectElement);
			}
		}

		// 需要删除的标题ID
		String crfObserveIds = "";

		// 查找需要删除的标题列表
		for (TCrfObservationSubjectElement subjectElement : crfObservationSubjectElementList) {
			// 判断标题是否需要删除
			boolean isExist = true;

			for (TCrfObservationSubjectElement crfObservationSubjectElement : crfObservationSubjectElementSet
					.getSubjectElemenList()) {// 查找现有标题在修改列表中是否存在
				if (crfObservationSubjectElement.getSubjectElementId().equals(subjectElement.getSubjectElementId())) {
					isExist = false;
				}
			}

			if (isExist) {// 如果没有找到则进入到删除列表
				crfObserveIds += "," + subjectElement.getCrfObserveId();
				deleteCrfObservationSubjectElementList.add(subjectElement);
			}
		}

		// 删除标题
		if (deleteCrfObservationSubjectElementList.size() > 0) {
			dao.deleteCrfObservationSubjectElementByIds(crfObserveIds.substring(1));
		}

		if (insertCrfObservationSubjectElementList.size() > 0) {// 保存新录入的标题
			dao.insertCrfObservationSubjectElementList(insertCrfObservationSubjectElementList);
		}
	}

	@Override
	public TCrfCourseDetailInfo queryFollowupTimeAxis(String crfCourseItemId, Long patientId, Long doctorId) {
		if (StringUtils.isEmpty(crfCourseItemId) || patientId == null) {
			throw new EmptyParamExcption();
		}
		RCrftemplateProject crftemplateProject = this.rCrftemplateProjectDao.findByCrfCourseItemId(crfCourseItemId);
		TCrfCourseDetailInfo crfCourseDetailInfo = this.crfCourseService
				.getCurrentCourseDetailInfo(crftemplateProject.getProjectId(), patientId);
		String currentCrfCourseItemId = null;
		if (crfCourseDetailInfo != null) {
			currentCrfCourseItemId = crfCourseDetailInfo.getCrfCourseItemId();
		}
		int days = this.crfCourseService.getFollowupDays(crftemplateProject.getCrfTemplateId(), crfCourseItemId);
		return this.dao.findFollowupTimeAxis(crftemplateProject.getProjectId(),
				crfCourseItemId, currentCrfCourseItemId,
				patientId, days, null, crfCourseDetailInfo.getAvailable());
	}
}
