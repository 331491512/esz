/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.bean;<br/>  
 * <b>文件名：</b>SystemActivityQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月29日上午11:26:33<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.bean;
/** 
* @ClassName: SystemActivityQueryReq
* @Description: 
* @author lichenghao
* @date 2016年6月29日 上午11:26:33  
*/
public class SystemActivityQueryReq {
	private int page;
	private int num;
	private String cityCode;
	private Integer isPublish;
	private Integer[] seate;
	private Integer hospitalId;
	private String activityId;
	private String ruleId;

	private String sourceType;

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}
	public Integer[] getSeate() {
		return seate;
	}
	public void setSeate(Integer[] seate) {
		this.seate = seate;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
}
