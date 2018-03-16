package com.esuizhen.cloudservice.research.dao.pro;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TProjectGroupInfo;

/**
 * <p>Title:ProjectGroupDao</p>
 * <p>Description:专题患者组数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年10月19日 上午11:04:26
 */
public interface ProjectGroupDao {
	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除专题患者组</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 上午11:05:00
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
	
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量添加专题患者组信息</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 上午11:23:50
	 * @param projectGroupInfos
	 * @return
	 */
	int insertByBatch(@Param("records")List<TProjectGroupInfo> projectGroupInfos);

	/**
	 * <p>Title:findByGroupId</p>
	 * <p>Description:根据专题患者组ID查询专题患者组信息</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 上午9:42:42
	 * @param groupId
	 * @return
	 */
	TProjectGroupInfo findByGroupId(String groupId);

	List<TProjectGroupInfo> findProjectGroupList(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:deleteById</p>
	 * <p>Description:根据ID删除</p>
	 * @author YYCHEN
	 * @date 2016年11月11日 下午12:09:36
	 * @param groupId
	 * @return
	 */
	int deleteById(String groupId);

	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增患者组</p>
	 * @author YYCHEN
	 * @date 2016年11月11日 下午12:11:52
	 * @param projectGroupInfo
	 * @return
	 */
	int insert(TProjectGroupInfo projectGroupInfo);

	/**
	 * <p>Title:update</p>
	 * <p>Description:更新患者组</p>
	 * @author YYCHEN
	 * @date 2016年11月11日 下午12:12:08
	 * @param projectGroupInfo
	 * @return
	 */
	int update(TProjectGroupInfo projectGroupInfo);
}
