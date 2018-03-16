package com.esuizhen.cloudservice.research.dao.pro;

import java.util.List;

import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;

/**
 * <p>Title: RCrftemplateProjectDao</p>
 * <p>Description: 科研模板与科研专题关系数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年4月12日 下午5:07:10
 */
public interface RCrftemplateProjectDao {
	/**
	 * <p>Title: findByProjectId</p>
	 * <p>Description: 通过科研专题ID获取科研专题模板与科研专题对应关系</p>
	 * @date 2016年4月12日 下午5:10:30
	 * @param projectId
	 * @return
	 */
	public RCrftemplateProject findByProjectId(String projectId);
	
	/**
	 * <p>Title:findByTemplateId</p>
	 * <p>Description:通过专题模板ID查找专题与模板关系</p>
	 * @author YYCHEN
	 * @date 2016年6月7日 下午4:52:44
	 * @param crfTemplateId
	 * @return
	 */
	public RCrftemplateProject findByTemplateId(String crfTemplateId);
	
	/**
	 * <p>Title:findByCrfCourseItemId</p>
	 * <p>Description:通过随访周期明细ID获取专题与模板关系</p>
	 * @author YYCHEN
	 * @date 2016年6月24日 下午5:12:49
	 * @param crfCourseItemId
	 * @return
	 */
	public RCrftemplateProject findByCrfCourseItemId(String crfCourseItemId);
	
	/**
	 * <p>Title:findByCrfObserveId</p>
	 * <p>Description:根据观察项ID获取专题与专题模板关系信息</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午5:32:37
	 * @param crfObserveId
	 * @return
	 */
	public RCrftemplateProject findByCrfObserveId(String crfObserveId);
	
	/**
	 * <p>Title: findsByProjectId</p>
	 * <p>Description: </p>
	 * @date 2016年4月28日 上午11:50:45
	 * @param projectId
	 * @return
	 */
	public List<RCrftemplateProject> findProjectTemplateByProjectId(String projectId);
}
