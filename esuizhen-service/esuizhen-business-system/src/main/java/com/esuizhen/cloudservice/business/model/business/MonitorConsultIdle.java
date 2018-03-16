/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>MonitorConsultIdle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午3:50:22<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

/**
 * @ClassName: MonitorConsultidle.java
 * @Description:图文或电话咨询空闲监视实体
 * @author lichenghao
 * @date 2015年12月12日 下午3:50:22
 */
public class MonitorConsultIdle {
	
	/**
	 * 咨询编号
	 */
	private Long monitorId;
	
	/**
	 * 产品服务申请ID
	 */
	private String productApplyId;
	
	/**
	 * 咨询过期时间
	 */
	private Date expireTime;
	
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

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
