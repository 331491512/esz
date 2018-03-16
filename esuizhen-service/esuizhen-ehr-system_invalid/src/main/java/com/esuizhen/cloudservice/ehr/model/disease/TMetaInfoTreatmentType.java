package com.esuizhen.cloudservice.ehr.model.disease;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TMetaInfoTreatmentType</p>
 * <p>Description:治疗类型bean</p>
 * @author YYCHEN
 * @date 2016年6月22日 下午2:28:04
 */
public class TMetaInfoTreatmentType implements Serializable {
	private static final long serialVersionUID = 1L;

	//治疗类型Id
	private Integer treatmentTypeId;
	//治疗类型名
	private String treatmentTypeName;
	//标识
	private Integer flag;
	
	//标识
	private Integer showFlag;
	
	//创建时间
	private Date createTime;
	
	//创建者
	private Long creator;
	
	public Integer getShowFlag() {
		return showFlag;
	}
	public void setShowFlag(Integer showFlag) {
		this.showFlag = showFlag;
	}
	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}
	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}
	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
}
