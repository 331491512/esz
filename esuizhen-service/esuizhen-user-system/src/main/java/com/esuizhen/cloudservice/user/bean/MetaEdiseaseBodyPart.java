package com.esuizhen.cloudservice.user.bean;

import java.util.Date;

/**
 * @ClassName: MetaEdiseaseBodyPart
 * @Description: 疾病部位元数据
 * @author wang_hw
 * @date 2015年12月29日 上午11:24:54
 */
public class MetaEdiseaseBodyPart {

	/**
	 * 疾病部位ID。主键。
	 */
	private Integer deseaseBodyPartId;
	/**
	 * 疾病部位名称
	 */
	private String deseaseBodyPartName;

	/**
	 * 疾病类型ID
	 */
	private Integer diseaseTypeId;

	/**
	 * 疾病名称
	 */
	private String diseaseTypeName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public void setDeseaseBodyPartId(Integer value) {
		this.deseaseBodyPartId = value;
	}

	public Integer getDeseaseBodyPartId() {
		return this.deseaseBodyPartId;
	}

	public void setDeseaseBodyPartName(String value) {
		this.deseaseBodyPartName = value;
	}

	public String getDeseaseBodyPartName() {
		return this.deseaseBodyPartName;
	}

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
