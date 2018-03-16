package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamItemDetailOptions;
import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;

/**
 * @ClassName: CrfObservationSubjectElementDao
 * @Description: crf标题项数据操作
 * @author wang_hw
 * @date 2016年4月5日 下午4:38:44
 */
public interface TCrfObservationSubjectElementDao {

	/**
	 * @author wang_hw
	 * @title :insertCrfObservationSubjectElement
	 * @Description:录入crf标题项数据
	 * @return void
	 * @date 2016年4月5日 下午4:39:05
	 */
	public void insertCrfObservationSubjectElement(TCrfObservationSubjectElement crfObservationSubjectElement);

	/**
	 * @author wang_hw
	 * @title :insertCrfObservationSubjectElementList
	 * @Description:批量录入CRF观察标题
	 * @return void
	 * @date 2016年4月5日 下午5:39:33
	 */
	public void insertCrfObservationSubjectElementList(
			List<TCrfObservationSubjectElement> crfObservationSubjectElementList);

	/**
	 * @author wang_hw
	 * @title :updateCrfObservationSubjectElement
	 * @Description:录入crf标题项数据
	 * @return void
	 * @date 2016年4月5日 下午4:39:28
	 */
	public void updateCrfObservationSubjectElement(TCrfObservationSubjectElement crfObservationSubjectElement);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationSubjectElement
	 * @Description:删除crf标题项数据
	 * @return void
	 * @date 2016年4月5日 下午4:39:41
	 */
	public void deleteCrfObservationSubjectElement(String crfObserveId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationSubjectElementByIds
	 * @Description:删除标题（一组ID）
	 * @return void
	 * @date 2016年4月21日 上午10:40:19
	 */
	public void deleteCrfObservationSubjectElementByIds(@Param("crfObserveIds") String crfObserveIds);

	/**
	 * @author wang_hw
	 * @title :deleteByCrfCourseItemId
	 * @Description:根据随访周期观察点ID删除观察标题
	 * @return void
	 * @date 2016年4月5日 下午5:37:50
	 */
	public void deleteCrfObservationSubjectElementByCrfCourseItemId(@Param("crfCourseItemId") String crfCourseItemId,
			@Param("parentId") String parentId, @Param("subjectElementIds") String subjectElementIds);

	/**
	 * <p>
	 * Title:deleteByBatch
	 * </p>
	 * <p>
	 * Description:批量删除CRF设置项
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年10月25日 下午6:24:18
	 * @param crfExamItemDetailOptions
	 * @return
	 */
	public int deleteByBatch(@Param("records") List<TCrfExamItemDetailOptions> crfExamItemDetailOptions);

	/**
	 * @author wang_hw
	 * @title :queryCrfObservationSubjectElement
	 * @Description:查询crf标题项数据
	 * @return CrfObservationSubjectElement
	 * @date 2016年4月5日 下午4:39:46
	 */
	public TCrfObservationSubjectElement queryCrfObservationSubjectElement(String crfObserveId);

	/**
	 * <p>
	 * Title:findCrfObservationSubjectElementBySubjectElementId
	 * </p>
	 * <p>
	 * Description:通过专题ID和观察项标题元素ID获取CRF观察项设置
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年6月12日 下午6:29:29
	 * @param projectId
	 * @param subjectElementId
	 * @return
	 */
	public TCrfObservationSubjectElement findCrfObservationSubjectElementBySubjectElementId(
			@Param("projectId") String projectId, @Param("subjectElementId") String subjectElementId);

	/**
	 * @author wang_hw
	 * @title :queryCrfSubjectElementChild
	 * @Description:CRF观察项-子标题元素（采集项）查看
	 * @return List<TCrfObservationSubjectElement>
	 * @date 2016年4月5日 下午5:27:50
	 */
	public List<TCrfObservationSubjectElement> queryCrfSubjectElementChild(
			@Param("crfCourseItemId") String crfCourseItemId, @Param("parentId") String parentId);

	/**
	 * <p>
	 * Title:findChildListByCrfObserveId
	 * </p>
	 * <p>
	 * Description:查询CRF设置项子项列表
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年10月25日 下午6:18:53
	 * @param crfObserveId
	 * @return
	 */
	public List<TCrfExamItemDetailOptions> findChildListByCrfObserveId(String crfObserveId);

	/**
	 * <p>
	 * Title:findFollowupTimeAxis
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年6月24日 下午5:42:02
	 * @param crfCourseItemId
	 * @param currentCrfCourseItemId
	 * @param patientId
	 * @param days
	 * @return
	 */
	TCrfCourseDetailInfo findFollowupTimeAxis(@Param("projectId") String projectId,
			@Param("crfCourseItemId") String crfCourseItemId,
			@Param("currentCrfCourseItemId") String currentCrfCourseItemId, @Param("patientId") Long patientId,
			@Param("days") Integer days, @Param("collectFlag") Integer collectFlag,
			@Param("available") Integer available);
}
