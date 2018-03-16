package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.HashMap; 
import java.util.List; 

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.MedicalRecordPost;

/**
 * 
 * @author fanpanwei
 *
 */
public interface CloudProductServiceApplyDao {
	//add by fanpanwei  根据医院，服务类型获取服务申请内容
	public List<MedicalRecordPost> getSeviceApplyList(@Param("hm")HashMap<String, Object> paramMap);
	
	/**
	* @Title: setWeixinSyncedFlag4Uuids 
	* @Description: 设置复查预约同步结果标记
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public int setServiceApplySyncedFlag(@Param("hm")HashMap<String,Object> paramMap);
}
