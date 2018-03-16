package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:ProductServiceApply</p>
 * <p>Description:病案邮寄B端请求参数的封装类</p>
 * @author fanpanwei
 * @date 2016年10月19日 上午11:36:36
 */
public class MedicalRecordPostReq {
	private Integer hospitalId;
	private Integer pageSize;
	private Integer num;
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
