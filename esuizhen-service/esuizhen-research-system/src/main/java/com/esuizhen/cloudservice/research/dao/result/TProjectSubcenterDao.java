package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;

/**
 * <p>Title:ProjectSubcenterDao</p>
 * <p>Description:专题分中心数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月31日 上午11:14:04
 */
public interface TProjectSubcenterDao {
	/**
	 * <p>Title:findByDoctorId</p>
	 * <p>Description:通过医生ID查找分中心信息</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 上午11:20:06
	 * @param doctorId
	 * @return
	 */
	public TProjectSubcenter findByDoctorId(@Param("projectId")String projectId, @Param("doctorId")Long doctorId);
	
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增专题分中心</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午4:15:00
	 * @param obj
	 * @return
	 */
	int insert(Object obj);

	/**
	 * <p>Title:findProjectSubcenters</p>
	 * <p>Description:使用专题ID查询所有分中心</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午5:28:16
	 * @param projectId
	 * @return
	 */
	public List<TProjectSubcenter> findProjectSubcenters(String projectId);

	/**
	 * <p>Title:findBySubcenterId</p>
	 * <p>Description:根据分中心ID查询分中心信息</p>
	 * @author YYCHEN
	 * @date 2016年10月26日 下午2:35:40
	 * @param subcenterId
	 * @param doctorId
	 * @return
	 */
	public TProjectSubcenter findBySubcenterId(@Param("subcenterId")Long subcenterId, @Param("doctorId")Long doctorId);

	public int delete(Long subcenterId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 下午3:35:13
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);

	/**
	 * <p>Title:existProjectSubcenterName</p>
	 * <p>Description:判断分中心名称是否存在</p>
	 * @author YYCHEN
	 * @date 2016年11月7日 下午3:18:27
	 * @param projectId
	 * @param subcenterName
	 * @return
	 */
	public int existProjectSubcenterName(@Param("projectId")String projectId, @Param("subcenterName")String subcenterName);
}
