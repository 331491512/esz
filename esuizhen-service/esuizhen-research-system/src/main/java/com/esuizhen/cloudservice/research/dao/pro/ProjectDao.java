package com.esuizhen.cloudservice.research.dao.pro;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TProjectCountInfo;
import com.esuizhen.cloudservice.research.bean.TProjectDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;

/** 
* @ClassName: ProjectDao 
* @Description: 科研专题数据访问层
* @author YYCHEN
* @date 2016年04月01日 下午15:58:01
*/
public interface ProjectDao {
	/**
	 * 科研专题创建
	 * @param project
	 * @return
	 */
	public int insert(TProjectSimpleInfo projectSimpleInfo);
	
	/**
	 * 修改专题信息
	 * @param projectSimpleInfo
	 * @return
	 */
	public int update(TProjectSimpleInfo projectSimpleInfo);
	
	public int setIsProjectTemplateSet(@Param("projectId")String projectId, @Param("isProjectTemplateSet")Integer isProjectTemplateSet);
	
	/**
	 * <p>Title:updateProjectState</p>
	 * <p>Description:更改专题的状态</p>
	 * @author YYCHEN
	 * @date 2016年6月7日 上午11:25:36
	 * @param projectId
	 * @param state
	 * @return
	 */
	int updateProjectState(@Param("projectId")String projectId, @Param("state")Integer state);
	
	int updateProjectEndState();
	
	/**
	 * 删除专题
	 * @param projectId
	 * @return
	 */
	public int delete(String projectId);
	
	/**
	 * <p>Title: queryCountByDirector</p>
	 * <p>Description: 通过医生ID查询负责该医生负责的专题数据</p>
	 * @date 2016年4月19日 下午2:28:13
	 * @param doctorId
	 * @return
	 */
	public TProjectCountInfo queryCountByDirector(Long doctorId);
	
	/**
	 * 
	 * @param doctorId
	 * @param createFlag
	 * @param joinFlag
	 * @param inviteFlag
	 * @return
	 */
	public List<TProjectSimpleInfo> findProjects(@Param("doctorId")Long doctorId, @Param("state")Integer state, @Param("stateFlag")Integer stateFlag, @Param("attributeFlag")Integer attributeFlag);

	public TProjectDetailInfo findDetailById(@Param("projectId")String projectId, @Param("subcenterId")Long subcenterId, @Param("doctorId")Long doctorId);
	
	/**
	 * <p>Title:findByCrfObserveId</p>
	 * <p>Description:通过观察项ID查找专题信息</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午5:09:35
	 * @param crfObserveId
	 * @return
	 */
	public TProjectSimpleInfo findByCrfObserveId(String crfObserveId);
	
	/**
	 * <p>Title:findById</p>
	 * <p>Description:根据专题ID获取专题简要信息</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 上午11:31:45
	 * @param projectId
	 * @return
	 */
	public TProjectSimpleInfo findById(String projectId);

	/**
	 * <p>Title:findParticipateInProjects</p>
	 * <p>Description:查询医生创建和参与的专题列表</p>
	 * @author YYCHEN
	 * @date 2016年10月29日 下午2:38:09
	 * @param doctorId
	 * @param state
	 * @param stateFlag
	 * @param attributeFlag
	 * @return
	 */
	public List<TProjectSimpleInfo> findParticipateInProjects(@Param("doctorId")Long doctorId, @Param("state")Integer state, @Param("stateFlag")Integer stateFlag,
			@Param("attributeFlag")Integer attributeFlag);

	/**
	 * <p>Title:releaseProject</p>
	 * <p>Description:专题发布</p>
	 * @author YYCHEN
	 * @date 2016年11月7日 下午2:40:54
	 * @param projectId
	 * @param issue
	 * @param state
	 * @return
	 */
	public int releaseProject(@Param("projectId")String projectId, @Param("issue")Integer issue, @Param("state")Integer state);
}
