package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultBasicAllergies</p>
 * <p>Description:基本信息-过敏史结果bean</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:23:44
 */
public class TCrfResultBasicAllergies implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfAllergyResultId;
	//结果项Id
	private String crfResultId;
	//过敏史
	private String allergyName;
	//过敏源
	private String allergySource;
	//过敏症状
	private String allergySymptom;
	//过敏药物名称
	private String allergyMedicinesName;
	/**
	 * 过敏严重性：
		1：轻
		2：中
		3：重
	 */
	private Integer allergyLevel;
	//过敏病情
	private Integer allergyTypeId;
	//排序索引
	private Integer index;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getAllergyTypeId() {
		return allergyTypeId;
	}
	public void setAllergyTypeId(Integer allergyTypeId) {
		this.allergyTypeId = allergyTypeId;
	}
	public String getCrfAllergyResultId() {
		return crfAllergyResultId;
	}
	public void setCrfAllergyResultId(String crfAllergyResultId) {
		this.crfAllergyResultId = crfAllergyResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	public String getAllergySource() {
		return allergySource;
	}
	public void setAllergySource(String allergySource) {
		this.allergySource = allergySource;
	}
	public String getAllergySymptom() {
		return allergySymptom;
	}
	public void setAllergySymptom(String allergySymptom) {
		this.allergySymptom = allergySymptom;
	}
	public String getAllergyMedicinesName() {
		return allergyMedicinesName;
	}
	public void setAllergyMedicinesName(String allergyMedicinesName) {
		this.allergyMedicinesName = allergyMedicinesName;
	}
	public Integer getAllergyLevel() {
		return allergyLevel;
	}
	public void setAllergyLevel(Integer allergyLevel) {
		this.allergyLevel = allergyLevel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
