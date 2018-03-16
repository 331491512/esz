package com.esuizhen.cloudservice.sync.bean;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
* @ClassName: TSyncResultNotify 
* @Description: 同步通知 
* @author LIPENG
* @date 2016年2月4日 上午10:49:26 
*
 */
public class TSyncResultNotify {
	/**
	 * 同步类型
	 */
	public enum resultType{
		resultTypeUnknow,
		resultTypeFlowup,//随访
		resultTypeWeixin,//微信
		resultTypeProductApply,//服务
		questionnaireResultId //问卷结果id
	}
	/**
	 * 医院编号
	 */
	private Integer hospitalId;
	/**
	 * 同步类型，1:随访结果 2:微信 3:复查预约
	 */
	private Integer resultType;
	/**
	 * 同步结果
	 */
	private List<TSyncRecord> uuids;

	/** 
	* @return hospitalId 
	*/
	public Integer getHospitalId() {
		return hospitalId;
	}

	/** 
	* @param hospitalId 要设置的 hospitalId 
	*/
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/** 
	* @return resultType 
	*/
	public Integer getResultType() {
		return resultType;
	}

	/** 
	* @param resultType 要设置的 resultType 
	*/
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}

	/** 
	* @return uuids 
	*/
	public List<TSyncRecord> getUuids() {
		return uuids;
	}

	/** 
	* @param uuids 要设置的 uuids 
	*/
	public void setUuids(List<TSyncRecord> uuids) {
		this.uuids = uuids;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :initFollowupResultBuffId
	 * @Description:将followupResultId 更新 到 followupResultBuffId
	 * @return void
	 * @date 2016年10月27日 下午5:03:01
	 */
	public void initFollowupResultBuffId(){
		if(uuids!=null)
			for(TSyncRecord record : uuids){
				if(StringUtils.isNotEmpty(record.getFollowupResultId()))
					record.setFollowupResultBuffId(record.getFollowupResultId());
			}
	}
}
