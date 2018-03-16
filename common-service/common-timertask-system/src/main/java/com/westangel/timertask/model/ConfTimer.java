package com.westangel.timertask.model;

import java.util.Date;


public class ConfTimer{
	
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 业务类型
	 */
	private Integer serviceType;
	/**
	 * 1：按天（默认）；2：按周；3：按月；4：按年
	 */
	private Integer periodType;
	/**
	 * (周期性)定时器执行时间。如9:30
	 */
	private Date actionTime;

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setServiceType(Integer value) {
		this.serviceType = value;
	}
	
	public Integer getServiceType() {
		return this.serviceType;
	}
	public void setPeriodType(Integer value) {
		this.periodType = value;
	}
	
	public Integer getPeriodType() {
		return this.periodType;
	}
	public void setActionTime(Date value) {
		this.actionTime = value;
	}
	
	public Date getActionTime() {
		return this.actionTime;
	}


}

