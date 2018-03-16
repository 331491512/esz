package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TCrfCourseConf;
import com.esuizhen.cloudservice.research.bean.TCrfCourseConfInfo;
import com.esuizhen.cloudservice.research.bean.TCrfCourseInfo;

/**
 * <p>Title: CrfCourseDao</p>
 * <p>Description: 随访周期数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年4月7日 上午10:31:20
 */
public interface CrfCourseDao {
	/**
	 * <p>Title: insert</p>
	 * <p>Description: 新增随访周期</p>
	 * @date 2016年4月7日 上午10:36:20
	 * @param tCrfCourseConfInfo
	 * @return
	 */
	public int insert(TCrfCourseConfInfo tCrfCourseConfInfo);

	/**
	 * <p>Title: delete</p>
	 * <p>Description: 删除随访周期</p>
	 * @date 2016年4月7日 下午2:58:22
	 * @param crfCourseId
	 * @return
	 */
	public int delete(String crfCourseId);
	
	/**
	 * <p>Title: queryCoursesByCrfTemplateId</p>
	 * <p>Description: 通过科研专题模板ID获取随访周期列表</p>
	 * @date 2016年4月7日 下午2:41:49
	 * @param crfTemplateId
	 * @return
	 */
	public List<TCrfCourseConfInfo> queryCoursesByCrfTemplateId(String crfTemplateId);
	/**
	 * <p>Title: findByCrfTemplateId</p>
	 * <p>Description: 通过模板ID获取随访周期</p>
	 * @date 2016年4月11日 下午3:00:14
	 * @param crfTemplateId
	 * @return
	 */
	public TCrfCourseConf findByCrfTemplateId(String crfTemplateId);
	
	/**
	 * <p>Title: queryByCrfTemplateId</p>
	 * <p>Description: 通过科研专题模板ID获取随访周期列表</p>
	 * @date 2016年4月12日 下午6:05:39
	 * @param crfTemplateId
	 * @return
	 */
	public List<TCrfCourseInfo> queryByCrfTemplateId(String crfTemplateId);
	
	/**
	 * <p>Title:queryByCrfCourseItemId</p>
	 * <p>Description:通过随访周期详情ID获取随访周期列表</p>
	 * @author YYCHEN
	 * @date 2016年6月24日 下午4:37:55
	 * @param crfCourseItemId
	 * @return
	 */
	public List<TCrfCourseInfo> queryByCrfCourseItemId(String crfCourseItemId);

	/**
	 * <p>Title:findProjectCourseItems</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 下午4:52:50
	 * @param projectId
	 * @param patientId
	 * @param currentCrfCourseItemId
	 * @return
	 */
	public List<TCrfCourseInfo> findProjectCourseItems(@Param("projectId")String projectId, @Param("patientId")Long patientId, @Param("currentCrfCourseItemId")String currentCrfCourseItemId);
	
	/**
	 * <p>Title:findByCrfCourseId</p>
	 * <p>Description:通过周期ID查找随访周期</p>
	 * @author YYCHEN
	 * @date 2016年7月23日 下午2:57:46
	 * @param crfCourseId
	 * @return
	 */
	public TCrfCourseInfo findByCrfCourseId(String crfCourseId);
	
	/**
	 * <p>Title:findByCrfCourseItemId</p>
	 * <p>Description:通过随访明细ID查询随访周期</p>
	 * @author YYCHEN
	 * @date 2016年7月23日 下午3:32:49
	 * @param crfCourseItemId
	 * @return
	 */
	public TCrfCourseInfo findByCrfCourseItemId(String crfCourseItemId);
	
}
