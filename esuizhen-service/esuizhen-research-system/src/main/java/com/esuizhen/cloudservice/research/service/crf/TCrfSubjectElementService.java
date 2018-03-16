package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElementSet;

/**
* @ClassName: CrfObservationSubjectElementService 
* @Description: crf标题观察服务接口
* @author wang_hw
* @date 2016年4月5日 下午4:55:15
 */
public interface TCrfSubjectElementService{
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationSubjectElement
	 * @Description:查询标题观察项
	 * @return TCrfObservationSubjectElement
	 * @date 2016年4月5日 下午4:56:59
	 */
	public List<TCrfObservationSubjectElement> queryCrfSubjectElementChild(String crfCourseItemId , String parentId);
	
	/**
	 * @author wang_hw
	 * @title :removeCrfSubjectElementChild
	 * @Description:根据观察ID删除观察标题
	 * @return void
	 * @date 2016年4月5日 下午5:09:58
	 */
	public void removeCrfSubjectElementChild(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :setCrfSubjectElementChild
	 * @Description:crf观察项设置
	 * @return void
	 * @date 2016年4月5日 下午5:15:34
	 */
	public void setCrfSubjectElementChild(TCrfObservationSubjectElementSet crfObservationSubjectElementSet);

	/**
	 * <p>Title:queryFollowupTimeAxis</p>
	 * <p>Description:患者随访时间轴查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 下午5:08:09
	 * @param crfCourseItemId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	public TCrfCourseDetailInfo queryFollowupTimeAxis(String crfCourseItemId, Long patientId, Long doctorId);
}
