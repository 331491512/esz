package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TSyncReviewRecord</p>
 * <p>Description:ToB端通知云端具体消息体</p>
 * @author fanpanwei
 * @date 2016年10月19日 上午11:36:36
 */
@SuppressWarnings("serial")
public class TSyncReviewRecord implements Serializable {
	private Date consultOrderTime;//预约时间
	private String remark;//备注
	private Integer state;//预约状态
	private String productApplyId;
	
	public Date getConsultOrderTime() {
		return consultOrderTime;
	}
	public void setConsultOrderTime(Date consultOrderTime) {
		this.consultOrderTime = consultOrderTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
