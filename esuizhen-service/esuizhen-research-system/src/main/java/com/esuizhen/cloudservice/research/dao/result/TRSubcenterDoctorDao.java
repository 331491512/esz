package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterDoctor;

/**
 * <p>Title:RSubcenterDoctorDao</p>
 * <p>Description:专题分中心医生关系数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年6月22日 下午4:07:32
 */
public interface TRSubcenterDoctorDao {
	
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增分中心医生关系</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 下午3:17:49
	 * @param obj
	 * @return
	 */
	int insert(Object obj);

	/**
	 * <p>Title:querySubcenterDoctorList</p>
	 * <p>Description:查询专题分中心医生数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午4:09:51
	 * @param projectId
	 * @param allFlag
	 * @return
	 */
	List<TRSubcenterDoctor> querySubcenterDoctorList(@Param("projectId")String projectId, @Param("allFlag")Integer allFlag);

	/**
	 * <p>Title:findProjectSubcenterDoctorsBySubcenterId</p>
	 * <p>Description:根据分中心ID查询分中心医生信息</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午9:55:46
	 * @param subcenterId
	 * @return
	 */
	List<TProjectSubcenterDetailInfo> findProjectSubcenterDoctorsBySubcenterId(@Param("projectId")String projectId, @Param("subcenterId")Long subcenterId);

	/**
	 * <p>Title:deleteBySubcenterIdAndDoctorId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 下午3:24:39
	 * @param subcenterId
	 * @param doctorId
	 * @return
	 */
	int deleteBySubcenterIdAndDoctorId(@Param("subcenterId")Long subcenterId, @Param("doctorId")Long doctorId);

	int findCount(Long subcenterId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月27日 下午3:34:18
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);

	/**
	 * <p>Title:deleteBySubcenterId</p>
	 * <p>Description:根据分中心ID删除分中心成员</p>
	 * @author YYCHEN
	 * @date 2016年11月8日 下午2:43:13
	 * @param subcenterId
	 * @return
	 */
	int deleteBySubcenterId(Long subcenterId);

}
