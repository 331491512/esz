package com.esuizhen.cloudservice.research.dao.result;

import org.apache.ibatis.annotations.Param;

/**
 * <p>Title:ProjectInvitationDao</p>
 * <p>Description:专题邀请数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年10月28日 上午9:53:30
 */
public interface ProjectInvitationDao {
	int insert(Object obj);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除专题邀请关系</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 上午11:00:04
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);

	/**
	 * <p>Title:deleteByInvitee</p>
	 * <p>Description:根据被邀请医生ID删除</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午3:16:52
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	int deleteByInvitee(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);
}
