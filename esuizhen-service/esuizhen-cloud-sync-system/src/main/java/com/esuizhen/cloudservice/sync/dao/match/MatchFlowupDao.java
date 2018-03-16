package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchFlowupDao {

	/**
	 * 
	* @Title: addResultRecord2Match 
	* @Description: 增量到匹配库 
	* @param @param result    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addResultRecord2Match(TPatientFollowupResultDetailInfo result);

	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	public int delete(@Param("followupResultBuffId")String followupResultBuffId);
	
	public List<TPatientFollowupResultDetailInfo> findByPatientUuid(String patientUuid);
	// 判断记录是否在匹配库已经存在
	public Integer isExistsResult(TPatientFollowupResultDetailInfo result);
}
