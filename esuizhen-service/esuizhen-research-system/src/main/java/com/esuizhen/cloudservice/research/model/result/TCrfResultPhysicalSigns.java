package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultGenenalPhysicalExamination</p>
 * <p>Description:患者检查-体征情况结果bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:03:05
 */
public class TCrfResultPhysicalSigns implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfPhysicalSignsResultId;
	//结果项Id。外键
	private String crfResultId;
	//部位ID
	private Integer physicalSignsId;
	//体征
	private String physicalSignsName;
	//检查日期
	private Date checkDate;
	//体征正常与否
	private Integer signsStatus;
	//体征异常描述
	private String description;
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
	public String getCrfPhysicalSignsResultId() {
		return crfPhysicalSignsResultId;
	}
	public void setCrfPhysicalSignsResultId(String crfPhysicalSignsResultId) {
		this.crfPhysicalSignsResultId = crfPhysicalSignsResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public Integer getPhysicalSignsId() {
		return physicalSignsId;
	}
	public void setPhysicalSignsId(Integer physicalSignsId) {
		this.physicalSignsId = physicalSignsId;
	}
	public String getPhysicalSignsName() {
		return physicalSignsName;
	}
	public void setPhysicalSignsName(String physicalSignsName) {
		this.physicalSignsName = physicalSignsName;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Integer getSignsStatus() {
		return signsStatus;
	}
	public void setSignsStatus(Integer signsStatus) {
		this.signsStatus = signsStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
