/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>MonitorTelConsultAlert.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:05:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

/** 
* @ClassName: MonitorTelConsultAlert.java
* @Description: 电话咨询
* @author lichenghao
* @date 2015年12月12日 下午4:05:53  
*/
public class MonitorTelConsultAlert {
	
	/**
	 * 电话咨询ID
	 */
	private Long monitorId;
	
	/**
	 * 产品服务申请ID
	 */
	private String productApplyId;
	
	/**
	 * 电话咨询到期时间
	 */
	private Date excutionTime;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;

	public Long getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public String getProductApplyId() {
		return productApplyId;
	}

	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}

	public Date getExcutionTime() {
		return excutionTime;
	}

	public void setExcutionTime(Date excutionTime) {
		this.excutionTime = excutionTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
