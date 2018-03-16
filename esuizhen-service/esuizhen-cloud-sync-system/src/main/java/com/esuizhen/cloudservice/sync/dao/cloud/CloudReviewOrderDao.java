package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientWeixinOpenIdInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncRecord;
import com.esuizhen.cloudservice.sync.bean.TSyncReviewRecord;
import com.westangel.common.bean.Patient;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudReviewOrderDao {
	//add by fanpanwei  同步复查预约信息
	public List<TSyncReviewRecord> getReviewOrderByHospital(Integer hospitalId);
	
	/**
	 * 
	* @Title: setWeixinSyncedFlag4Uuids 
	* @Description: 设置复查预约同步结果标记
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public int setReviewSyncedFlag(@Param("uuids")List<TSyncRecord> uuids);
}
