package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;

/**
* @ClassName: TCrfRadiotherapyPartInfo 
* @Description: 放疗部位实体
* @author wang_hw
* @date 2016年4月14日 下午6:41:23
 */
public class TCrfRadiotherapyPartInfo{
	/**
	 * 明细ID。
	 */
	private String crfObserveItemId;
	/**
	 * 方案ID。外键。
	 */
	private String crfObserveSchemeId;
	/**
	 * 放疗部位ID。外键：ehr_db.meta_e_radiotherapy_part
	 */
	private Integer radiotherapyPartId;
	
	/**
	 * 部位名称
	 */
	private String radiotherapyPartName;
	//排序索引
	private Integer index;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfObserveItemId(String value) {
		this.crfObserveItemId = value;
	}
	
	public String getCrfObserveItemId() {
		return this.crfObserveItemId;
	}
	public void setCrfObserveSchemeId(String value) {
		this.crfObserveSchemeId = value;
	}
	
	public String getCrfObserveSchemeId() {
		return this.crfObserveSchemeId;
	}
	public void setRadiotherapyPartId(Integer value) {
		this.radiotherapyPartId = value;
	}
	
	public Integer getRadiotherapyPartId() {
		return this.radiotherapyPartId;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public String getRadiotherapyPartName()
	{
		return radiotherapyPartName;
	}

	public void setRadiotherapyPartName(String radiotherapyPartName)
	{
		this.radiotherapyPartName = radiotherapyPartName;
	}

	

}

