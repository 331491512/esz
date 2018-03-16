package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.FollowupRecordInfo;

/**
 * <p>Title:FollowupResultDao</p>
 * <p>Description:患者随访结果数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年6月8日 上午10:53:36
 */
public interface FollowupResultDao {

	/**
	 * <p>Title:findFollowupResults</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月24日 上午10:20:06
	 * @param patientId
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	List<FollowupRecordInfo> findFollowupResults(@Param("patientId")Long patientId, @Param("orderBy")String orderBy, @Param("orderType")String orderType);

}
