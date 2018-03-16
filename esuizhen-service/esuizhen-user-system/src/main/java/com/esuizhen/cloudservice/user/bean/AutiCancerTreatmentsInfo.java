package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
 * @ClassName: AutiCancerTreatmentsInfo.java
 * @Description: 抗癌治疗方案的元数据 查询
 * @author fanpanwei	
 * @date   2016年9月23日
 */
public class AutiCancerTreatmentsInfo implements Serializable {
	private Integer sdtId;//主键ID
	private String sdtName;//特病诊治及建议名称
	public Integer getSdtId() {
		return sdtId;
	}
	public void setSdtId(Integer sdtId) {
		this.sdtId = sdtId;
	}
	public String getSdtName() {
		return sdtName;
	}
	public void setSdtName(String sdtName) {
		this.sdtName = sdtName;
	}
	
}
