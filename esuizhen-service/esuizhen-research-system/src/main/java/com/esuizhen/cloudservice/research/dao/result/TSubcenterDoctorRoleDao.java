package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterRoleInfo;

/**
 * <p>Title:TSubcenterDoctorRoleDao</p>
 * <p>Description:分中心医生角色数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年10月20日 上午10:54:12
 */
public interface TSubcenterDoctorRoleDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增分中心医生角色关系</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午10:55:16
	 * @param obj
	 * @return
	 */
	int insert(Object obj);
	
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量新增分中心医生角色关系</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午10:55:32
	 * @param list
	 * @return
	 */
	int insertByBatch(List<?> list);

	/**
	 * <p>Title:deleteBySubcenterIdAndDoctorId</p>
	 * <p>Description:根据分中心ID和医生ID删除分中心医生角色关系</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 下午3:22:55
	 * @param subcenterId
	 * @param doctorId
	 * @return
	 */
	int deleteBySubcenterIdAndDoctorId(@Param("subcenterId")Long subcenterId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:findByDoctorId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 下午12:00:56
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	List<TProjectSubcenterRoleInfo> findByDoctorId(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 下午3:31:30
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);

	/**
	 * <p>Title:deleteBySubcenterId</p>
	 * <p>Description:根据分中心ID删除</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午3:27:56
	 * @param subcenterId
	 * @return
	 */
	int deleteBySubcenterId(Long subcenterId);
}
