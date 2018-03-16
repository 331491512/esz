/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TDiagnosisPeriodization.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日上午9:53:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: TDiagnosisPeriodization
* @Description: 
* @author lichenghao
* @date 2016年5月24日 上午9:53:53  
*/
public class TMetaDiagnosisPeriodization {
	//分期编号
	private Integer disagnosisPeriodizationId;
	//分期code
	private String disagnosisPeriodizationCode;
	//分期名称
	private String disagnosisPeriodizationName;
	//分期号
	private Integer phase;
	//分期索引
	private Integer index;
	//创建时间
	private Date createTime;
	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}
	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}
	public String getDisagnosisPeriodizationCode() {
		return disagnosisPeriodizationCode;
	}
	public void setDisagnosisPeriodizationCode(String disagnosisPeriodizationCode) {
		this.disagnosisPeriodizationCode = disagnosisPeriodizationCode;
	}
	public String getDisagnosisPeriodizationName() {
		return disagnosisPeriodizationName;
	}
	public void setDisagnosisPeriodizationName(String disagnosisPeriodizationName) {
		this.disagnosisPeriodizationName = disagnosisPeriodizationName;
	}
	public Integer getPhase() {
		return phase;
	}
	public void setPhase(Integer phase) {
		this.phase = phase;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
