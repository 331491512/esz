package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncRecord;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudFlowupDao {

	/**
	 * 
	* @Title: addResultRecord2Cloud 
	* @Description: 增量到云端库 
	* @param @param result    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addResultRecord2Cloud(TPatientFollowupResultDetailInfo result);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :addResultBuffRecord2Cloud
	 * @Description:增量到云端库缓冲表 
	 * @return void
	 * @date 2016年10月27日 下午6:11:06
	 */
	public void addResultBuffRecord2Cloud(TPatientFollowupResultDetailInfo result);
	
	public int update(List<TPatientFollowupResultDetailInfo> followupResultDetailInfos);
	/**
	 * 
	* @Title: incrResultsOfHostpital 
	* @Description: C端增量 
	* @param @param hospitalId
	* @param @return    设定文件 
	* @return List<TPatientFollowupResultDetailInfo>    返回类型 
	* @throws
	 */
	public List<TPatientFollowupResultDetailInfo> findIncrResultsOfHostpital(@Param("hospitalId")Integer hospitalId);

	/**
	 * <p>Title:setC2BSyncMark</p>
	 * <p>Description:ToB端拉取到云端的随访结果后，通知云端，云端修改相应的随访结果的拉取标识</p>
	 * @author YYCHEN
	 * @date 2016年9月9日 上午11:42:50
	 * @param hospitalId
	 * @param uuids
	 * @return
	 */
	public int setC2BSyncMark(@Param("hospitalId")Integer hospitalId, @Param("uuids")List<TSyncRecord> uuids);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :findResultValueTypeById
	 * @Description:结果状态
	 * @return Integer
	 * @date 2016年10月28日 下午4:03:16
	 */
	public Integer findResultValueTypeById(@Param("followupResultValueId")Integer followupResultValueId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :findResultWayNameById
	 * @Description:随访方式名称
	 * @return String
	 * @date 2016年10月28日 下午5:39:19
	 */
	public String findResultWayNameById(@Param("followupWayId")Integer followupWayId);
	
	/**
	 * add by fanpanwei
	 * 判断随访记录是否存在
	 */
	public Integer isExistsResult(TPatientFollowupResultDetailInfo result);
}
